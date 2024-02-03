import java.util.HashMap;
/**
 * Basketball is a Game, and in the Basketball constructor, the number of options the user can select, the score values
 * associated with the number of options, and the name of each of those scoring methods are initialized. The max amount
 * of time incrementation is also set in the constructor.
 */
public class Basketball extends Game {
    public Basketball(){
        setNumOptions(7);
        HashMap<String, Integer> scoreValues = new HashMap<>();
        String[] options = new String[3];
        scoreValues.put("1", 3);
        scoreValues.put("2", 2);
        scoreValues.put("3", 1);
        scoreValues.put("4", 3);
        scoreValues.put("5", 2);
        scoreValues.put("6", 1);
        scoreValues.put("7",1);
        setScoreValues(scoreValues);
        options[0] = "3-pointer";
        options[1] = "2-pointer";
        options[2] = "free-throw";
        setOptions(options);
        setMaxPeriod(4);
    }
    /**
     * Sets the timeFormat to quarters since it is a basketball game
     * @return the name of the time format
     */
    @Override
    public String timeFormat() {
        return "Quarter";
    }

}
