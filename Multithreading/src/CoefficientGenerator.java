import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class is used to create the coefficients that will be passed into the Worker. This is a runnable class so it is
 * able to generate the coefficients concurrently with the threads pulling it from the buffer. This allows for faster
 * runtime
 */

public class CoefficientGenerator implements Runnable{
    /**
     * used for holding the coefficients before the worker is able to take them
     */
    CircularBuffer buffer1;
    /**
     * tracks user input
     */
    private int userChoice;
    /**
     * tracks number of coefficients that have been put into the buffer
     */
    private int coefNumber = 1;

    /**
     * sets the shared circular buffer as well as what the user selected
     * @param buffer1 shared buffer for coefficients
     * @param userChoice user choice determined in command line
     */

    public CoefficientGenerator(CircularBuffer buffer1, int userChoice){
        this.buffer1 = buffer1;
        this.userChoice = userChoice;

    }
    /**
     * This method is used by the Boss class to generate 30 or 3000 sets of coefficients
     */
    @Override
    public void run() {
        Random randNumber = new Random();
        String[] setOfCoefficients = new String[4];
        ArrayList<String[]> coefficients = new ArrayList<>();
        if(userChoice == 1) {
            for (int i = 0; i < 30; i++) {
                // generates sets of coefficients and then puts each of them into an ArrayList
                setOfCoefficients[0] = String.valueOf(randNumber.nextDouble(10));
                setOfCoefficients[1] = String.valueOf(randNumber.nextDouble(10));
                setOfCoefficients[2] = String.valueOf(randNumber.nextDouble(10));
                coefficients.add(setOfCoefficients);
                try {
                    // prints the number of coefficients generated
                    buffer1.blockingPut(coefficients.get(i));
                    System.out.println("Coefficient #"  + coefNumber + ": "+ coefficients.get(i)[0] + ", " +
                            coefficients.get(i)[1] + ", " + coefficients.get(i)[2]);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                coefNumber++;
            }
        }
        else if(userChoice == 2){
            for(int i = 0; i < 3000; i++){
                setOfCoefficients[0] = String.valueOf(randNumber.nextDouble(10));
                setOfCoefficients[1] = String.valueOf(randNumber.nextDouble(10));
                setOfCoefficients[2] = String.valueOf(randNumber.nextDouble(10));
                coefficients.add(setOfCoefficients);
                try{
                    buffer1.blockingPut(coefficients.get(i));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                coefNumber++;
            }
        }
    }
}
