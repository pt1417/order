package com.ibm.order.util;

import java.util.UUID;

public class GenerateUniqueID {

	public static String GenerateID(String prefix) {
		
		UUID uuid = UUID.randomUUID();
		return prefix + uuid;
	}
}
