/*  Author: William Applegate
    Course: INFO-C211
    Date:   02/04/2022

    Program Description: This is a single class program that determines if two
    strings are anagrams of each other. Two strings are anagrams if they contain
    the same letters, but in different order. The program has no instance
    variables and is not intended to be instantiated. The main method is used to 
    obtain two strings from the user via input in the terminal. The program 
    uses all lowercase letters in the two strings and checks if they contain 
    the same letters in a different order. The program outputs to the terminal 
    whether the two strings are anagrams or they are not anagrams. The program
    does not accept multiple words, punctuation or numbers within a compared
    string.
*/

package hw4;                                // The anagram class is inside of 
                                            // the hw4 package.

import java.util.Scanner;                   // Import Scanner class in order to
                                            // obtain user input.

import java.util.Arrays;                    // Import the Arrays class in order
                                            // to call the Arrays sort method.

public class anagram 
{
/*  The anagram class checks if two strings are anagrams of each other, and 
    outputs to the terminal whether the words are anagrams or not. The class
    does not have any instance variables. The class includes only static 
    methods, and is not meant to be instantiated. The class has a private,
    no-argument constructor in order to prevent it from being instantiated. 
    There are three static methods. The main method obtains two string inputs
    from the user via the terminal. The main method checks if strings contain
    only letters by calling the hasOnlyLetters method before passing the strings
    as parameters to the isAnagram method. The main method then checks if these
    are anagrams of each other by calling the isAnagram method. The isAnagram
    method checks that the two words are not identical and are not different
    lengths. If the two words pass these checks and may still be anagrams, their
    characters are placed into a character array sorted alphabetically. After
    the two arrays are sorted alphabetically, both arrays will match if the
    words are anagrams. isAnagram returns true of false to the main method. The
    main method then outputs to the terminal whether the two words are or are
    not anagrams. 
*/
    
    private anagram()                       // Single private constructor 
    {                                       // prevents other classes from
    }                                       // instantiating anagram objects.
    
    
    static public boolean isAnagram(String s1, String s2)
    {
    /*  The isAnagram class takes two strings as parameters, s1 and s2. 
        This method has the assumption that its string parameters contain only
        letters without whitespace, numbers or punctuation. Both s1 and s2 are
        converted to all lowercase letters. The method checks if s1 and s2 are
        equal using the string .equals method. If s1 and s2 are the same word,
        the method returns false. The method also returns false if s1 and s2 are
        different lengths. If s1 and s2 may still be anagrams, the program sorts
        the characters from both strings into alphabetical order using
        arrays.sort method calls and assigning the value to charArrayOne and 
        charArrayTwo. Both char arrays will contain the same characters in the
        same order if they are anagrams. If charArrayOne and charArrayTwo are
        equal, the method returns true. Otherwise, the method returns false.  
    */
        
        
        s1 = s1.trim();                     // Trim any whitespace from the 
        s2 = s2.trim();                     // beginning and end of s1 and s2
                                            // strings.
        
        
        s1 = s1.toLowerCase();              // Convert both s1 and s2 to all
        s2 = s2.toLowerCase();              // lowercase letters.
        
        
        if(s1.equals(s2))                   // If s1 and s2 are equal, return
            return false;                   // false.
        
        if(s1.length() != s2.length())      // If s1 and s2 are different
            return false;                   // lengths, return false.
        
        // Create a char array and assign it the value of s1 using .toCharArray.
        char[] charArrayOne = s1.toCharArray();
        
        // Create a char array and assign it the value of s2 using .toCharArray.
        char[] charArrayTwo = s2.toCharArray();
        
        
        Arrays.sort(charArrayOne);          // Call Arrays.sort in order to sort
        Arrays.sort(charArrayTwo);          // both char arrays alphabetically.
        
        
        // If both alphabetically sorted char arrays are equal to each other, 
        // return true. If they are not equal, return false:
        if (Arrays.equals(charArrayOne, charArrayTwo))
            return true;
        else
            return false;        
    }
    
    
    static public boolean hasOnlyLetters(String text)
    {
    /*  The hasOnlyLetters method takes a single string parameter named text. 
        The method traverses the chars of text via an enhanced for loop and 
        the string's .toCharArray method. The method checks if each character is
        a letter using Character.isLetter method. If any character is not a 
        letter, the method returns false. If the loop terminates without finding
        anything other than letter characters, the method returns true.
        
    */
        //Enhanced for loop traverses each char in text.toCharArray:
        for(char c : text.toCharArray())
            if(!Character.isLetter(c))      // If any character is not a letter,
                return false;               // return false.
        
        return true;                        // If loop ends without returning
                                            // false, the method returns true.
    }

 
    public static void main(String[] args) 
    {
    /*  The main method tests the anagram class. The method creates a Scanner 
        object in order to get input from the user. The method prints
        instructions to the user, and uses the Scanner to receive two strings
        from the user through the terminal. The strings are assigned to 
        local variables s1 and s2. The process of obtaining user input is placed
        in a do-while loop that loops until the user input value only contains
        letters. This is done by calling the hasOnlyLetters method and is to
        ensure only validated parameters enter the isAnagram class. The method 
        calls the isAnagram class to check if s1 and s2 are anagrams of each
        other.Depending on the return value of isAnagram, the method outputs
        whether s1 and s2 are anagrams or not.
    */
        // Create new Scanner object in order to receive user input via the 
        // terminal: 
        Scanner scan = new Scanner(System.in);
        
        // Print instructions in the terminal to the user in order to obtain 
        // input:
        System.out.println("This program will check if two words are anagrams of"
                + " each other. Do not enter multiple words, spaces, or"
                + " numbers.\n");
        
        
        String s1, s2;                      // Create two local variables of 
                                            // type string that will be assigned
                                            // values by user input.
        
        boolean isValidInput = false;       // Create local boolean variable for
                                            // do-while input that checks for
                                            // valid user input.
        
        // do-while loop continues until user enters valid input for s1:
        do{
            
            // Ask the user to enter the first word into the terminal:
            System.out.println("Enter the first word in the terminal, then"
                + " press enter: ");
        
            s1 = scan.nextLine();           // Assign the string s1 the input 
                                            // user entered into terminal.
                                            
                                                
            if(hasOnlyLetters(s1))          // If the string s1 only contains                
                isValidInput = true;        // letters, break the do-while loop.
        
        } while (!isValidInput);            // Do-while Loop continues until
                                            // isValidInput is set to true.
        
                                            
        isValidInput = false;               // Reset isValidInput to false in 
                                            // order to recieve second string
                                            // from user. 
        
        // do-while loop continues until user enters valid input for s2:                        
        do{
            // Ask the user to enter the second word into the terminal:
            System.out.println("Enter the second word in the terminal, then"
                + " press enter: ");
        
            s2 = scan.nextLine();           // Assign the string s2 the input 
                                            // user entered into terminal.
                                            
                                            
        if(hasOnlyLetters(s2))              // If the string s1 only contains                
                isValidInput = true;        // letters, break the do-while loop.
  
       
        } while(!isValidInput);             // Do-while loop continues until 
                                            // isValidInput is set to true.
            
        // If isAnagram method returns true with s1 and s2 as parameters, output
        // that s1 and s2 are anagrams, otherwise, output that s1 and s2 are not
        // anagrams:
        if(isAnagram(s1,s2))
            System.out.printf("%s and %s are anagrams of each other\n", s1, s2);
        else
            System.out.printf("%s and %s are not anagrams of each other\n",
                    s1, s2);
    }
    
}
