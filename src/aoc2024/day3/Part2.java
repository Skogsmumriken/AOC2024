package aoc2024.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Part2 {
	private static final String FILE_NAME = "input.txt";
	private static final String EXAMPLE_NAME = "example.txt";
	
	public Part2(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		
		ArrayList<Integer> firstList = new ArrayList<>();
		ArrayList<Integer> secondList = new ArrayList<>();
		int simScore = 0;
		
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

		while(firstIt.hasNext()) {
			Iterator<Integer> secondIt = secondList.stream().sorted().iterator();
			int firstNum = firstIt.next();
			int simMultiplier = 0;
			while(secondIt.hasNext()) {
				if (secondIt.next() == firstNum) {
					simMultiplier++;
				}
			}
			simScore += firstNum * simMultiplier;
		}
		
		System.out.println("Total similarity score of \"" + fileName + "\" is: \n" + simScore);
	}
	
    public static void main(String[] args) throws FileNotFoundException{
    	new Part2(EXAMPLE_NAME);
    	new Part2(FILE_NAME);
    }
}
