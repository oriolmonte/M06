package model;
import java.io.Serializable;
import java.util.Objects;

public class PlayerId implements Serializable {

    private String team_abv;
    private String name;

    public PlayerId() {}

    public PlayerId(String team_abv, String name) {
        this.team_abv = team_abv;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.team_abv);
        hash = 23 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PlayerId other = (PlayerId) obj;
        if (!Objects.equals(this.team_abv, other.team_abv)) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }

}
