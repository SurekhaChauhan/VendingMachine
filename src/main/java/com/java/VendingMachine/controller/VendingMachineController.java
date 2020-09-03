package com.java.VendingMachine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.java.VendingMachine.dto.VendingMachineDTO;
import com.java.VendingMachine.service.VendingMachineService;

@RestController
public class VendingMachineController {

	private VendingMachineService vendingMachineService;
	
	@Autowired
    public VendingMachineController(VendingMachineService vendingMachineService) {
        this.vendingMachineService = vendingMachineService;
    }
	
	/**
	 * REST endpoint for Choosing Item and Sending Money to Vending Machine
	 *
	 * @param item
	 * @param money
	 *           
	 * @return A VendingMachineDTO having total, item and conditionOfVendingMachine
	 */
	
	@GetMapping(value = "/choose/{item}/{money}")
	public VendingMachineDTO getItemAndChange(@PathVariable String item, @PathVariable String money) {
		
		VendingMachineDTO vendingMachineDTO =  vendingMachineService.getItemAndChange(item, money);
		vendingMachineService.checkVendingMachineStatus(vendingMachineDTO);
		return vendingMachineDTO;
		
	}

}
