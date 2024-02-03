import java.util.HashMap;

/**
 * The purpose of this class is to define aspects that all sports have. This is done by making sure that
 * each of the defined steps are aspects such as the Team name and who is the winner at the end of the game.
 * The class is abstract because some aspects of the game are different, so those will have to have
 * abstract implementations in the other classes.
 */
public abstract class Game {

    /**
     * Keeps track of the current time incrementation that the user is on while playing the game
     */
    private int numPeriod;

    /**
     * Allows access to see what time incrementation the user is on
     * @return the current time incrementation
     */
    public int getNumPeriod() {
        return numPeriod;
    }

    /**
     * Allows incrementation of current period that the user is on
     */
    public void setNumPeriod() {
        this.numPeriod++;
    }

    /**
     * Keeps track of what the max possible time incrementation could be for that sport (e.g. 4 for football)
     */
    private int maxPeriod;

    /**
     * Allows access to see the max time incrementation
     * @return the max time incrementation
     */
    public int getMaxPeriod() {
        return maxPeriod;
    }

    /**
     * Allows the ability to change the max possible time incrementation depending on the sport
     * @param maxPeriod holds the max time incrementation
     */
    public void setMaxPeriod(int maxPeriod) {
        this.maxPeriod = maxPeriod;
    }

    /**
     * Tracks what the name of what the Home team's name is
     */
    private Team teamName1;

    /**
     * Allows access to see what the first team name is
     * @return the Home team's name
     */
    public Team getTeamName1() {
        return teamName1;
    }

    /**
     * Allows the ability to set the first team's name
     * @param teamName1 holds the Home team's name
     */
    public void setTeamName1(Team teamName1) {
        this.teamName1 = teamName1;
    }

    /**
     * Tracks what the name of what the Away team's name is
     */
    private Team teamName2;
    /**
     * Allows access to see what the second team name is
     * @return the second teams name
     */
    public Team getTeamName2() {
        return teamName2;
    }

    /**
     * Allows the ability to set the second team's name
     * @param teamName2
     */
    public void setTeamName2(Team teamName2) {
        this.teamName2 = teamName2;
    }

    /**
     * Sets both teams at the same time
     * @param team1 Home team
     * @param team2 Away team
     */
    public void setTeams(Team team1, Team team2){
        setTeamName1(team1);
        setTeamName2(team2);
    }
    /**
     * Tracks the total number of options that the user can use (e.g. 11 for Football)
     */
    private int numOptions;

    /**
     * Allows the ability to see the number of options that are associated with that sport
     * @return number of options depending on the sport
     */
    public int getNumOptions() {
        return numOptions;
    }

    /**
     * Allows programmer to set the number of options that are associated with that sport
     * @param numOptions
     */
    public void setNumOptions(int numOptions) {
        this.numOptions = numOptions;
    }


    /**
     * Holds the total number of scoring methods that could be used depending on the sport (e.g. "touchdown", "field-goal",...)
     */
    private String[] options;
    public void setOptions(String[] options) {
        this.options = options;
    }

    /**
     * Returns how many scoring methods there are
     * @return
     */
    public int getOptions() {
        return options.length;
    }


    /**
     * Associates each decimal number with the number of points that would be scored if that decimal number were to be
     * selected by the user
     */
    private HashMap<String, Integer> scoreValues = new HashMap<>();
    public HashMap<String, Integer> getScoreValues() {
        return scoreValues;
    }

    public void setScoreValues(HashMap<String, Integer> scoreValues) {
        this.scoreValues = scoreValues;
    }

    /**
     * Sets the format of time that will be used for the sport (quarter, half, or period).
     * This method is abstract because the time format can change depending on the sport.
     * @return the time format for the selected sport
     */
    public abstract String timeFormat();


    /**
     * gets the number that was selected by the user and then processes it through returning the points scored associated
     * with that number that was selected. This method is the method that outputs the value in the hashmap.
     * @param numSelected is always going to be the user inputted number
     * @return the points that should be added after that scoring method was selected
     */
    public int getScoringMethod(String numSelected) {

        return scoreValues.get(numSelected);
    }

    /**
     * To output the name of the scoring method (e.g. "touchdown")
     * @param optionNum is the number that is associated with the name of that specific scoring method
     * @return the name of the scoring method
     */
    public String getOptionText(int optionNum){

        return options[optionNum-1];
    }
}
