/*  Author: William Applegate
    Course: INFO-C211
    Date:   04/22/2022

    Program Description: The HW9 program assists keeping track of baseball team
    player data. It contains one Team.java file which contains a Team class 
    and a Player class. The Team class stores a list of Player objects in the 
    form of a linked list. The Team class contains the main method along with 
    methods used to alter or retrieve data from the Player list. The Player 
    class contains specific information regarding each player object, including
    name, uniform number, position, and salary. 
 */

package hw9;                            // This file is within the hw9 package.

import java.util.Scanner;               // This file uses the Scanner method
                                        // to obtain user input in the
                                        // terminal.

import java.util.InputMismatchException;// This file uses the
                                        // InputMismatchException in order to
                                        // catch errors thrown if the user
                                        // enters a non-integer value in the 
                                        // terminal and throws an error. 

public class Team 
{/* The Team class is used to retrieve and manipulate a linked list of Player
    objects. The class contains a main method, which calls the runMenu()
    method in order to run a user interface in the terminal. The runMenu() 
    method calls the printMenu() method which outputs a list of menu selections
    to the user. The runMenu() method then prompts the user to make a selection
    via entering a number in the terminal. Once the user inputs an int value, 
    the runMenu() method passes the user input to the takeAction() method, 
    which evaluates user input and takes appropriate action via calling methods
    that complete that specific action. The user can add a player to the team,
    remove a player from the team, adjust a player's salary, give a raise to all
    players, print all players on the team to the terminal, or quit the program.
    
*/
    
    
    /******************CLASS ATTRIBUTES****************/
    
    // Create a static Scanner object which will be used in several methods
    // in order to obtain user input in the terminal:
    private static Scanner scan = new Scanner(System.in);
    
    // Create a boolean attribute called menuLoop and set it to true. This 
    // value will be checked in a while loop that runs the user interface and
    // menu until it is re-assigned to false:
    private boolean menuLoop = true;
    
    // Create the Player attribute named headPlayer that serves as the head
    // of the linked list:
    private Player headPlayer;
    
    
    /******ACCESSOR AND MUTATOR METHODS*********/
    
    private Player getHeadPlayer()
    {/* This method is an accessor for the headPlayer attribute. It returns
        the headPlayer of type Player.
    */
        return headPlayer;
    }
    
    private void setHeadPlayer(Player headPlayerInput)
    {/* This method is a mutator for the headPlayer attribute. It takes one 
        parameter of type Player and assigned it to the headPlayer attribute.
    */
        headPlayer = headPlayerInput;
    }
    
    /********************MENU SPECIFIC ACTIONS**************/
    
    private void addAPlayer()
    {/* The addaPlayer method does not take any parameters. The method prompts 
        the user to enter the values to be assigned to a new Player object. the
        method does this by calling the createNewPlayer() method, which returns
        a new Player object. The method then passes the player to the 
        insertPlayerToList() method in order to add the new Player to the 
        team's linked list in order by uniform number. The operations of this
        method are wrapped in a try and catch block because the 
        createNewPlayer() method may throw an InputMismatchException if the 
        user enters a non-integer value for an integer field.
        
    */
        // Try block:
        try{
            // Create a new Player object by calling the createNewPlayer()
            // method which returns a Player object:
            Player newPlayer = createNewPlayer();
            
            
            // Attempt to insert the player to the list by passing the 
            // insertPlayerToList method. If the method returns true, show the 
            // player was added. If the method returns false, show the player 
            // was node added:
            if(insertPlayerToList(newPlayer))
                System.out.println("Player added");
            else
                System.out.println("Player not added");
            
        // Catch Block:
        }catch(InputMismatchException e)
        {
            // Move the Scaner attribute to a new and clear line:
            scan.nextLine();
            
            // Log that an InputMismatch occurred:
            System.out.println("User did not enter valid input for a number.");
                    
        }
    }
    
    
    private static Player createNewPlayer() throws InputMismatchException
    {/* The createNewPlayer method prompts the user to enter attributes for a 
        new player object. The method then instantiates a new Player object 
        by passing the user input to the constructor of the Player class. 
        The method returns the new Player object. If the user enters an invalid
        entry, then the method will throw an InputMismatchException. This
        may occur if the user enters a value that cannot be parsed into an int
        for the uniform number, or if the user enters a value that cannot be 
        parsed into a double for the salary variable. 
        
    */
        // Prompt the user to enter a player name:
        System.out.println("Enter the player's name:");
        // Read user input and assign it to the nameInput String variable:
        String nameInput = scan.nextLine();
        
        // Prompt the user to enter the player's position:
        System.out.println("Enter the player's position: ");
        // Read user input and assign it to the positionInput String variable:
        String positionInput = scan.nextLine();
        
        // Prompt the user to enter a player uniform number:
        System.out.println("Enter the player's uniform number: ");
        // Read user input and attempt to assign it to the int variable
        // uniformNumberInput:
        int uniformNumberInput = scan.nextInt();
        
        // Move the Scanner to a new line:
        scan.nextLine();
        
        // Prompt the user to enter a player salary:
        System.out.println("Enter the player's salary:");
        // Read user input and attempt to assign it to the double variable
        // salaryInput:
        double salaryInput = scan.nextDouble();
        
        // Move the Scanner to a new line:
        scan.nextLine();
        
        // Instantiate a new Player object by passing the user input values
        // to the Player constructor:
        Player newPlayer = new Player(nameInput, positionInput, 
                uniformNumberInput, salaryInput);
        
        // Return the new Player object:
        return newPlayer;
        
    }
    
