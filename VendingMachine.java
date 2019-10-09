/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designclassesdriver;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Naveene Raya Carlos Alvarenga
 */
public class VendingMachine {
    
    // array that stores all products in the vending machine
    
    private HashMap<valuables, Integer> vendor = new HashMap<>();
    
    //Carlos
    private final int coinsStart = 5;//Carlos
    private Map<valuables, Integer> coins = new HashMap<>(); 
    
    /**
     * default constructor
     */
    public VendingMachine(){
        for(valuables v : valuables.values())
            vendor.put(v, 0);
        
        //Carlos
        int coinsStartValue = 0;
        int coinsIndexStart = 5;
        for(valuables v : valuables.values()){
            if(v.getValue() >= coinsIndexStart){
                coins.put(v, coinsStartValue);
            }
        }
    }
    
    //Carlos
    public void buy(){
        Scanner in = new Scanner(System.in);     // takes in user response
        String response = in.nextLine();
        String lowerResponse = response.toLowerCase();
        String firstChars = "xxx" ;
        firstChars = lowerResponse.substring(0,1);
        if (firstChars == "m" && lowerResponse.length() == 1){
            System.out.println("Try typing full product name");
            return;
        }
        if(lowerResponse.charAt(0) == 'm' || lowerResponse.charAt(0)=='M'){
            firstChars = lowerResponse.substring(0, 2);
        }
        
        switch(firstChars){
            case "d":
                //coins.put(valuables.PENNY, coins.get(valuables.PENNY) + 1);
                processPurchase(valuables.DIETPEPSI);
                //System.out.println("Quantity: "+quantity);
                break;
            case "w":
                processPurchase(valuables.WATER);
                break;
            case "ma":
                processPurchase(valuables.MARSBAR);
                break;
            case "m&":
                processPurchase(valuables.MANDMS);
                break;
            case "p":
                processPurchase(valuables.POPCORN);
                break;
            default:
                System.out.println("Invalid Choice.");
        }
    }
    public void processPurchase(valuables item){
        int quantity = vendor.get(item);
        if(quantity>0){
            if(getTotalCoinValue()>= item.getPrice()){
                int itemsPurchased = 1;
                vendor.put(item, vendor.get(item) - itemsPurchased);
                //setTotalCoinValueToZero();
                String name = item.getName();
                double price = item.getPrice();
                System.out.println("Purchasing a: "+name+ " Value: "+price+" Quantity: "+quantity);
                System.out.println("Vending a: "+name+ " Value: "+price+" Quantity: "+quantity);

                for (Map.Entry<valuables, Integer> coin : coins.entrySet()){
                    while(coin.getValue() > 0){
                        String coinName = coin.getKey().getName();
                        System.out.println("Putting a "+coinName+" into the till.");
                        coin.setValue(coin.getValue() - 1);
                    }
                }
            }
            else{
                System.out.println("We require more minerals.");
            }
        }
        else{
            System.out.println("Additional supply depots required.");
        }
        

    }
    /*public void getCoins(){
        System.out.println(this.coins);
    }*/
    public void setCoins(){
        System.out.println("Insert Coin");
        Scanner in = new Scanner(System.in);     // takes in user response
        String response = in.nextLine();
        String lowerResponse = response.toLowerCase();
        String firstChars = "xxx" ;
        firstChars = lowerResponse.substring(0,1);
        if(lowerResponse.charAt(0) == 'd' || lowerResponse.charAt(0)=='D'){
            firstChars = lowerResponse.substring(0, 2);
        }
        
        switch(firstChars){
            case "p":
                coins.put(valuables.PENNY, coins.get(valuables.PENNY) + 1);
                break;
            case "n":
                coins.put(valuables.NICKEL, coins.get(valuables.NICKEL) + 1);
                break;
            case "di":
                coins.put(valuables.DIME, coins.get(valuables.DIME) + 1);
                break;
            case "q":
                coins.put(valuables.QUARTER, coins.get(valuables.QUARTER) + 1);
                break;
            case "h":
                coins.put(valuables.HALFDOLLAR, coins.get(valuables.HALFDOLLAR) + 1);
                break;
            case "do":
                coins.put(valuables.DOLLAR, coins.get(valuables.DOLLAR) + 1);
                break;
            default:
                System.out.println("Invalid Choice.");
        }
    }
    public void setTotalCoinValueToZero(){
        coins.put(valuables.DIME, 0);
        coins.put(valuables.DOLLAR, 0);
        coins.put(valuables.HALFDOLLAR, 0);
        coins.put(valuables.NICKEL, 0);
        coins.put(valuables.PENNY, 0);
        coins.put(valuables.QUARTER, 0);
    }
    public double getTotalCoinValue(){
        double totalCoinValue = 0;
        
        //iterate Map
        for (Map.Entry<valuables, Integer> entry : coins.entrySet()) {
            int totalCoins = entry.getValue();
            double coinValue = entry.getKey().getPrice();
            totalCoinValue = totalCoinValue + totalCoins*coinValue;
        }
        return totalCoinValue;
    }
    public void printTotalCoinValue(){
        System.out.println("You have put $"+getTotalCoinValue()+" into the machine.");
    }
    
    /**
     * adds valuables to the vending machine
     * @param v
     * @param add
     * @return
     */
    public boolean addQuantity(valuables v, String add){
        if(vendor.containsKey(v))
            vendor.put(v, vendor.get(v)+ Integer.parseInt(add));
        
        return true;
    }
    
    /**
     * retrieves the vendor hash map
     * @return
     */
    public HashMap<valuables, Integer> getVend(){
        return vendor;
    } 
}
