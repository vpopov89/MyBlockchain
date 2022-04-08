package com.acme.myblockchain;

import static com.acme.myblockchain.HashUtil.calculateBlockHash;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

public class BlockchainTest {

	@Test
	public void empty_blockchain_is_valid() {
		assertTrue(new Blockchain().verify());
	}

	@Test
	public void inserting_a_single_block_in_an_empty_blockchain_is_valid() {

		var block = new Block("123");

		var blockchain = new Blockchain();
		blockchain.addBlock(block);
		assertTrue(blockchain.verify());
	}

	@Test
	public void changing_data_in_a_block_in_the_blockchain_is_invalid() {

		var block = new Block("123");

		var blockchain = new Blockchain();
		blockchain.addBlock(block);
		assertTrue(blockchain.verify());

		var transaction1 = new Transaction("trans_1");
		transaction1.setSender("person1");

		block.setTransactions(Set.of(transaction1));

		assertFalse(blockchain.verify());
	}

	@Test
	public void changing_data_in_a_block_and_recalculating_the_hash_is_valid() {

		var block = new Block("123");

		var blockchain = new Blockchain();
		blockchain.addBlock(block);
		assertTrue(blockchain.verify());

		var transaction1 = new Transaction("trans_1");
		transaction1.setSender("person1");

		block.setTransactions(Set.of(transaction1));
		block.setBlockHash(calculateBlockHash(block));

		assertTrue(blockchain.verify());
	}

	@Test
	public void multiple_blocks_in_the_blockchain_is_valid() {

		var block1 = new Block("1");
		var block2 = new Block("2");
		var block3 = new Block("3");

		var blockchain = new Blockchain();
		blockchain.addBlock(block1);
		blockchain.addBlock(block2);
		blockchain.addBlock(block3);
		assertTrue(blockchain.verify());
	}

	@Test
	public void changing_data_in_a_block_makes_other_blocks_invalid() {

		var block1 = new Block("1");
		var block2 = new Block("2");
		var block3 = new Block("3");

		var blockchain = new Blockchain();
		blockchain.addBlock(block1);
		blockchain.addBlock(block2);
		blockchain.addBlock(block3);
		assertTrue(blockchain.verify());

		var transaction1 = new Transaction("trans_1");
		transaction1.setSender("person1");

		block1.setTransactions(Set.of(transaction1));
		block1.setBlockHash(calculateBlockHash(block1));

		assertFalse(blockchain.verify());
	}
}
