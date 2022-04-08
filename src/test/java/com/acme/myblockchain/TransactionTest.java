package com.acme.myblockchain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TransactionTest {
	@Test
	public void transaction_with_empty_id_is_invalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Transaction(null);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Transaction("");
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Transaction("  ");
		});
	}
}