    private boolean insertPlayerToList(Player newPlayer)
    {/* The insertPlayerToList method takes a Player object as a parameter. 
        The method traverses the Team's linked list of players, and attempts to 
        insert the Player parameter into the linked list in order by the
        uniformNumber attribute. Once the Player object is inserted into the 
        list, the method returns true. In the event that the same uniform
        number is already in the list, the method returns false. 
        
     */
        
        // Get the Player parameter's uniformNumber attribute and assign it
        // to a local variable newPlayerNumber:
        int newPlayerNumber = newPlayer.getUniformNumber();
        
        // If the team's headPlayer attribute is null, then the list is empty.
        // Add the newPlayer as the headPlayer and return true:
        if(headPlayer == null)
        {
            setHeadPlayer(newPlayer);
            return true;
        }
        
        // If the new player's uniform number is smaller/less than the 
        // headPlayer's uniform number, then insert newPlayer as the new 
        // headPlayer attribute:
        else if(newPlayerNumber < headPlayer.getUniformNumber())
        {
            // Prior to re-assigning the headPlayer, newPlayer's nextPlayer 
            // attribute must be set to the current headPlayer to avoid
            // losing the Player list:
            newPlayer.setNextPlayer(getHeadPlayer());
            
            // Set the new player as the team's new headPlayer attribute:
            setHeadPlayer(newPlayer);
            
            // return true:
            return true;
        }
        
        // If the new player's uniform number matched the current headPlayer's
        // uniform number, return false:
        else if(newPlayerNumber == headPlayer.getUniformNumber())
        {
            System.out.println("Uniform number already exists");
            return false;
        }
        // If the method is still evaluating to this conditonal, then 
        // being traversing the list to find a location to insert the new 
        // player object:
        else
        {
            // Create a new Player object named temp to traverse the list, 
            // starting with the headPlayer:
            Player temp = headPlayer;
        
            // Iterations must look ahead to the next element in the list in 
            // order to complete an insertion. Continue the iterations while 
            // temp's nextPlayer attribute is not null and the new player's 
            // uniform number is greater than the nextPlayer's uniform number.
            // While loop will terminate either at the last element of the list
            // or at the insertion point somewhere within the Team's list:
            while(temp.getNextPlayer() != null &&
                newPlayerNumber > temp.getNextPlayer().getUniformNumber())
            {
                temp = temp.getNextPlayer();
            }
            
            // If at the end of the list (new player has the largest 
            // uniform number), add the new player to the end of the list and
            // return true:
            if(temp.getNextPlayer() == null)
            {
                temp.setNextPlayer(newPlayer);
                return true;
            }
            
            // Check if the uniform number matches the next player in the 
            // list, in which case the method returns false:
            else if(newPlayerNumber == temp.getNextPlayer().getUniformNumber())
            {
                System.out.println("Uniform number already exists");
                return false;
            }
            
            // Otherwise, The new player is being inserted into the middle 
            // of the list wherever the while loop terminated. Assign
            // the new player's nextPlayer attribute to the next player in the
            // list, then set temp's nextPlayer to the new player in order 
            // to inser the new player to the list. Afterwards, return true:
            else
            {
                newPlayer.setNextPlayer(temp.getNextPlayer());
                temp.setNextPlayer(newPlayer);
                return true;
            }
        }
    
    }
    
