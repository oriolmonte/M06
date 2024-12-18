package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Player;
import model.Team;

@SuppressWarnings("CallToPrintStackTrace")
public class TeamHibernateImpl implements DaoManager {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("ORMTeam");
	EntityManager entityManager = factory.createEntityManager();
	
	@Override
	public boolean AddTeam(Team oneTeam) {
		EntityTransaction t = entityManager.getTransaction();
		try {
			t.begin();
			entityManager.persist(oneTeam);	
			t.commit();	
			return true;
		}
		catch(Exception e)
		{
			t.rollback();
			
			return false;
		}
	}

	@Override
	public boolean DeleteTeam(String teamAbbr) {
		EntityTransaction t = entityManager.getTransaction();
		
		try {
			t.begin();
			Team team = getTeamByAbbr(teamAbbr);
		    team = entityManager.merge(team); // Attach to persistence context
			entityManager.remove(team);
			t.commit();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Team updateTeam(Team oneTeam) {
		EntityTransaction t = entityManager.getTransaction();
		try {
			t.begin();
			Team fromDb = getTeamByAbbr(oneTeam.getAbv());
			fromDb.setAbv(oneTeam.getAbv());
			fromDb.setLogo_link(oneTeam.getLogo_link());
			fromDb.setName(oneTeam.getName());
			t.commit();
		}
		catch(Exception e)
		{
			
			t.rollback();
			
		}
		return null;
	}

	@Override
	public Team getTeamByAbbr(String teamAbbr) {
		try {
		Query q = entityManager.createQuery("Select t from Team t WHERE t.abv = ?1");
		q.setParameter(1, teamAbbr);
		Team team = (Team)q.getSingleResult();
		return team;
		}
		catch (Exception e)
		{
			return null;
		}
		
		
	}

	@Override
	public Team getTeamByName(String teamName) {
		
		try {
		Query q = entityManager.createQuery("Select t from Team t WHERE t.name = ?1");
		q.setParameter(1, teamName);
		Team team = (Team)q.getSingleResult();
		return team;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	@Override
	public ArrayList<Team> getAllTeams() {
	    List<Team> allTeams;
		try
		{
			Query q = entityManager.createQuery("FROM Team",Team.class);
			allTeams = q.getResultList();
			return (ArrayList<Team>) allTeams;
		}
		catch (Exception e)
		{
			return null;
		}
		
	}
	
	@Override
    public boolean AddPlayer(Player onePlayer) {
		EntityTransaction t = entityManager.getTransaction();
		try{
			t.begin();
			entityManager.persist(onePlayer);
			t.commit();
			return true;
		}
		catch(Exception e)
		{
			t.rollback();
			return false;
		}

    }
	@Override
    public int importPlayers(String playersFileName) {

		try(BufferedReader br = new BufferedReader(new FileReader(playersFileName)))
		{
			
			int added = 0;
			String line = br.readLine();
			while(line!=null)
			{
				int id = 0;
				int height = 0;
				String[] split = line.split(";");
				Team read = getTeamByName(split[2]);
				if(read==null) throw new Exception(); 
				try
				{
					height = Integer.parseInt(split[split.length-2].split(" ")[0]);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				try{
					id = Integer.parseInt(split[0]);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				Player playerRead = new Player(height, split[1], id ,split[split.length-1],read.getAbv());
				AddPlayer(playerRead);
				added++;
				line=br.readLine();
			}
			return added;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
    }

    @Override
    public List<Player> GetTeamMembers(String teamAbv) {

		Team team = getTeamByAbbr(teamAbv);
		return team.getPlayerList();
    }

    @Override
    public boolean AddTeam(Team oneTeam, List<Player> plantilla) {		
		oneTeam.setPlayerList(plantilla);
		plantilla.forEach(player -> AddPlayer(player));
		return AddTeam(oneTeam);
	}

	@Override
	public void close() throws Exception {
		entityManager.close();
		factory.close();	
	
	}



   
   

}
