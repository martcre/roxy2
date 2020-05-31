package de.martcre.roxy.roxy2.backend;

import java.math.BigInteger;

public class AdressDAO {
	private static int adressIdCounter;

	private static int getNextAdressIdCounter() {
		return (adressIdCounter++);
	}

	public static AdressDTO randomAdressGenerator() {
		return new AdressDTO(BigInteger.valueOf(getNextAdressIdCounter()), "street", "number", "city", "postalCode");
	}
}
