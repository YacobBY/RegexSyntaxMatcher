package com.yacob;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegexComparer {

    private static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        String input;

//        System.out.println("Enter Regex please.");
//        input = scan.nextLine();
        String secondRegex = "(xyz)xyzxyz";
        input = "xyz(xyz)xyz";
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
                while (i + 2 <= regex.size() - 1 && regex.get(i + 1) != ')') {
                    i++;
                    temp += regex.get(i);
                }
                temp += ')';
                result.add(temp);
                i += 2;
            }
            if (i < regex.size()) {
                result.add(regex.get(i).toString());
            }
            if (i < regex.size() && regex.get(i).equals('+')) {

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

        for (int i = 0; i < result.size() - 1; i++) {
            //Get index with (
            if (i > 0 && (result.get(i).charAt(0) == '(')) {
                //last character before the )
//                  if (result.get(i-1).charAt(result.get(i).length()-2) ==  )

                if ((result.get(i).charAt(result.get(i).length() - 2)) == (result.get(i - 1).charAt(result.get(i - 1).length() - 1))) {
                    System.out.println((result.get(i).charAt(result.get(i).length() - 2)));
                    System.out.println((result.get(i - 1).charAt(result.get(i - 1).length() - 1)));
                    //Switch last character before ")" and last character in slot before, and then switch the entire slots.
                    StringBuilder charSwapper = new StringBuilder();
                    charSwapper.append(result.get(i - 1).charAt(result.get(i - 1).length() - 1));
                    charSwapper.append(result.get(i).substring(1, result.get(i).length() - 2));
                    charSwapper.insert(0, '(');
                    charSwapper.append(")");
                    result.set(i, String.valueOf(result.get(i - 1).charAt(result.get(i - 1).length() - 1)));
                    result.set(i - 1, charSwapper.toString());
                    System.out.println(charSwapper.toString());
                    i = 0;

                }
            }
        }
        System.out.println("-----------------------------");
        StringBuilder finalString = new StringBuilder();
        index = 0;
        for (String s : result) {
            finalString.append(s);
            System.out.println((index++) + ": " + s);
        }

        System.out.println("Final result: "+finalString);
        System.out.println("Compare to: "+ secondRegex);

        if (secondRegex.equals(finalString.toString())){
            System.out.println("Match found");
        }

    }

}

/*
Tussen haakjes plus vervangen door res te gebruiken ipv result met 2e functie

Alles met een OR moet op alfabetische volgorde verwisseld worden van plaats. Laat een scan door de array loopen
Wanneer er een OR wordt gevonden wordt gechekt of de linker hoger in het alfabet staat dan de rechter en dan worden ze
verwisseld

Wanneer de laatste letter tussen haakjes hetzelfde is als de laatste letter voor de haakjes kunnen deze allebei naar rechts verschoven worden, example:

String regexOne = "xyz(zxy)+z";
String regexOne = "x(yzx)*yz";
String regexTwo = "(xyz)*xyz";
*/