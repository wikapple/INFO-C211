/*  Author: William Applegate
    Course: INFO-C211
    Date: 1/22/2022

    Description: This program has one class that represents a data table of 
    integers. The program creates and manipulates a two dimensional array 
    using methods to output the table, change its size, and assign values 
    randomly. 
 */

package lab2;                                   // Table class is within lab2
                                                // package.

import java.util.Scanner;                       // Import Scanner class in order
                                                // to obtain user input.

import java.util.Random;                        // Import Random class in order
                                                // to create random numbers. 

import java.util.Arrays;                        // Import Arrays class in order 
                                                // to manipulate arrays.

public class Table 
{
/*  This Table class is used to represent a table of integer values. The table
is created using the two dimensional int array maze property and the int 
properties: rows and columns. The init method creates a new two dimensional 
array. The randomize method assigns the value 1 to elements of the array at a
given percentage rate. The make border method assigns the value 2 to 
all elements along the border of the table. Expand and shrink methods change the 
size of the array. Raw output and pretty output methods output the table to 
the terminal. There are two searching methods that search for a given value and
print the index it is first found to the terminal. The main method exists within
the Table class in order to test its methods.    */
    
    int[][] maze;                               // Two Dimensional integer array
    
    int rows, columns;                          // Rows and Columns attributes
    
    // Static scanner object is used to obtain user input in terminal. 
    static Scanner scan = new Scanner(System.in); 
    
    // Static Random object used to assign values throughout the array in a 
    // randomized manner.
    static Random rand = new Random();
    
    
    public Table(int m, int n)
    {
    /*  This constructor takes two int parameters. Constructor calls the init
        method and passes both m and n to it. init method will check if m and n
        are both greater than 0, and use them to instantiate maze two 
        dimensional array if true.  */
        
        init(m, n);                             // pass both m and n to init 
                                                // method call.
    }
    
    
    public Table(int m)
    {
    /*  This constructor takes one int parameter. Constructor calls the init
        method and passes m to it as both init parameters. init method will 
        check if m is greater than 0, and use it to instantiate maze two 
        dimensional array if true.  */
        
        init(m, m);                             // Pass m as both parameters 
                                                // to init method call.
    }
    
    
    
