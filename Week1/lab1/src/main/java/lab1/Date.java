package lab1;

import java.util.Scanner;

/** Lab One Date class
 *  Author: William Applegate
 *  INFO-C211
 *  01/15/2022
 */
public class Date {
    /*Global Instance Variables*/
    int day, month, year;
    private static Scanner scan = new Scanner(System.in);
    
    /*Constructors*/
    public Date(){
        this.month = 0;
        this.day = 0;
        this.year = 0;
    }
    
    public Date(int monthInput, int dayInput, int yearInput){
        this.month = monthInput;
        this.day = dayInput;
        this.year = yearInput;
        
        checkSetValues();
    }
    
    
    /*Check for valid values*/
    private void checkSetValues(){
        //Evaluate and assign month input
        if(this.month > 12){
            this.month = 12;
        }else if(this.month < 1){
            this.month = 1;
        }
        
        //Evaluate and assign day input
        if(this.day > 31){
            this.day = 31;
        }else if (this.day < 1){
            this.day = 1;
        }
    }
    
    /*Get user input*/
    public void input(){
        //Get user input
        System.out.println("Enter a date in the format month, day, year (mm dd yyyy): ");
        
        this.month = scan.nextInt();
        this.day= scan.nextInt();
        this.year = scan.nextInt();
        
        checkSetValues();
        
    }
    
    /*Print global variables*/
    public void output(){
        System.out.println("" + this.month + "/" + this.day + "/" + this.year);
    }
    
    public boolean before(Date otherDate){
        if(this.year < otherDate.year){
            return true;
        }else if(this.year > otherDate.year){
            return false;
        }else if(this.month < otherDate.month){
            return true;
        }else if(this.month > otherDate.month){
            return false;
        }else if(this.day < otherDate.day){
            return true;
        }else{
            return false;
        }
    }
    
    
    public static void main(String[] args) {
        Date today = new Date(1, 15, 2022);
        Date someday = new Date();
        today.output();
        someday.input();
        someday.output();
        
        if(today.before(someday)){
            System.out.println("Today is earlier than someday");
        }else{
            System.out.println("Today is not earlier than someday");
        }
        
    }
    
}
