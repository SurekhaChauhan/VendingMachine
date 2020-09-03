package com.java.VendingMachine.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import com.java.VendingMachine.dto.VendingMachineDTO;

@RunWith(JUnit4.class)
public class VendingMachineServiceImplTest {
	
	 @Autowired
	 private VendingMachineService vendingMachineService;
	 @Autowired
	 VendingMachineDTO vendingMachineDTO;
	 	
	 
	  /**
	     * test if returned DTO is not null
	     */
	    @Test
	    public void checkGetItemAndChange_shouldSucceed() throws Exception {
	        vendingMachineDTO = vendingMachineService.getItemAndChange("COKE", "10");
	        assertNotNull(vendingMachineDTO);
	    }
	    
	    
	
	    /**
	     * test if returned DTO is not null
	     */
	    @Test
	    public void checkVendingMachineStatus_shouldSucceed() throws Exception {
	        vendingMachineDTO = vendingMachineService.getItemAndChange("", "");
	        VendingMachineDTO returnDTO = new VendingMachineDTO();
	        returnDTO.setConditionOfVendingMachine(-2);
	        returnDTO.setItem("");
	        returnDTO.setTotal(0);
	        assertEquals(returnDTO, vendingMachineDTO);
	    }


}
