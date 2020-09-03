package com.java.VendingMachine.service;

import org.springframework.stereotype.Service;

import com.java.VendingMachine.dto.VendingMachineDTO;
/** * Public API for our Vending Machine */

@Service
public interface VendingMachineService {

	public void checkVendingMachineStatus(VendingMachineDTO vendingMachineDTO);

	public VendingMachineDTO getItemAndChange(String item, String money);

}
