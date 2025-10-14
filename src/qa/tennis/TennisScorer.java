package qa.tennis;

public class TennisScorer {
	private Score score;
	private String previousString;
	
	public TennisScorer() {
		score = new Score();
		previousString = "";
	}
	
	public void winningPoint(char player) {
		winningPoints(String.valueOf(player));
	}
	
	public void winningPoints(String players) {
		previousString += players;
	}


	public String currentScore() {
		char[] winningSequence = previousString.toCharArray();

        int playerA = 0;
        int playerB = 0;

        for (char winner : winningSequence) {
            if (winner == 'A') {
                if (playerA < 30) {
                    playerA += 15;
                } else {
                    playerA += 10;
                }
            } else if (winner == 'B') {
                if (playerB < 30) {
                    playerB += 15;
                } else {
                    playerB += 10;
                }
            }
        }

        String playerAScore = Integer.toString(playerA);
        String playerBScore = Integer.toString(playerB);
		
		return playerAScore + ":" + playerBScore;
	}

	public Score getScore() {
		return score;
	}
	
	

}
