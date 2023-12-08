package aoc2023;

import java.math.BigInteger;
import java.util.ArrayList;

import Utils.FileTransform;

public class Day02b {

	private static final int BLUE = 0;
	private static final int GREEN = 1;
	private static final int RED = 2;

	public static void main(String[] args) {
		String fileName = "inputs/day02.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		list = FileTransform.fileToStringList(fileName);

		int[] distribution = new int[] {0, 0, 0};
		
		int sum = 0;
		
		for (int i = 0; i < list.size(); i++) {
			int game_id = 0;
			String[] tmp = list.get(i).split(": ");
			game_id = Integer.valueOf(tmp[0].split(" ")[1]);
			
			String[] game = tmp[1].split("; ");
			int j = 0;
			while (j < game.length) {
				String[] set = game[j].split(", ");
				
				for (int k = 0; k < set.length; k++) {
					String[] tmp2 = set[k].split(" ");
					int nb = Integer.valueOf(tmp2[0]);
					switch (tmp2[1]) {
					case "blue" :
						distribution[BLUE] = Math.max(distribution[BLUE], nb);
						break;
					case "green" :
						distribution[GREEN] = Math.max(distribution[GREEN], nb);
						break;
					case "red" :
						distribution[RED] = Math.max(distribution[RED], nb);
						break;
					default :
						break;
					}
				}
				
				j++;
			}
			
			System.out.println(distribution[BLUE] + " - " + distribution[GREEN] + " - " + distribution[RED]);
			
			sum += (distribution[BLUE] * distribution[GREEN] * distribution[RED]);
			
			distribution[BLUE] = 0;
			distribution[GREEN] = 0;
			distribution[RED] = 0;
		}
		
		System.out.println(BigInteger.valueOf(sum));
	}
}
