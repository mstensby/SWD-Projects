package S50_House_Hard;

/**
 * Description: Allows the user to input the color of their door since that differs from user to user. This is done
 * through the constructor, so as soon as the attribute door is fulfilled in the main, the toString method will have
 * access to what the user inputted. The toString method is what allows the Door to be printed to the screen in the
 * desired format.
 */
public class Door {
    /**
     *  Stores the color of the user's door
     */
    private String doorColor;

    /**
     * To set the color of the door to what the user inputs upon object creation
     * @param colorDoor represents the color of the door that the user inputted
     */
    public Door(String colorDoor){
        doorColor = colorDoor;
    }

    /**
     *  To access what the door color is set to in order to adjust how it is outputted later
     * @return the Door's color
     */
    public String getDoorColor(){return doorColor;}

    /**
     *  To change how the variable doorColor is outputted after called in a print statement in main
     * @return The outputted string that contains the color that the user entered
     */
    @Override
    public String toString(){
        String doorColorOut = "I have a " + getDoorColor() + " door.\n";
        return doorColorOut;
    }
}
