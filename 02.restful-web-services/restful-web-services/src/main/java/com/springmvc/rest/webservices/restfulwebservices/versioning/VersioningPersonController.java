package com.springmvc.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionofPerson() {
		return new PersonV1("Mukul Saini");
	}
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionofPerson() {
		return new PersonV2(new Name("Mukul","Saini"));
	}
}
