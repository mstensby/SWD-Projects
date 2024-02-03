package S50_House_Hard;

/**
 * Description: Allows the user to input their name and their house attributes to be outputted
 * in a different format later. This is done through a toString method that concatenates the inputted name
 * as well as the inputted information for their attributes of their house or apartment.
 */
public class Person {
    /**
     * Stores the users name
     */
    private String name;
    /**
     * Stores the house object that is created by the user
     */
    private House house;

    /**
     * Takes in both input values and sets them to the private attributes of Person
     * @param name stores the name of the user or whatever name they put in
     * @param house stores all attributes of the house of that specific person
     */
    Person(String name, House house){
        this.house = house;
        this.name = name;
    }

    /**
     * To reformat how the user's name and house attributes are outputted after creation through objects
     * in main
     * @return
     */
    @Override
    public String toString(){
        return "My name is " + this.name + ", my place is " + house;
    }
}
