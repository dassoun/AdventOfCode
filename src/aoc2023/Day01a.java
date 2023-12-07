package aoc2023;

import java.math.BigInteger;
import java.util.ArrayList;

import Utils.FileTransform;

public class Day01a {

	public static void main(String[] args) {
		String fileName = "inputs/day01.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		list = FileTransform.fileToStringList(fileName);

		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < list.size(); i++) {
			char char1 = '\0';
			char char2 = '\0';
			String tmp = list.get(i);
			for (int j = 0; j < tmp.length(); j++) {
				if (tmp.charAt(j) >= '0' && tmp.charAt(j) <= '9') {
					if (char1 == '\0') {
						char1 = char2 = tmp.charAt(j);
					} else {
						char2 = tmp.charAt(j);
					}
				}
			}
			int tmp2 = Integer.parseInt("" + char1 + char2);
			
//			System.out.println("" + char1 + char2);
//			System.out.println(tmp2);
//			System.out.println(BigInteger.valueOf(tmp2));
			
			sum = sum.add(BigInteger.valueOf(tmp2));
			System.out.println(sum);
		}
		
		System.out.println(sum);
	}
}
