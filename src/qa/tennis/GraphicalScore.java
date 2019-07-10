package qa.tennis;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class GraphicalScore extends Frame {
	private TennisScorer scorer = new TennisScorer();
	private static String playerAname = "A.Murray";
	private static String playerBname = "N.Djokovic";
	private static Font font = new Font("Courier", Font.BOLD, 32);
	private Label[][] gamesLabels = new Label[2][5];
	private Label playerAscore;
	private Label playerBscore;

	public static void main(String[] args) {
		if (args.length==2) {
			playerAname = args[0];
			playerBname = args[1];
		}
		GraphicalScore gs = new GraphicalScore();
		gs.setLocation(100,100);
		gs.setVisible(true);
	}

	public GraphicalScore() {
		super("Tennis Scoreboard");
		Panel mainPanel = new Panel();
		Panel namesPanel = new Panel();
		namesPanel.setLayout(new GridLayout(2, 1));
		labelCreator(namesPanel).setText(playerAname);
		labelCreator(namesPanel).setText(playerBname);
		Panel scoresPanel = new Panel();
		scoresPanel.setLayout(new GridLayout(2, 1));
		playerAscore = labelCreator(scoresPanel);
		playerBscore = labelCreator(scoresPanel);		
		Panel gamesPanel = new Panel();
		gamesPanel.setLayout(new GridLayout(2, 5));
		for (int i=0; i<5; i++) {
			for (int j=0; j<2; j++) {
				gamesLabels[j][i] = labelCreator(gamesPanel);
			}
		}
		mainPanel.add(namesPanel);
		mainPanel.add(scoresPanel);
		mainPanel.add(gamesPanel);
		this.add(mainPanel);
		
		Panel buttonsPanel = new Panel();
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		Button playerApoint = new Button("Player A");
		Button playerBpoint = new Button("Player B");
		playerApoint.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				scorer.winningPoint('A');
				populate();
			}
		});
		playerBpoint.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				scorer.winningPoint('B');
				populate();
			}
		});
		buttonsPanel.add(playerApoint);
		buttonsPanel.add(playerBpoint);
		this.add(buttonsPanel,BorderLayout.SOUTH);
		populate();
		this.setSize(500, 160);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
	}
	
	public void populate() {
		Score score = scorer.getScore();
		for (int i=0; i<5; i++) {
			gamesLabels[0][i].setText(""+score.getPlayerAgames()[i]);
			gamesLabels[1][i].setText(""+score.getPlayerBgames()[i]);
		}
		playerAscore.setText(score.getPlayerAgameScore());
		playerBscore.setText(score.getPlayerBgameScore());
		
	}
	
	private Label labelCreator(Panel p) {
		Label l = new Label();
		l.setFont(font);
		p.add(l);
		return l;
	}

}
