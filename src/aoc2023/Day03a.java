package aoc2023;

import java.util.ArrayList;

import Utils.FileTransform;

public class Day03a {

	public static void main(String[] args) {
		String fileName = "inputs/day03.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		list = FileTransform.fileToStringList(fileName);

		int sum = 0;
		
		for (int i=0; i<list.size(); i++) {
			
			int j = 0;
			
			int nbChar = list.get(i).length();
			
			String current = "";
			
			while (j < nbChar) {
				char c = list.get(i).charAt(j);
				
				int k = j;
				
				while (isNumeric(c) && k < nbChar) {
					
					
					current += c;
					
					k++;
					
					if (k < nbChar) {
						c = list.get(i).charAt(k);
					}
					
				}
				if (!current.equals("")) {
					if (isAdjacent(i, j, current, list)) {
						System.out.println(current);
						sum += Integer.valueOf(current);
					}
				}

				
//				if (!current.equals("")) {
//					System.out.println(current);
//				}
				
				current = "";
				
				if (j == k) {
					j++;
				} else {
					j = k;
				}
				
			}			
		}
		
		System.out.println("Sum = " + sum);
	}

	public static boolean isNumeric(char c) {
		return (c >= '0' && c <= '9');
	}
	
	public static boolean isAdjacent(int line, int start, String number, ArrayList<String> list) {
		if (line > 0) {
			int startIndex = Math.max(0, (start - 1));
//			int endIndex = Math.min(startIndex + number.length() + 2, list.get(line - 1).length() + 1);
			int endIndex = Math.min(startIndex + number.length() + 2, list.get(line - 1).length());
			String s1 = list.get(line - 1).substring(startIndex, endIndex);
//			System.out.println(s1);
			
			for (int i=0; i<s1.length(); i++) {
				if (s1.charAt(i) != '.') {
					return true;
				}
			}
		}
		
		if (start > 0) {
			if (list.get(line).charAt(start - 1) != '.') {
				return true;
			}
		}
		
		if (start + number.length() < list.get(line).length() - 1) {
			if (list.get(line).charAt(start  + number.length()) != '.') {
				return true;
			}
		}
		
		if (line < list.size() - 1) {
			int startIndex = Math.max(0, (start - 1));
			int endIndex = Math.min(startIndex + number.length() + 2, list.get(line + 1).length());
			String s2 = list.get(line + 1).substring(startIndex, endIndex);
//			System.out.println(s2);
			
			for (int i=0; i<s2.length(); i++) {
				if (s2.charAt(i) != '.') {
					return true;
				}
			}
		}
		
		return false;
	}
}
