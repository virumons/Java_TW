package practices.oop;

import java.io.*;
import java.util.*;

public class program4 {
	private static final int THREAD_COUNT = 3;

	public static void main(String[] args) {
		try {
			int n = 100; // Number of random integers to generate
			generateIntegersFile(n, "integers.txt");

			int[] numbers = readIntegersFromFile("integers.txt");
			int chunkSize = numbers.length / THREAD_COUNT;

			List<int[]> sortedChunks = new ArrayList<>();
			Thread[] threads = new Thread[THREAD_COUNT];

			for (int i = 0; i < THREAD_COUNT; i++) {
				int startIndex = i * chunkSize;
				int endIndex = (i == THREAD_COUNT - 1) ? numbers.length : startIndex + chunkSize;
				int[] chunk = Arrays.copyOfRange(numbers, startIndex, endIndex);

				threads[i] = new Thread(new Runnable() {
					@Override
					public void run() {
						Arrays.sort(chunk);
						synchronized (sortedChunks) {
							sortedChunks.add(chunk);
						}
					}
				});

				threads[i].start();
			}

			for (Thread thread : threads) {
				try {
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			int[] sortedNumbers = mergeSortedArrays(sortedChunks);

			writeSortedIntegersToFile(sortedNumbers, "sorted_integers.txt");
			System.out.println("Sorting and merging complete. Results are stored in sorted_integers.txt.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private static void generateIntegersFile(int n, String filename) throws IOException {
		Random random = new Random();
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		for (int i = 0; i < n; i++) {
			writer.write(random.nextInt(n * 10) + "\n");
		}
		writer.close();
	}

	private static int[] readIntegersFromFile(String filename) throws IOException {
		List<Integer> numbersList = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line;
		while ((line = reader.readLine()) != null) {
			numbersList.add(Integer.parseInt(line));
		}
		reader.close();

		return numbersList.stream().mapToInt(Integer::intValue).toArray();
	}

	private static int[] mergeSortedArrays(List<int[]> arrays) {
		int totalSize = arrays.stream().mapToInt(arr -> arr.length).sum();
		int[] result = new int[totalSize];

		int[] indexes = new int[arrays.size()];

		for (int i = 0; i < totalSize; i++) {
			int minIndex = -1;
			int minValue = Integer.MAX_VALUE;

			for (int j = 0; j < arrays.size(); j++) {
				if (indexes[j] < arrays.get(j).length && arrays.get(j)[indexes[j]] < minValue) {
					minValue = arrays.get(j)[indexes[j]];
					minIndex = j;
				}
			}

			result[i] = minValue;
			indexes[minIndex]++;
		}

		return result;
	}

	private static void writeSortedIntegersToFile(int[] sortedNumbers, String filename) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		for (int number : sortedNumbers) {
			writer.write(number + "\n");
		}
		writer.close();
	}
}