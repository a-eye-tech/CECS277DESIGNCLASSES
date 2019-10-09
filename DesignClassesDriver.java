package DesignClasses;

import java.util.Scanner;

/**
 *
 * @author Naveene Raya Carlos Alvarenga
 */
public class DesignClassesDriver {

    /**
     * This is a program designed to emulate a vending machine
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String option = "";
        final String quit = "q";
        int snackValue = 5;
        VendingMachine myVend = new VendingMachine();
        
        do {
                    
        System.out.println("S)how Products I)nsert Coin B)uy A)dd Product R)emove Coins Q)uit");
        
        Scanner in = new Scanner(System.in);     // takes in user response
        String response = in.nextLine();
        option = processString(response);
        switch(option){
            case "s":     // prints out snacks 
                System.out.println("Show products");
                printSnacks(myVend, snackValue);
                break;
            case "i":     // insert coins and displays money
                printMoney(myVend, snackValue);
                break;
            case "b":     // buy a snack with money
                printMoney(myVend, snackValue);
                break;
            case "a":     // add +1 to a snack
                System.out.println("Add Products");
                printSnacks(myVend, snackValue);
                addToMachine( myVend, option, snackValue);
                break;
            case "r":     // remove all money
                System.out.println("");
                break;
            case "q":     // exit program
                option = "q";
                break;
            default:
                System.out.println("Error, incorrect option");
        }

        } while(!option.equals(quit));
        
        System.out.println("Quit");
        System.out.println("Completed satisfactorily");
    }
    
    /**
     * Processes the response string to fit to the first char of 
     * @param response
     * @return first character of response
     */
    public static String processString(String response){
        
        if("".equals(response))
            return "";
        String lowerResponse = response.toLowerCase();
         
        String firstChar = lowerResponse.substring(0, 1);
        
        return firstChar;
    }
    
    /**
     * prints out snacks
     * @param myVend
     * @param snackValue
     */
    public static void printSnacks(VendingMachine myVend, int snackValue){
       for(valuables v : myVend.getVend().keySet()){
           if(v.getValue() < snackValue){
               System.out.println(v.toString() + myVend.getVend().get(v));
           }
       }
    }  
    
    /**
     * prints out the money
     * @param myVend
     * @param snackValue
     */
    public static void printMoney(VendingMachine myVend, int snackValue){
        for(valuables v : myVend.getVend().keySet()){
            if(v.getValue() >= snackValue)
                System.out.println(v.toString() + myVend.getVend().get(v));
       }
    }
    
     public static void addToMachine(VendingMachine myVend, String option, int snackValue){

         Scanner in = new Scanner(System.in); 
       
         String snack = in.nextLine();
         
         System.out.print("How many of " + snack +  " are you adding? -->");
         
         String lowerSnack = snack.toLowerCase();
         
         Scanner in1 = new Scanner(System.in); 
       
         String amount = in1.nextLine();
         
         for(valuables v : myVend.getVend().keySet()){
             if(v.getName().toLowerCase().equals(lowerSnack))
                myVend.addQuantity(v, amount);
         }
     }
}