/*  Author: William Applegate
    Course: INFO-C211
    Date: 2/10/2022

    Program Description: Substring class shell provided by instructors. This hw5
    program requests the user input two strings into the terminal and checks if
    the second string is a substring of the first. The program contains a 
    single class, Substring, that contains two static methods: isSubstring and 
    the main method. The Substring class contains no global variables and only
    has a default constructor that is not intended to be instantiated. The main
    method obtains user input and uses it to call isSubstring, which checks for
    the substring. The main method outputs whether a substring exists or not.
    The end of the program includes comments that lists what user input was
    tested. 
*/


package hw5;                                    // This class is within the 
                                                // hw5 package.

import java.util.Scanner;                       // Import Scanner class in order
                                                // to get input from user.

public class Substring 
{
/*  The Substring class shell was provided by instructors of the INFO-C211
    course. The Substring class requests user input two strings in the terminal 
    and checks if the second string is a substring of the first. The class
    contains no global variables. The class only has a default constructor, 
    though it is not intends to be instantiated. The class contains two static
    methods: The isSubstring method and the main method. The main method asks
    the user to input two strings into the terminal and obtains user input via 
    a scanner object. The main method then uses conditional statements calling
    the isSubstring method in order to determine if the second user input 
    string is a substring of the first. The isSubstring method traverses the
    first string so long as the second string may be a substring of the first.
    If the beginning of the potential substring matches an element of the main
    string, the isSubstring method continues to traverse both strings to check 
    if all proceeding chars of the potential substring match up to the main
    string. If a substring is found, isSubstring returns the index where the 
    substring begins on the main text string. If no substring is found, the 
    isSubstring method returns the value -1. The main method uses these return
    values conditional statements to output to the user if the second input
    is a substring of the first. 
*/

