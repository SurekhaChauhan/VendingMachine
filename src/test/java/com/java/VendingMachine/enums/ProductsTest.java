package com.java.VendingMachine.enums;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ProductsTest {


	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void should() {

		assertThat(Products.COLDDRINK.getPrice(), is(100));
		assertEquals(Products.COLDDRINK.getName(), "COLDDRINK");

		assertThat(Products.CANDY.getPrice(), is(65));
		assertEquals(Products.CANDY.getName(), "CANDY");

		assertThat(Products.CHOCLATE.getPrice(), is(50));
		assertEquals(Products.CHOCLATE.getName(), "CHOCLATE");

	}

}
