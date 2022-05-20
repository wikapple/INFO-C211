/*  Author: William Applegate
    Course: INFO-C211
    Date: 1/19/2022

    Program Description: This is a single class program that represents vehicle
    properties. The program includes constructors to instantiate vehicle 
    objects. Methods are used to obtain user input through the terminal, output
    vehicle information and compare vehicle objects.
*/

package hw1a;                                    // this class is inside of 
                                                 // hw1a package

import java.util.Scanner;                        // Import Scanner in order to
                                                 // obtain input from terminal

public class Vehicle2 
{
/*  Vehicle2 class was created to hold information about a vehicle object. There
are two attributes, vehicle type and color, that are represented by string 
values. The other two attributes are the number of tires and fabrication year, 
which are represented by integers. The class includes two constructors for
instantiating objects. Methods are used to receive input about object properties
from the user and output attributes via the terminal. A static scanner object
is used to obtain user input in the terminal. There are two methods used to
compare different vehicles by their number of tires and fabrication year, both 
of which return boolean values. The class includes a static main method to test 
instances of the class and its methods.  */
    
    String vehicleType, color;                    // Attributes hold the string
                                                  // representations of vehicle
                                                  // type and vehicle color.
    
    int numberOfWheels, fabricationYear;          // Attributes hold integer 
                                                  // representation for the 
                                                  // number of wheels and the 
                                                  // fabrication year.
    
    //Scanner obejct instantiated for obtaining user input.
    private static Scanner scan = new Scanner(System.in);
    
    
    public Vehicle2()
    {
    /*  This is a no-argument constructor that uses constructor chaining to 
        pass parameter values to the next constructor. Attributes with string 
        values are passed as empty strings and integer values are passed as 0.
    */
        
        this("", 0, 0, "");                                            
    }
    
    
    public Vehicle2(String typeInp, int wheelsInp, int fabYearInp,
            String colorInp)
    {
    /*  This constructor accepts four parameter values in order to create
        vehicle 2 objects with a given type, number of wheels, fabrication year
        and color.  */
        
        vehicleType = typeInp;                      // All attributes of
        numberOfWheels = wheelsInp;                 // instance are assigned a 
        fabricationYear = fabYearInp;               // value from parameters
        color = colorInp;
    }
    
    
    public void input()
    {
    /*  The input method prompts the user for input on four separate lines in 
        the terminal. These inputs represent the vehicle2 instance attributes of
        type, number of tires, production year, and color. This method assumes
        it will recieve integer values from the user for number of wheels and
        production year.   */
        
        // Request user input for vehicle type. Assign the vehicleType String 
        // the value the user enters.
        System.out.println("Enter the vehicle type, and then press enter: ");
        
        vehicleType = scan.nextLine();                  //Assign value          
        
        // Request user input for number of wheels. Assign the numberOfWheels 
        // int the value the user enters.
        System.out.println("Enter the vehicle's number of wheels, and then "
        + "press enter: ");
        
        numberOfWheels = scan.nextInt();                //Assign value
        
        // Request user input for the fabrication year. Assign the
        //fabricationYear int the value the user enters.
        System.out.println("Enter the vehicle's fabrication year, using "
            + "four number format (yyyy) and then press enter: ");
        
        fabricationYear = scan.nextInt();               //Assign value
        
        // Request user input for vehicle color. Assign the color String the  
        // value the user enters.
        System.out.println("Enter the vehicle's color, and then press enter: ");
        
        color = scan.next();                            //Assign value
   
        System.out.println();                           // Terminal line break
    }
    
    
    public void output()
    {
    /*  This method outputs attribute values to the terminal, using two lines.
    */
    
        System.out.println("Vehicle Type: " + vehicleType + "\t" + 
                "Number of Wheels: " + numberOfWheels + "\n" + 
                "Fabrication Year: " + fabricationYear + "\t" + 
                "Vehicle Color: " + color + "\n");
    }
    
    
    public boolean isBigger(Vehicle2 otherVehicle)
    {
    /*  This method compares this Vehicle2 object to another one passed into the
        method as a parameter. The method returns true if this object has more
        wheels than the other vehicle that was passed. Returns false if 
        this object has lesser than or equal to the number of wheels in the 
        other vehicle object. */
    
        return numberOfWheels > otherVehicle.numberOfWheels;
    }
    
    
    public boolean isNewer(Vehicle2 otherVehicle)
    {
    /*  This method compares this Vehicle2 object to another one passed to the 
        method as a parameter. The method returns true if this object is newer,
        or has a higher 'production year' value than the other vehicle
        being passed. The method returns false if this object is older than 
        the other vehicle, or if the production year for both objects are the 
        same.   */    
    
       return fabricationYear > otherVehicle.fabricationYear;
    }
    
    
    public static void main(String[] args) {
        /*  The static main method tests the vehicle2 class by instantiating 
            two Vehicle2 objects, calling different constructors. Tha method
            then calls the input method for user input in order to assign new 
            attribute values. The method outputs vehicle attributes to the 
            terminal. Method uses comparitive methods and conditional if 
            statements to output vehicle comparison information to the terminal.
        */
        
        //Instantiate a Vehicle2 object using no-argument constructor:
        Vehicle2 firstVehicle = new Vehicle2();
        
        //Instantiate a Vehicle2 object entering all attributes as parameters:
        Vehicle2 secondVehicle = new Vehicle2("Truck", 6, 2004, "White");
        
        
        firstVehicle.input();                           // Call input method
                                                        // to change attributes
                                                        // of firstVehicle 
                                                       
                                                        
        System.out.println("First Vehicle: ");          // Call output method
        firstVehicle.output();                          // on first vehicle
        
        System.out.println("Second Vehicle: ");         // Call output method 
        secondVehicle.output();                         // on second vehicle
                  
        
        /* If/Else statements print strings to terminal based on object
           comparisons:     */
        if(firstVehicle.isBigger(secondVehicle))   // If this vehicle is bigger:     
            System.out.println("The first vehicle is bigger than the second"
                + " vehicle.");
        else                                       // If not bigger:
            System.out.println("The first vehicle is not bigger than the second"
                + " vehicle");

                                                   
        if(firstVehicle.isNewer(secondVehicle))    // If this vehicle is newer:
            System.out.println("The first vehicle is newer than the second"
                + " vehicle");
        else                                       // If not newer:
            System.out.println("The first vehicle is not newer than the second "
                + "vehicle");
      
    }
}
