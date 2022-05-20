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

import java.io.File;                            // Import File class to obtain
                                                // files.

import java.io.FileWriter;                      // Import FileWriter to write to
                                                // files.

import java.util.Scanner;                       // Import Scanner to read input
                                                // from files.

public class FootballTeam implements Comparable<FootballTeam>
{
/*  The FootballTeam class simulates a football team. It includes attributes
for the football team's name, location, and the team's number of wins. The class
has a no argument constructor that assigns strings name and location as empty
0 length strings, and sets number of wins to 0. The second constructor includes
two strings and one int for paramaters to assign values to attributes. The 
class implements Comparalbe interface and can call the compareTo method to 
compare it to another FootballTeam and use Array.sort by the team's number of
wins. The addWins method adds a given number of wins to the number of wins 
attribute. The class can obtain attributes via two read methods and write it's
attributes via two write methods. The class strictly writes to and from .txt
files that are formatted specific to this class, with attributes in order on 
separate lines with no additional text.    */
    
    String name, location;                      // name and location attributes
                                                // represent team name and 
                                                // the team's location.

    int numberWins;                             // number of wins attribute
                                                // represent team's wins for
                                                // the season.

    public FootballTeam()
    {
    /*  This is a no-argument constructor that uses constructor chaining to pass
        parameter values to the next three parameter constructor. Attributes 
        with string values are passed with empty, 0 length, strings. integer
        attributes are given value of 0.
    */
    
        this("", "", 0);                        // Chain constructors
    }

    
    public FootballTeam(String nameInput, String locationInput, int winsInput)
    {
    /*  This constructor accepts three parameters in order to assign values
        to attributes. Parameters include two strings for the taem name and 
        location, as well at an int parameter for the football teams number
        of wins. The constructor does not validate the parameters prior to 
        passing them. 
    */
        name = nameInput;                       // Assign the team name.
        
        location = locationInput;               // Assign the team's location.
        
        numberWins = winsInput;                 // Assign the team's number of 
                                                // wins.
    }
    
    @Override
    public int compareTo(FootballTeam other)
    {
    /*  This method compares this instance of FootballTeam to another team that 
        is passed as a parameter. The method calculates the difference between 
        this team's number of wins and the other team's number of wins, and 
        returns the difference as an int. Positive return indicates that this 
        team has more wins, while negative indicates this team has less wins 
        than the other team. A return of 0 indicates that these teams have the 
        same number of wins. 
    */
        
        return (numberWins - ((FootballTeam)other).numberWins);
    }
    
    
    public void addWins(int winsInput)
    {
    /*  The addWins method accepts an int parameter for wins to add to this 
        numberWins attribute. The wins are added to the current number of wins. 
        The method does not validate parameter value, which could be any int 
        value to include negative values.
    */
        numberWins += winsInput;
    }
    
    
    public void read(String filename)
    {
    /*  The read method takes a string parameter for a filename to include it's 
        file path. The method instantiates a new File object using the filename
        as a parameter without checking if the file exists. A try with resrouces
        is attempted using a Scanner object that reads the newly instantiated 
        File object. The Scanner checks if there is text to read, then  reads
        the file line by line. The text in the file is assigned as values
        to the football teams attributes. The catch block handles all 
        exceptions.
    */
        
        File f = new File(filename);            // Create new File object using 
                                                // filename parameter.
                                                
        try(Scanner scan = new Scanner(f))      // Try with Scanner as resource
        {
            if(scan.hasNext()){                 // Check if there is text to
                                                // read from file.
                                                
                name = scan.nextLine();         // Assign first line of text
                                                // from file to team name. 
                                                
                location = scan.nextLine();     // Assign second line of text
                                                // from file to the team's 
                                                // location.
                                                
                numberWins = scan.nextInt();    // Assign third line of text
                                                // from file to the team's 
                                                // number of wins. 
            }
        }
        catch(Exception e){                     //  If try block fails, print
            e.printStackTrace();                // catch exception and print
                                                // the stack trace.
        }
    }
    
    
    public void read(Scanner scan)
    {
    /*  Overloaded read method takes a Scanner parameter in the event the 
        program has already found it's input source prior to this class. 
        As the other read method, the Scanner object checks for text, then 
        reads text line by line, assigning values to the class attributes. 
        The method does not use a try block because the File has already 
        been located. A Format exception is still possible depending on the 
        Scanner's input. 
    */
            
        if(scan.hasNext()){                 // Check if there is text to
                                            // read from file.
                                                
            name = scan.nextLine();         // Assign first line of text
                                                // from file to team name. 
                                                
            location = scan.nextLine();     // Assign second line of text
                                                // from file to the team's 
                                                // location.
                                                
            numberWins = scan.nextInt();    // Assign third line of text
                                                // from file to the team's 
                                                // number of wins. 
        }
    }
   
    
    /*Write*/
    public void write(String filename)
    {
    /*  The write method takes a string parameter that represents a file and 
        it's file path. The method uses a try with resources, instantiating 
        a new FileWriter object as the try resource. The FileWriter takes 
        the filename parameter as it's parameter. Within the try block, this
        football team's attributes are written to the FileWriter object using
        the objects write method and a concatenated string. The method catches 
        exceptions with one Catch for any type Exception, which then prints the 
        exception's stack trace. 
        
    */    
        
        // Try with FileWriter as a resource. FileWriter takes the filename 
        // paramter:
        try(FileWriter f = new FileWriter(filename);)
        {
            // Call FileWriter's write method to write concatenated string of
            // this football team's attributes to file. 
            f.write(name + "\n" + location + "\n" + numberWins +"\n");
        }
        
        //Catch exceptions:
        catch(Exception e){
            
            //Print stack trace:
            e.printStackTrace();
        }
    }
    
    
    public void write(FileWriter f)
    {
    /*  This overloaded write method takes a FileWriter as a parameter. The 
        The method calls the FileWriter's write method within a try block in 
        order to write a concatenated string of this football team's attributes.
        The catch block catches any type Exception, which then prints the 
        exception stack trace.
        
    */    
        // Try block:
        try
        {
            // Call FileWriter's write method to write concatenated string of
            // this football team's attributes to file. 
            f.write(name + "\n" + location + "\n" + numberWins +"\n");
        }
        
        //Catch exceptions:
        catch(Exception e){
            
            //Print stack trace:
            e.printStackTrace();
    
        }
    }
}