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
                } else if (playerA == playerB && playerA == 40) {
                    playerA += 5; // Advantage denoted as 45
                } else {
                    playerA += 10;
                }
            } else if (winner == 'B') {
                if (playerB < 30) {
                    playerB += 15;
                } else if (playerA == playerB && playerB == 40) {
                    playerB += 5; // Advantage denoted as 45
                } else {
                    playerB += 10;
                }
            }
        }


        String playerAScore;
        String playerBScore;
        if (playerA == 45) {
            playerAScore = "Adv";
            playerBScore = Integer.toString(playerB);
        } else if (playerB == 45) {
            playerBScore = "Adv";
            playerAScore = Integer.toString(playerA);
        } else {
            playerAScore = Integer.toString(playerA);
            playerBScore = Integer.toString(playerB);
        }

		return playerAScore + ":" + playerBScore;
	}

	public Score getScore() {
		return score;
	}
	
	

}
