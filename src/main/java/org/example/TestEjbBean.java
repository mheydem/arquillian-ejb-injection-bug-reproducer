package org.example;

import jakarta.ejb.Stateless;

@Stateless
public class TestEjbBean {

	public void callVoid() {
		System.out.println(getClass().getName() + "::callMe: ");
	}

	public long callLong() {
		System.out.println(getClass().getName() + "::callLong: ");
		return 1L;
	}
}
