package com.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {
	public static void main(String args[]) {
		// double num;
		// long iPart;
		// double fPart;

		// Get user input
		// num = 2.3;
		// iPart = (long) num;
		// fPart = num - iPart;
		// System.out.println("Integer part = " + iPart);
		// System.out.println("Fractional part = " + fPart);

		/*-----------------*/

		// Convert to hex (eg 70 to 0x70 ie 112)
		// for converting 2 digits
		// int a,b,c,d,e;
		// byte f;
		//
		// a = 70;
		//
		// b = a%10;
		// c = a/10;
		// f = (byte) ((c << 4) | b);
		//
		// System.out.println(f);

		// for converting upto 4 digits
		// float speed = 15;
		// int fanSpeed = (int) speed;
		// int a, b, c, d, speed1, speed2;
		//
		// a = fanSpeed % 100;
		//
		// b = a % 10;
		// c = a / 10;
		// speed1 = (byte) ((c << 4) | b);
		// speed1++;
		//
		// a = fanSpeed / 100;
		//
		// b = a % 10;
		// c = a / 10;
		// speed2 = (byte) ((c << 4) | b);
		// speed2++;
		//
		// System.out.println(speed1 + "\n" + speed2);

		/*-----------------*/

		// //Separate logo in csv
		// String a = "1,123,BMS,Sosaley,$qerqwtiyu,iuay,wuqytu$,Chennai";
		// if(a.contains(",$")) {
		// String b = a.substring(a.indexOf(",$"), a.indexOf("$,")+2);
		// String logo = b.substring(b.indexOf(",$")+2, b.indexOf("$,"));
		// String c = a.replace(b, ",");
		// System.out.println(b + "\n" + c);
		// }

		// // Separate each 5 chars in str
		// String s = "123";
		// String a = "";
		// while (!s.equalsIgnoreCase("")) {
		// if (s.length() < 5) {
		// a = s.substring(0, s.length());
		// System.out.println(a);
		// break;
		// } else {
		// a = s.substring(0, 5);
		// s = s.substring(5);
		// System.out.println(a);
		// }
		//
		// }

		/*-----------------*/

		// //Functionality for TAFE
		// String dateTime;
		// int rpm, batteryVoltage, fuelLevel, engineTemperature;
		// boolean wifStatus, immobilizerStatus, headLampStatus;
		//
		// String[] ip = new String[]{"55", "AA", "09", "BC", "CB", "90", "09",
		// "1D", "85", "00", "00", "0B"};
		// int[] array = new int[12];
		// array[0] = Integer.parseInt(ip[0], 16);
		// array[1] = Integer.parseInt(ip[1], 16);
		// array[2] = Integer.parseInt(ip[2], 16);
		// array[3] = Integer.parseInt(ip[3], 16);
		// array[4] = Integer.parseInt(ip[4], 16);
		// array[5] = Integer.parseInt(ip[5], 16);
		// array[6] = Integer.parseInt(ip[6], 16);
		// array[7] = Integer.parseInt(ip[7], 16);
		// array[8] = Integer.parseInt(ip[8], 16);
		// array[9] = Integer.parseInt(ip[9], 16);
		// array[10] = Integer.parseInt(ip[10], 16);
		// array[11] = Integer.parseInt(ip[11], 16);
		//
		// String a = Integer.toBinaryString(array[3]);
		// String b = Integer.toBinaryString(array[4]);
		// String c = Integer.toBinaryString(array[5]);
		// String d = Integer.toBinaryString(array[6]);
		// String e = Integer.toBinaryString(array[7]);
		// String f = Integer.toBinaryString(array[8]);
		// String g = Integer.toBinaryString(array[9]);
		// String h = Integer.toBinaryString(array[10]);
		// String i = Integer.toBinaryString(array[11]);
		//
		// rpm = Integer.parseInt(d.substring(3, 8), 2);
		// batteryVoltage = array[8];
		//
		// rpm = extract(array[3], 3, 5);
		// batteryVoltage = array[8];
		// wifStatus = (extract(array[9], 0, 1) == 1);
		// fuelLevel = extract(array[9], 1, 7);
		// immobilizerStatus = (extract(array[10], 0, 1) == 1);
		// engineTemperature = extract(array[10], 1, 7);
		// headLampStatus = (extract(array[11], 3, 4) == 1);

		/*-----------------*/

		// Timer
		// Timer timer = new Timer();
		// boolean var = false;
		// TimerTask timerTask = new TimerTask() {
		// @Override
		// public void run() {
		// // Your database code here
		// var = false;
		// is.read(data);
		// var = true;
		// }
		// };
		// if (var == false) {
		// // exception
		// }
		//
		// timer.schedule(timerTask, 2 * 60 * 1000);

		/*-----------------*/

		// Cumulate
		ArrayList<Graph> a = new ArrayList<Graph>();
		a.add(new Graph(1, 41.1));
		a.add(new Graph(1, 42.2));
		a.add(new Graph(1, 46.6));
		a.add(new Graph(3, 41.0));
		a.add(new Graph(4, 41.0));
		a.add(new Graph(5, 41.0));

		Map<Integer, List<Graph>> map = new HashMap<Integer, List<Graph>>();

		for (Graph graph : a) {
			int key = graph.x;
			if (map.containsKey(key)) {
				List<Graph> list = map.get(key);
				list.add(graph);
			} else {
				List<Graph> list = new ArrayList<Graph>();
				list.add(graph);
				map.put(key, list);
			}
		}

		ArrayList<Double[]> d = avg(map);
		System.out.println(d);
	}

	static ArrayList<Double[]> avg(Map<Integer, List<Graph>> map) {
		ArrayList<Double[]> result = new ArrayList<Double[]>();
		for (int i = 1; i <= 31; i++) {
			List<Graph> x = map.get(i);
			result.add(new Double[] {(double)i,average(x)});
		}
		return result;
	}

	public static double average(List<Graph> list) {
		// 'average' is undefined if there are no elements in the list.
		if (list == null || list.isEmpty())
			return 0.0;
		// Calculate the summation of the elements in the list
		long sum = 0;
		int n = list.size();
		// Iterating manually is faster than using an enhanced for loop.
		for (int i = 0; i < n; i++)
			sum += list.get(i).y;
		// We don't want to perform an integer division, so the cast is
		// mandatory.
		return ((double) sum) / n;
	}

	static int extract(int value, int begin, int end) {
		int mask = (1 << (end - begin)) - 1;
		return (value >> begin) & mask;
	}

}
