import java.util.HashMap;

/**
 * Football is a Game, and in the Football constructor, the number of options the user can select, the score values
 * associated with the number of options, and the name of each of those scoring methods are initialized. The max amount
 *  * of time incrementation is also set in the constructor.
 */
public class Football extends Game {
    public Football(){
        setNumOptions(11);
        HashMap<String, Integer> scoreValues = new HashMap<>();
        String[] options = new String[5];
        scoreValues.put("1", 6);
        scoreValues.put("2", 3);
        scoreValues.put("3", 1);
        scoreValues.put("4", 2);
        scoreValues.put("5", 2);
        scoreValues.put("6", 6);
        scoreValues.put("7", 3);
        scoreValues.put("8", 1);
        scoreValues.put("9", 2);
        scoreValues.put("10", 2);
        scoreValues.put("11",1);
        setScoreValues(scoreValues);
        options[0] = "touchdown";
        options[1] = "field goal";
        options[2] = "extra-point";
        options[3] = "two-point conversion";
        options[4] = "safety";
        setOptions(options);
        setMaxPeriod(4);
    }

    /**
     * Sets the timeFormat to quarters since it is a football game
     * @return the name of the time format
     */
    @Override
    public String timeFormat() {
        return "Quarter";
    }
}
