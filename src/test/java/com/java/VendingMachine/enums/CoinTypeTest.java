package com.java.VendingMachine.enums;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CoinTypeTest {


	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void should() {

		assertThat(CoinType.DIME.getDenomination(), is(10));
		assertEquals(CoinType.DIME.getName(), "DIME");

		assertThat(CoinType.QUARTER.getDenomination(), is(25));
		assertEquals(CoinType.QUARTER.getName(), "QUARTER");

		assertThat(CoinType.DOLLAR.getDenomination(), is(100));
		assertEquals(CoinType.DOLLAR.getName(), "DOLLAR");

	}

}
