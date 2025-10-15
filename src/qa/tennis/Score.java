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
        String set = "";
        for (int i = 0; i < currentSet; i++) {
            if (playerAgames[i] != 0 || playerBgames[i] != 0) {
                set += Integer.toString(playerAgames[i]) + "-" + Integer.toString(playerBgames[i]) + " ";
            }
        }
		return set + playerAgameScore + ":" + playerBgameScore;
	}

    // Getters
	public String getPlayerAgameScore() {return playerAgameScore;}
	public String getPlayerBgameScore() {return playerBgameScore;}
    public int getCurrentSet() {
        return currentSet;
    }
    public int[] getPlayerAgames() {return playerAgames;}
    public int[] getPlayerBgames() {
        return playerBgames;
    }

    // Setters
    public void setPlayerAgameScore(String playerAgameScore) {this.playerAgameScore = playerAgameScore;}
    public void setPlayerBgameScore(String playerBgameScore) {this.playerBgameScore = playerBgameScore;}
	public void setCurrentSet(int currentSet) {this.currentSet = currentSet;}
    public void setPlayerAgames(int playerAgameScore) {this.playerAgames[currentSet - 1] = playerAgameScore;}
    public void setPlayerBgames(int playerBgameScore) {this.playerBgames[currentSet - 1] = playerBgameScore;}
}
