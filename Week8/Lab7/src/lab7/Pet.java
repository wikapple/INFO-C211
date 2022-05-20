/*  Author: William Applegate   
    Course: INFO-C211
    Date: 03/02/2022

    Program Description:  This program serves as a training 
    exercise on abstraction and inheritance in java. The program has 
    an abstract class Pet that provides common attributes as well as 
    abstract methods. The classes Cat, Dog, and Parrot all inherit 
    from Pet and are specific to the animal they partially represent. 
    The TestPet class holds the main method, and is used to create an
    array of Pet objects and call their methods, specific to the child 
    classes.
*/

package lab7;               // This class is within the lab7 package.


public abstract class Pet implements Comparable<Pet>
{
/*  The abstract class Pet represents the common characteristics of 
    the sub-classes Dog, Cat and Parrot. Pet implements the Comparable
    interface by overriding the compareTo method in order to compare 
    instances of the Pet class. The class contains two attributes. The 
    attribute name of type String represents the Pet object's name. 
    The attribute birthYear of type int represents the Pet object's 
    year of birth. The class has two constructors. The first 
    constructor is a no argument constructor that passes an empty 
    string for the name and 0 for the birthYear. The no argument
    constructor uses constructor chaining to call the second
    constructor, which takes a string parameter for name and an int 
    parameter for birthYear. The class contains three abstract 
    methods that do not return a value. The methods are makeSound,
    doTrick and output which all must be implemented by subclasses. 
    
*/
    
    String name;            // Global Variable name of type String 
                            // represents Pet object's name.
    
    int birthYear;          // Global variable birthYear of type int
                            // represents Pet object's birth year.
    
    public Pet()
    {
    /* This no-argument constructor calls the two parameter
        constructor. The constructor passes an empty string and the 
        integer 0 to the next constructor in order to assign an empty
        string to name attribute and 0 to birthYear attribute. 
    */
        this("", 0);
    }
    
    
    public Pet(String theName, int year)
    {
    /*  This constructor takes two parameters including theName of 
        type String and year of type int. The constructor assigns 
        parameter values to the object's attributes, with theName
        being assigned to name and year being assigned to birthYear.
    */
        
        name = theName;         // Assign theName parameter to name 
                                // attribute.
                                
        birthYear = year;       // Assign year parameter to the 
                                // birthYear attribute.
    }
    
    
    @Override
    public int compareTo(Pet p)
    {
    /*  The compareTo method is overridden in order to implement the 
        Comparable interface. The method takes a Pet object P as a
        parameter. The method returns the difference between the 
        parameter's birthYear and this object's birthYear. If 
        the returned value is 0, then the two Pet objects are 
        considered to be 'equal' for the purposes of this method.
    */
        return p.birthYear - birthYear;
    }
    
    
    /*  The makeSound, doTrick and output methods are all abstract
        methods that do not return a value and take no parameters. 
        They must be implemented by subclasses of the Pet class. 
    */
    
    // Implement makeSound references the sound the specific animal 
    // will make:
    public abstract void makeSound();
    
    // Implement doTrick method to reference a trick the specific
    // animal will do:
    public abstract void doTrick();
    
    // Implement output method to provide object information to the 
    // user.
    public abstract void output();
    
}
