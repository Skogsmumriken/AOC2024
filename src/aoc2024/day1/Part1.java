package aoc2024.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Part1 {
	private static final String FILE_NAME = "input.txt";
	private static final String EXAMPLE_NAME = "example.txt";
	
	public Part1(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		
		ArrayList<Integer> firstList = new ArrayList<>();
		ArrayList<Integer> secondList = new ArrayList<>();
		int totalDist = 0;
		
		try (Scanner scanner = new Scanner(file)) {
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				int firstSpace = line.indexOf(" ");
				int lastSpace = line.lastIndexOf(" ");
				
				String firstString = line.substring(0,firstSpace);
				String secondString = line.substring(lastSpace+1);
				
				int firstNum = Integer.valueOf(firstString) ;
				int secondNum = Integer.valueOf(secondString);
				
				firstList.add(firstNum);
				secondList.add(secondNum);
			}
		}
		Iterator<Integer> firstIt = firstList.stream().sorted().iterator();
		Iterator<Integer> secondIt = secondList.stream().sorted().iterator();
		while(firstIt.hasNext() && secondIt.hasNext()) {
			totalDist += Math.abs(firstIt.next() - secondIt.next());
		}
		
		System.out.println("Total distance of \"" + fileName + "\" is: \n" + totalDist);
	}
	
    public static void main(String[] args) throws FileNotFoundException{
    	new Part1(EXAMPLE_NAME);
    	new Part1(FILE_NAME);
    }
}
