package com.java.VendingMachine.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.java.VendingMachine.constants.VendingMachineConstant;
import com.java.VendingMachine.dto.VendingMachineDTO;
import com.java.VendingMachine.enums.CoinType;
import com.java.VendingMachine.enums.Products;
import com.java.VendingMachine.exception.NotAvailableException;

/** * Implementation of Vending Machine*/
public class VendingMachineServiceImpl implements VendingMachineService{

	private static int Balance=0; //stores total balance
	
	/** * A Map to create Inventory to hold Products inside Vending Machine */
	private static Map<String, Integer> itemInventory = new HashMap<String, Integer>(); //hashmap for items and its numbers
	
	/** * A Map to create Coin Inventory to hold cash inside Vending Machine */
	private static Map<String, Integer> coinInventory = new HashMap<String, Integer>(); //hashmap for coins and its numbers 


	@Override
	public VendingMachineDTO getItemAndChange(String item, String money) {
		VendingMachineDTO vendingMachineDTO = new VendingMachineDTO();
		int total = getTotalMoney(money, 0);
		if(Products.COLDDRINK.toString().equals("COLDDRINK")) {
			if(total >= Products.COLDDRINK.getPrice()){
				total = total - Products.COLDDRINK.getPrice();
				vendingMachineDTO.setTotal(total);
			}else{
				vendingMachineDTO.setConditionOfVendingMachine(2);
				return vendingMachineDTO;
			}
		}else if(Products.CANDY.toString().equals("CANDY")){
			if(total>=Products.CANDY.getPrice()){ 
				total = total - Products.CANDY.getPrice();
				vendingMachineDTO.setTotal(total);
			}else{
				vendingMachineDTO.setConditionOfVendingMachine(2);
				return vendingMachineDTO;
			}
		}else if(Products.CHOCLATE.toString().equals("CHOCLATE")){
			if(total>=Products.CHOCLATE.getPrice()){
				total = total - Products.CHOCLATE.getPrice();
				vendingMachineDTO.setTotal(total);
			}else{
				vendingMachineDTO.setConditionOfVendingMachine(2);
				return vendingMachineDTO;
			}
		}else if(item.equals("RETURN")){
			vendingMachineDTO.setConditionOfVendingMachine(1);
			return vendingMachineDTO;
		}else if(item.equals("CANCEL")){
			vendingMachineDTO.setConditionOfVendingMachine(-1);
			return vendingMachineDTO;
		}else{
			vendingMachineDTO.setConditionOfVendingMachine(1);
			return vendingMachineDTO;
		}
		vendingMachineDTO.setTotal(total);
		return vendingMachineDTO;
	}

	private static int getTotalMoney(String coin, int total) {
		total = 0;
		if(coin.equals("NICKLE")){
			total = total + CoinType.NICKLE.getDenomination();
		}else if(coin.equals("DIME")){
			total = total + CoinType.DIME.getDenomination();
		}else if(coin.equals("QUARTER")){
			total = total + CoinType.QUARTER.getDenomination();
		}else if(coin.equals("DOLLAR")){
			total = total + CoinType.DOLLAR.getDenomination();
		}else{
			total = -1;
		}

		return total;
	}

	@Override
	public void checkVendingMachineStatus(VendingMachineDTO vendingMachineDTO) {
		initiateInventory(); // initiate with items and coins storage in the vending machine
		Scanner sc = new Scanner(System.in);
		String sample=vendingMachineDTO.getItem(); // select items
		int checkVendCond=0;
		try {
			if(!itemInventory.containsKey(sample)){ // for return and cancel case
				checkVendCond=vendingMachineDTO.getConditionOfVendingMachine();
			} else if(itemInventory.get(sample)==0){ // Sold out items
				throw new NotAvailableException(VendingMachineConstant.SOLD_OUT_CUSTOM_EXCEPTION);
			}else{
				checkVendCond = vendingMachineDTO.getConditionOfVendingMachine();
				if(checkVendCond==2){
					sample=vendingMachineDTO.getItem();
					if(itemInventory.get(sample)==0){
						throw new NotAvailableException(VendingMachineConstant.SOLD_OUT_CUSTOM_EXCEPTION);
					} else if(itemInventory.get(sample)==1 || itemInventory.get(sample)==-1){
						throw new NotAvailableException(VendingMachineConstant.SOLD_OUT_CUSTOM_EXCEPTION);
					}else{
						itemInventory.put(sample, itemInventory.get(sample) - 1);
						Balance=checkVendCond;
					}
				}else{
					itemInventory.put(sample, itemInventory.get(sample) - 1);
					Balance=checkVendCond;
				}

			}
		}finally{
			sc.close();	
		}		
	}

	private static void initiateInventory(){
		for(Products i : Products.values()){
			itemInventory.put(i.getName(), 5);
		}
		for(CoinType i : CoinType.values()){
			coinInventory.put(i.getName(), 5);
		}
	}

}
