package game;

import javax.swing.JPanel;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlaceholderMainMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public PlaceholderMainMenu() {

		Dimension size = new Dimension(Game.GAME_SIZE, Game.GAME_SIZE);
		setSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		
		setBorder(new CompoundBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 0), new Color(0, 255, 0)), new MatteBorder(18, 18, 18, 18, (Color) new Color(255, 0, 0))), new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 0), new Color(0, 255, 0))));
		setBackground(Color.BLACK);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{816, 0};
		gridBagLayout.rowHeights = new int[] {50, 0, 70, 0, 40, 0, 40, 0, 40, 0, 40, 0, 140, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel mainTitleLabel = new JLabel("Snake Game");
		mainTitleLabel.setForeground(Color.GREEN);
		mainTitleLabel.setVerticalAlignment(SwingConstants.TOP);
		mainTitleLabel.setFont(new Font("AR DESTINE", Font.PLAIN, 99));
		mainTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_mainTitleLabel = new GridBagConstraints();
		gbc_mainTitleLabel.insets = new Insets(0, 0, 5, 0);
		gbc_mainTitleLabel.fill = GridBagConstraints.BOTH;
		gbc_mainTitleLabel.gridx = 0;
		gbc_mainTitleLabel.gridy = 1;
		add(mainTitleLabel, gbc_mainTitleLabel);
		
		JButton soloButton = new JButton("Solo Game");
		soloButton.setForeground(Color.BLACK);
		soloButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_soloButton = new GridBagConstraints();
		gbc_soloButton.insets = new Insets(0, 0, 5, 0);
		gbc_soloButton.gridx = 0;
		gbc_soloButton.gridy = 3;
		add(soloButton, gbc_soloButton);
		
		JButton soloVSButton = new JButton("Player VS Computer");
		soloVSButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		soloVSButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_soloVSButton = new GridBagConstraints();
		gbc_soloVSButton.insets = new Insets(0, 0, 5, 0);
		gbc_soloVSButton.gridx = 0;
		gbc_soloVSButton.gridy = 5;
		add(soloVSButton, gbc_soloVSButton);
		
		JButton localMultiplayerButton = new JButton("Local Multiplayer");
		localMultiplayerButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_localMultiplayerButton = new GridBagConstraints();
		gbc_localMultiplayerButton.insets = new Insets(0, 0, 5, 0);
		gbc_localMultiplayerButton.gridx = 0;
		gbc_localMultiplayerButton.gridy = 7;
		add(localMultiplayerButton, gbc_localMultiplayerButton);
		
		JButton onlineMultiplayerButton = new JButton("Online Multiplayer");
		onlineMultiplayerButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_onlineMultiplayerButton = new GridBagConstraints();
		gbc_onlineMultiplayerButton.insets = new Insets(0, 0, 5, 0);
		gbc_onlineMultiplayerButton.gridx = 0;
		gbc_onlineMultiplayerButton.gridy = 9;
		add(onlineMultiplayerButton, gbc_onlineMultiplayerButton);
		
		JButton highScoresButton = new JButton("High Scores");
		highScoresButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_highScoresButton = new GridBagConstraints();
		gbc_highScoresButton.insets = new Insets(0, 0, 5, 0);
		gbc_highScoresButton.gridx = 0;
		gbc_highScoresButton.gridy = 11;
		add(highScoresButton, gbc_highScoresButton);
		
		JLabel authorLabel = new JLabel("  Created by: Benjamin Willms");
		authorLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		authorLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		authorLabel.setForeground(Color.GREEN);
		authorLabel.setFont(new Font("AR DESTINE", Font.BOLD | Font.ITALIC, 24));
		GridBagConstraints gbc_authorLabel = new GridBagConstraints();
		gbc_authorLabel.anchor = GridBagConstraints.LINE_START;
		gbc_authorLabel.gridx = 0;
		gbc_authorLabel.gridy = 13;
		add(authorLabel, gbc_authorLabel);

	}

}
