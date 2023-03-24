package com.springmvc.rest.webservices.restfulwebservices.versioning;

import jakarta.persistence.NamedQuery;

public class PersonV2 {
	public Name name;

	public PersonV2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV2 [name=" + name + "]";
	}

}

