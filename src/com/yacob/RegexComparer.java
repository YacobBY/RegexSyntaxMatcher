package com.yacob;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegexComparer {

	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		String input;

		System.out.println("Enter Regex please.");
		input = scan.nextLine();
		System.out.println(input);
		List<Character> regex = new ArrayList<Character>();

		for (int i = 0; i < input.length(); i++) {
			regex.add(input.charAt(i));
		}

		List<String> result = new ArrayList<String>();
		String temp = "";
		for (int i = 0; i < regex.size(); i++) {
			//
			if (regex.get(i).equals('(')) {
				temp += '(';
				while (regex.get(i + 1) != ')') {
					i++;
					temp += regex.get(i);
				}
				temp += ')';
				result.add(temp);
				i+=2;
				
			}
			result.add(regex.get(i).toString());

			if (regex.get(i).equals('+')) {

				if (temp.contains("(")) {
					result.remove(result.size() - 1);
				} else {
					result.remove(result.size() - 1);
					temp = result.get(result.size() - 1);

				}

				temp += '*';
				result.add(temp);
				temp = "";
			}

		}

		System.out.println("ArrayList -> result");
		System.out.println(result);
		int index = 0;
		for (String s : result)
			System.out.println((index++) + ": " + s);
	}
}
/*
Tussen haakjes plus vervangen door res te gebruiken ipv result met 2e functie

Alles met een OR moet op alfabetische volgorde verwisseld worden van plaats. Laat een scan door de array loopen
Wanneer er een OR wordt gevonden wordt gechekt of de linker hoger in het alfabet staat dan de rechter en dan worden ze
verwisseld

Wanneer de laatste letter tussen haakjes hetzelfde is als de laatste letter voor de haakjes kunnen deze allebei naar rechts verschoven worden, example:

String regexOne = "xy(zxy)*z"; 
String regexTwo = "(xyz)*xyz";
*/