    // Function looking for a substring in a string.
    // If found, it returns the index of the substring.
    // If not found, it returns -1.
    static public int isSubstring(String subs, String text)
    {
    /*  The isSubstring method takes two string parameters. The method checks if
        the parameter subs is a substring of the parameter text. The method 
        includes local variables of type int that represent the length of each
        parameter. The method includes local variables of type int that
        represent the current index of text and current index of subs being
        checked. The local variable "found" indicates whether the elements of
        subs and text match at a particular point in the loops. The method uses 
        a for loop that traverses indices of text, so long as the subs string
        could still be a substring at that given index of text. If subs could
        still be a substring of text, the "found" variable is initially set to
        be true. The method then traverses the subs string so long as each
        subsequent char of subs matches the subsequent char of text. Once a char
        from either string does not match, the "found" variable is set to false
        and the next index of text is checked if applicable. If the loop
        traverses the entire subsstring without breaking, the method returns the
        index of text where the substring begins. If the method traverses all
        possible indices of text without returning an index (without finding a
        substring), the method returns -1 to indicate no substring was found. 
    */
        
        // Assign the int length of subs to local variable m.
        // Assign the int length of subs to local variable n.
	int m = subs.length(), n = text.length();
	
        // Create local variables i and j of type int that will be used to
        // traverse for loops.
        int i, j;
        
        // Create found variable of type boolean that indicates if a substring
        // is still possible at indices of text string. 
	boolean found;
		
        
        
        // For loop iterates over each index of text, so long as the length of
        // subs is less than or equal to the ramaining indices of text to 
        // compare. The nested for loop checks if a substring begins at the 
        // current index. If the length of subs is greater than the remaining indicies
        // of text, than there is no need to check further because subs can no
        // longer be a substring. 
	for (i = 0; n-i >= m; i++) 
        {
            
            // Assertion checks if the remainder of indices of text minus the 
            // current index is greater than or equal to the length of subs. 
            assert text.length() - i >= subs.length();
            
            // During each iteration of for loop, found is initially set to
            // true. 
            found = true;
                        
            // Nested for loop iterates over length of subs string.   
            for (j = 0; j < m; j++)
            {
                
                // Assertion checks if the sum of j (current iteration of 
                // subs string) and of i (current iteration of text string) 
                // is less than or equal to the length of text string. 
                assert j + i <= text.length();
                
                
                // Log the char from text and char from subs being compared:
                System.out.printf("Checking if substring \"%c\""
                        + " matches main text \"%c\"\n",
                        subs.charAt(j), text.charAt(i+j));

                
                // If the char in subs does not match the corresponding char 
                // of text, set "found" to false, log "no match", and break
                // nested for loop:
                if (subs.charAt(j) != text.charAt(i+j)) {
                    found = false;
                    System.out.println("No Match!");
                    break;
                }
                
                // If characters match, log fraction of substring characters
                // that match thus far: 
                System.out.println("Match " + (j+1) + " / " + m);
                        
            }
            // If the entire subs string is traversed and "found" remains set
            // to true, return the current index of text string:
            if (found)
                return i;
                        
        }
            // If the entire text string is traversed up to the point that a 
            // substring is possible without ever finding a substring, return
            // -1 to indicate no substring was found:
            return -1;
        }
	
    
    public static void main(String[] args)
    {
    /*  The main method is used to test the isSubstring method. The method
        creates a Scanner object to obtain user input. The method then asks the
        user to input a string, and assigned user input to a new string s1. 
        The method then asks the user to input a possible substring of s1, and
        the input it assigned to a new variable s2. The method used a
        conditional statement and calls the method isSubstring using user input
        as parameters. If isSubstring returns a value greater than or equal to 
        0, indicating a substring was found, then the method prints that a 
        substring was found. If the isSubstring method does not return a value 
        greater than or equal to 0, the method outputs that the substring was 
        not found.
    */
        
        // Create a Scanner object to obtain user input in the terminal:
        Scanner scan = new Scanner(System.in);          
                                                        
                                                        
        // Output instructions to user to input first string value: 
        System.out.println("Enter a string, then press enter: ");           
        
        String s1 = scan.nextLine();                // Assign user input to 
                                                    // new string variable s1.

        // Output instructions to user to input possible substring: 
        System.out.println("Enter a possible substring of the first string, "
                + "then press enter: ");
        
        String s2 = scan.nextLine();                // Assign user input to 
                                                    // new string variable s2.

        // Within conditional statement. Call isSubstring using s2 and s1 as 
        // parameters. If method call returns greater than or equal to 0, 
        // indicating a substring was found, output a substring was found. 
        // Otherwise, output that a substring was not found:
        if (isSubstring(s2, s1) >= 0)
            System.out.println("The substring was found");
        else
            System.out.println("The substring was not found");
    }

}

/*********************************Sample Output*********************************
 *  s1 = "hopper", s2 = "op"    - Did not work at first
 *                              - Worked after debugging
 * 
 * s1 = "hopper", s2 = "group"  - Did not work at first
 *                              - Worked after debugging
 * 
 * s1 = "", s2 = "group"        - worked
 * 
 * s1 = "hopper", s2 = ""       - worked
 * 
 * s1 = "Pickup", s2 = "pickuP" - Did not work at first
 *                              - Worked after debugging
 * 
 * s1 = "farm", s2 = "farM"     - worked
 * 
 * s1 = "", s2 = ""             - Did not work at first
 *                              - Worked after debugging
 * 
 * s1 = "dog", s2 = "og"        - worked
 * 
 * s1 = "bool", s2 = "boolean"  - worked
 * 
 * 
 * s1 = "A program that checks for substrings" s2 = "substrings" - worked
 * 
 * s1 = "A program that checks for stuff" s2 = "checks"          - worked 
 * 
 * s1 = "A program that checks", s2 = "thee"                     - worked
 * 
 * 
 * s1 = "123435", s2 = "234"        - worked
 * 
 * s1 = "@123", s2 = "!123"         - worked
 * 
 * s1 = "Hello World", s2 = "World" - worked
 * 
 * s1 = "s", s2 = "s"               - worked
 * 
 * s1 = "S", s2 = "s"               - worked
 ******************************************************************************/