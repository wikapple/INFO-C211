/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

/**
 *
 * @author wikap
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

//Given
        final double KILOMETER_TO_MILE = .6214;
        int totalKilometers = 5;
        
        Problem:
        System.out.printf("%d kilometers converted to miles is %.2f",
                totalKilometers, totalKilometers * KILOMETER_TO_MILE);
        
    }
    
}
