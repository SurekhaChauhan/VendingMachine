package com.java.VendingMachine.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.java.VendingMachine.dto.VendingMachineDTO;
import com.java.VendingMachine.enums.CoinType;
import com.java.VendingMachine.enums.Products;

public class VendingMachineServiceImpl implements VendingMachineService{

	private static int Balance=0; //stores total balance
	private static Map<String, Integer> itemInventory = new HashMap<String, Integer>(); //hashmap for items and its numbers
	private static Map<String, Integer> coinInventory = new HashMap<String, Integer>(); //hashmap for coins and its numbers

	@Override
	public VendingMachineDTO getItemAndChange(String item, String money) {
		VendingMachineDTO vendingMachineDTO = new VendingMachineDTO();
		int total = getTotalMoney(money, 0);
		if(item.equals("COLDDRINK")){
			System.out.println("You have selected "+Products.COLDDRINK.getName());
			if(total >= Products.COLDDRINK.getPrice()){
				total = total - Products.COLDDRINK.getPrice();
				vendingMachineDTO.setTotal(total);
				System.out.println("Thank you for your purchase!! ");
				System.out.println("Your balance is "+total);
			}else{
				System.out.println("Insert more coins ");
				vendingMachineDTO.setConditionOfVendingMachine(2);
				return vendingMachineDTO;
			}

		}else if(item.equals("CANDY")){
			System.out.println("You have selected "+Products.CANDY.getName());
			if(total>=Products.CANDY.getPrice()){
				total = total - Products.CANDY.getPrice();
				System.out.println("Thank you for your purchase!! ");
				System.out.println("Your balance is "+total);
				vendingMachineDTO.setTotal(total);
			}else{
				System.out.println("Insert more coins ");
				vendingMachineDTO.setConditionOfVendingMachine(2);
				return vendingMachineDTO;
			}
		}else if(item.equals("CHOCLATE")){
			System.out.println("You have selected "+Products.CHOCLATE.getName());
			if(total>=Products.CHOCLATE.getPrice()){
				total = total - Products.CHOCLATE.getPrice();
				System.out.println("Thank you for your purchase!! ");
				vendingMachineDTO.setTotal(total);
				System.out.println("Your balance is "+total);
			}else{
				System.out.println("Insert more coins ");
				vendingMachineDTO.setConditionOfVendingMachine(2);
				return vendingMachineDTO;
			}
		}else if(item.equals("RETURN")){
			System.out.println("Your balance is "+total+" and is returned.");
			vendingMachineDTO.setConditionOfVendingMachine(1);
			return vendingMachineDTO;
		}else if(item.equals("CANCEL")){
			vendingMachineDTO.setConditionOfVendingMachine(-1);
			return vendingMachineDTO;
		}else{
			System.out.println("Wrong choice: Your balance is "+total);
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
			System.out.println("Wrong Input Coin");
		}

		return total;

	}

	@Override
	public void checkVendingMachineStatus(VendingMachineDTO vendingMachineDTO) {
		initiateInventory(); // initiate with items and coins storage in the vending machine
		Scanner sc = new Scanner(System.in);
		String sample=vendingMachineDTO.getItem(); // select items
		int checkVendCond=0;
		if(!itemInventory.containsKey(sample)){ // for return and cancel case
			checkVendCond=vendingMachineDTO.getConditionOfVendingMachine();
		} else if(itemInventory.get(sample)==0){ // Sold out items
			System.out.println("Sold Out, Please insert coins and buy another item");
		}else{
			checkVendCond = vendingMachineDTO.getConditionOfVendingMachine();
			if(checkVendCond==2){
				sample=vendingMachineDTO.getItem();
				if(itemInventory.get(sample)==0){
					System.out.println("Sold Out, Please insert coins and buy the items");
				} else if(itemInventory.get(sample)==1 || itemInventory.get(sample)==-1){

				}else{
					itemInventory.put(sample, itemInventory.get(sample) - 1);
					Balance=checkVendCond;
				}
			}else{
				itemInventory.put(sample, itemInventory.get(sample) - 1);
				Balance=checkVendCond;
			}

		}

		sc.close();		
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
