package scoring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import game.Game;

public class HighScores {

	private static HighScores theInstance = null;
	
	private List<Score> highScores;

	private HighScores() {
		highScores = new ArrayList<Score>();
		for(int i = 0; i<5; i++) {
			highScores.add(new Score(-3));
		}
	}

	public static HighScores getInstance() {
		if(theInstance == null) {
			theInstance = new HighScores();
		}
		return theInstance;
	}

	public Score getHighScore(int index) {
		return highScores.get(index);
	}
	
	public List<Score> getHighScores() {
		List<Score> scores = Collections.unmodifiableList(highScores);
		return scores;
	}
	
	public void addScore(Score score) {
		highScores.add(score);
		Collections.sort(highScores);
		if(highScores.size() > Game.NUM_SCORES) {
			this.removeLowestScore();
		}
	}
	
	private void removeLowestScore() {
		highScores.remove(highScores.size()-1);
	}
	
	/**
	 * 
	 * @param score
	 * @return Returns -1 if the score is not greater than 1 of NUM_SCORES scores, otherwise returns the position the score will be in highScores.
	 */
	public int getScorePosition(Score score) {
		for(int i = 0; i < highScores.size(); i++) {
			if(score.getScore() > highScores.get(i).getScore()) {
				return i;
			}
		}
		if(highScores.size() < 5) {
			return highScores.size();
		}
		return -1;
	}
}
