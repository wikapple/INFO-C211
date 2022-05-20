
package hw1;
import java.util.Scanner;

/**
 * Author: William Applegate
 * INFO-C211
 * 
 * Vehicle class simulates a vehicle object with basic properties and behaviors
 */
public class Vehicle {
    
    /*Data Fields*/
    String vehicleType;
    int numberOfWheels;
    int fabricationYear;
    String color;
    private static Scanner scan = new Scanner(System.in);
    
    /*Constructors*/
    public Vehicle(){
        this("", 0, 0, "");
    }
    
    public Vehicle(String typeInp, int wheelsInp, 
            int fabYearInp, String colorInp){
        
        vehicleType = typeInp;
        numberOfWheels = wheelsInp;
        fabricationYear = fabYearInp;
        color = colorInp;
    }
    
    /*Input Method*/
    public void input(){
        System.out.println("Enter the vehicle type: ");
        vehicleType = scan.nextLine();
        
        System.out.println("Enter the vehicle's number of wheels: ");
        numberOfWheels = scan.nextInt();
        
        System.out.println("Enter the vehicle's fabrication year: ");
        fabricationYear = scan.nextInt();
        
        System.out.println("Enter the vehicle's color: ");
        color = scan.next();
    }
    
    /*Output Method*/
    public void output(){
        System.out.println("Vehicle Type: " + vehicleType + "\t" + 
                "Number of Wheels: " + numberOfWheels + "\t" + 
                "Fabrication Year: " + fabricationYear + "\t" + 
                "Vehicle Color: " + color);
    }
    
    /*Comparison Methods*/
    public boolean isBigger(Vehicle otherVehicle){
        
        return numberOfWheels > otherVehicle.numberOfWheels;
    }
    
    public boolean isNewer(Vehicle otherVehicle){
        
       return fabricationYear > otherVehicle.fabricationYear;
    }
    
    /*Main Method*/
    public static void main(String[] args) {
        Vehicle firstVehicle = new Vehicle();
        
        Vehicle secondVehicle = new Vehicle("Truck", 6, 2004, "White");
        firstVehicle.input();
        
        
        System.out.println("First Vehicle: ");
        firstVehicle.output();
        System.out.println("Second Vehicle: ");
        secondVehicle.output();
        
        
        if(firstVehicle.isBigger(secondVehicle)){
            System.out.println("The first vehicle is bigger than the second"
                    + " vehicle.");
        }else{
            System.out.println("The first vehicle is not bigger than the second"
                    + " vehicle");
        }
        
        if(firstVehicle.isNewer(secondVehicle)){
            System.out.println("The first vehicle is newer than the second"
                    + " vehicle");
        }else{
            System.out.println("The first vehicle is not newer than the second "
                    + "vehicle");
        }
    }
    
}
