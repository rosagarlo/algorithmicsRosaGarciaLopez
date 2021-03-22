package algstudent.s4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SegmentsPlacement {

	private String fileName;
	private static Integer[] segments;

	public static void main(String args[]) {
		SegmentsPlacement seg1 = new SegmentsPlacement(args[0]);

		long t1, t2, time;
		double pufos = 0;
		for (int n = 100; n <= 10000000; n *= 2) {
			t1 = System.currentTimeMillis();
			pufos = seg1.Greedy1(n);
			t2 = System.currentTimeMillis();
			time = SegmentsPlacementTimes.measureTime(t1, t2);
			System.out.println("------GREEDY 1------");
			System.out.println("n = " + n + " TIME: " + time + " milliseconds");
			System.out.println("Cost of greedy 1 is: " + pufos);
		} // forInteger
		
		for (int n = 100; n <= 10000000; n *= 2) {
			t1 = System.currentTimeMillis();
			pufos = seg1.Greedy2( n);
			t2 = System.currentTimeMillis();
			time = SegmentsPlacementTimes.measureTime(t1, t2);
			System.out.println("------GREEDY 2------");
			System.out.println("n = " + n + " TIME: " + time + " milliseconds");
			System.out.println("Cost of greedy 2 is: " + pufos);
		}
		
		for (int n = 100; n <= 10000000; n *= 2) {
			t1 = System.currentTimeMillis();
			pufos = seg1.Greedy3( n);
			t2 = System.currentTimeMillis();
			time = SegmentsPlacementTimes.measureTime(t1, t2);
			System.out.println("------GREEDY 3------");
			System.out.println("n = " + n + " TIME: " + time + " milliseconds");
			System.out.println("Cost of greedy 3 is: " + pufos);
		}
		
	}


	public SegmentsPlacement(String fileName) {
		this.fileName = Paths.get("").toAbsolutePath().toString()
				+ "/src/algstudent/s4/" + fileName + ".txt";
		ArrayList<Integer> aux = new ArrayList<>(readGameFromFile(this.fileName));
		segments = new Integer[aux.size()];
		segments = aux.toArray(segments);
	}

	public static List<Integer> readGameFromFile(String file) {
		BufferedReader fich = null;
		String line;
		List<Integer> elements = new ArrayList<Integer>();

		try {
			fich = new BufferedReader(new FileReader(file));
			line = fich.readLine(); // first element of the file
			while (line != null) {
				elements.add(Integer.parseInt(line));
				line = fich.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("There is no file: " + file);
		} catch (IOException e) {
			System.out.println("Error reading the file: " + file);
		} finally {
			if (fich != null)
				try {
					fich.close();
				} catch (IOException e) {
					System.out.println("Error closing the file: " + file);
					e.printStackTrace();
				}
		}
		return elements;
	}

	public double Greedy1(int n) {
		double result = 0;
		for (int j = 0; j < n; j++) {
			double x = 0, y;
			result = 0;
			result = midpoint(0, segments[1]);
			for (int i = 1; i < segments.length - 1; i++) { // O(n)
				x = segments[i] + x;
				y = segments[i+1] + x;
				result += midpoint(x, y);
			}
		}
		return result;
	}

	public double Greedy2(int n) {
		double result = 0;
		for (int j = 0; j < n; j++) {
			double x = 0, y;
			result = 0;
			Integer[] aux = Arrays.copyOfRange(segments, 1, segments.length);
			Arrays.sort(aux, Collections.reverseOrder());
			for (int i = 0; i < aux.length - 1; i++) { // O(n)
				x = aux[i] + x;
				y = aux[i+1] + x;
				result += midpoint(x, y);
			}
		}
		return result;
	}

	public double Greedy3(int n) {
		double result = 0;
		for (int j = 0; j < n; j++) {
			double x = 0, y;
			result = 0;
			Integer[] aux = Arrays.copyOfRange(segments, 1, segments.length);
			Arrays.sort(aux);
			for (int i = 0; i < aux.length - 1; i++) { // O(n)
				x = aux[i] + x;
				y = aux[i+1] + x;
				result += midpoint(x, y);
			}
		}
		return result;
	}

	private double midpoint(double x, double y) {
		return (x + y)/2;
	}
}
