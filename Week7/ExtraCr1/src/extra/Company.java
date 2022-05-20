/*  Author: William Applegate
    Course: INFO-C211
    Date: 02/27/2022

    Program Description: This Extra Credit One program is a single file
    program containing the Company java class with a nested java class named
    Workers. The Company class contains a reference to the first element of a
    linked list representing the Company's workers. The workers are represented
    by objects of the nested java class Workers. The list of workers is
    initially null. The Company class contains a Main method that instantiates
    a new Company object and calls methods to provide a user interface in the
    terminal, where the linked list can be altered. 
*/

package extra;                      // Company class is within the extra
                                    // package. 

import java.util.Scanner;           // Import the Scanner class in order to 
                                    // get user input via the terminal. 


public class Company 
{
/*  The Company class is used to store and adjust a linked list of workers. 
    Workers are represented by objects of the Workers class, which is nested 
    within Company.java. The Company class contains three attributes. The 
    head attribute of type Workers serves as a reference to the first element 
    of the linked list of workers, or is null. The quit attribute of type 
    boolean is initially set to false, and is changed to true once the user 
    chooses to end the program. The static scan attribute is a Scanner object
    that is used to obtain user input via the terminal. The class uses a 
    default constructor and the class must be instantiated to work as intended.
    The Company class contains the Main method which instantiates a Company
    object and calls its user interface method. The interface contains a 
    while loop that continues to print a menu and ask for user input to adjust
    the linked list of workers. Once user input is received, the input is 
    passed to the take action method which takes action based on a switch 
    block. The program ends when the user selects the option to quit the
    program.
*/
    
    
    public Workers head;            // head of type Workers is a reference to 
                                    // the first element of Workers linked
                                    // list. It is initially null.
    
    boolean quit = false;           // quit of type boolean is initially set 
                                    // to false. User input will be requested
                                    // by program until user selects option
                                    // that changes quit value to true. 

    // scan of type Scanner is a static variable used to obtain user input
    // in terminal:
    static Scanner scan = new Scanner(System.in);
    
    
    public class Workers
    {
    /*  The Workers class represents nodes of a linked list of workers in a
        company The class is nested within the Company java class. The Workers
        Workers class contains three attributes. name of type String and 
        employeeID of type int represent worker object identifying information
        and they serve as the element's data. The next attribute of type 
        Workers references the next Workers object in the linked list, or is 
        null. The class contains three constructors that use constructor 
        chaining to instantiate objects and assign values to attributes. The 
        class contains get and set methods for all three attributes. 
    */
        
        public String name;         // name of type String represents the name
                                    // of Workers object.
        
        public int employeeID;      // employeeID of type int represents 
                                    // and ID number for workers object.
        
        public Workers next;        // next of type Workers references the 
                                    // next element in the linked list, or is 
                                    // null if no next element exists.
        
        public Workers (String nameInput, int employeeIDInput,
                Workers nextWorkerInput)
        {
        /*  This Workers constructor takes three parameters that are used to 
            assign values to the object's global variables. nameInput of type
            String is assigned to name, employeeIDInput of type int is assigned
            to employeeID, and nextWorkerInput is assigned to next. The other 
            constructors are chained to this one. 
        */
            
            name = nameInput;               // Assign nameInput parameter to
                                            // name attribute.
                                            
            employeeID = employeeIDInput;   // Assign employeeIDInput parameter
                                            // to employeeID attribute.
                                            
            next = nextWorkerInput;         // Assign nextWorkerInput parameter
                                            // to next attribute.
        }
        
        public Workers (String nameInput, int employeeIDInput)
        {
        /*  This workers constructor takes one string and one int parameter 
            to be assigned to name and employeeID attributes. The constructor 
            calls the three parameter constructor via chaining, and passes a
            null value for the next Workers attribute. 
        */
            this(nameInput, employeeIDInput, null);
        }
        
        public Workers (String nameInput)
        {
        /*  This workers constructor takes one string parameter to be assigned
            to the name attribute. The constructor calls the two parameter 
            constructor via chaining, passing a -1 value to be assigned to the 
            employeeID attribute.
        */
            this(nameInput, -1);
        }
        
        public String getName()
        {
        /*  This get method returns the name attribute of type String to the 
            caller.
        */
            return name;
        }
        
        public int getEmployeeID()
        {
        /*  This get method returns the employeeID attribute of type int to the 
            caller.
        */
            return employeeID;
        }
        
        public Workers getNextWorker()
        {
        /*  This get method returns the next attribute of type Workers to the 
            caller.
        */
            return next;
        }
        
        public void setName(String nameInput)
        {
        /*  This set method takes one parameter of type String and assigns it
            to the object's name attribute.
        */
            name = nameInput;
        }
        
        public void setEmployeeID(int employeeIDInput)
        {
        /*  This set method takes one parameter of type int and assigns it to
            the object's employeeID attribute.
        */
            employeeID = employeeIDInput;
        }
        
