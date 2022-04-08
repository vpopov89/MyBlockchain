package com.acme.myblockchain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Just a class to represent some data for which a hash to be calculated.
 * 
 */
@Getter
@Setter
@ToString
public class Transaction {

	private String id;
	private String sender;
	private String receiver;
	private BigDecimal transferAmount;

	public Transaction(String id) {

		if (id == null || id.trim().length() == 0) {
			throw new IllegalArgumentException("id should not be empty");
		}

		this.id = id;
	}
}
