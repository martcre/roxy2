package de.martcre.roxy.roxy2.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigInteger;

@Data
@AllArgsConstructor
public class AdressDTO {
	private BigInteger id;
	private String street;
	private String number;
	private String city;
	private String postalCode;
}