package DesignClasses;

/**
 *
 * @author Naveene Raya Carlos Alvarenga
 */
public enum valuables {
        //The value of the products
	DIETPEPSI(0, 1.25, "Diet pepsi"), WATER(1, 1.0, "Water"), MARSBAR(2, 0.65, "Mars bar"), MANDMS(3, 0.65, "M&ms"), POPCORN(4, 1.5, "Popcorn"),
        //values of the money
        PENNY(5, 0.01, "Penny"), NICKEL(6, 0.05, "Nickel"), DIME(7, 0.10, "Dime"), QUARTER(8, 0.25, "Quarter"), HALFDOLLAR(9, 0.50, "Half dollar"), DOLLAR(10, 1.0, "Dollar");
	
	/** Basic functions of a product */
	private final int value;
        private final double price;
        private final String name;
        
        /**
         * Constructs the basics of what a product and money consists of
         * @param pValue value used for menu functions
         * @param pPrice price of product
         * @param pName name of product
         */
	private valuables(final int pValue, final double pPrice, final String pName) {
		/** Stores both the integer value, price, and name of the product */
		this.value = pValue;
                this.price = pPrice;
                this.name = pName;
	}
	
	/**
	 * Retrieves designated number of the valuable
	 * @return number of valuable
	 */
	public int getValue () { return value; }
        
        /**
         * 
         * @return 
         */
        public String getName () { return name; }

        /**
         * Retrieves name of product and how much it costs, overrides toString method
         * @return name and price of product
         */
        @Override
        public String toString(){ return name + " Value: " + price + " Quantity: "; }
        
}
