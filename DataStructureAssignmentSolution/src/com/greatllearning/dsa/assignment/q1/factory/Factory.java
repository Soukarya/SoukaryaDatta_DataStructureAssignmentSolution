package com.greatllearning.dsa.assignment.q1.factory;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import com.greatllearning.dsa.assignment.q1.singleton.Singleton;
import com.greatllearning.dsa.assignment.q1.skyscraper.Skyscraper;

public class Factory {

	private List<Integer> floorListFromfactory = null;
	
	public List<Integer> getFloorsFromFactory() {
		return this.floorListFromfactory;
	}
	
	public static void input(final int totalFloorsInTheBuilding, Skyscraper skyscraper) {
		
		final Scanner sc = Singleton.getScannerInstance();
		Factory factory = Singleton.getFactoryInstance();
		int floorSize = 0;
		
		factory.floorListFromfactory = new ArrayList<Integer>(totalFloorsInTheBuilding);
		
		// factory is producing the floors that will be given to architect by factories on the ith day  
		for(int i=0;i<skyscraper.getTotalFloorsInTheBuilding();) {
			System.out.println("enter the floor size given on day : "+(i+1));
			floorSize = sc.nextInt();
			if(factory.getFloorsFromFactory().contains(floorSize)) {
				System.err.println("duplicate value exist!!! Please enter distinct values between 1 and "+skyscraper.getTotalFloorsInTheBuilding()+"\n");
			} else if(floorSize>skyscraper.getTotalFloorsInTheBuilding()){
				System.err.println("Invalid!!! Entered number cannot be greater than "+skyscraper.getTotalFloorsInTheBuilding()+"\n");
			} else if(floorSize<=0){
				System.err.println("Invalid!!! Entered number cannot be less than or equal to 0"+"\n");
			}else {
				factory.getFloorsFromFactory().add(floorSize);
				i++;
			}
		}
		skyscraper = null;
		sc.close();
	}	
}