    public Table()
    {
        /*  This no-argument constructor assigns the value of rows 
            and columns properties to 0.   */
        
        rows = 0;                   
        columns = 0;
    }
    
    
    public void init(int m, int n)
    {
    /*  The init method takes two int parameters, m and n. It uses a conditional
        if statement to determine if m and n are both greater than 0. If m and n
        are both over 0, then they are used to intantiate maze two dimensional
        array, using m as the number of rows and n as the number of columns.
        */
        
        if(m > 0 && n > 0)                      // If int parameters m and n are
        {                                       // greater than 0, use them to
            maze = new int[m][n];               // instantiate maze array and  
            rows = m;                           // assign values to rows and 
            columns = n;                        // columns properties.
        
        }else                                   // Invalid parameter warning:
            System.err.println("Warning: dimensions cannot be less than 1.");
        
    }
    
    
    public void randomize(float percent)
    {
    /*  This method takes the float parameter percent and generates random 
        values of 1 in the maze based on whether random value is greater, less 
        than or equal to percent parameter  */
        
        int i, j;                               // Iterator variables           
        float r;                                // float assigned random values
        
        for(i = 0; i < rows; i++)               // Nested for loop traverses
            for(j = 0; j < columns; j++)        // 2D array.
            {
                r = rand.nextFloat();           // Assign random float to r
                
                if(r <= percent)                // If r is less than or equal to
                    maze[i][j] = 1;             // percent parameter, assign 
                                                // value 1 at index.
            }
    }
    
    
    public void rawOutput()
    {
    /*  Outputs values of maze two dimensional array into the termainal with 
        one line per row. Method uses nested array to obtain maze elements   */

        for (int i = 0; i < rows; i++)          // Nested for loop traverses
        {                                       // 2D array.
            for (int j = 0; j < columns; j++)
            {
                // Print the element at current index within a 3 space format
                System.out.printf("%3d ", maze[i][j]);  
            }
            System.out.println();               // Line break at the end of row
        }
    }
    
    
    public void expand(int m, int n)
    {
    /*  This method takes integer parameters m and n and uses them to expand 
        maze two dimensional array. The maze reference is assigned to a new 
        reference variable, and m and n are used in calling the init method  
        to create a new array, which is assigned the values from the original
        array where applicable. Method assumes the caller will provide parameter
        values that are smaller than the global variables: rows and columns.    
        */
        
        int[][] mazeCopy = maze;                // Assign mazeCopy the same
                                                // reference as maze.
        
        init(m, n);                             // Call init to point maze to 
                                                // a new 2D array using new 
                                                // dimensions from parameters.
        
        // Traverse each row of the original maze, use arraycopy to copy
        // mazeCopy's row values over to the new maze array.
        for(int i = 0; i < mazeCopy.length; i++)
            System.arraycopy(mazeCopy[i], 0, maze[i], 0, mazeCopy[i].length);
    }
    
    
    public void shrink(int m, int n)
    {
    /*  This method takes integer parameters m and n and uses them to shrink 
        maze two dimensional array. The maze reference is assigned to a new 
        reference variable, and m and n are used in callin gthe init method to 
        create a new array. The new array is assigned the values of the 
        original array where applicable. Method assumes the caller will provide
        parameter values that are smaller than the global variables: rows and 
        columns.    */
        
        int[][] mazeCopy = maze;                // assign mazeCopy the same
                                                // reference as maze.
                                                
        init(m, n);                             // Call init to point maze to 
                                                // a new 2D array.
       
        // Traverse each row of the new maze array, use arraycopy to copy
        // mazeCopy's row values over to the new maze array.
        for(int i = 0; i < maze.length; i++)
            System.arraycopy(mazeCopy[i], 0, maze[i], 0, maze[i].length);
    }
    
    
    public void prettyOutput()
    {
    /*  This method prints a 2D array to the terminal based on maze values.
        This method creates a top and bottom border based on maze row length, 
        then travesrses maze array while creating a border on left and right 
        of terminal/beginning and end of each row. This method checks element 
        values and prints the following: two spaces for value 0, astrisk and 
        space for value 1, and a period and space for value 2. Conditional 
        statement does not take any action for values outside of 0, 1 and 2. */
        
        String horizontalBorder = "";           // Initialize border string
        
        for(int i = 0; i < columns; i++)        // For every column, add
            horizontalBorder += "--";           // two dashes to border.
       
        // add both corners to the horizontal border  
        horizontalBorder = "+" + horizontalBorder + "+";
        
        System.out.println(horizontalBorder);   // Print top border
        
        for(int j = 0; j < rows; j++)           // travese maze rows
        {                                       
            System.out.print("|");              // Add left border to each row
            
            for (int k = 0; k < columns; k++)   // Nested loop traverses the 
            {                                   // given row.
                
                if (maze[j][k] == 0)            // If element equals 0, 
                    System.out.print("  ");     // print two spaces.
                else if (maze[j][k] == 1)       // Else if element equals 1,
                    System.out.print("* ");     // print asterisk and space.
                else if (maze[j][k] == 2)       // Else if element equals 2,
                    System.out.print(". ");     // print period and space.
            }
            System.out.println("|");            // Add right border to each row
        }
        System.out.println(horizontalBorder);   // Print bottom border
    }
    
    
    public void makeBorder()
    {
    /*  This method makes a border around the maze array by assigning the value
        2 to all maze elements in the first row ( row 0), the last row 
        (length - 1), the first column (0 index of each row), and last column
        (row length - 1 for each row).  */
        
        Arrays.fill(maze[0], 2);                // Assigning the value 2 to 
                                                // all of the first row.
        
        Arrays.fill(maze[rows - 1], 2);         // Assigning the value 2 to 
                                                // all of the last row.
        
        for(int i = 1; i < rows - 1; i++)       // traverse each row
        {
            maze[i][0] = 2;                     // assign the first element as 2
            maze[i][columns - 1] = 2;           // assign the last element as 2
        }
    }
    
    
    public void searchFirst(int searchedVal)
    {
    /*  This method searches the maze array for the searched parameter value. 
        The method traverses maze from the start (index 0,0) and outputs to the 
        console where the searched value is found, if at all. If the entire 
        array is traversed without finding a match, then the method outputs 
        that the value was not found. */
        
        for(int i = 0; i < rows; i++)              // Traverse maze from 
            for(int j = 0; j < columns; j++)       // beginning.
            {
                if(maze[i][j] == searchedVal)      // Check if element matches 
                                                   // parameter value.
                {
                    // Output index location to terminal if found:
                    System.out.printf("Searched value %d first found in row %d,"
                            + " column %d.\n", searchedVal, i, j);
                    
                    return;                         // Once value is found, 
                                                    // end loop and return.
                }
            }
        // If entire array is traversed without finding searched value, output
        // negative finding to the user:
        System.out.println("Searched value " + searchedVal + " was not found");
    }
    
    
    public void searchLast(int searchedVal)
    {
    /*  This method searches the maze array for the searched parameter value. 
        The method traverses maze backwards from the end of the array and 
        outputs to the console where the searched value is found, if at all. If 
        the entire array is traversed without finding a match, then the method 
        outputs that the value was not found. */
        
        for(int i = rows -1; i >= 0; i--)           // Traverse maze from 
            for(int j = columns -1; j >= 0; j--)    // end.
            {
                if(maze[i][j] == searchedVal)       // Check if element matches
                                                    // parameter value.
                {
                    // Output index location to terminal if found:
                    System.out.printf("Searched value %d last found in row %d,"
                            + " column %d.\n", searchedVal, i, j);
                    
                    return;                         // Once value is found, 
                                                    // return to caller.
                }
            }
        // If entire array is traversed without finding searched value, output
        // negative finding to the user:
        System.out.println("Searched value " + searchedVal + " was not found");
    }
    
    
    public static void main(String[] args) 
    {
    /*  The main method creates a integer n to represent table dimesion, float p
        to represent perenctage, and a creates a new Table object. The Table
        object is used to test the methods in the Table class, calling the 
        table constructor and calling init to intialize the table. The table
        is output to the terminal using rawOutput and the table is made smaller
        using a shrink method call. prettyOutput method is called to output maze
        to the console per specifications. Lastly, the main method calls both 
        searching methods to check for a value within the maze array.     */
      
        int n;                                         // Table dimension
                                                       // variable
       
        float p;                                       // float variable created
                                                       // to represent percent.
                                                       
        Table board = new Table();                     // Create new Table
       
        // Ouput instructions to user in order to get table dimensions:
        System.out.println("Enter the dimension of the table using a single"
               + " integer, then press enter: ");
       
        n = scan.nextInt();                           // Assign user input.
       
        board.init(n, n);                             // Initalize board with 
                                                      // n value from user.
        
        // Output instructions to user in order to get percentage value:
        System.out.println("Enter the percentage of 1s in the maze. Enter the "
            + "percentage as a decimal number between zero and one, then press "
               + "enter: ");
       
        p = scan.nextFloat();                         // Assign user input to 
                                                      // p float variable. 
       
        // Call rendomize method, using newly assigned p variable as a variable.
        board.randomize(p);               
                                                                   
        board.rawOutput();                            // Output board to
                                                      // terminal.
       
        // Ouput instructions to user in order to get new dimension:
        System.out.println("Enter a new (smaller or larger) dimension size for "
                + "the table using a single integer, then press enter: ");
       
        int newDimension = scan.nextInt();            // Create new dimension
                                                      // value.
       
        
        // If new dimension is greater than old dimension, call expand method. 
        // If new dimension is smaller, call shrink method.
        if(newDimension > n)                          
            board.expand(newDimension, newDimension);
        else if (newDimension < n)
            board.shrink(newDimension, newDimension);
           
       
        board.rawOutput();                              // Output board to 
                                                        // terminal.
       
        // Assign the value 2 to all elements along edge of the table.
        board.makeBorder();                             
                                                        
        board.prettyOutput();                           // Output pretty board
                                                        // to terminal.
      
        board.searchFirst(1);                           // search for first and 
        board.searchLast(1);                            // last 1 value within
                                                        // the board.
    }
    
}
