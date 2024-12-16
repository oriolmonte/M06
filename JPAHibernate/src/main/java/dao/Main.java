package dao;

public class Main {

	public static void main(String[] args) {
		
		TeamDaoFactory factory = new TeamDaoFactory();
		DaoManager dao = factory.CreateTeamDAO();
		dao.importPlayers("JPAHibernate/src/main/resources/PLAYERS.TXT");
	}
}
