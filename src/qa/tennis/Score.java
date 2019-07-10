package qa.tennis;

public class Score {
	private int[] playerAgames;
	private int[] playerBgames;
	private String playerAgameScore;
	private String playerBgameScore;
	private int currentSet = 1;
	
	public Score() {
		playerAgames = new int[5];
		playerBgames = new int[5];
		playerAgameScore = "0";
		playerBgameScore = "0";
		
		// remove these!
		randomGameScore();
		randomScore();
	}
	
	public void nextSet() {
		currentSet++;
	}
	
	
	public String toString() {
		return "";
	}

	public String getPlayerAgameScore() {
		return playerAgameScore;
	}

	public void setPlayerAgameScore(String playerAgameScore) {
		this.playerAgameScore = playerAgameScore;
	}

	public String getPlayerBgameScore() {
		return playerBgameScore;
	}

	public void setPlayerBgameScore(String playerBgameScore) {
		this.playerBgameScore = playerBgameScore;
	}

	public int getCurrentSet() {
		return currentSet;
	}

	public void setCurrentSet(int currentSet) {
		this.currentSet = currentSet;
	}

	public int[] getPlayerAgames() {
		return playerAgames;
	}

	public int[] getPlayerBgames() {
		return playerBgames;
	}
	
	private void randomScore() {
		for (int i=0;i<5;i++) {
			playerAgames[i] = (int)(Math.random()*7);
			playerBgames[i] = (int)(Math.random()*7);
		}
	}
	
	private void randomGameScore() {
		String[] scoring = {"0","15","30","40","A"};
		playerAgameScore = scoring[(int)(Math.random()*5)];
		playerBgameScore = scoring[(int)(Math.random()*5)];
	}
	
	
}
