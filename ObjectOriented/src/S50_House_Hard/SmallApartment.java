package S50_House_Hard;

/**
 *Description: This class is a subclass of the class House. In this, all
 * Apartments have a preset area of 500, a preset door color of black,
 * and a preset color of their apartment as soon as a SmallApartment object is created. This class is then used
 * if the user has an apartment instead of a house
 */
public class SmallApartment extends House {
    SmallApartment() {
        super(500, "multi", 0, new Door("black"));
    }

}