    private void removePlayer()
    {
        int numberToDelete = getUniformNumberFromUser();
        if (numberToDelete < 0)
            return;
        
        if(headPlayer == null)
        {
            System.out.println("The list is empty");
        }
        else if(headPlayer.getUniformNumber() == numberToDelete)
        {
            headPlayer = headPlayer.getNextPlayer();
            System.out.println("Player deleted");
        }
        
        
        Player temp = headPlayer;
        
        while(temp.getNextPlayer() != null)
        {
            if(temp.getNextPlayer().getUniformNumber() == numberToDelete)
            {
                temp.setNextPlayer(temp.getNextPlayer().getNextPlayer());
                System.out.println("Player deleted");
                return;
            }
            temp=temp.getNextPlayer();
        }
        System.out.println("Player not found;");
    }
    
    private void setPlayerSalary()
    {/* This method sets a player's salary to a new value provided by the 
        user. The method takes no parameters and does not return anything. The
        method fist promps the user to enter a uniform number by calling
        the getUniformNumberFromUser() method. The method then checks if user
        input matches a Player element by calling the findPlayer() method. 
        If a matching Player element is found, the method outputs the Player's
        current salary, then prompts the user to enter a new salary via the
        inputSalary() method. This value is then assigned as the Player's
        salary attribute. Because an error can be thrown while recieving user 
        input that cannot be parsed into a number (InputMismatchException),
        this method has a try and catch block. If an error is thrown matching 
        the catch block, the catch block will log that an invalid entry 
        was recieved before returning to the caller without re-assigning a 
        salary.
        
    */
        // Wrap method operations within a try catch block:
        try
        {
            
        // Instantiate a thisPlayer object of type Player as null:
        Player thisPlayer = null;
        
        // While loop continues as long as thisPlayer remains null:
        while(thisPlayer == null)
        {
            // Prompt the user to input a uniform number by calling the 
            // getUniformNumberFromUser() method. Store the return value in 
            // uniformNumber variable of type int. (method call can throw
            // an InputMismatchException): 
            int uniformNumber = getUniformNumberFromUser();
        
            // Pass the uniformNumber variable to the findPlayer() method. 
            // Assign the return value to the thisPlayer variable:
            thisPlayer = findPlayer(uniformNumber);
        
            // If thisPlayer is still null, output to the user that no valid
            // Player object was found:
            if(thisPlayer == null)
                System.out.println("Did not find a player corresponding to"
                        + " that uniform number, try again.");
        }
        
        // If the user entered a valid uniform number, prompt the user to enter
        // a new salary:
        
        // Output the player's current salary:
        System.out.println("Player's current salary is: " 
                + thisPlayer.getSalary());
        
        
        // Receive a new salary value by calling the inputSalary() method and
        // assigning the return value in the newSalary local variable of type 
        // double. (method call can throw an InputMismatchException). 
        double newSalary = inputSalary();
        
        // set the Player objects salary attribute to the newSalary value.
        thisPlayer.setSalary(newSalary);
        
        // In the event the user entered something other than a number value,
        // catch the thrown error here:
        }catch(InputMismatchException e)
        {
            // log that the error was caught:
            System.out.println("User input was unable to parsed into a"
                    + " number.");
            
        }
        
        
        
    }
    
