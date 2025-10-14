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
	public String getPlayerBgameScore() {
		return playerBgameScore;
	}
    public int getCurrentSet() {
        return currentSet;
    }
    public int[] getPlayerAgames() {return playerAgames;}
    public int[] getPlayerBgames() {
        return playerBgames;
    }

    public void setPlayerAgameScore(String playerAgameScore) {
        this.playerAgameScore = playerAgameScore;
    }
    public void setPlayerBgameScore(String playerBgameScore) {
		this.playerBgameScore = playerBgameScore;
	}
	public void setCurrentSet(int currentSet) {
		this.currentSet = currentSet;
	}
}
