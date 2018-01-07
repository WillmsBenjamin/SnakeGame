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
import java.awt.Component;

public class PauseMenu extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4719463789749185529L;
	private JPanel pausePanel,gameOverPanel;
	private JLabel pauseLabel, gameOverLabel;
	private JButton resumeButton, restartButton, exitButton, endRestartButton, endExitButton;
	
	public PauseMenu() {
		
		setBorder(null);
		Dimension size = new Dimension(Game.GAME_SIZE/2, Game.GAME_SIZE/2);
		setSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setLayout(new CardLayout(0, 0));
		
		pausePanel = new JPanel();
		pausePanel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.GREEN));
//		pausePanel.setBackground(Color.GRAY);
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
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{pausePanel, gameOverPanel}));
		
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