    private static double inputSalary() throws InputMismatchException
    {/* The inputSalary method prompts the user to enter a salary. The method
        assigns user input to a double value, and returns it. The method does
        not take any parametes. If the user inputs a value that cannot be 
        parsed into a double, an InputMismatchException is thrown to the
        caller.
    */
        
        // Output instructions to the user:
        System.out.println("Enter a player salary:");
        
        // Assign user input to a double variable named newSal. Read user input
        // with the class's static Scanner attribute:
        double newSal = scan.nextDouble();
        
        // Move scanner to a new/clean line:
        scan.nextLine();
        
        // return newSal:
        return newSal;
        
    }
    
    private int getUniformNumberFromUser() throws InputMismatchException
    {/* This method prompts the user to input a uniform number in the form of 
        an int in the terminal. The method does not take a parameter. Once
        input is received from the user, the method attempts to assign user 
        input to an int value and return that value. If the user enters a 
        value other than an int, an InputMismatchException is thrown to the
        caller.
    */
        
       
            // Output instructions to the user:
            System.out.println("Enter the uniform number of the player: ");
            
            // Use the static Scanner attribute to read user input and assign
            // it to the int value uniformNum:
            int uniformNum = scan.nextInt();
            
            // Move the Scanner to a new/clean line:
            scan.nextLine();
            
            // Return uniformNum:
            return uniformNum; 
                  
        
    }
        
        private Player findPlayer(int uniformNumberInput)
    {/* The findPlayer method takes one parameter of type int that represents
        a Player object's uniform number. The method iterates through the 
        Team's linked list of players, checking if each element's uniformNumber
        attribute matches the number passed to the method. If the number 
        matches a uniformNumber in the list, the Player element is returned to
        the caller. If no match is found, this method returns null.
    */
        
        // Create temp variable of type Player. Assign it the value of the 
        // team's headPlayer attribute:
        Player temp = getHeadPlayer();
        
        // While loop iterates until temp is null:
        while(temp != null)
        {
            // If temp's uniformNumber attribute is equal to the parameter 
            // passed to this method, return temp. Otherwise, continue 
            // iterating through the list:
            if (temp.getUniformNumber() == uniformNumberInput)
                return temp;
            else
                temp=temp.getNextPlayer();
        }   
        
        // If while loop terminates before a matching value is found, then
        // the team does not have a matching Player object. Return null:
        return null;
    }

    
    private void raiseToAllPlayers()
    {/* This method increases the Salary of each element of the list of players
        by 10%. The method does not take any parameters, and does not return
        anything to the caller. The method uses the Player object temp to
        traverse the linked list of Player objects in the list, starting with
        the headPlayer object. While iterating through the list, it re-assigns
        each elements Salary attribute to be 110% of its current value.
     */
        
        // Create temp object of type Player, assign it the value of headPlayer
        // attribute from Team object:
        Player temp = headPlayer;
        
        // While loop repeats until temp value is null:
        while(temp != null)
        {
            // Create a double called newSalary that is 110% of temp's current
            // salary:
            double newSalary = temp.getSalary() * 1.1;
            
            // Round new Salary using Math.round(). The value is first
            // mulitplied by 100, then rounded, then divided by 100. The
            // multiplication and division is done to round to two decimal
            // places. Math.round would otherwise round to the nearest whole
            // number:
            newSalary = (Math.round(newSalary * 100.00)) / 100.00;
            
            // Re-assign temp's salary value to that of newSalary:
            temp.setSalary(newSalary);
            
            // Re-assign temp to the next element in the list:
            temp = temp.getNextPlayer();
        }
    }
    
    private void printPlayers()
    {/* The printPlayers() method ouputs the list of players and their 
        attributes to the terminal. The method does not take any parameters, 
        and does not return anything to the caller. The method uses the Player
        object temp to traverse the linked list of Player objects in the list,
        starting with the headPlayer object. While iterating through the list, 
        each element and its attributes are printed using their toString()
        method.
     */
        
        // Output header for list
        System.out.println("Players:");             
       
        // Create a temp object of type Player, assign it the value of the 
        // headPlayer in the Team:
        Player temp = headPlayer;                   
        
        // While loop that iterates so long as temp is not null:
        while(temp != null)
        {
            // Output the temp object by calling its toString method:
            System.out.println(temp);
            
            // Print a line break between Player objects:
            System.out.println("----------------");
            
            // Re-assign temp to the next Player object in the list:
            temp = temp.getNextPlayer();
        }
    }

