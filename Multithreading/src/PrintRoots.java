/**
 * The purpose of this class is to print out each of the roots one by one as they are being put into the circular buffer.
 * This is done by creating a runnable class that waits for the buffer to be filled by the worker so that each of the roots
 * are able to be pulled before the buffer fills up.
 */
public class PrintRoots implements Runnable {
    /**
     * Shared circular buffer that holds the roots (filled by worker class)
     */
    private final Buffer sharedLoc2;
    /**
     * Tracks number of root pairs that have been printed to the screen
     */
    private int negativeRoot = 0;
    private int positiveRoot = 0;
    private int pairNumber = 1;
    private int userChoice;

    /**
     * Sets the buffer so that the worker and the root printer are using the same buffer
     * @param sharedLoc2 shared ciruclar buffer for roots
     */
    public PrintRoots(Buffer sharedLoc2, int userChoice){

        this.sharedLoc2 = sharedLoc2;
        this.userChoice = userChoice;
    }

    /**
     * The purpose of this class is to control what the PrintRoots thread should do while it is active. In this situation,
     * it needs to wait until the number of roots printed equals 30 and then print the roots one by one. This is done
     * through waiting and then taking them out of the buffer so that they can be used.
     */
    @Override
    public void run() {
        String[] roots;
        if(userChoice == 1){
            while(sharedLoc2.getRootsPrinted()!= 30){
                try {
                    roots = sharedLoc2.blockingGet();
                    if(roots[0].contains("i") || roots[1].contains("i")){
                        negativeRoot++;
                    }
                    else{
                        positiveRoot++;
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Root Pair #" + pairNumber + ": " +roots[0] + ", " + roots[1]);
                pairNumber++;
                sharedLoc2.setRootsPrinted(sharedLoc2.getRootsPrinted()+1);
            }
        }
        else if(userChoice == 2){
            while(sharedLoc2.getRootsPrinted()!=3000){
                try{
                    roots = sharedLoc2.blockingGet();
                    if(roots[0].contains("i") || roots[1].contains("i")){
                        negativeRoot++;
                    }
                    else{
                        positiveRoot++;
                    }
                }catch (Exception e){
                    throw  new RuntimeException();
                }
                sharedLoc2.setRootsPrinted(sharedLoc2.getRootsPrinted()+1);
            }
        }
        System.out.println("Number of negative roots: " + negativeRoot);
        System.out.println("Number of positive roots: " + positiveRoot);
    }
}
