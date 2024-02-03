import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description: This class is going to be used to take care of everything to do with solving for the roots of the
 * sets of random coefficients. First, a circular buffer is used by the Boss to pass in one set of coefficients at a time.
 * Each thread will then take in the coefficients, calculate the roots of the given coefficients, and put it back into
 * a different queue which can be used by the Boss to print out information regarding the roots.
 */
public class Worker implements Runnable {
    /**
     * used for grabbing the coefficients from the coefficient generator
     */
    private final Buffer sharedLoc1; // input
    /**
     * used for placing the found roots into a different circular buffer so they can be printed later
     */
    private final Buffer sharedLoc2; // output for 30 sets

    private int userChoice;


    /**
     * Constructor takes in two parameters and sets the buffer and the capacity of the threads.
     * @param sharedLoc1 allows access to the circular buffer
     */
    public Worker(Buffer sharedLoc1, Buffer sharedLoc2, int userChoice){
        this.sharedLoc1 = sharedLoc1;
        this.sharedLoc2 = sharedLoc2;
        this.userChoice = userChoice;
    }

    /** Calculates the roots of the random coefficients.
 There is a special case for when the roots are imaginary roots, therefore the roots may never change
 if the discriminant is > 0. If the root is 0, then the second root will be set to null and the array of roots
 will only have one root. The root(s) will then be put into their own array that will be passed into the second
 buffer.
 */
    public static String[] calculateRoots(String[] coefficients){
        String root1;
        String root2;
        String a = coefficients[0], b = coefficients[1], c = coefficients[2];
        double newB = Double.parseDouble(b);
        double newA = Double.parseDouble(a);
        double newC = Double.parseDouble(c);
        double discriminant = (newB * newB) - (4 * newA * newC);
        root1 = String.valueOf((-1*newB + Math.sqrt(Math.abs(discriminant))) / (2 * newA));
        root2 = String.valueOf((-1*newB - Math.sqrt(Math.abs(discriminant))) / (2 * newA));
        String[] roots;
        if (discriminant < 0) {
            root1 = root1  + "i";
            root2 = root2 + "i";
            roots = new String[2];
            roots[0] = root1;
            roots[1] = root2;
        } else if (discriminant == 0) {
            roots = new String[1];
            roots[0] = root1;
        } else {
            roots = new String[2];
            roots[0] = root1;
            roots[1] = root2;
        }
        return roots;
    }

    /**
     * This method is an overridden method from the Runnable class. This class runs whenever a thread is used.
     * The method takes in no values and returns no value. This means that all the work being done to find
     * the roots is going to be put into the Circular Buffer through the BlockingPut method.
     * The buffer is what allows the transfer of coefficients and roots between the Boss and the Worker classes.
     */
    @Override
    public void run() {
        String[] coefficients;
        if (userChoice == 1) {
            while (sharedLoc1.getNumCoefPrinted() != 30) {
                try {
                    coefficients = sharedLoc1.blockingGet();
                    String[] roots = calculateRoots(coefficients);
                    sharedLoc2.blockingPut(roots);
                    sharedLoc1.setNumCoefPrinted(sharedLoc1.getNumCoefPrinted() + 1);
                    // waits until the second buffer is used, so you know that the coefficient was generated
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
       else if(userChoice == 2){
            while(sharedLoc1.getNumCoefPrinted() != 3000){
                try {
                    coefficients = sharedLoc1.blockingGet();
                    String[] roots = calculateRoots(coefficients);
                    sharedLoc2.blockingPut(roots);
                    sharedLoc1.setNumCoefPrinted(sharedLoc1.getNumCoefPrinted()+1);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
