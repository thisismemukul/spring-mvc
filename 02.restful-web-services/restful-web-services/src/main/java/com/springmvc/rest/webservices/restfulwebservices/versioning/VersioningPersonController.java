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
	@GetMapping(path="/person",params = "version=1")
	public PersonV1 getFirstVersionofPersonRequestParameter() {
		return new PersonV1("Mukul Saini");
	}
	@GetMapping(path="/person",params = "version=2")
	public PersonV2 getSecondVersionofPersonRequestParameter() {
		return new PersonV2(new Name("Mukul","Saini"));
	}
	@GetMapping(path="/person/header",headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionofPersonRequestHeader() {
		return new PersonV1("Mukul Saini");
	}
	@GetMapping(path="/person/header",headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionofPersonRequestHeader() {
		return new PersonV2(new Name("Mukul","Saini"));
	}
	@GetMapping(path="/person/accept",produces = "application/vdn.company.app-v1+json")
	public PersonV1 getFirstVersionofPersonAccepttHeader() {
		return new PersonV1("Mukul Saini");
	}
	@GetMapping(path="/person/accept",produces = "application/vdn.company.app-v2+json")
	public PersonV2 getSecondVersionofPersonAccepttHeader() {
		return new PersonV2(new Name("Mukul","Saini"));
	}
}
