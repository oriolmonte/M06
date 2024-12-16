package model;

import  javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="PLAYER")
@IdClass(PlayerId.class)
public class Player {
	
    
    public Player()
    {

    }
	private static final long serialVersiounUID = 2L;
    
    @Id   
    @Column(name="team_abv")
	private String team_abv;
    @Id
    @Column(name="player_id")
	private int player_id;
    @Column(name="name")
	private String name;
    @Column(name="height")
	private int height;
    @Column(name="position")
	private String position;
    public Player(int height, String name, int player_id, String position, String team_abv) {
        this.height = height;
        this.name = name;
        this.player_id = player_id;
        this.position = position;
        this.team_abv = team_abv;
    }
    public Player(int player_id,  String team_abv) {
        this.height = 0;
        this.name = null;
        this.player_id = player_id;
        this.position = null;
        this.team_abv = team_abv;
    }

    @Override
    public String toString() {
        return "Player [team_abv=" + team_abv + ", player_id=" + player_id + ", name=" + name + ", height=" + height
                + ", position=" + position + "]";
    }

    @ManyToOne
    @JoinColumn(name = "team_abv", referencedColumnName = "ABV", insertable = false, updatable = false)
    private Team team;

    public String getTeam_abv() {
        return team_abv;
    }

    public void setTeam_abv(String team_abv) {
        this.team_abv = team_abv;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
	
}


