import java.util.Scanner;

/**
 * This class displays and takes in all user inputs and game outputs. This class takes in many different aspects
 * of the Game class Hierarchy in order to display the game in a way that is easy for other developers to add their own
 * type of game.
 */
public class ScoreboardGameDriver {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String sportSelection = ""; // Changes depending on what the user wants to play
        Game newGame = null;
        boolean isValid = false; // Makes sure that what the user inputted is a valid number
        while (!isValid) {
            System.out.print("Please select the sport you wish to play: \n 1. Football\n 2. Hockey\n 3. Soccer\n 4. " +
                    "Basketball\n Enter choice: ");
            String firstChoice = userInput.next(); // puts what the user pressed into a variable
            // if the user wants to play a sport, a new object of that sport must be created
            if (firstChoice.equals("1")) {
                sportSelection = "Football";
                isValid = true;
                newGame = new Football();
            } else if (firstChoice.equals("2")) {
                sportSelection = "Hockey";
                isValid = true;
                newGame = new Hockey();
            } else if (firstChoice.equals("3")) {
                sportSelection = "Soccer";
                isValid = true;
                newGame = new Soccer();
            } else if (firstChoice.equals("4")) {
                sportSelection = "Basketball";
                isValid = true;
                newGame = new Basketball();
            }
        }
        // Sets the home and away teams
        System.out.print("Enter Home Team: ");
        Team teamName1 = new Team(userInput.next());
        System.out.print("Enter Away Team: ");
        Team teamName2 = new Team(userInput.next());
        newGame.setTeams(teamName1, teamName2);
        System.out.println(teamName1 + " vs " + teamName2 + " in " + sportSelection);
        System.out.println("\nLET THE GAME BEGIN");
        // Starts the game by setting the numPeriod to 1 and each score to 0
        newGame.setNumPeriod();
        int score1 = 0;
        int score2 = 0;
        // while the final period has not been reached, keep asking the user what they want to do in the game
        while (newGame.getNumPeriod() <= newGame.getMaxPeriod()) {
            System.out.println("\nCurrent " + newGame.timeFormat() + ": " + newGame.getNumPeriod());
            System.out.println(newGame.getTeamName2() + " - " +  score2 + ", " + newGame.getTeamName1() + " - " + score1);
            System.out.println("\nMenu:\n");
            // Prints all possible scoring methods for each team
            for (int i = 1; i <= newGame.getOptions(); i++) {
                System.out.println(i + ". " + newGame.getTeamName1() + " " + newGame.getOptionText(i));
            }
            for (int i = 1; i <= newGame.getOptions(); i++) {
                System.out.println(i + newGame.getNumOptions()/2 + ". " + newGame.getTeamName2() + " " + newGame.getOptionText(i));
            }
            // Leaves the final option for ending the quarter/half/period
            System.out.println(newGame.getNumOptions() + ". End " + newGame.timeFormat());
            System.out.print("Enter choice: ");
            String choice = userInput.next(); // Takes in what the user selected
            if(choice.equals(String.valueOf(newGame.getNumOptions()))){
                // if the user wants to end the quarter/half/period, this statement will execute
                newGame.setNumPeriod();
            }
            // Checks if what the user inputted is valid
            else if((Integer.parseInt(choice) <= newGame.getNumOptions()) && (Integer.parseInt(choice) > 0)){
                // if the user inputted a valid number, depending on what team they want to score,
                // that team's score should increase. The amount that is scored depends on how much the associated word
                // should increment their score.
                if((Integer.parseInt(choice) <= newGame.getNumOptions()/2)){
                    score1 += newGame.getScoringMethod(choice);
                }
                else{ // "else" is used here since the above "else if" checks is it was a valid input already
                    score2+=newGame.getScoringMethod(choice);
                }
            }
            else{
                System.out.println("\nTry a different number\n");
            }
        }
        // Prints out the final score and who won after the game has ended
        System.out.println(newGame.getTeamName2() + " - " +  score2 + ", " + newGame.getTeamName1() + " - " + score1);
        if(score1 > score2){
            System.out.println("Winner: " + teamName1);
        }
        else if(score1 < score2){
            System.out.println("Winner: " + teamName2);
        }
        else{
            System.out.print("Game ended in a tie");
        }
    }
}
