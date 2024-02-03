import java.util.HashMap;
/**
 * Soccer is a Game, and in the Soccer constructor, the number of options the user can select, the score values
 * associated with the number of options, and the name of each of those scoring methods are initialized. The max amount
 *  * of time incrementation is also set in the constructor.
 */
public class Soccer extends Game {
    public Soccer(){
        setNumOptions(3);
        HashMap<String, Integer> scoreValues = new HashMap<>();
        String[] options = new String[1];
        scoreValues.put("1", 1);
        scoreValues.put("2", 1);
        scoreValues.put("3", 1);
        setScoreValues(scoreValues);
        options[0] = "goal";
        setOptions(options);
        setMaxPeriod(2);
    }

    /**
     * Sets the timeFormat to halves since it is a soccer game
     * @return the name of the time format
     */
    @Override
    public String timeFormat() {
        return "Half";
    }

}
