package xmljson;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Rector {
    @JsonProperty("awards")
    private String awards;
    @JsonProperty("budjet")
    private int budjet;

    public Rector(String awards, int budjet) {

        this.awards = awards;
        this.budjet = budjet;
    }

    public Rector() {
    }


    public int getBudjet() {
        return budjet;
    }

    public void setBudjet(int budjet) {
        this.budjet = budjet;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    @Override
    public String toString() {
        return "Rector [budjet = " + budjet + " " + "awards = " + awards + "]";
    }

}

