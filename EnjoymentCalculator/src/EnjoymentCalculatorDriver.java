import java.util.Scanner;

/**
 * The purpose of this class is to allow the user to play the Thanksgiving game. In this situation, the user
 * is given the ability to input the volume and enjoyment of each food. After this, the user is then able to set the
 * max capacity of their stomach. Once all of these numbers are set by the user, an optimal enjoyment is calculated
 * through the EnjoymentCalculator.
 */
public class EnjoymentCalculatorDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double vol1, vol2, vol3, vol4, vol5, vol6, vol7; // Each of the 7 volumes for each of the 7 different foods
        double enjoy1, enjoy2, enjoy3, enjoy4, enjoy5, enjoy6, enjoy7; // Each of the 7 enjoyment levels
        double capacity; // the max stomach capacity of the user
        double enjoyment; // final enjoyment rating
        System.out.println("Welcome to Grandma's House. Please enter the volume and enjoyment level of each food " +
                "listed below:");
        System.out.print("Turkey's weight: ");
        vol1= scanner.nextDouble();
        System.out.print("Turkey's enjoyment level: ");
        enjoy1 = scanner.nextDouble();
        System.out.print("Stuffing's weight: ");
        vol2 = scanner.nextDouble();
        System.out.print("Stuffing's enjoyment level: ");
        enjoy2 = scanner.nextDouble();
        System.out.print("Pie's weight: ");
        vol3 = scanner.nextDouble();
        System.out.print("Pie's enjoyment level: ");
        enjoy3 = scanner.nextDouble();
        System.out.print("Mac and Cheese's weight: ");
        vol4 = scanner.nextDouble();
        System.out.print("Mac and Cheese's enjoyment level: ");
        enjoy4 = scanner.nextDouble();
        System.out.print("Mashed Potatoes' weight: ");
        vol5 = scanner.nextDouble();
        System.out.print("Mashed Potatoes' enjoyment level: ");
        enjoy5 = scanner.nextDouble();
        System.out.print("Gravy's weight: ");
        vol6 = scanner.nextDouble();
        System.out.print("Gravy's enjoyment level: ");
        enjoy6 = scanner.nextDouble();
        System.out.print("Corn Casserole's weight: ");
        vol7 = scanner.nextDouble();
        System.out.print("Corn Casserole's enjoyment level: ");
        enjoy7 = scanner.nextDouble();
        System.out.print("Max stomach capacity: ");
        capacity = scanner.nextDouble();
        EnjoymentCalculator calculator = new EnjoymentCalculator(vol1, vol2, vol3, vol4, vol5, vol6, vol7, enjoy1, enjoy2,
                enjoy3, enjoy4, enjoy5, enjoy6, enjoy7, capacity);
        enjoyment = calculator.calcEnjoyment();
        System.out.println("\nCalculated Optimal Enjoyment: " + Math.round(enjoyment));
        // second rounding is used for output formatting
    }
}
