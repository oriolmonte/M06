package dao;

import model.Team;

public class Main {

	public static void main(String[] args) {
		
		String link = "https://www.falsofutbolclub.com";
		TeamDaoFactory factory = new TeamDaoFactory();
		DaoManager dao = factory.CreateTeamDAO();
		Team mafalda = new Team("MAF", "Mafalda", link);
		
		////AddTeam 
		//dao.AddTeam(new Team("Corregim", "CRC", link));

		////DeleteTeam
		// dao.DeleteTeam("CRC");

		////UpdateTeam
		//dao.updateTeam(new Team("Corregim", "CRC", link));
		//System.out.println(dao.updateTeam(new Team("Corregim", "CRC", link+"cambiao")));
		
		////GetTeam
		//System.out.println(dao.getTeamByAbbr("ARS"));

		// //GetAll
		// dao.getAllTeams().forEach(team -> System.out.println(team));

		////AddPlayer
		//dao.AddPlayer(new Player(180, "Menganito", 9999, "MC", "CRC"));

		//ImportPlayers
		//dao.importPlayers("./src/main/resources/PLAYERS.TXT");
		// Crear equip		
		// ArrayList<Player> jugadors = new ArrayList<>();
		// jugadors.add(new Player(150, "Pepa", 9998, "MC", "MAF"));
		// jugadors.add(new Player(151, "Pepe", 9997, "MC", "MAF"));
		// jugadors.add(new Player(152, "Pepi", 9996, "MC", "MAF"));
		// jugadors.add(new Player(153, "Pepo", 9995, "MC", "MAF"));
		// jugadors.add(new Player(154, "Pepu", 9994, "MC", "MAF"));
		// dao.AddTeam(mafalda, jugadors);
		// System.out.println(dao.GetTeamMembers("MAF"));

	}
}
