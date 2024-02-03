/**
 * Sets the team names of both the Home and Away teams. These names are found from the user's input
 */
public class Team {
    /**
     * Holds the name of the team, whether it is the home or away team it does not matter. the specifics are done
     * through the setters and getters that are used in the driver method
     */
    private String teamName;

    /**
     * Dynamically sets the name of the team at runtime, which means that no method has to be used, the name of the team
     * just has to be passed in through the creation of the Team object
     * @param teamName
     */
    public Team(String teamName){
        this.teamName = teamName;
    }

    /**
     * Returns the name of the team. This needed to be overridden since the teamName is of type Team.
     * @return the name of the team in a readable format
     */
    @Override
    public String toString(){
        return teamName;
    }
}
