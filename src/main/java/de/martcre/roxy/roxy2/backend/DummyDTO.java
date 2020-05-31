package de.martcre.roxy.roxy2.backend;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;
import java.util.Set;

@Data
@AllArgsConstructor
public class DummyDTO {
	private BigInteger id;
	private String firstName;
	private String lastName;
	private AdressDTO homeAdress;
	private Set<AdressDTO> otherAdresses;
}