// Fig. 23.18: CircularBuffer.java
// Synchronizing access to a shared three-element bounded buffer.

/**
 * The purpose of the buffer is that each of the threads have the ability to grab from the buffer,
 * find the roots of the coefficients, and then be able to put them back into a separate buffer which can then either
 * be 1. printed or 2. summarize statistics about how the sets of coefficients were processed
 */
public class CircularBuffer implements Buffer {
    /**
     * Creates a buffer that is of size 10, and at each index there is an array of size 3.
     */
    private final String[][] buffer = new String[2000][3];
    /**
     * Counts the number of buffers currently being used
     */
    private int occupiedCells = 0;
    /**
     * Index of the next element to write to
     */
    private int writeIndex = 0;
    /**
     * Index of the next element to be read
     */
    private int readIndex = 0;
    /**
     * Number of coefficients that have been printed so far
     */
    private int numCoefPrinted = 0;
    /**
     * Number of roots that have been printed so far
     */
    private int rootsPrinted = 0;

    /**
     * getter for the number of coefficients printed
     * @return the number of coefficients that have been printed so far
     */
    public int getNumCoefPrinted(){
        return numCoefPrinted;
    }

    /**
     * setter for the number of coefficients printed
     * @param value the number of coefficients that have been printed so far
     */
    public void setNumCoefPrinted(int value){this.numCoefPrinted = value;}

    /**
     * getter for the number of roots printed
     * @return the number of roots printed
     */
    public int getRootsPrinted(){return rootsPrinted;}

    /**
     * Setter for number of roots printed
     * @param value number of roots printed
     */
    public void setRootsPrinted(int value){this.rootsPrinted = value;}

    /**
     * puts values into the queue
     * @param value the array of either coefficients or roots that need to be put into the queue
     * @throws InterruptedException if there is nothing to be put into the queue, an exception will be thrown
     */
    @Override
    public synchronized void blockingPut(String[] value)
            throws InterruptedException {
        // wait until buffer has space available, then write value;
        // while no empty locations, place thread in blocked state
        while (occupiedCells == buffer.length) {
            wait(); // wait until a buffer cell is free
        }

        buffer[writeIndex] = value; // set new buffer value

        // update circular write index
        writeIndex = (writeIndex + 1) % buffer.length;
        ++occupiedCells; // one more buffer cell is full
        // makes sure that there is occupied cells before notifying threads
            notifyAll(); // notify threads waiting to read from buffer
    }

    /**
     * this method returns a set of coefficients that can be used by the Worker to find the roots.
     * @return reads the value from the buffer and outputs the value;
     * @throws InterruptedException if the thread being sued gets interrupted, this exception will be thrown.
     */
    @Override
    public synchronized String[] blockingGet() throws InterruptedException {
        // wait until buffer has data, then read value;
        // while no data to read, place thread in waiting state
        while (occupiedCells == 0) {
            wait(); // wait until a buffer cell is filled
        }

        String[] readValue = buffer[readIndex]; // read value from buffer

        // update circular read index
        readIndex = (readIndex + 1) % buffer.length;
        --occupiedCells; // one fewer buffer cells are occupied
            notifyAll(); // notify threads waiting to use the buffer that they should use it
        return readValue;
    }
}

