package com.java.VendingMachine.enums;

/** * Products Supported by our Vending Machine. */
public enum Products {

	COLDDRINK("COLDDRINK", 100), CANDY("CANDY", 65), CHOCLATE("CHOCLATE", 50);

	private String name; 
	private int price; 

	private Products(String name, int price){ 
		this.name = name; this.price = price; 
	} 

	public String getName(){ 
		return name; 
	} 

	public int getPrice(){ 
		return price; 
	} 

}
