package qa.tennis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleScore {

	public static void main(String[] args) {
		if (args.length == 1) {
			commandLineInput(args[0]);
		} else {
			consoleInput();
		}
	}

	public static void commandLineInput(String s) {
		TennisScorer ts = new TennisScorer();
		ts.winningPoints(s);
		System.out.println(ts.currentScore());
	}

	public static void consoleInput() {
		TennisScorer ts = new TennisScorer();
		System.out.println("Enter A or B or X to quit");
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String lastInput = br.readLine();
			while (!lastInput.equalsIgnoreCase("X")) {
				if (lastInput.equalsIgnoreCase("a")
						|| lastInput.equalsIgnoreCase("b")) {
					ts.winningPoints(lastInput);
					System.out.println(ts.currentScore());
				}
				lastInput = br.readLine();
			}
			System.out.println("Final score was " + ts.currentScore());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
