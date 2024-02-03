/**
 * The purpose of this interface is that so any type of buffer can be made through this interface, but a circularBuffer
 * is used in this problem.
 */
public interface Buffer {
    void blockingPut(String[] value) throws Exception;
    String[] blockingGet() throws Exception;
    int getNumCoefPrinted();
    void setNumCoefPrinted(int value);
    int getRootsPrinted();
    void setRootsPrinted(int value);
}
