package aoc2024.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part1 {
	private static final String FILE_NAME = "input.txt";
	private static final String EXAMPLE_NAME = "example.txt";
	
	public Part1(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		
		ArrayList<ArrayList<Integer>> bigList = new ArrayList<>();
		int safeReportCounter = 0;
		
		try (Scanner scanner = new Scanner(file)) {
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				bigList.add(getIntList(line));
			}
		}
		
		for(ArrayList<Integer> smallerList : bigList) {
			if(smallerList.size() == 1 ) {
				safeReportCounter++;
			}else if(isReportSafe(smallerList)) {
				safeReportCounter++;
			}
		}
		
		System.out.println(safeReportCounter);
	}
	private boolean isReportSafe(ArrayList<Integer> list) {
		if(!isListSorted(list)) {
			return false;
		}
		
		for(int i = 0; i < list.size()-1; i++) {
			if(3 < Math.abs(list.get(i) - list.get(i+1)) //
					||  Math.abs(list.get(i+1) - list.get(i)) < 1) {
				return false;
			}
		}
		return true;
	}
	private boolean isListSorted(ArrayList<Integer> list) {
		boolean isAcending = list.get(0) < list.get(1);
		for(int i = 1; i < list.size()-1; i++) {
			if (isAcending && list.get(i) > list.get(i+1) || !isAcending && list.get(i) < list.get(i+1)) {
				return false;
			}
		}
		return true;
	}
	public ArrayList<Integer> getIntList(String line){
		String[] stringArray = line.split(" ");
		ArrayList<Integer> integerList = new ArrayList<Integer>(); 
		for(String el : stringArray) {
			integerList.add(Integer.valueOf(el));
		}
		return integerList; 
	}
    public static void main(String[] args) throws FileNotFoundException{
    	new Part1(EXAMPLE_NAME);
    	new Part1(FILE_NAME);
    }
}
