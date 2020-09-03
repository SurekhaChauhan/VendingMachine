package com.java.VendingMachine.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.VendingMachine.dto.VendingMachineDTO;

@RunWith(JUnit4.class)
public class VendingMachineServiceTest {
	
	 @Autowired
	    private VendingMachineService vendingMachineService;
	 @Autowired
	 VendingMachineDTO vendingMachineDTO;
	 	
	 
	  /**
	     * test if function returns item and change
	     */
	    @Test
	    public void checkVendingMachineStatus_shouldSucceed() throws Exception {
	    	vendingMachineDTO.setConditionOfVendingMachine(0);
	        vendingMachineDTO.setItem("COKE");
	        vendingMachineDTO.setTotal(9);
	        String item = "vending";
	        String money = "20";
	        VendingMachineDTO vendingMachineDTO = vendingMachineService.getItemAndChange(item, money);
	        assertNotNull(vendingMachineDTO);
	    }

}
