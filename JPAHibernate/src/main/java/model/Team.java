package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="TEAM")
@Entity

public class Team {

	private static final long serialVersiounUID = 2L;
	    

	@Id
	@Column(name="ABV")
	private String abv;
	@Column(name="CLUB_NAME")
	private String name;
	@Column(name="LOGO_LINK")
	private String logo_link;
	@Column(name="HEX_CODE")
	private String hex_code;

    @OneToMany(mappedBy = "team_abv")  
    private List<Player> playerList;

	public Team() {
		
	}
	public Team(String abv, String name, String logo_link) {
		super();
		this.abv = abv;
		this.name = name;
		this.logo_link = logo_link;
	}


	public String getLogo_link() {
		return logo_link;
	}

	public void setLogo_link(String logo_link) {
		this.logo_link = logo_link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbv() {
		return abv;
	}
	public void setAbv(String abv) {
		this.abv = abv;
	}

	@Override
	public String toString() {
		return "Team [abv=" + abv + ", name=" + name + ", logo_link=" + logo_link 
				+ "]";
	}

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
