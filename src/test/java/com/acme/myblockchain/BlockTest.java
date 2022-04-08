package com.acme.myblockchain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BlockTest {
	@Test
	public void block_with_empty_id_is_invalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Block(null);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Block("");
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Block("  ");
		});
	}
}
