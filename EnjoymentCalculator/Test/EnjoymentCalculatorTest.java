import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is used as an exhaustive testing of what the optimal enjoyment should be and what the returned value is from
 * the created class.
 */
public class EnjoymentCalculatorTest{
    EnjoymentCalculator enjoymentTest;
    private double optimal;
    @Test
    public void testOptimalEnjoyment1(){
        enjoymentTest = new EnjoymentCalculator(3,2,4,10,2,7,12,4,
                2,5,10,3,5,17,20);
        optimal = enjoymentTest.calcEnjoyment();
        assertEquals(30,optimal);
    }
    @Test
    public void testOptimalEnjoyment2(){
        enjoymentTest = new EnjoymentCalculator(3,2,4,1,2,10,15,4,2,5,1,3,14,24,41);
        optimal = enjoymentTest.calcEnjoyment();
        assertEquals(64,optimal);
    }
    @Test
    public void testOptimalEnjoyment3(){
        enjoymentTest = new EnjoymentCalculator(3,4,1,2,1,2,3,5,12,1,5,1,2,3,7);
        optimal = enjoymentTest.calcEnjoyment();
        assertEquals(18,optimal);
    }
    @Test
    public void testOptimalEnjoyment4(){

        enjoymentTest = new EnjoymentCalculator(3,4,1,2,1,2,3,6,9,0.5,4,1,2,3,9);
        optimal = enjoymentTest.calcEnjoyment();
        assertEquals(19,optimal);
    }
    @Test
    public void testOptimalEnjoyment5(){
        enjoymentTest = new EnjoymentCalculator(6,7,7,8,8,9,9,11,12,12,12,12,12,12,5);
        optimal = enjoymentTest.calcEnjoyment();
        assertEquals(0,optimal);
    }
    @Test
    public void testOptimalEnjoyment6(){
        enjoymentTest = new EnjoymentCalculator(3,4,1,2,1,2,3,6,0.5,4,1,2,3,9,19);
        optimal = enjoymentTest.calcEnjoyment();
        assertEquals(76,optimal);
    }
    @Test
    public void testOptimalEnjoyment7(){
        enjoymentTest = new EnjoymentCalculator(3,4,7,8,12,13,5,5,3,8,4,9,10,4,1);
        optimal = enjoymentTest.calcEnjoyment();
        assertEquals(0,optimal);
    }
    @Test
    public void testOptimalEnjoyment8(){
        enjoymentTest = new EnjoymentCalculator(5,6,7,8,9,10,11,12,13,14,15,16,17,18,1);

        optimal = enjoymentTest.calcEnjoyment();
        assertEquals(0,optimal);
    }
    @Test
    public void testOptimalEnjoyment9(){
        enjoymentTest = new EnjoymentCalculator(5,6,7,8,9,10,11,12,13,14,15,16,17,18,100);

        optimal = enjoymentTest.calcEnjoyment();
        assertEquals(240,optimal);
    }
    @Test
    public void testOptimalEnjoyment10(){
        enjoymentTest = new EnjoymentCalculator(5,6,7,8,9,10,11,12,13,14,15,16,17,18,40);

        optimal = enjoymentTest.calcEnjoyment();
        assertEquals(96,optimal);
    }
}