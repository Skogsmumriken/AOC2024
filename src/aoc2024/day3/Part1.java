package aoc2024.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
	private static final String FILE_NAME = "input.txt";
	private static final String EXAMPLE_NAME = "example.txt";
	
	public Part1(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Pattern pattern = Pattern.compile("mul\\(\\d+,\\d+\\)");
		ArrayList<String> multipl = new ArrayList<>();
		try (Scanner scanner = new Scanner(file)) {
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				Matcher matcher = pattern.matcher(line);
				while (matcher.find()) {
					multipl.add(matcher.group(0));
				}
			}
		}
		int result = 0;
		for(String mul : multipl) {
			String text = mul.substring(4, mul.length() - 1);
			String[] strNumbers = text.split(",");
	        int num1 = Integer.parseInt(strNumbers[0]);
	        int num2 = Integer.parseInt(strNumbers[1]);
	        result += num1*num2;
		}
		System.out.println(result);
	}
	
    public static void main(String[] args) throws FileNotFoundException{
    	new Part1(EXAMPLE_NAME);
    	new Part1(FILE_NAME);
    }
}
