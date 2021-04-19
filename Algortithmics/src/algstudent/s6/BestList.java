package algstudent.s6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BestList {

	public class SortByScore implements Comparator<Song> {

		@Override
		public int compare(Song s1, Song s2) {
			return s2.getScore() - s1.getScore();
		}

	}

	private static BestList bestList;
	private long maxDuration; // total length of the blocks of songs in minutes
	private List<Song> songs; // songs of the file
	private int numberOfSongs; // number of songs the file determines
	private List<String> lines; // lines of the file
	private List<Song> blockA; // first block of songs
	private List<Song> blockB; // second block of songs
	private Song currentSong; // saves the current best song
	private int totalScore; // the addition of scores of the selected songs
	List<Song> sol = new ArrayList<>(); // the list with the best songs
	private int counter; // counter that allows counting the total number of
							// states generated to reach the solution
	private long totalDuration;

	public static void main(String[] args) {
		bestList = new BestList(args[0], args[1]);
		bestList.computeBlocks();
		bestList.print();
	}

	public BestList(String file, String dur) {
		if (Long.parseLong(dur) <= 0)
			throw new IllegalArgumentException(
					"The duration of the blocks has to be greater than zero.");
		songs = new ArrayList<Song>();
		readFile(file);
		maxDuration = Long.parseLong(dur) * 60;
	}

	/**
	 * Read the file passed as an argument on the main method.
	 * 
	 * @param file
	 */
	private void readFile(String file) {
		String fileName = Paths.get("").toAbsolutePath().toString()
				+ "/src/algstudent/s6/" + file + ".txt";
		BufferedReader fich = null;
		String line;
		lines = new ArrayList<String>();

		try {
			fich = new BufferedReader(new FileReader(fileName));
			line = fich.readLine(); // first element of the file
			while (line != null) {
				lines.add(line);
				line = fich.readLine();
			}
			createSongs();
		} catch (FileNotFoundException e) {
			System.out.println("There is no file: " + fileName);
		} catch (IOException e) {
			System.out.println("Error reading the file: " + fileName);
		} finally {
			if (fich != null)
				try {
					fich.close();
				} catch (IOException e) {
					System.out.println("Error closing the file: " + fileName);
					e.printStackTrace();
				}
		}
	}

	/**
	 * Add the songs of the file to the list of songs.
	 */
	private void createSongs() {
		String[] aux;
		String[] duration;
		numberOfSongs = Integer.parseInt(lines.get(0));
		for (int i = 1; i < lines.size(); i++) {
			aux = lines.get(i).split("\t");
			duration = aux[1].split(":");
			songs.add(new Song(Integer.parseInt(duration[0]),
					Integer.parseInt(duration[1]), aux[0],
					Integer.parseInt(aux[2])));
		}
	}

	public void computeBlocks() {
		Collections.sort(songs, new SortByScore()); // sort by descending order
													// the songs
		bestListUtil(songs.get(0));
	}

	private void bestListUtil(Song song) {
		counter++;
		if (totalDuration >= maxDuration * 2
				&& sol.size() >= numberOfSongs - 1) {
			sol.remove(song); // delete the last song that stops the algorithm
			totalDuration -= song.getDuration();
			fillBlocks(sol);
			return;
		} else {
			for (int i = 0; i < songs.size(); i++) {
				counter++;
				if (!sol.contains(song)) {
					if (song.getDuration() <= songs.get(i).getDuration()
							&& song.getScore() >= songs.get(i).getScore()) {
						sol.add(song);
						totalDuration += song.getDuration();
						bestListUtil(songs.get(i));
						sol.remove(song);
						totalDuration -= song.getDuration();
						counter++;
					} else if (sol.size() < numberOfSongs
							&& !sol.contains(songs.get(i))
							&& totalDuration < maxDuration) {
						counter++;
						sol.add(songs.get(i));
						totalDuration += songs.get(i).getDuration();
					}
				}
			}
		}
	}

	/**
	 * Fills the two blocks that contain the songs
	 * 
	 * @param list
	 * @param song
	 */
	private void fillBlocks(List<Song> list) {
		blockA = new ArrayList<>();
		blockB = new ArrayList<>();
		totalScore = 0;
		int dur = 0;
		for (int i = 0; i < list.size(); i++) {
			if (dur < maxDuration) {
				blockA.add(list.get(i));
				totalScore += list.get(i).getScore();
				dur += blockA.get(i).getDuration();
				list.remove(i);
			}
		}
		dur = 0;
		for (int i = 0; i < list.size(); i++) {
			if (dur < maxDuration) {
				blockB.add(list.get(i));
				totalScore += list.get(i).getScore();
				dur += blockA.get(i).getDuration();
			}
		}
	}

	/**
	 * Show all the information
	 */
	private void print() {
		System.out.println("Number of songs: " + numberOfSongs + "\n");
		System.out.println("List of songs:");
		for (Song song : songs) {
			System.out.println(song.toString());
		}

		System.out.println();
		System.out.println("Length of the blocks: " + maxDuration / 60 + ':'
				+ maxDuration % 60);
		System.out.println("Total score: " + totalScore);
		System.out.println("Total counter: " + counter);
		System.out.println();

		System.out.println("Best block A:");
		for (Song song : blockA) {
			System.out.println(song.toString());
		}
		System.out.println();
		System.out.println("Best block B:");
		for (Song song : blockB) {
			System.out.println(song.toString());
		}
	}
}
