/*  Author:  William Applegate
    Course:  INFO-C211
    Date:    4/16/2022
    

    Program Description: This program is a practical exercise in java generics.
    The program uses a generic class to create a word game that gives the user 
    a random word, then asks the user to input words that are exactly 1 
    Hamiltonian distance from the given word. The program includes two files:
    MyArray.java and MyArrayTest.java. The MyArray class takes a generic type
    <T>. The constructor takes an array of any object type <T>. The class
    has a global variable ArrayList named store, which is instantiated with the
    object type passed in the array to the constructor. The elements of the
    passed array are added to the ArrayList. The class includes two methods, 
    one that returns a random element from the store ArrayList and another
    method that returns the Hamiltonian Distance between this store ArrayList
    and another store attribute from a different MyArray object passed as a
    parameter. The MyArrayTest class includes the main method. The main method
    instantiates MyArray objects containing different object types (String
    and Character). The main method provides instructions to the user, presents
    the user with a random word from a MyArray object, then asks the user to
    provide a word that is one Hamiltonian distance from the given word. The
    user enters words in the terminal until an invalid entry is made, at which
    point the program outputs the number of successful entries and terminates. 
*/


package lab9;                               // Class is within the lab9
                                            // package.

import java.util.ArrayList;                 // Import the ArrayList class
                                            // in order to use as attribute.

import java.util.Arrays;                    // Import the Arrays class in order
                                            // to use method to pass array 
                                            // elements to an ArrayList on 
                                            // single line. 

import java.util.Random;                    // Import the Random class in order
                                            // to obtain a random element from
                                            // an ArrayList.


public class MyArray <T> 
{/* The MyArray class is a generic class that uses a generic of type <T>. The
    class has one attribute which is an ArrayList named store containing <T>
    elements. The class has one constructor which takes an array of <T> 
    elements and adds the array elements to the store attribute, thereby 
    assigning <T> an object type. The class has two public methods: distance 
    and sample. The distance method takes another MyArray object as a 
    parameter, and returns an integer representing the Hamiltonian distance
    between this instance of the store object and another instance of the store
    object via the parameter passed. The sample method returns one element at 
    random from the store ArrayList by calling the Math.random method. 
 */

    // Create ArrayList store of type <T>:
    private ArrayList<T> store;
    
    // Create a static Random object rand that will be used to obtain a 
    // random index from the store attribute:
    private static Random rand = new Random();
    
    public MyArray(T[] list)
    {/* The MyArray constructor takes one parameter: an array of <T> elements
        called list. The constructor takes this list and adds the elements
        to the store attribute ArrayList.
    */
        
        // Instantiate the store attribute:
        store = new ArrayList<>();
        
        // Call ArrayList's addAll method and use Arrays.asList method in 
        // order to add all elements of list parameter to the ArrayList store
        // attribute:
        store.addAll(Arrays.asList(list));
    }
    
    
    public int distance(MyArray<T> other)
    {/* The distance method takes one parameter, which is another MyArray 
        object of type <T> called other. The method finds the Hamiltonian 
        distance between the two MyArray object's store lists. The method
        first checks the difference in ArrayList length, and stores the
        difference in a variable called distance of type int. The method then
        traverses the shortest store ArrayList (either from this object or from
        the parameter other). The method checks each element and compares it
        to the element at the same index from the other MyArray object. If
        the two elements are not equal, the method adds one to the distance
        attribute. Once the traversal is complete, the method returns the 
        distance.
        
        Possible logic error: Because this method checks for matching elements 
        at a given index, adding elements that would shift the letters (such as 
        adding values to the beginining) will cause the method to count each
        element as not matching. Example: comparing 'ore' and 'oreo' will 
        return 1, but comparing 'more' and 'ore' will return 4 because letters
        do not match at their indices, even though there is only one letter
        difference.
     */
       
        // distance variable of type int contains the difference in size
        // between this object's store attribute and the other object's 
        // store attribute. The value is stored as an absolute value:
        int distance = Math.abs(store.size() - other.store.size());
 
        
        // Already accounted for indices beyond length of the shortest array,
        // so only have to check elements of the shortest ArrayList. Store
        // smallest ArrayList in local variable length:
        int length = Math.min(store.size(), other.store.size());
        
        
        // Traverse the smallest store attribute, either from this object or
        // from other object. Compare elements from both objects at the same 
        // index using .equals method. If they are not equal, increment 
        // distance variable:
        for(int i = 0; i < length; i++)
            if(!other.store.get(i).equals(store.get(i)))
                distance++;
          
        
        // return the distance variable:
        return distance;
        
    }
    
    
    public T sample()
    {/* The sample method obtains a random index of the store attribute, and
        returns it. The method makes a random index by using the Random object
        attribute.
    */
        // Obtain a random index by calling rand.nextInt. Return value will
        // be an int between 0(inclusive) and store.size()(exclusive):
        int randomIndex = rand.nextInt(store.size());
        
        // Return an element of store at the random index:
        return store.get(randomIndex);
    }
    
}