    /*******************MENU INTERFACE METHODS**********************/
    
    private void runMenu()
    {/* The runMenu method continuously runs the menu user interface in a 
        while loop until the user makes a selection that terminates the while
        loop. The method calls the printMenu method to show the menu options
        in the terminal, then prompts the user to input a number correponding
        to the printed menu. Once user input is recieved, the method checks 
        if user input is of type int via the Scanner hasNextInt() method. 
        If the user has entered an int value, the method passed user input 
        to the takeAction method that evaluates userinput and takes the 
        corresponding actions. Once the takeAction method returns (void), or
        the user did not enter an int value, the while loop checks it's boolean
        condition and repeats.
        
    */
        
        // While loop repeats until user makes selection that sets menuLoop
        // attribute to false:
        while(menuLoop)
        {
            // Call printMenu() to print the menu options to the terminal:
            printMenu();
            
            // Prompt the user for input:
            System.out.println("Input an number represening a menu selection,"
                    + "then press enter: ");
            
            
            // If the input contains an integer, pass it to takeAction()
            // method:
            if(scan.hasNextInt())
            {
                // Store user input in the userInput variable:
                int userInput = scan.nextInt();
                
                // Scanner skip to a new/clear line:
                scan.nextLine();
                
                // Pass userInput to the takeAction method:
                takeAction(userInput);
                
            }
            else
            {
                // Scanner skip to a new/clear line:
                scan.nextLine();
                
                // Output issue to the user:
                System.out.println("User did not enter an integer, try again");
            }
        }
        
        // Output to terminal before program terminates:
        System.out.println("Program closed");
    }
    
    private static void printMenu()
    { /* The printMenu method is static and outputs menu options to the 
        terminal. The method is void and does not return anything to the 
        caller.
      */
        
        // Output menu:
        System.out.printf("%16s\n", "MENU");
        System.out.println("(1)\tAdd a player to the team.");
        System.out.println("(2)\tRemove a player from the team.");
        System.out.println("(3)\tModify a player's salary.");
        System.out.println("(4)\tGive all players a 10% raise.");
        System.out.println("(5)\tPrint out information for every player.");
        System.out.println("(6)\tQuit");           
    }
    
    private void takeAction(int userInput)
    {/* The takeAction method takes one int parameter named userInput and is 
        intended to be used in conunction with a user interface that obtains
        the user input. The method uses the userInput parameter in a switch 
        statement in order to take action corresponding to that menu selection,
        where applicable. If the userInput variable does not match a
        condition, then the default condition will trigger, which outputs a 
        message then returns to the caller method. 
       
    */
        // Switch statement based on the userInput variable:
        switch(userInput)
        {
            // Case 1 - Add player to team:
            case 1:
                addAPlayer();
                break;
                
            // Case 2 -  Remove player from team:
            case 2:
                removePlayer();
                break;  
                
            // Case 3 -  Modify a player salary:
            case 3:
                setPlayerSalary();
                break;
                
            // Case 4 -  Give all players a 10% raise:
            case 4:
                raiseToAllPlayers();
                break;
                
            // Case 5 -  Print out information for every player:
            case 5:
                printPlayers();
                break;
                
            // Case 6 -  Quit the program:
            case 6:
                menuLoop = false;
                break;
                
            // Default Case -  Invalid input:
            default:
                System.out.println("Invalid user input, try again");
                break;
                
        }
    }
    
    public static void main(String[] args) 
    {
        
        Player john = new Player("John", "Pitcher", 27, 68500);
        Player Weston = new Player ("Weston", "Catcher", 31, 72999);
        Player Kris = new Player ("Kris", "Left Field", 15, 38950);
        Player Boe = new Player("Boe", "Right Field", 48, 43000);
        Player Kat = new Player("Kat", "Short Stop", 5, 60000);
        Player Matt = new Player("Matt", "First Base", 19, 45000);
        Player Mary = new Player("Mary", "Second Base", 2, 52250);
        Player Victor = new Player("Victor", "Third Base", 50, 53000);
        Player Jessie = new Player("Jessie", "Center Field", 7, 29500);
       
        Team newTeam = new Team();
        
        newTeam.insertPlayerToList(john);
        newTeam.insertPlayerToList(Weston);
        newTeam.insertPlayerToList(Kris);
        newTeam.insertPlayerToList(Boe);
        newTeam.insertPlayerToList(Kat);
        newTeam.insertPlayerToList(Matt);
        newTeam.insertPlayerToList(Mary);
        newTeam.insertPlayerToList(Victor);
        newTeam.insertPlayerToList(Jessie);
        newTeam.runMenu();
    }
}
    
