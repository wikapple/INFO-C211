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


public class Parrot extends Pet 
{
/*  The Parrot class is a subclass of the Pet class. The class uses
    one constructor that takes parameters for the Parrot's name and 
    birthYear attributes inherited from Pet.java. The constructor
    passes parameters to the superclass's constructor. The Parrot
    class implements the methods makeSound, doTrick, and output that
    must be overridden to inherit from Pet.java. All three methods
    output a string to the terminal specific to the Parrot class
    and the instance's name attribute. 
*/
    
    public Parrot(String nameInput, int yearInput)
    {
    /*  The Parrot constructor takes two parameters, nameInput of type
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
        to the terminal including the name of this Parrot instance and 
        " sings."        
    */
        System.out.println( name + " sings.");
    }
    
    
    public void doTrick()
    {
    /*  The doTrick method takes no parameters and outputs a string 
        to the terminal including the name of this Parrot instance and 
        stating that it dances.
    */
        System.out.println(name + " dances");
    }
    
    public void output()
    {
    /* The output method takes no parameters and outputs this Parrot
        instance's name and birthYear attributes to the terminal.
    */
        System.out.println("Parrot " + name + " born in " + birthYear);
    }
    

    
    
}
