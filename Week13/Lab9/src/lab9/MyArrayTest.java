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

import java.util.ArrayList;
import java.util.Scanner;                   // import the Scanner class in 
                                            // order to obtain user input
                                            // in terminal. 


public class MyArrayTest
{/* The MyArrayTest class contains the main method which starts and controls 
    the Hamiltonian distance game that the user will play in the terminal. 
    The method instantiates an array of strings which are the list of possible
    words the game may select at random to use. A MyArray object named
    wordsArray is instantiated by passing the array of words to the MyArray
    constructor. A random word named firstWord is then selecting by calling
    the wordsArray sample method. Another myArray object is created by passing
    a Character Array containing the letters from the firstWord. The method
    then presents instructions to the user. The user is then prompted to 
    enter words into the terminal that are exactly one Hamitonian distance from
    the randomly selected firstWord. User input is read as a String, which is
    passed into a myArray object named second in the same process as the
    firstWord. The firstWord's distance method is called in order to obtain the 
    Hamiltonian distance of the two words. So long as the distance is equal to 
    one, the game will add a point to the user and prompt the user to enter 
    another word. Once the distance between first and second is not equal to
    one, the method will output the user score and terminate. 
    
*/


    public static void main(String[] args)
    {/* the main method runs the Hamiltonian distance game that the user will
        play in the terminal. The method instantiates an array of strings which
        are the list of possible words the game may select at random to use.
        A MyArray object named wordsArray is instantiated by passing the array
        of words to the MyArray constructor. A random word named firstWord is
        then selecting by calling the wordsArray sample method. Another myArray
        object is created by passing a Character Array containing the letters
        from the firstWord. The method then presents instructions to the user.
        The user is then prompted to enter words into the terminal that are
        exactly one Hamiltonian distance from the randomly selected firstWord.
        User input is read as a String, which is passed into a myArray object
        named second in the same process as the firstWord. The firstWord's
        distance method is called in order to obtain the Hamiltonian distance
        of the two words. So long as the distance is equal to one, the game
        will add a point to the user via an accumulator variable named
        correctInputs. The game will repeatedly ask for user input within a
        while loop. Once the distance between first and second is not equal to
        one, the method will output the user score and terminate. 
    */
        
        // Instantiate an array of type String containing 10 random words:
        String[] words = {"car", "dog", "pool", "wine", "bath", "date",
        "core", "cow", "table", "game"};
        
        // Create a MyArray object of type String called wordsArray. Pass
        // the words array as a parameter to the constructor:
        MyArray<String> wordsArray = new MyArray<>(words);
        
        // Call the wordsArray .sample method in order to obtain a random 
        // element (word). Store the returned String in a variable called
        // firstWord:
        String firstWord = wordsArray.sample();
        
        // Create a Character Array called firstArray that stores the letters
        // of firstWord as its elements:
        // NOTE: The following operation to create Character array was
        // provided by school instructor:
        Character[] firstArray = firstWord.chars().mapToObj(ch-> (char)ch)
                .toArray(Character[]::new);
        
        // Create a MyArray object named first by passing the firstArray of 
        // Characters to the constructor:
        MyArray<Character> first = new MyArray<>(firstArray);
        
       // Output title to the terminal:
        System.out.println("Hamiltonian Distance Game");
        
        // Output general game instructions to the terminal:
        System.out.println("This game will select a random word, and have the"
                + " user enter as many words as possible that are exactly 1 "
                + "Hamiltonian distance different than the given word.");
        System.out.println("The words the user enters must be exactly 1 letter"
                + " different than the given word.");
        
        // Output the selected word to the terminal with formatting to add 
        // emphasis:
        System.out.println("\t****************************");
        System.out.printf("\t* The magic word is: %5s *\n", firstWord);
        System.out.println("\t****************************");
        
        
        // Create a Scanner object named scan that will be used to obtain 
        // user input in game:
        Scanner scan = new Scanner(System.in);
        
        // Create an accumulator variable called correctInputs of type int.
        // Initially set it to 0:
        int correctInputs = 0;
        
        // Create boolean variable named gameContinues and set it to true. 
        // The game will continue via a while loop until conditional statement
        // is triggered and sets gameContinues to false:
        boolean gameContinues = true;
        
        // Create an ArrayList to keep track of inputs user has already 
        // entered:
        ArrayList<String> wordsUsed = new ArrayList<>();
        
        // Continue prompting user for input within while loop until 
        // gameContinues is false:
        while(gameContinues)
        {
            // Output score so far into the terminal:
            System.out.println("(Inputs: " + correctInputs + ")");
            
            // Output instructions to the terminal:
            System.out.println("Enter a word into the terminal:");
            
            // Read user input in terminal. Assign entire line of user 
            // input to the String variable secondWord:
            String secondWord = scan.nextLine();
         
            // Create an array of Characters that contains the letters of 
            // secondWord as its elements:
            // NOTE: The following operation to create Character array was
            // provided by school instructor:
            Character[] secondArray = secondWord.chars().mapToObj(ch-> (char)ch)
                .toArray(Character[]::new);
            
            // Create a MyArray object named second by passing the secondArray
            // as a paramter to the constructor:
            MyArray<Character> second = new MyArray<>(secondArray);
            
            // dist variable created and initialized to 1 per specifications.
            // dist will store the Hamiltonian distance between two store
            // attributes from MyArray objects.
            int dist = 1;
            
            // call the first myArray object's distance method by passing the 
            // second myArray object as a parameter. The method returns the 
            // Hamiltonian distance between the two arrays. Store the returned
            // value to variable dist:
            dist = first.distance(second);
            
            // If dist variable is not equal to one, output the dist value
            // and set gameContinues to false. Otherwise, if dist does equal 1,
            // make sure input has not already been used, then add one to
            // correctInputs variable:
            if(dist != 1)
            {
                // Output actual dist value to the terminal:
                System.out.println("Incorrect! Hamiltonian Distance between "
                        + firstWord + " and " + secondWord + " was: "
                        + dist);
                
                // Break while loop by re-assigning gameContinues to false:
                gameContinues = false;
            }
            else if(wordsUsed.contains(secondWord))
            {
                System.out.println("Entry already used, try again.");
                // Break this while loop iteration from the next:
                System.out.println("--------------------------------------");
            }
            else
            {
                // Add correct user entry into wordsUsed ArrayList:
                wordsUsed.add(secondWord);
                
                // Output success to the terminal:
                System.out.println("Correct!");
                
                // Add one to accumulator variable correctInputs:
                correctInputs++;
                
                 // Break this while loop iteration from the next:
                System.out.println("--------------------------------------");
            }
        }
        
        // End of while loop line break:
        System.out.println("*************************************************");
        
        // Output number of correctInputs to the terminal:
        System.out.println("Game over. successful user entries: "
                + correctInputs);
    }
}
