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

package lab7;               // Class is within the lab7 package.

import java.util.Arrays;    // Importing Arrays class in order to 
                            // utilyze the Arrays.sort method.

public class TestPets 
{
/*  The TestPets class was created to test implementation of the 
    abstract Pet class and its child classes. It includes one method, 
    the program's main method. The main method creates an array of 
    Pet objects with each element being a subclass of Pet. The method
    then iterates through the array calling methods that were 
    overridden from Pet to each Pet subclass. 
    
*/
    
    public static void main (String[] args)
    {
    /*  The main method creates a new array containing subclasses of 
        the abstract Pet class. Each element is one of the three 
        possible subclasses: Cat, Dog or Parrot. The method uses
        enhanced for loops to call methods from each element of the 
        array which are implemented differently for each subclass. 
        The method also uses Arrays.sort in order to place the 
        Pet array in order by their attribute birthDate. The method
        outputs the elements of the array again to show the changes
        made after the sort method call.   
    */
        
    /* The following code was commented out by the instructor:
        
     Pet p;
     p = new Cat("Mitzi", 2015);
     p.output();
    
    */    
    
    Pet[] family = new Pet[6];          // Create new array of Pet
                                        // objects with length of 6
                                        // elements.
        
                                        
    // Instantiate new Cat objects and assign them to indices 0 and 1
    // of family array:
    family[0] = new Cat("Snowy", 2008); 
    family[1] = new Cat("Oreo", 2016);
    
    // Instantiate new Dog objects and assign them to indices 2 and 3
    // of family array:
    family[2] = new Dog("Bear", 2005);
    family[3] = new Dog("Ziggy", 2017);
    
    // Instantiate new Parrot objects and assign them to indices 4 and 
    // 5 of family array:
    family[4] = new Parrot("Pirate", 2014);
    family[5] = new Parrot("Frankie", 2012);
    
    
    // Use enhanced for loop to traverse family array and call each
    // elements output method. Prints all elements name and birthDate
    // attributes to the terminal:
    for(Pet p : family)           
        p.output();                
    
    // Use enhanced for loop to traverse family array and call each
    // elements makeSound and doTrick methods:
    for(Pet p : family)
    {
        p.makeSound();
        p.doTrick();
         
    }
    
    
    Arrays.sort(family);            // Sort the family array by each 
                                    // element's birthDate attribute.
    
    // Use enhanced for loop to traverse family array and call each
    // elements output method again. This is done again in order to 
    // show changes made by calling Arrays.sort:
    for(Pet p : family)
        p.output();
    
       
    
    
    
    }
    
}
