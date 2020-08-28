package com.java.VendingMachine.service;

import org.springframework.stereotype.Service;

import com.java.VendingMachine.dto.VendingMachineDTO;

@Service
public interface VendingMachineService {

	public VendingMachineDTO getItemAndChange(String item, String money);

	public void checkVendingMachineStatus(VendingMachineDTO vendingMachineDTO);

}
