package com.acme.myblockchain;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@Getter
@Setter
@ToString
public class Block {

	private Set<Transaction> transactions;

	private String id;
	private String prevBlockHash;

	@Exclude
	private String blockHash;

	@Exclude
	private Block nextBlock;

	public Block(String id) {

		if (id == null || id.trim().length() == 0) {
			throw new IllegalArgumentException("id should not be empty");
		}

		this.id = id;
	}
}
