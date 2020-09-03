package com.java.VendingMachine.exception;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.VendingMachine.dto.VendingMachineDTO;
import com.java.VendingMachine.service.VendingMachineService;

public class NotAvailableException {	
	@Autowired
	VendingMachineService vendingMachineService;

	@Test(expected = Exception.class)
	public void checkCustomException() throws Exception {
		VendingMachineDTO vendingMachineDTO = vendingMachineService.getItemAndChange("CAKE", "100");
        if (vendingMachineDTO.getConditionOfVendingMachine() == -1) {
           throw new Exception("Item Not Available");
        }
    }

}
