/*  Author: William Applegate
    Course: INFO-C211
    Date:   02/03/2022

    Program Description: This is a single class program that determines if a 
    string or phrase is or is not a palindrome. A palindrome is a word or phrase
    that reads the same forwards and backwards. The program has no instance
    variables and is not intended to be instantiated. The main method is used to  
    have the user input a string in the terminal. The program removes any 
    whitespace, punctuation, or numbers from the text to be evaluated. The 
    remaining text is then checked to determine if it is a palindrome. The
    program outputs whether the text is a palindrome to the user via the
    terminal. 
*/

package lab4;                                   // This class is inside of the
                                                // lab4 package.

import java.util.Scanner;                       // Import Scanner in order to 
                                                // obtain input from terminal


public class palindrome 
{
/*  The palindrome class checks if a string or phrase is a palindrome, and 
    outputs to the terminal whether the string or phrase is or is not a 
    palindrome. The class does not include any instance variables. The class
    is not meant to be instantiated, however the default constructor is still
    accessible. The class includes three static methods, including the main 
    method. The main method gets the user to input a string via the terminal. 
    The main method calls the isPalindrome method to check if the user input is
    a palindrome. The isPalindrome method takes the user input string and
    changes all letters to lowercase, then calls the trimSpacePunct to create a
    new string with only the letters from the user input. The user inputted
    string is then checked if it is a palindrome and returned true of false to 
    the main method. The main method outputs whether the string is or is not a
    palindrome to the terminal. 
*/
    
    
    static public String trimSpacePunct(String text)
    {
    /*  The trimSpacePunct method takes a string 'text' as a parameter and
        creates a new empty string 'result'. The method used the text parameter 
        to create a char array of it's characters, and traverses the array. The
        method checks if each character is a letter. Each character that is
        a letter is appended to the result string. Once the traversal of the 
        parameter string is complete, the method returns the result string. 
    */
        
        String result ="";                      // Create new empty string  
                                                // named result.
                
                                                
        // Call string method toCharArray() to get an array of type char using 
        // the text parameter. Traverse the char array using an enhanced for
        // loop:
        for(char c: text.toCharArray())         
            if(Character.isLetter(c))           // If this char is a letter,
            result += c;                        // append it to the result 
                                                // variable.
        
        return result;                          // Once the traversal of the 
                                                // text parameter is complete,
                                                // return the result string.
    }
    
    
    static public boolean isPalindrome(String text)
    {
    /*  The isPalindrome method takes a string 'text' as a parameter and calls
        the string method toLowerCase() in order to make all letters of the text
        to lowercase. The method calls the trimSpacePunct method using the text 
        variable as a parameter in order to remove any whitespace, punctuation,
        or numbers from the text variable. The method traverses first half of
        the text string, and checks if the char does not match it's equivalent 
        char in the second half of array. Elements are equivalent/compared that
        are equal distance from the center of the string. If any equivalent 
        chars do not match when compared, the method returns false. If the loop
        completes without returning false, then the text is determined to be a 
        palindrome, and the method returns true.
    */
        
        // Call text's toLowerCase method in order to reassign value of text to
        // methods return value. Changes all letters within text to lowercase:
        text = text.toLowerCase();              
   
        // Call trimSpacePunct method with text as a parameter in order to 
        // reassign value of text to include only letters: 
        text = trimSpacePunct(text);            
        
        
        // Use a for loop to traverse the first half of the text string. and 
        // compare the char at each index to the char equal distance from the 
        // center of the string in the second half of the text string.
        // If the char in first half and char in second half do not match,
        // return false:
        for(int i = 0 ; i < text.length()/2; i++)
            if (text.charAt(i) != text.charAt(text.length() -1 - i))
                return false;
        
        
        // If the for loop terminates without returning false, then return true:
        return true;        
    }
    
    public static void main(String[] args)
    {
    /*  The main method tests the palindrome class. The method creates a Scanner
        object, and asks for user input via the terminal. The user input is 
        assigned to a string reference named text. The method checks if text is 
        a palindrome by calling the isPalindrome method with text as a
        parameter. The method outputs to the terminal whether text is or is not
        a palindrome.
    */
        
       // Create new Scanner object in order to recieve input via the terminal: 
       Scanner scan = new Scanner(System.in);
       
       // Output instructions to the user to provide input: 
       System.out.println("Enter a string to test if it is a palindrome, then"
               + " press enter : ");
       
       
       String text = scan.nextLine();               // Assign line of user input
                                                    // to the reference variable
                                                    // text of type String.
       
      // Call the isPalindrome method using text as a parameter. If the method
      // returns true, output to the terminal that text is a palindrome. Else,
      // output to the terminal that text is not a palindrome:
      if(isPalindrome(text))                                      
        System.out.println("Yes, it's a palindrome");   
      else
        System.out.println("no, it's not a palindrome");
    }
}
