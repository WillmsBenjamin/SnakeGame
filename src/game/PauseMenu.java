package game;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

public class PauseMenu extends JPanel {
	
	JLabel gamePausedLabel;
	
	JButton resumeButton, quitButton;
	
	public PauseMenu() {
		
		setBorder(new MatteBorder(20, 20, 20, 20, (Color) Color.GRAY));
		setBackground(Color.BLACK);
		Dimension size = new Dimension(Game.GAME_SIZE, Game.GAME_SIZE);
		setSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{816, 0};
		gridBagLayout.rowHeights = new int[] {50, 130, 70, 46, 40, 46, 40, 46, 40, 46, 40, 46, 130, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{50.0, 130.0, 70.0, 46.0, 40.0, 46.0, 40.0, 46.0, 40.0, 46.0, 40.0, 46.0, 130.0, 0.0};
		setLayout(gridBagLayout);
		
		gamePausedLabel = new JLabel("Game Paused");
		gamePausedLabel.setForeground(Color.GREEN);
		gamePausedLabel.setVerticalAlignment(SwingConstants.TOP);
		gamePausedLabel.setFont(new Font("AR DESTINE", Font.PLAIN, 99));
		gamePausedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_gamePausedLabel = new GridBagConstraints();
		gbc_gamePausedLabel.insets = new Insets(0, 0, 5, 0);
		gbc_gamePausedLabel.fill = GridBagConstraints.BOTH;
		gbc_gamePausedLabel.gridx = 0;
		gbc_gamePausedLabel.gridy = 1;
		add(gamePausedLabel, gbc_gamePausedLabel);
		
		resumeButton = new JButton("Resume Game");
		resumeButton.setForeground(Color.BLACK);
		resumeButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_resumeButton = new GridBagConstraints();
		gbc_resumeButton.insets = new Insets(0, 0, 5, 0);
		gbc_resumeButton.gridx = 0;
		gbc_resumeButton.gridy = 5;
		add(resumeButton, gbc_resumeButton);
		
		quitButton = new JButton("Exit Game");
		quitButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_quitButton = new GridBagConstraints();
		gbc_quitButton.insets = new Insets(0, 0, 5, 0);
		gbc_quitButton.gridx = 0;
		gbc_quitButton.gridy = 8;
		add(quitButton, gbc_quitButton);
		
		setOpaque(true);
		
		
		resumeButton.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            resumeButtonActionPerformed();
	        }
	    });
	    quitButton.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            quitButtonActionPerformed();
	        }
	    });
		
	}

	protected void quitButtonActionPerformed() {
		Game.game.setState(GameState.MENU);
	}

	protected void resumeButtonActionPerformed() {
		Game.game.setState(GameState.PLAYING);
	}

}
