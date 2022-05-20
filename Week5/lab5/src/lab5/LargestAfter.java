/*  Author: William Applegate
    Course: INFO-C211
    Date: 02/10/2022

    Program Description: This program contains the LargestAfter class. The shell
    of LargestAfter.java was provided by the instructors of this course. The 
    program contains the one class LargestAfter that checks an array of 
    integers at a given index, and checks for the next largest integer within 
    the array. At the botttom of this class, the program includes test sample
    output that was used for debugging the program. 

*/

package lab5;                               // This class is within the lab5
                                            // package. 

public class LargestAfter 
{
/*  The shell of the LargestAfter class was provided by the instructors of 
    INFO-C211. This class takes an array of integers and an index of the array, 
    and checks of the next element that is larger. The method contains no 
    global variables and only uses the default constructor that is not needed to
    be instantiated. The method contains two static methods, largerAfter and the
    main method. The main method creates an array of integers and an index. 
    The main method passes these values to a method call to largerAfter. The
    largerAfter method traverses the array from the given index, and checks for 
    the next larger element of the array. The largerAfter array returns the next
    index that is larger than the index given as a parameter. The main method 
    prints to the terminal the starting element and the element at the index
    provided by the largerAfter return. 
*/


    // Finds the first larger number after the given index
    // If the value is not found, it returns -1.
    static int largerAfter(int[] a, int start)
    {
    /*  The largerAfter method takes an int array and an int as parameters. 
        So long as the starting point is greater than 0, the method
        traverses the array, looking for the next element that is greater
        than the element where the traversal began. The method returns 
        the index of the next largest element of the int array. 
    */
        
        if (start < 0)                  // If start value is less than 0, 
            return -1;                  // return -1.

        int i;                      // Create variable i that will iterate
                                    //  over int array from given point. 

        int n = a.length;           // Create variable n of type int and
                                    // assign the length pf the array.


        // Traverse the int array "a", beginning at the index passed to method
        // as parameter "start". Traverses the array so long as element is less
        // than the starting element:
        for (i = start; i < n && a[i] <= a[start]; i++)
        {   
            // assert that the current value of iterator i is less than the
            // length of the a int array: 
            assert i < n; 
           
            System.out.println(i);  // Log the current index being itterated
                                    // over. 
        }
        
        if( i < n)                  // If for loop terminates before length of 
            return i;               // array, return the given indice.
        else                        // Else, return -1 to indicate that no 
            return -1;              // larger element was found. 

    }
    
    
    public static void main(String[] args) 
    {
    /*  The main method tests the largerAfter method. The method creates an 
        array of ints. The method then creates a local variable index that
        represents a given index of the int array. The method passes these 
        variables into a largerAfter method call, which returns the next 
        largest element after the given index if applicable. The main method
        outputs the next largest index or outputs that there is no such value
        depending on the returned value. 
        
    */
            // Create and assign values to new int array numbers:
            int[] numbers = {11, 8, 6, 5, 4, 20};
            
            // Create local variable index and assign it a value: 
            int index = 3;
            
            // Create local variable and assign it the value that returns from
            // calling largerAfter using numbers and index variables as 
            // parameters: 
            int indexLarge = largerAfter(numbers, index);

            // If returned value is greater than or equal to 0 (indicating a 
            // larger element was found), output the next largest index. 
            // Otherwise, output that no such value was found:
            if (indexLarge >= 0)
                System.out.println("Largest after " + numbers[index]
                            + ": " + numbers[indexLarge]);
            else
                System.out.println("There is no such value.");

    }

}

/********************** Sample Output ******************************************
 * {1,4,3,2,5,7} and index 1        - worked
 * 
 * {1,2,3,4,5,7} and index 2        - worked
 * 
 * {11,8,6,5,4,2} and index 1       - did not work at first
 *                                      it worked after debugging
 * 
 * {} and index = 1                 - worked
 * 
 * {11,8,6,5,4,2} and index 10      - worked
 * 
 * {11,8,6,5,4,2} and -10           - did not work at first
 *                                      it worked after debugging
 * 
 * 
 * 
 ******************************************************************************/
 