package DesignClasses;

import java.util.HashMap;

/**
 *
 * @author Naveene Raya Carlos Alvarenga
 */
public class VendingMachine {
    
    // array that stores all products in the vending machine
    
    private HashMap<valuables, Integer> vendor = new HashMap<>();
    
    /**
     * default constructor
     */
    public VendingMachine(){
        for(valuables v : valuables.values())
            vendor.put(v, 0);
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

