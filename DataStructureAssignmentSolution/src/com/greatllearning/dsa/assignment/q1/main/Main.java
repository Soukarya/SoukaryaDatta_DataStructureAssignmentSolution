package com.greatllearning.dsa.assignment.q1.main;

import java.util.Stack;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.greatllearning.dsa.assignment.q1.factory.Factory;
import com.greatllearning.dsa.assignment.q1.singleton.Singleton;

public class Main {
	
	//Methods
	private static void output(final List<Integer> lists) {
		
		Stack<Integer> stack = new Stack<>();
		boolean isFloorPresent = false;
		int floorSizeTemp=0 ,totalNoOfFloors = 0;
		floorSizeTemp = totalNoOfFloors = lists.size();
		Comparator<Integer> comparator = (i1,i2) -> i1.compareTo(i2);
				
		System.out.println("\nThe order of construction is as follows\n");
		for(int i=0;i<totalNoOfFloors;i++) {

			isFloorPresent = false;
			System.out.println("Day: "+(i+1));
			if(lists.get(i) == floorSizeTemp) {
				stack.push(lists.get(i));
				isFloorPresent = true;
			}else {
				stack.push(lists.get(i));
			}
			if(isFloorPresent) {
				stack.sort(comparator);
				for(int j=0;j<stack.size();) {
					if(j != stack.size()-1) {
						System.out.print(stack.pop()+" ");
					} else {
						System.out.print(stack.pop());
					}
					floorSizeTemp--;
					if(stack.size()>0) {
						if(stack.peek() != floorSizeTemp) {
							break;
						}
					}
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {

		// local variables
		Scanner sc = Singleton.getScannerInstance();
		Factory factory = Singleton.getFactoryInstance();
		int totalFloorsInTheBuilding = -1; // this will be used to provide input to the Factory that how many floors a skyscraper must have
		
		do {
			System.out.println("enter the total no of floors in the building");
			totalFloorsInTheBuilding = sc.nextInt();
			
			if(totalFloorsInTheBuilding<=0) {
				System.err.println("Invalid!!! Total no of floors in a skyscrapper should be greater than or equal to 1\n");
			}
		} while(totalFloorsInTheBuilding<=0);
		
		Factory.input(totalFloorsInTheBuilding);
		
		// getting the floor details from factory
		Main.output(factory.getFloorsFromFactory());
		
		// de-allocating resources
		factory = null;
		sc.close();
	}
}