class Player
{   /*  The Player class stores information about Player objects as attributes
        along with a reference to another Player object. The class contains
        four attributes representing information about this player. The name
        and position attributes of type String, uniformNumber attribute of type
        int, and salary of type double. The class contains a nextPlayer
        attribute of type Player that  holds a reference to another Player
        object for the purposes of making a linked list of Player objects. The
        class contains a single constructor that instantiates all attributes
        along with accessor and mutator methods for each attribute. 
        */
        
        
    private String name, position;  // Attributes name and position of type
                                    // String represent the name and player's
                                    // position respectively.
        
    private int uniformNumber;      // Attribute uniformNumber of type int
                                    // represents the player's uniform number
                                    // and is intended to be unique for a given
                                    // team. 
        
    private double salary;          // Attribute salary of type double 
                                    // represents the player's salary.
        
    private Player nextPlayer;      // Attribute nextPlayer of type Player is a
                                        // reference to another Player object, 
                                        // or is null if at end of list.

        
    public Player(String nameInput, String positionInput, 
                    int uniformNumberInput, double salaryInput)
    {/* This constructor takes four parameters representing a Player name and
        position of type String, uniform number of type int, and salary of type
        double. The values of each parameter are assigned to the Player
        object's attributes. 
     */
            
        // Assign the nameInput parameter value to the name attribute:
        name = nameInput;           
            
        // Assign the positionInput parameter value to the position attribute:
        position = positionInput;   
            
        // Assign the uniformNumberInput parameter value to the uniformNumber
        // attribute:
        uniformNumber = uniformNumberInput;
            
        // Assign the salaryInput parameter value to the salary attribute:
        salary = salaryInput;
            
    }

    // Getter and setter the nextPlayer attribute:
        
    public Player getNextPlayer()
    {/* This method returns the object's nextPlayer attribute of type Player.
     */
        return nextPlayer;
    }

    public void setNextPlayer(Player nextPlayer)
    {/* This method takes a parameter of type Player and assigns it to this
        object's nextPlayer attribute. 
     */
        this.nextPlayer = nextPlayer;
    }

    public String getName()
    {/* This method returns the object's name attribute of type String.
     */
        return name;
    }

    public void setName(String name) 
    {/* This method takes a parameter of type String and assigns it to this
        object's name attribute. 
     */
        this.name = name;
    }

    public String getPosition() 
    {/* This method returns the object's position attribute of type String.
     */
        return position;
    }

    public void setPosition(String position) 
    {/* This method takes a parameter of type String and assigns it to this
        object's position attribute. 
     */
        this.position = position;
    }

    public int getUniformNumber() 
    {/* This method returns the object's uniformNumber attribute of type int.
     */
        return uniformNumber;
    }

    public void setUniformNumber(int uniformNumber) 
    {/* This method takes a parameter of type int and assigns it to this 
        object's uniformNumber attribute. 
     */
        this.uniformNumber = uniformNumber;
    }

    public double getSalary()
    {/* This method returns the object's salary attribute of type double.
     */
        return salary;
    }

    public void setSalary(double salary) 
    {/* This method takes a parameter of type double and assigns it to this 
        object's salary attribute. 
     */
        this.salary = salary;
    }
        
    @Override
    public String toString()
    {/* The toString method overrides the Object toString method and returns a
        formatted String containing this Player object's name, uniformNumber,
        position, and salary attributes.
     */
        return "Player: " + name + "\nUniform Number: " + uniformNumber 
                + "\nPosition: " + position + "\nSalary: " + salary;
    }
             
}

