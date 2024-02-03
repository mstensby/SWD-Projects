import java.util.Arrays;
import java.util.HashMap;

/**
 * This class takes in the user's input and calculates the optimal enjoyment for the meal being served during Thanksgiving.
 * This is done through passing each of the volumes and enjoyments into the constructor so that the ratio of
 * enjoyment to volume can be calculated. How they are calculated is explained in the calcEnjoyment() method.
 */
public class EnjoymentCalculator {
    /**
     * used to hold all the distinct volumes set by the user
     */
   private double vol1, vol2, vol3, vol4, vol5, vol6, vol7; // Each of the 7 volumes for each of the 7 different foods
    /**
     * used to hold all the distinct enjoyment ratings set by the user
     */
    private double enjoy1, enjoy2, enjoy3, enjoy4, enjoy5, enjoy6, enjoy7; // Each of the 7 enjoyment levels
    /**
     * Used to hold all distinct ratios
     */
    private double ratio1,ratio2,ratio3,ratio4,ratio5,ratio6,ratio7;
    /**
     * used to hold all ratios in an array, so they can later be used to find the most efficient volume and enjoyment
     */
    private double[] ratios;
    /**
     * Used to hold all enjoyments in an array, so tehy can later be used to find the enjoyment associated with the best ratio
     */
    private double[] enjoyments;
    /**
     * Used to hold all volumes in an array, so they can later be used to find the weight associated with the best ratio
     */
    private double[] volumes;
    /**
     * Used to determine the index associated with the most effective ratio. This is helpful for when the ratio used should no longer be used
     * if it does not fit in the remaining capacity
     */
    private int weightIndex = 0;
    /**
     * Used to hold the value that is added to the optimal enjoyment
     */
    private double currentFoodEnjoyment = 0;
    /**
     * Used to hold the value that is subtracted from the remaining capacity
     */
    private double currentFoodWeight = 0;
    /**
     * used to hold the max capacity set by the user
     */
   private double capacity;
    /**
     * used to output the highest possible enjoyment given all foods and their enjoyment level, weight, and capacity
     */
   private double optimalEnjoyment = 0;

    /**
     * Used to pass in each of the weight and enjoyments set by the user
     * @param vol1 Turkeys weight
     * @param vol2 Stuffings weight
     * @param vol3 Pies weight
     * @param vol4 Mac and Cheese weight
     * @param vol5 Mashed Potatoes weight
     * @param vol6 Gravy's weight
     * @param vol7 Corn Casserole weight
     * @param enjoy1 Turkeys enjoyment
     * @param enjoy2 Stuffings enjoyment
     * @param enjoy3 Pies enjoyment
     * @param enjoy4 Mac and Cheese enjoyment
     * @param enjoy5 Mashed Potatoes enjoyment
     * @param enjoy6 Gravy's enjoyment
     * @param enjoy7 Corn casserole enjoyment
     * @param capacity max stomach capacity
     */

    public EnjoymentCalculator(double vol1, double vol2, double vol3, double vol4, double vol5, double vol6, double vol7, double enjoy1,
                               double enjoy2, double enjoy3, double enjoy4, double enjoy5, double enjoy6, double enjoy7, double capacity){
        this.vol1 = vol1;
        this.vol2 = vol2;
        this.vol3 = vol3;
        this.vol4 = vol4;
        this.vol5 = vol5;
        this.vol6 = vol6;
        this.vol7 = vol7;
        this.enjoy1 = enjoy1;
        this.enjoy2 = enjoy2;
        this.enjoy3 = enjoy3;
        this.enjoy4 = enjoy4;
        this.enjoy5 = enjoy5;
        this.enjoy6 = enjoy6;
        this.enjoy7 = enjoy7;
        this.capacity = capacity;
    }

    /**
     * This method calculates each of the associated enjoyment to volume ratios. These ratios are used to determine the
     * ranking of most efficient food to the least efficient food. The food item with the highest efficiency is
     * the one with the highest amount of enjoyment for the lowest amount of weight. The first array
     * is to associate the enjoyment rating with its ratio and the second one is to associate the volume with its ratio.
     * This is used after the ratio is sorted in an array so the best possible enjoyment rating will always be used if
     * the capacity is not less than the associated weight. In the scenario that the capacity is lower than the
     * associated weight with the best ratio, the next best ratio will be used until the capacity is less than or equal
     * to 0.
     * @return  the maximum enjoyment for the Thanksgiving meal.
     */
    public double calcEnjoyment(){
        ratio1 = enjoy1/vol1;
        ratio2 = enjoy2/vol2;
        ratio3 = enjoy3/vol3;
        ratio4 = enjoy4/vol4;
        ratio5 = enjoy5/vol5;
        ratio6 = enjoy6/vol6;
        ratio7 = enjoy7/vol7;
        // The values will change depending on the user's input
        ratios = new double[]{ratio1, ratio2, ratio3, ratio4, ratio5, ratio6, ratio7};
        volumes = new double[] {vol1,vol2,vol3,vol4,vol5,vol6,vol7};
        enjoyments = new double[] {enjoy1,enjoy2,enjoy3,enjoy4,enjoy5,enjoy6,enjoy7};
        // finds the first ratio to be used
        getMaxRatio();
        currentFoodEnjoyment = enjoyments[weightIndex];
        currentFoodWeight = volumes[weightIndex];
        int numUnworkable = 0;
        int reset = 0;
        // First checks to make sure that at least one of the foods can be eaten
        for(int i = 0; i < 6; i++){
            if(volumes[i] > capacity){
                numUnworkable++;
            }
        }
        if(numUnworkable == 6){ // if no food can be eaten, then the default value is returned (0)
            return Math.round(optimalEnjoyment);
        }
        // checks if the current food weight can fit in the remaining capacity, and if it can then the capacity will
        // be subtracted and the optimal enjoyment will be added to the current enjoyment associated with the most efficient ratio
        while(capacity > 0){
            if(capacity >= currentFoodWeight){
                capacity = capacity - currentFoodWeight;
                optimalEnjoyment = optimalEnjoyment + currentFoodEnjoyment;
            }
            // if the current food weight associated with the best ratio can not be used, the ratio should be set to
            // zero and the next best ratio is found. This continuously loops until the capacity is <= 0
            else{
                ratios[weightIndex] = 0;
                getMaxRatio();
            }
        }
        return Math.round(optimalEnjoyment); // rounded for formatting
    }

    /**
     * Used for determining the maximum ratio that can be used to optimally fill the user's capacity. This method
     * is also used to find the index that should be set to zero in the situation that the best ratio can no longer be
     * used. After this happens, the next best ratio is found.
     */
    public void getMaxRatio(){
        double tmp = 0;
        for(int i = 0; i < volumes.length; i++){
            if(ratios[i] > tmp){
                weightIndex = i; // grabs the index associated with the most efficient ratio
                tmp = ratios[i]; // assigns tmp to the next best ratio
                currentFoodEnjoyment = enjoyments[i];
                currentFoodWeight = volumes[i];
            }
        }
    }
}
