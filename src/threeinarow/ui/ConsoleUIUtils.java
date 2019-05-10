/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threeinarow.ui;

import java.util.Scanner;

/**
 *
 * @author veymarmc
 */
public class ConsoleUIUtils {
    private static Scanner reader = new Scanner(System.in);
    
    public static void showMenu(String title, String[] options) {
        System.out.println("----- " + title + " -----");
        for(int i=0; i<options.length; i++) {
            System.out.println(options[i]);
        }
    }
    
    public static int readOptionMenu(int leastOption, int greatestOption) {
        boolean isInvalidOption = true;
        int optionMenu = 0;
        
        while(isInvalidOption) {
            try {
                optionMenu = ConsoleUIUtils.reader.nextInt();
                if (optionMenu < leastOption || optionMenu > greatestOption) {
                    throw new Exception();
                }
                isInvalidOption = false;
            } catch (Exception e) {
                System.out.println("You should put an Integer, and a valid option");
            }
        }
        
        return optionMenu;
    }
}
