/*  Author: William Applegate
    Course: INFO-C211
    Date:   1/29/2022

    Program Description: This program reads and writes to and from .txt files. 
    The program includes a Tournament class and a FootballTeam class. Instances
    of tournament class contain an array of FootballTeam objects. The 
    FootballTeam class includes methods to read and write to .txt files, and the
    Tournament class also reads and writes to .txt files via calling on the
    FootballTeam method for each element of array.
*/

package lab3;                                   // Class is inside of lab3
                                                // package.

import java.util.Random;                        // Import Random class to obtain
                                                // random numbers.

import java.io.File;                            // Import File class to obtain
                                                // files.

import java.io.FileWriter;                      // Import FileWriter to write to
import java.util.Arrays;
                                                // files.

import java.util.Scanner;                       // Import Scanner to read input
                                                // from files.

class Tournament 
{
    FootballTeam[] teams;                       // Array representing the 
                                                // football teams in tournament.
    
    Random rand = new Random();                 // New random object to
                                                // randomize number of wins.
    
    Tournament()
    {
    /*  This no-argument constructor assigns a null value to the array of 
        teams attribute.
    */
        teams = null;
    }
    
    Tournament(int numberOfTeamsInput)
    {
    /*  This constructor takes one parameter for the number of teams within the 
        tournament. The construcutor instantiates the array of teams attribute, 
        using the numberOfTeamsInput parameter as the array's length. This 
        constructor instantiates each FootballTeam element by calling it's no
        argument constructor, which could have also been implemented in the 
        read method.
    */
        teams = new FootballTeam[numberOfTeamsInput]; // instantate teams array
                                                      // using the constructor's 
                                                      // parameter for length.
        
        
        for (int i = 0; i < teams.length; i++)      // loop through teams array
        {
            teams[i] = new FootballTeam();          // Instantiate each element 
                                                    // with no argument
                                                    // constructor.
        }
        
    }
    
    
    public void read(String filename)
    {
    /*  The read method takes a string parameter for a filename. The method 
        creates a new File object using the string parameter for its file path.
        The method performs a try with resources statement. The try resource is
        a new Scanner that recieves input from the new File object. Within the 
        try block, the method uses a for loop to iterate through the teams 
        array. The scanner checks if there is more text in the file, then 
        calls a FootballTeam's read method, using the scanner as a parameter. 
        Once the FootballTeam's read method returns, the scanner skips to the 
        next line before checking for another loop iteration. 
        
        
    */
        File f = new File(filename);        // Create new File using filename
                                            // parameter as the filepath.
        
        try(Scanner scan = new Scanner(f))  // Try with scanner as resource.
        {
                // Iterate through the teams array:
                for(int i = 0; i < teams.length; i++){
                    
                    // Check if there is more text to read from file:
                    if(scan.hasNext()){
                       
                        //Call read method from teams element at index i:
                       teams[i].read(scan);
                       
                       // Skip to next line in file before continuing loop.
                       scan.nextLine();
                       
                    }else                   // If scan.hasNext() returns false,
                                            // inform the user and stop loop.
                    {
                        System.out.println("Ran out of input on index " + i);
                        break;
                    }
                }
               
        }
        
        catch(Exception e)                  // Catch all exception types.
        {
            e.printStackTrace();            // Print the exception stack trace.
        }
    }
    
    
    public void write(String filename)
    {
    /*  The write method takes a string parameter for a file name. The method 
        creates a new FileWriter object, using the parameter as the filepath. 
        The method uses an enhanced for loop to iterate through the array and
        call the write method from each FootballTeam within the teams array, 
        using the FileWriter as the parameter.   
    */
        
        //Try with FileWriter as resource:
        try(FileWriter f = new FileWriter(filename))    
        {
            
            for(FootballTeam thisTeam : teams)  // Traverse teams array and
                thisTeam.write(f);              // call write method for each
                                                // element.
        }
        
        catch(Exception e)                      // catch exceptions
        {
            e.printStackTrace();                // Print the exception's stack 
                                                // trace.
        }
    }
    
    
    public void output()
    {
    /*  This method prints the values within the teams array to the terminal.  
        The method traverses the teams array and, for each element, outputs a 
        formatted print statement to the terminal. 
    */
        
        // Print a header:
        System.out.printf("%14s\t%14s\t%14s\n", "Team Name", "Team Location",
                "Number of wins");
        
        // Traverse the teams array, outputting formatted print statement for 
        // each element:
        for(FootballTeam thisTeam : teams)
            System.out.printf("%14s\t%14s\t%-14d\n", thisTeam.name, thisTeam.location, 
                    thisTeam.numberWins);
        
    }
    
    public void season()
    {
    /*   This method traverses the teams array, and adds a random number of wins
        between 1 and 10 to each team's numberOfWins attribute. The method
        adds the wins by calling each element's addWins method and using the 
        tournament's Random object's nextInt method, which returns an int
        between 1 and 10. The method then sorts the array by calling Arrays.sort
        method.
    */ 
        
        // Traverse 0the teams array and add random number of wins between 1 and 
        // 10 to each element: 
        for(FootballTeam thisTeam : teams)
            thisTeam.addWins(rand.nextInt(1, 11)); 
        
        //Sort the teams array:
        Arrays.sort(teams);
        
    }
}
