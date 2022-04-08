package com.acme.myblockchain;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class HashUtil {
	public static String calculateBlockHash(Block block) {
		return calculateHash(block.toString());
	}

	private static String calculateHash(String message) {
		return new String(Base64.encodeBase64(DigestUtils.sha256(message)));
	}
}
