package com.greatllearning.dsa.assignment.q1.singleton;

import java.util.Scanner;

import com.greatllearning.dsa.assignment.q1.factory.Factory;

public class Singleton {

	private static Scanner scannerInstance = null;
	private static Factory factoryInstance = null;
	
	// Scanner class
	public static Scanner getScannerInstance() {
		if(scannerInstance == null) {
			scannerInstance = new Scanner(System.in);
		}
		return scannerInstance;
	}
	
	// Factory class
	public static Factory getFactoryInstance() {
		if(factoryInstance == null) {
			factoryInstance = new Factory();
		}
		return factoryInstance;
	}
	
	
	
	
}
