package game;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.CardLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import persistence.PersistenceXStream;
import scoring.Score;

import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.DropMode;

public class PauseMenu extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4719463789749185529L;
	
	private JPanel pausePanel,gameOverPanel, highScorePanel;
	private JLabel pauseLabel, gameOverLabel, highScoreLabel, score1Label, score2Label, score3Label, score4Label, score5Label;
	private JButton resumeButton, restartButton, exitButton, endRestartButton, endExitButton, submitButton;
	private JTextField score1TextField, score2TextField, score3TextField, score4TextField, score5TextField;
	
	private int scorePosition;
	
	public PauseMenu() {
		
		setBorder(null);
		Dimension size = new Dimension(Game.GAME_SIZE/2, Game.GAME_SIZE/2);
		setSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setLayout(new CardLayout(0, 0));
		
		pausePanel = new JPanel();
		pausePanel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.GREEN));
		pausePanel.setBackground(Color.GRAY);
		add(pausePanel, "Pause");
		GridBagLayout gbl_pausePanel = new GridBagLayout();
		gbl_pausePanel.columnWidths = new int[] {430};
		gbl_pausePanel.columnWeights = new double[]{0.0};
		gbl_pausePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		pausePanel.setLayout(gbl_pausePanel);
		
		pauseLabel = new JLabel("Game Paused");
		pauseLabel.setVerticalAlignment(SwingConstants.TOP);
		pauseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pauseLabel.setForeground(Color.GREEN);
		pauseLabel.setFont(new Font("AR DESTINE", Font.PLAIN, 54));
		GridBagConstraints gbc_pauseLabel = new GridBagConstraints();
		gbc_pauseLabel.insets = new Insets(0, 0, 5, 0);
		gbc_pauseLabel.gridx = 0;
		gbc_pauseLabel.gridy = 0;
		pausePanel.add(pauseLabel, gbc_pauseLabel);
		
		resumeButton = new JButton("Resume Game");
		resumeButton.setForeground(Color.BLACK);
		resumeButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_resumeButton = new GridBagConstraints();
		gbc_resumeButton.insets = new Insets(0, 0, 5, 0);
		gbc_resumeButton.gridx = 0;
		gbc_resumeButton.gridy = 2;
		pausePanel.add(resumeButton, gbc_resumeButton);
		
		restartButton = new JButton("Restart Game");
		restartButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_restartButton = new GridBagConstraints();
		gbc_restartButton.insets = new Insets(0, 0, 5, 0);
		gbc_restartButton.gridx = 0;
		gbc_restartButton.gridy = 4;
		pausePanel.add(restartButton, gbc_restartButton);
		
		exitButton = new JButton("Exit Game");
		exitButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_exitButton = new GridBagConstraints();
		gbc_exitButton.insets = new Insets(0, 0, 5, 0);
		gbc_exitButton.gridx = 0;
		gbc_exitButton.gridy = 6;
		pausePanel.add(exitButton, gbc_exitButton);
		
		gameOverPanel = new JPanel();
		gameOverPanel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.GREEN));
		gameOverPanel.setBackground(Color.GRAY);
		add(gameOverPanel, "Game Over");
		GridBagLayout gbl_gameOverPanel = new GridBagLayout();
		gbl_gameOverPanel.columnWidths = new int[] {430};
		gbl_gameOverPanel.columnWeights = new double[]{0.0};
		gbl_gameOverPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gameOverPanel.setLayout(gbl_gameOverPanel);
		
		gameOverLabel = new JLabel("Game Over!");
		gameOverLabel.setVerticalAlignment(SwingConstants.TOP);
		gameOverLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameOverLabel.setForeground(Color.GREEN);
		gameOverLabel.setFont(new Font("AR DESTINE", Font.PLAIN, 54));
		GridBagConstraints gbc_gameOverLabel = new GridBagConstraints();
		gbc_gameOverLabel.insets = new Insets(0, 0, 5, 0);
		gbc_gameOverLabel.gridx = 0;
		gbc_gameOverLabel.gridy = 0;
		gameOverPanel.add(gameOverLabel, gbc_gameOverLabel);
		
		endRestartButton = new JButton("Restart Game");
		endRestartButton.setForeground(Color.BLACK);
		endRestartButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_endRestartButton = new GridBagConstraints();
		gbc_endRestartButton.insets = new Insets(0, 0, 5, 0);
		gbc_endRestartButton.gridx = 0;
		gbc_endRestartButton.gridy = 2;
		gameOverPanel.add(endRestartButton, gbc_endRestartButton);
		
		endExitButton = new JButton("Exit Game");
		endExitButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_endExitButton = new GridBagConstraints();
		gbc_endExitButton.insets = new Insets(0, 0, 5, 0);
		gbc_endExitButton.gridx = 0;
		gbc_endExitButton.gridy = 4;
		gameOverPanel.add(endExitButton, gbc_endExitButton);
		
		highScorePanel = new JPanel();
		highScorePanel.setBackground(Color.GRAY);
		highScorePanel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.GREEN));
		add(highScorePanel, "High Score");
		GridBagLayout gbl_highScorePanel = new GridBagLayout();
		gbl_highScorePanel.columnWidths = new int[] {430};
		gbl_highScorePanel.rowHeights = new int[] {30, 0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0};
		gbl_highScorePanel.columnWeights = new double[]{1.0};
		gbl_highScorePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		highScorePanel.setLayout(gbl_highScorePanel);
		
		highScoreLabel = new JLabel("High Score!");
		highScoreLabel.setForeground(Color.GREEN);
		highScoreLabel.setFont(new Font("AR DESTINE", Font.PLAIN, 54));
		GridBagConstraints gbc_highScoreLabel = new GridBagConstraints();
		gbc_highScoreLabel.insets = new Insets(0, 0, 5, 0);
		gbc_highScoreLabel.gridx = 0;
		gbc_highScoreLabel.gridy = 1;
		highScorePanel.add(highScoreLabel, gbc_highScoreLabel);
		
		score1Label = new JLabel();
		score1Label.setFont(new Font("AR DESTINE", Font.PLAIN, 20));
		GridBagConstraints gbc_score1Label = new GridBagConstraints();
		gbc_score1Label.insets = new Insets(0, 0, 5, 0);
		gbc_score1Label.gridx = 0;
		gbc_score1Label.gridy = 2;
		highScorePanel.add(score1Label, gbc_score1Label);
		
		score1TextField = new JTextField();
		score1TextField.setHorizontalAlignment(SwingConstants.CENTER);
		score1TextField.setSelectedTextColor(Color.GREEN);
		score1TextField.setBackground(Color.GRAY);
		score1TextField.setFont(new Font("AR DESTINE", Font.PLAIN, 17));
		GridBagConstraints gbc_score1TextField = new GridBagConstraints();
		gbc_score1TextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_score1TextField.insets = new Insets(0, 0, 5, 0);
		gbc_score1TextField.gridx = 0;
		gbc_score1TextField.gridy = 3;
		highScorePanel.add(score1TextField, gbc_score1TextField);
		score1TextField.setColumns(50);
		
		score2Label = new JLabel();
		score2Label.setFont(new Font("AR DESTINE", Font.PLAIN, 20));
		GridBagConstraints gbc_score2Label = new GridBagConstraints();
		gbc_score2Label.insets = new Insets(0, 0, 5, 0);
		gbc_score2Label.gridx = 0;
		gbc_score2Label.gridy = 4;
		highScorePanel.add(score2Label, gbc_score2Label);
		
		score2TextField = new JTextField();
		score2TextField.setHorizontalAlignment(SwingConstants.CENTER);
		score2TextField.setBackground(Color.GRAY);
		score2TextField.setSelectedTextColor(Color.GREEN);
		score2TextField.setFont(new Font("AR DESTINE", Font.PLAIN, 17));
		GridBagConstraints gbc_score2TextField = new GridBagConstraints();
		gbc_score2TextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_score2TextField.insets = new Insets(0, 0, 5, 0);
		gbc_score2TextField.gridx = 0;
		gbc_score2TextField.gridy = 5;
		highScorePanel.add(score2TextField, gbc_score2TextField);
		score2TextField.setColumns(50);
		
		score3Label = new JLabel();
		score3Label.setFont(new Font("AR DESTINE", Font.PLAIN, 20));
		GridBagConstraints gbc_score3Label = new GridBagConstraints();
		gbc_score3Label.insets = new Insets(0, 0, 5, 0);
		gbc_score3Label.gridx = 0;
		gbc_score3Label.gridy = 6;
		highScorePanel.add(score3Label, gbc_score3Label);
		
		score3TextField = new JTextField();
		score3TextField.setHorizontalAlignment(SwingConstants.CENTER);
		score3TextField.setSelectedTextColor(Color.GREEN);
		score3TextField.setBackground(Color.GRAY);
		score3TextField.setFont(new Font("AR DESTINE", Font.PLAIN, 17));
		GridBagConstraints gbc_score3TextField = new GridBagConstraints();
		gbc_score3TextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_score3TextField.insets = new Insets(0, 0, 5, 0);
		gbc_score3TextField.gridx = 0;
		gbc_score3TextField.gridy = 7;
		highScorePanel.add(score3TextField, gbc_score3TextField);
		score3TextField.setColumns(50);
		
		score4Label = new JLabel();
		score4Label.setFont(new Font("AR DESTINE", Font.PLAIN, 20));
		GridBagConstraints gbc_score4Label = new GridBagConstraints();
		gbc_score4Label.insets = new Insets(0, 0, 5, 0);
		gbc_score4Label.gridx = 0;
		gbc_score4Label.gridy = 8;
		highScorePanel.add(score4Label, gbc_score4Label);
		
		score4TextField = new JTextField();
		score4TextField.setHorizontalAlignment(SwingConstants.CENTER);
		score4TextField.setBackground(Color.GRAY);
		score4TextField.setSelectedTextColor(Color.GREEN);
		score4TextField.setFont(new Font("AR DESTINE", Font.PLAIN, 17));
		GridBagConstraints gbc_score4TextField = new GridBagConstraints();
		gbc_score4TextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_score4TextField.insets = new Insets(0, 0, 5, 0);
		gbc_score4TextField.gridx = 0;
		gbc_score4TextField.gridy = 9;
		highScorePanel.add(score4TextField, gbc_score4TextField);
		score4TextField.setColumns(50);
		
		score5Label = new JLabel();
		score5Label.setFont(new Font("AR DESTINE", Font.PLAIN, 20));
		GridBagConstraints gbc_score5Label = new GridBagConstraints();
		gbc_score5Label.insets = new Insets(0, 0, 5, 0);
		gbc_score5Label.gridx = 0;
		gbc_score5Label.gridy = 10;
		highScorePanel.add(score5Label, gbc_score5Label);
		
		score5TextField = new JTextField();
		score5TextField.setHorizontalAlignment(SwingConstants.CENTER);
		score5TextField.setSelectedTextColor(Color.GREEN);
		score5TextField.setBackground(Color.GRAY);
		score5TextField.setFont(new Font("AR DESTINE", Font.PLAIN, 17));
		GridBagConstraints gbc_score5TextField = new GridBagConstraints();
		gbc_score5TextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_score5TextField.insets = new Insets(0, 0, 5, 0);
		gbc_score5TextField.gridx = 0;
		gbc_score5TextField.gridy = 11;
		highScorePanel.add(score5TextField, gbc_score5TextField);
		score5TextField.setColumns(50);
		
		submitButton = new JButton("Submit");
		submitButton.setFont(new Font("AR DESTINE", Font.PLAIN, 24));
		GridBagConstraints gbc_submitButton = new GridBagConstraints();
		gbc_submitButton.gridx = 0;
		gbc_submitButton.gridy = 12;
		highScorePanel.add(submitButton, gbc_submitButton);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{pausePanel, gameOverPanel, highScorePanel}));
		
		resumeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				resumeButtonActionPerformed();
			}
		});
		restartButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				restartButtonActionPerformed();
			}
		});
		endRestartButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				restartButtonActionPerformed();
			}
		});
		exitButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitButtonActionPerformed();
			}
		});
		endExitButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitButtonActionPerformed();
			}
		});
		submitButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitButtonActionPerformed();
			}
		});
	}

	protected void submitButtonActionPerformed() {
		switch(scorePosition) {
		case 0 : {
			if(validateInput(score1TextField.getText())) {
				Game.game.getScore().setPlayer(score1TextField.getText());
				Game.game.hs.addScore(Game.game.getScore());
				PersistenceXStream.saveToXMLwithXStream(Game.game.hs);
				Game.game.setState(GameState.GAMEOVER);
			} else {
				score1TextField.setText("Please enter your name!");
				highScorePanel.repaint();
			}
			break;
		}
		case 1 : {
			if(validateInput(score2TextField.getText())) {
				Game.game.getScore().setPlayer(score2TextField.getText());
				Game.game.hs.addScore(Game.game.getScore());
				PersistenceXStream.saveToXMLwithXStream(Game.game.hs);
				Game.game.setState(GameState.GAMEOVER);
			} else {
				score2TextField.setText("Please enter your name!");
				highScorePanel.repaint();
			}
			break;
		}
		case 2 : {
			if(validateInput(score3TextField.getText())) {
				Game.game.getScore().setPlayer(score3TextField.getText());
				Game.game.hs.addScore(Game.game.getScore());
				PersistenceXStream.saveToXMLwithXStream(Game.game.hs);
				Game.game.setState(GameState.GAMEOVER);
			} else {
				score3TextField.setText("Please enter your name!");
				highScorePanel.repaint();
			}
			break;
		}
		case 3 : {
			if(validateInput(score4TextField.getText())) {
				Game.game.getScore().setPlayer(score4TextField.getText());
				Game.game.hs.addScore(Game.game.getScore());
				PersistenceXStream.saveToXMLwithXStream(Game.game.hs);
				Game.game.setState(GameState.GAMEOVER);
			} else {
				score4TextField.setText("Please enter your name!");
				highScorePanel.repaint();
			}
			break;
		}
		case 4 : {
			if(validateInput(score5TextField.getText())) {
				Game.game.getScore().setPlayer(score5TextField.getText());
				Game.game.hs.addScore(Game.game.getScore());
				PersistenceXStream.saveToXMLwithXStream(Game.game.hs);
				Game.game.setState(GameState.GAMEOVER);
			} else {
				score5TextField.setText("Please enter your name!");
				highScorePanel.repaint();
			}
			break;
		}
		default : {
			//shouldn't ever happen.
			break;
		}
		}
		
	}
	
	protected boolean validateInput(String s) {
		if(s.length() == 0 || s.equals("Your Name") || s.equals("Please enter your name!")) {
			return false;
		} else {
			return true;
		}
	}
	
	public void prepareHighScoresPanel() {
		Score score = Game.game.getScore();
		scorePosition = Game.game.hs.getScorePosition(score);
		
		if(scorePosition < 0) {
			Game.game.setState(GameState.GAMEOVER);
		} else {
			int num = score.getScore();
			
			//Ugly code right here.
			switch(scorePosition) {
			case 0 : {
				score1Label.setText("" + num);
				score1TextField.setText("Your Name");
				score1TextField.setEditable(true);
				
				score2Label.setText("" + Game.game.hs.getHighScore(0).getScore());
				score2TextField.setText(Game.game.hs.getHighScore(0).getPlayer());
				score2TextField.setEditable(false);
				
				score3Label.setText("" + Game.game.hs.getHighScore(1).getScore());
				score3TextField.setText(Game.game.hs.getHighScore(1).getPlayer());
				score3TextField.setEditable(false);
				
				score4Label.setText("" + Game.game.hs.getHighScore(2).getScore());
				score4TextField.setText(Game.game.hs.getHighScore(2).getPlayer());
				score4TextField.setEditable(false);
				
				score5Label.setText("" + Game.game.hs.getHighScore(3).getScore());
				score5TextField.setText(Game.game.hs.getHighScore(3).getPlayer());
				score5TextField.setEditable(false);
				break;
			}
			case 1 : {
				score1Label.setText("" + Game.game.hs.getHighScore(0).getScore());
				score1TextField.setText(Game.game.hs.getHighScore(0).getPlayer());
				score1TextField.setEditable(false);
				
				score2Label.setText("" + num);
				score2TextField.setText("Your Name");
				score2TextField.setEditable(true);
				
				score3Label.setText("" + Game.game.hs.getHighScore(1).getScore());
				score3TextField.setText(Game.game.hs.getHighScore(1).getPlayer());
				score3TextField.setEditable(false);
				
				score4Label.setText("" + Game.game.hs.getHighScore(2).getScore());
				score4TextField.setText(Game.game.hs.getHighScore(2).getPlayer());
				score4TextField.setEditable(false);
				
				score5Label.setText("" + Game.game.hs.getHighScore(3).getScore());
				score5TextField.setText(Game.game.hs.getHighScore(3).getPlayer());
				score5TextField.setEditable(false);
				break;
			}
			case 2 : {
				score1Label.setText("" + Game.game.hs.getHighScore(0).getScore());
				score1TextField.setText(Game.game.hs.getHighScore(0).getPlayer());
				score1TextField.setEditable(false);
				
				score2Label.setText("" + Game.game.hs.getHighScore(1).getScore());
				score2TextField.setText(Game.game.hs.getHighScore(1).getPlayer());
				score2TextField.setEditable(false);
				
				score3Label.setText("" + num);
				score3TextField.setText("Your Name");
				score3TextField.setEditable(true);
				
				score4Label.setText("" + Game.game.hs.getHighScore(2).getScore());
				score4TextField.setText(Game.game.hs.getHighScore(2).getPlayer());
				score4TextField.setEditable(false);
				
				score5Label.setText("" + Game.game.hs.getHighScore(3).getScore());
				score5TextField.setText(Game.game.hs.getHighScore(3).getPlayer());
				score5TextField.setEditable(false);
				break;
			}
			case 3 : {
				score1Label.setText("" + Game.game.hs.getHighScore(0).getScore());
				score1TextField.setText(Game.game.hs.getHighScore(0).getPlayer());
				score1TextField.setEditable(false);
				
				score2Label.setText("" + Game.game.hs.getHighScore(1).getScore());
				score2TextField.setText(Game.game.hs.getHighScore(1).getPlayer());
				score2TextField.setEditable(false);
				
				score3Label.setText("" + Game.game.hs.getHighScore(2).getScore());
				score3TextField.setText(Game.game.hs.getHighScore(2).getPlayer());
				score3TextField.setEditable(false);

				score4Label.setText("" + num);
				score4TextField.setText("Your Name");
				score4TextField.setEditable(true);
				
				score5Label.setText("" + Game.game.hs.getHighScore(3).getScore());
				score5TextField.setText(Game.game.hs.getHighScore(3).getPlayer());
				score5TextField.setEditable(false);
				break;
			}
			case 4 : {
				score1Label.setText("" + Game.game.hs.getHighScore(0).getScore());
				score1TextField.setText(Game.game.hs.getHighScore(0).getPlayer());
				score1TextField.setEditable(false);
				
				score2Label.setText("" + Game.game.hs.getHighScore(1).getScore());
				score2TextField.setText(Game.game.hs.getHighScore(1).getPlayer());
				score2TextField.setEditable(false);
				
				score3Label.setText("" + Game.game.hs.getHighScore(2).getScore());
				score3TextField.setText(Game.game.hs.getHighScore(2).getPlayer());
				score3TextField.setEditable(false);
				
				score4Label.setText("" + Game.game.hs.getHighScore(3).getScore());
				score4TextField.setText(Game.game.hs.getHighScore(3).getPlayer());
				score4TextField.setEditable(false);
				
				score5Label.setText("" + num);
				score5TextField.setText("Your Name");
				score5TextField.setEditable(true);
				break;
			}
			default : {
				//shouldn't ever happen.
				break;
			}
			}
		}
	}

	protected void exitButtonActionPerformed() {
		Game.game.resetAll();
		Game.game.setState(GameState.MAIN_MENU);
	}

	protected void restartButtonActionPerformed() {
		Game.game.setupGame();
		Game.game.setState(GameState.PLAYING);
	}

	protected void resumeButtonActionPerformed() {
		Game.game.setState(GameState.PLAYING);
	}
	
	
	

}
