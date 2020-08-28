package com.java.VendingMachine.enums;

public enum CoinType {

	NICKLE("NICKLE",5), DIME("DIME",10), QUARTER("QUARTER",25), DOLLAR("DOLLAR",100); 
	private int denomination; 
	private String name;

	private CoinType(String name, int denomination){ 
		this.name = name; this.denomination = denomination; 
	} 

	public int getDenomination(){ 
		return denomination; 
	} 

	public String getName(){ 
		return name; 
	} 

}
