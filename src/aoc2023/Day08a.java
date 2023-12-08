package aoc2023;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

import Utils.FileTransform;

public class Day08a {

	public static void main(String[] args) {
		String fileName = "inputs/day08.txt";
		
		ArrayList<String> list = new ArrayList<String>();
		list = FileTransform.fileToStringList(fileName);

		HashMap<String, Node> map = new HashMap<String, Node>();
		
		String navigation = list.get(0);
		
		String exit = null;
		
		for (int i=2; i<list.size(); i++) {
			String[] tmp = list.get(i).split(" = ");
			String key = tmp[0];
			
			String tmp2 = tmp[1].substring(1, (tmp[1].length() - 1));
			
			String[] tmp3 = tmp2.split(", ");
			
			map.put(key, new Node(tmp3[0], tmp3[1]));
			
			if (key.equals(tmp3[0]) && key.equals(tmp3[1])) {
				exit = key;
			}
		}
		
		String position = "AAA";
		
		boolean found = false;
		
		int nb = 0;
		
		Node node = map.get(position);
		
		int i = 0;
		while (!found) {
			char dest = navigation.charAt(i);
			
			if (dest == 'L') {
				position = node.left;
			} else {
				position = node.right;
			}
			node = map.get(position);
			
			i++;
			if (i >= navigation.length()) {
				i = 0;
			}
			
			nb++;
			
			if (position.equals("ZZZ")) {
				found = true;
			}
		}
		
		System.out.println(nb);
	}

	public static class Node {
		public String left;
		public String right;
		
		public Node() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Node(String left, String right) {
			super();
			this.left = left;
			this.right = right;
		}
	}
}
