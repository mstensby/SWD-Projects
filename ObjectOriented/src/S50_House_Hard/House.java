package S50_House_Hard;
/**
 *
 * Description: This class allows the user to input the area of their house, color of their door,
 * color of their house, and the number of garages that they have. This class then outputs its own conversion
 * from strings of words to full sentences by overriding the Object method toString. each attribute is initialized
 * through the constructor, so that as soon as the user inputs their attributes in the main function, each of the
 * fields are properly representing the information.
 *
 */
public class House {

    /**
     *  To capture the value of sq. footage (of type double) that is given by the user to display later
     */
    private double areaTotal;

    /**
     * To obtain the string that the user inputs regarding the color of their house
     */
    private String houseColor;

    /**
     *  An instantiation of the door class, which holds the string associated with the color of their door
     */
    Door door;

    /**
     * Purpose: to capture the input of the user's number of garages in order to display the number later
     */
    private int numGarage;

    /**
     * This constructor initializes the users area, color of the door,
     * color of the house, and the number of garages. This allows the user to input the attributes of their house
     * upon the creation of the House object
     * @param userArea represents the area that the user inputted
     * @param colorHouse represents the color of the user's house
     * @param garageNum represents the number of garages for that particular house
     * @param door represents the door class (which is used for finding the color of the door)
     */
    public House(double userArea, String colorHouse, int garageNum, Door door){
        areaTotal = userArea;
        this.door = door;
        houseColor = colorHouse;
        numGarage = garageNum;
    }

    /**
     * @return each attribute of the House class
     */
    public String getHouseColor(){return houseColor;}
    public int getNumGarage(){return numGarage;}
    public double getAreaTotal(){return areaTotal;}

    /**
     *To change how each variable is outputted after it is called in a print statement in main
     * @return the complete string that is shown to the user
     */
    @Override
    public String toString(){
        String areaOut = getAreaTotal() + " square feet.\n";
        String numGarageOut = "I have a " + getNumGarage() + " car garage.\n";
        String houseColorOut = "I have a " + getHouseColor() + "-colored building.\n";
        return areaOut + door + numGarageOut + houseColorOut;
    }
}