        public void setNext(Workers nextWorkerInput)
        {
        /*  This set method takes one parameter of type Workers and assigns it
            to the object's next attribute that references next element in 
            linked list.
        */
            next = nextWorkerInput;
        }
    }
    
    
    public static void printMenu()
    {
    /*  The printMenu method outputs a menu of options to the user via the 
        terminal. It prompts the user to enter a integer, 1 through 4 that will 
        be used by user interface to adjust linked list.
    */
        // Main menu:
        System.out.println("\tMain Menu");
        System.out.println("-----------------------------------------");
        
        // Enter a '1' to enter a new head entry:
        System.out.println("(1)\tEnter a new entry for the database at the "
                + "\"head position\"");
        
        // Enter a '2' to delete the head position element:
        System.out.println("(2)\tDelete an entry from the database from the "
                + "\"head\" position");
        
        // Enter a '3' to output the entire database to terminal:
        System.out.println("(3)\tPrint out the entire database (Name and ID"
                + " number on the same line)");
        
        // Enter a '4' to quit the program:
        System.out.println("(4)\tQuit");
    }
    
    public void takeAction(int choice)
    {
    /*  The takeAction method takes one parameter choice of type int. the 
        choice parameter represents a user selection as an integer. The 
        method uses a switch block to take appropriate action based on the 
        value of choice. Values 1 through 4 represent possible options of 
        adding a new first element to the linked list, deleting the first 
        element of the linked list, outputting the list, or quitting the
        program. If the integer does not represent a valid choice, the default
        case is used to output that the entry if invalid before returning to 
        the sender.
    */
        // Switch block based on int parameter choice:
        switch (choice)
        {
            // Case 1 prompts the user to enter information to create a new 
            // first element represented to the head attribute:
            case 1: 
                
                // Prompt user to enter new Workers name:
                System.out.println("Enter worker name, then press enter:");
                String nameInput = scan.nextLine();
                
                // Prompt user to enter new Workers employee ID: 
                System.out.println("Enter employee ID as an integer,"
                        + "then press enter: ");
                int employeeIDInput = scan.nextInt();
                
                // Move scanner to the next line after reading int:
                scan.nextLine();
                
                // Instante new Workers object using user input:
                Workers newWorker = new Workers(nameInput, employeeIDInput);
                
                // Assign the head attribute to the new Workers next attribute.
                // (Prepare to insert new head element):
                newWorker.next = head;
                
                // Re-assign Company's head attribute to the new Workers
                // object: 
                head = newWorker;
                
                break;
                
            // Case 2 removes the first element and re-assigns it to the  
            // second element if one exists:
            case 2:
                
                // Log deletion of first element:
                System.out.println("Deleting worker at head position");
                
                // Re-assign head to the second element (if no next element
                // exists then value will be null):
                head = head.next;
                
                break;
                
            // Case 3 outputs the linked list to the terminal by traversing 
            // the list and outputting each element:
            case 3: 
                
                // temp references the head element and will traverse linked
                // list:
                Workers temp = head;
                
                // while temp does not reference null value, output the value 
                // then re-assign temp to the next attribute:
                while (temp != null)
                {
                    System.out.printf("Name: %s\tID Number: %d\n",
                            temp.getName(), temp.getEmployeeID());
                    
                    temp = temp.next;
                }
                
                break;
                
            // Case 4 sets quit attribute to true, which will end caller's
            // while loop:
            case 4:
                quit = true;
                break;
                
            // default is used if choice did not represent a valid selection:
            default:
                
                // Log invalid entry before returning to caller:
                System.out.println("Entry invalid, try again");
                break;
            
        }
    }
    
    public void userInterface()
    {
    /*  The userInterface method is used to repeatedly allow the user to 
        interact with a user interface via the terminal. The method has a 
        local variable choice that represents the user's selection. While the 
        global variable quit is false, the method uses a while loop to 
        repeatedly do the following: Calls the printMenu method to output 
        possible selections, prompts the user to input a selection as an 
        integer, assigns the user input to choice variable and passes it 
        to the takeAction method to make appropriate action. Once quit 
        global variable is switched to true by the user input, the method
        returns to the caller. 
    */
        
         int choice;                // choice of type int will be assigned 
                                    // integer value entered by user. 
                                   
          // Repeatedly promp user to enter selections in terminal user
          // interface until quit global variable is switched to true by user.
          while(!quit)
        {
            printMenu();            // call printMenu method to provide list
                                    // of possible selections.
            
            // Promp user to enter an integer to be assigned to choice:
            System.out.println("Enter a menu selection as an integer, then"
                    + " press enter: ");
            
            choice = scan.nextInt();// Assign choice variable the value of 
                                    // user input (does not validate user 
                                    // input and may throw exception).
            
            scan.nextLine();        // After recieving int value, move scanner
                                    // to next line.
                                    
            takeAction(choice);     // pass choice variable to a takeAction
                                    // method call. 
        }
    }
    
    public static void main (String[] args)
    {
    /*  The main method is used to instantiate a Company object. The object's 
        userInterface method is then called in order to have user interact with 
        user interface in the terminal. Once the user interface returns, The
        main method logs that the program is closing. 
    */
        
        // Intantiate new Company object:
        Company thisCompany = new Company();
        
        // Call new Company object's user interface:
        thisCompany.userInterface();
        
        // Log program complete:
        System.out.println("Program closing.");
        
    }
}
