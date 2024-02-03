import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description: This class is the "Master" class. the purpose of the master class is to generate 3 random coefficients,
 * and put them into their own array so that array can be passed into an ArrayList that holds all sets of coefficients.
 * This is done through a method so that in the main program, the method simply needs to be called in order to have
 * the coefficients be generated. This class will then use the Worker class to calculate the roots
 * of ONE of the sets of coefficients. The Boss will then will display different information about the roots
 * if the user wants to generate 30 or 3000 coefficients.
 */
public class Boss {

    /**
     * Driver method of the program. This method creates the threads, takes in the user input, puts the coefficients
     * into the queue, and grabs from the Worker created queue to display information about the roots for the situation
     * that the user selects 1. If the user selects 2, there will be statistics printed out about each of the roots printed
     * @param args stores java command line arguments.
     * @throws Exception if the main method does not execute properly.
     */
    public static void main(String[] args) throws Exception {
        // Used for creating exactly 11 threads: 10 threads that are used for calculating the roots
        // and 1 thread that is used for generating the roots
        ExecutorService executorService = Executors.newCachedThreadPool();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose either 1 or 2 to generate and solve:\n");
        System.out.println("1. 30 sets of coefficients\n2. 3000 sets of coefficients");
        int choice = scanner.nextInt();
       // ArrayList<String[]> coefficients = getListOfCoefficients(choice);

        // Creation of the two buffers, one for the coefficients and one for the roots.
        CircularBuffer sharedFirstLocation = new CircularBuffer();
        CircularBuffer sharedSecondLocation = new CircularBuffer();
        int counter1 = 0;
        if(choice == 1){
            CoefficientGenerator coefficientGenerator = new CoefficientGenerator(sharedFirstLocation, 1);
            executorService.execute(coefficientGenerator);
            for(int i = 0; i < 10;i++) {
                executorService.execute(new Worker(sharedFirstLocation, sharedSecondLocation, choice));
            }
            executorService.execute(new PrintRoots(sharedSecondLocation, 1));
            executorService.shutdown();
        }
        else if(choice == 2){
            CoefficientGenerator coefficientGenerator = new CoefficientGenerator(sharedFirstLocation, 2);
            executorService.execute(coefficientGenerator);
            for(int i = 0; i < 10; i++){
                executorService.execute(new Worker(sharedFirstLocation, sharedSecondLocation, choice));
            }
            executorService.execute(new PrintRoots(sharedSecondLocation, 2));
            executorService.shutdown();
        }
    } //
}
