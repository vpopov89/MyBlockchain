package com.acme.myblockchain;

import static com.acme.myblockchain.HashUtil.calculateBlockHash;

public class Blockchain {

	private Block headBlock;
	private Block currentBlock;

	public boolean verify() {

		var block = headBlock;
		String previousBlockHash = null;

		while (block != null) {

			if (previousBlockHash != null && !previousBlockHash.equals(block.getPrevBlockHash())) {
				return false;
			}

			var blockHash = calculateBlockHash(block);
			if (!blockHash.equals(block.getBlockHash())) {
				return false;
			}

			previousBlockHash = blockHash;
			block = block.getNextBlock();
		}

		return true;
	}

	public void addBlock(Block block) {
		if (headBlock == null) {
			headBlock = block;
		}

		if (currentBlock != null) {
			currentBlock.setNextBlock(block);
			block.setPrevBlockHash(calculateBlockHash(currentBlock));
		}
		block.setBlockHash(calculateBlockHash(block));
		currentBlock = block;
	}
}
