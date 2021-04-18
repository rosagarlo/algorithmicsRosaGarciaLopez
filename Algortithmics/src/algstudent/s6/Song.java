package algstudent.s6;

public class Song implements Comparable<Song> {
	
	private int minutes;
	private int seconds;
	private String code;
	private int score;
	
	public Song(int minutes, int seconds, String code, int score) {
		this.minutes = minutes;
		this.seconds = seconds;
		this.code = code;
		this.score = score;
	}

	public String getCode() {
		return code;
	}

	public int getScore() {
		return score;
	}

	public int getDuration() {
		return minutes * 60 + seconds;
	}

	@Override
	public String toString() {
		return "id: " + code + " seconds: " + minutes + ":"
				+ seconds + " score: " + score;
	}

	@Override
	public int compareTo(Song arg) {
		if(arg.getScore() > this.getScore())
			return 1;
		if(arg.getScore() == this.getScore()) {
			if(arg.getDuration() < this.getDuration())
				return 1;
		}
		return 0;
	}
	
}
