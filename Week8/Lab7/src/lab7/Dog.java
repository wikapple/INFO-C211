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

package lab7;           // Class is within the lab7 package.


public class Dog extends Pet 
{
/*  The Dog class is a subclass of the Pet class. The class uses one
    constructor that takes parameters for the Dog's name and 
    birthYear attributes inherited from Pet.java. The constructor
    passes parameters to the superclass's constructor. The Dog class
    implements the methods makeSound, doTrick, and output that must
    be overridden to inherit from Pet.java. All three methods
    output a string to the terminal specific to the Dog class
    and the instance's name attribute. 
*/
    
    public Dog(String nameInput, int yearInput)
    {
    /*  The Dog constructor takes two parameters, nameInput of type
        String and yearInput of type String. These to parameters are
        then passes to the superclass, Pet.java, constructor in order
        to assign nameInput to the name attribute and yearInput to the 
        birthYear attribute both inherited from Pet. 
    */
        super(nameInput, yearInput);
    }
    
    public void makeSound()
    {
    /*  The makeSound method takes no parameters and outputs a string
        to the terminal including the name of this Dog instance and 
        " barks."        
    */
        System.out.println( name + " barks.");
    }
    
    
    public void doTrick()
    {
    /*  The doTrick method takes no parameters and outputs a string 
        to the terminal including the name of this Dog instance and 
        stating that it rolls over.
    */
        System.out.println(name + " rolls over");
    }
    
    public void output()
    {
    /* The output method takes no parameters and outputs this Dog
        instance's name and birthYear attributes to the terminal.
    */
        System.out.println("Dog " + name + " born in " + birthYear);
    }
    

    
}
