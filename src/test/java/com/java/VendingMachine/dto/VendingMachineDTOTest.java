package com.java.VendingMachine.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class VendingMachineDTOTest {

	private VendingMachineDTO vendingMachineDTO = new VendingMachineDTO();

	@Before
	public void setUp() throws Exception {
		vendingMachineDTO.setItem("COKE");
		vendingMachineDTO.setTotal(20);
		vendingMachineDTO.setConditionOfVendingMachine(0);
	}

	@Test
	public void testGetterOfItem() {
		assertEquals("COKE", vendingMachineDTO.getItem());
	}

	@Test
	public void testSetTotal() {
		assertEquals(20, vendingMachineDTO.getTotal());
	}

	@Test
	public void testGetterOfConditionOfMachine() {
		assertEquals(0, vendingMachineDTO.getConditionOfVendingMachine());
	}

	@Test
	public void testGetterOfCOnditionOfMachine() {
		assertEquals(0, vendingMachineDTO.getConditionOfVendingMachine());
	}

}
