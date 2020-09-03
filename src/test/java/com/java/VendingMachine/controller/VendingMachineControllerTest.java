package com.java.VendingMachine.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.java.VendingMachine.dto.VendingMachineDTO;
import com.java.VendingMachine.service.VendingMachineService;


public class VendingMachineControllerTest {
    
    @InjectMocks
    VendingMachineController vendingMachineController;
    
    @Autowired
    VendingMachineDTO vendingMachineDTO;
    
    @Mock
    private VendingMachineService vendingMachineService;
    
    @Autowired
    private MockMvc mockMvc;
    
    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testGetItemAndChange() throws Exception {
        vendingMachineDTO.setConditionOfVendingMachine(0);
        vendingMachineDTO.setItem("COKE");
        vendingMachineDTO.setTotal(9);
        String item = "COKE";
        String money = "20";
        given(vendingMachineService.getItemAndChange(item, money)).willReturn(vendingMachineDTO);
        mockMvc.perform(get("/choose/COKE/20")).andExpect(status().isOk());

    }

}
 








