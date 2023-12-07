package aoc2023;

import java.math.BigInteger;
import java.util.ArrayList;

import Utils.FileTransform;

public class Day01b {

	public static void main(String[] args) {
String fileName = "inputs/day01.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		list = FileTransform.fileToStringList(fileName);

		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < list.size(); i++) {
			char char1 = '\0';
			char char2 = '\0';
			String tmp = list.get(i);
			int j = 0;
			while (j < tmp.length()) {
//				System.out.println(tmp.charAt(j));
				if (tmp.charAt(j) >= '0' && tmp.charAt(j) <= '9') {
					if (char1 == '\0') {
						char1 = char2 = tmp.charAt(j);
					} else {
						char2 = tmp.charAt(j);
					}
					j++;
				} else if (tmp.substring(j, Math.min(j + 3, tmp.length())).equals("one")) {
					if (char1 == '\0') {
						char1 = char2 = '1';
					} else {
						char2 = '1';
					}
					j += 2;
				} else if (tmp.substring(j, Math.min(j + 3, tmp.length())).equals("two")) {
					if (char1 == '\0') {
						char1 = char2 = '2';
					} else {
						char2 = '2';
					}
					j += 2;
				} else if (tmp.substring(j, Math.min(j + 5, tmp.length())).equals("three")) {
					if (char1 == '\0') {
						char1 = char2 = '3';
					} else {
						char2 = '3';
					}
					j += 4;
				} else if (tmp.substring(j, Math.min(j + 4, tmp.length())).equals("four")) {
					if (char1 == '\0') {
						char1 = char2 = '4';
					} else {
						char2 = '4';
					}
					j += 4;
				} else if (tmp.substring(j, Math.min(j + 4, tmp.length())).equals("five")) {
					if (char1 == '\0') {
						char1 = char2 = '5';
					} else {
						char2 = '5';
					}
					j += 3;
				} else if (tmp.substring(j, Math.min(j + 3, tmp.length())).equals("six")) {
					if (char1 == '\0') {
						char1 = char2 = '6';
					} else {
						char2 = '6';
					}
					j += 3;
				} else if (tmp.substring(j, Math.min(j + 5, tmp.length())).equals("seven")) {
					if (char1 == '\0') {
						char1 = char2 = '7';
					} else {
						char2 = '7';
					}
					j += 4;
				} else if (tmp.substring(j, Math.min(j + 5, tmp.length())).equals("eight")) {
					if (char1 == '\0') {
						char1 = char2 = '8';
					} else {
						char2 = '8';
					}
					j += 4;
				} else if (tmp.substring(j, Math.min(j + 4, tmp.length())).equals("nine")) {
					if (char1 == '\0') {
						char1 = char2 = '9';
					} else {
						char2 = '9';
					}
					j += 3;
				} else {
					j++;
				}
			}
			int tmp2 = Integer.parseInt("" + char1 + char2);
			
//			System.out.println("" + char1 + char2);
//			System.out.println(tmp2);
//			System.out.println((i + 1) + " - " + BigInteger.valueOf(tmp2));
			System.out.println(BigInteger.valueOf(tmp2));
			
			sum = sum.add(BigInteger.valueOf(tmp2));
//			System.out.println(sum);
		}
		
		System.out.println(sum);
	}

}
