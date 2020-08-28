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
	
	@GetMapping("/choose/{item}/{money}")
	public VendingMachineDTO getItemAndChange(@PathVariable String item, @PathVariable String money) {
		
		VendingMachineDTO vendingMachineDTO =  vendingMachineService.getItemAndChange(item, money);
		vendingMachineService.checkVendingMachineStatus(vendingMachineDTO);
		return vendingMachineDTO;
		
	}

}
