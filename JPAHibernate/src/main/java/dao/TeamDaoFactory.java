package dao;


public class TeamDaoFactory {
	public DaoManager CreateTeamDAO()
	{
		try {
			
			return new TeamHibernateImpl();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
}
