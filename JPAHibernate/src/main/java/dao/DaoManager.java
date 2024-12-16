package dao;

import java.util.ArrayList;

import model.Player;
import model.Team;

public interface DaoManager extends AutoCloseable {
	public boolean AddTeam(Team oneTeam);
	public boolean DeleteTeam(String teamAbbr);
	public Team updateTeam(Team oneTeam);
	public Team getTeamByAbbr(String teamAbbr);
	public Team getTeamByName(String teamName);
	public ArrayList<Team> getAllTeams();
	public boolean AddPlayer(Player onePlayer);
	public int importPlayers(String playersFileName);
}
