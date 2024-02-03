package S50_House_Hard;
public class House_HardDriver {
    public static void main(String[] args) {
        SmallApartment myApartment = new SmallApartment();
        House myHouse = new House(1000, "brown", 2, new Door("beige"));
        Person myPerson = new Person("Matt", myHouse);
        Person myPerson2 = new Person("Smithers", myApartment);
        System.out.println("I have a house. " + myPerson); // This is where the toString method affects how it is printed. NOT DURING OBJECT INSTANTIATION
        System.out.println("I have an apartment. " + myPerson2);
    }
}