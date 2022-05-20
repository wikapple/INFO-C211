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

package lab3;                       // Class is inside of lab3 package.


public class Main 
{
/*  The Main class is used to test the FootballTeam and Tournament classes. It
    contains the main method. The main method creates a Tournament object 
    containing an array of 10 FootballTeam objects. The tournament object 
    reads from a file in order to obtain values for the FootballTeam array. The 
    football teams are then printed to the console. The tournament's season 
    method is called in order to assign a random amount wins to each team, after 
    which the teams are sorted by number of wins. The newly sorted array is 
    written onto a new file, and the football teams are again printed to the 
    console. 
*/
    
    public static void main(String[] args) {
        
        // Instantiate new Tournament object passing 10 into the parameter
        // to assign the football team array length of 10. 
        Tournament Kentuckiana = new Tournament(10);
        
        // Call the tournament's read method, traverses through each of it's
        // football teams and calls their read method in order to obtain 
        // values from the a .txt file and assign them to team attributes. 
        Kentuckiana.read("teams.txt");
        
        Kentuckiana.output();               // Output football teams to console.
        
        
        Kentuckiana.season();               // Call seaon method to add a random
                                            // number of wins to each team 
                                            // between 1 and 10. Also sorts the 
                                            // array.
        
                                            
        Kentuckiana.write("newTeams.txt");  // Write sorted teams with updated 
                                            // win property to a new file.
       
        System.out.println();               // Line break in the console.
        
        
                
        Kentuckiana.output();               // Ouput updated teams array to the 
                                            // console.
    }
    
}
