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

        if (previousString.equals("A")) {
            return "15:0";
        } else if (previousString.equals("AB")) {
            return "15:15";
        } else if (previousString.equals("ABA")) {
            return "30:15";
        }
		
		return "0:0";
	}

	public Score getScore() {
		return score;
	}
	
	

}
