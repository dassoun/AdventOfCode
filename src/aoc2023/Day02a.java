package aoc2023;

import java.math.BigInteger;
import java.util.ArrayList;

import Utils.FileTransform;

public class Day02a {

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
			boolean ok = true;
			int j = 0;
			while (ok && j < game.length) {
				String[] set = game[j].split(", ");
				
				for (int k = 0; k < set.length; k++) {
					String[] tmp2 = set[k].split(" ");
					switch (tmp2[1]) {
					case "blue" :
						distribution[BLUE] += Integer.valueOf(tmp2[0]);
						break;
					case "green" :
						distribution[GREEN] += Integer.valueOf(tmp2[0]);
						break;
					case "red" :
						distribution[RED] += Integer.valueOf(tmp2[0]);
						break;
					default :
						break;
					}
				}
				
				if (distribution[BLUE] > 14 || distribution[GREEN] > 13 || distribution[RED] > 12) {
					ok = false;
				}
				
				distribution[BLUE] = 0;
				distribution[GREEN] = 0;
				distribution[RED] = 0;
				
				j++;
			}
			
			if (ok) {
				sum += game_id;
			}
		}
		
		System.out.println(BigInteger.valueOf(sum));
	}
}
