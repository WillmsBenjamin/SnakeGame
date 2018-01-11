package scoring;

public class Score implements Comparable<Score> {

	private int score;
	private String player;
	
	public Score(int score) {
		this.score = score;
		this.player = "";
	}
	
	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @return the player
	 */
	public String getPlayer() {
		return player;
	}
	
	public void setPlayer(String player) {
		this.player = player;
	}

	@Override
	public int compareTo(Score score) {
		if(this.score < score.getScore()) {
			return -1;
		} else if(this.score == score.getScore()) {
			return 0;
		} else {
			return 1;
		}
	}

	public void setScore(int score) {
		this.score = score;
	}
}
