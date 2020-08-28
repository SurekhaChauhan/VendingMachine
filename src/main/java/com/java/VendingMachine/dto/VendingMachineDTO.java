package com.java.VendingMachine.dto;

public class VendingMachineDTO {
	
	private int total;
	private String item;
	private int conditionOfVendingMachine;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getConditionOfVendingMachine() {
		return conditionOfVendingMachine;
	}
	public void setConditionOfVendingMachine(int conditionOfVendingMachine) {
		this.conditionOfVendingMachine = conditionOfVendingMachine;
	}

}
