package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

public class GapsOptionsMenu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9201377963879369858L;
	
	private JButton yesButton;
	private JButton noButton;
	private JButton backButton;
	
	private JLabel mainTitleLabel;
	private JLabel authorLabel;
	private JLabel gapsLabel;
	
	/**
	 * Create the panel.
	 */
	public GapsOptionsMenu() {
		initComponents();
	}

	private void initComponents() {
		
		Dimension size = new Dimension(Game.GAME_SIZE + 6, Game.GAME_SIZE + 35);

		setBorder(new CompoundBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 0), new Color(0, 255, 0)), new MatteBorder(18, 18, 18, 18, (Color) new Color(255, 0, 0))), new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 0), new Color(0, 255, 0))));
		setBackground(Color.BLACK);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{816, 0};
		gridBagLayout.rowHeights = new int[] {50, 130, 70, 46, 40, 46, 40, 46, 40, 46, 40, 46, 130, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{50.0, 130.0, 70.0, 46.0, 40.0, 46.0, 40.0, 46.0, 40.0, 46.0, 40.0, 46.0, 130.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		mainTitleLabel = new JLabel("Snake Game");
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
		
		gapsLabel = new JLabel("Wall Gaps?");
		gapsLabel.setForeground(Color.GREEN);
		gapsLabel.setVerticalAlignment(SwingConstants.TOP);
		gapsLabel.setFont(new Font("AR DESTINE", Font.PLAIN, 29));
		gapsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_gapsLabel = new GridBagConstraints();
		gbc_gapsLabel.insets = new Insets(0, 0, 5, 0);
		gbc_gapsLabel.gridx = 0;
		gbc_gapsLabel.gridy = 5;
		add(gapsLabel, gbc_gapsLabel);
		
		yesButton = new JButton("Yes!");
		yesButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_yesButton = new GridBagConstraints();
		gbc_yesButton.insets = new Insets(0, 0, 5, 0);
		gbc_yesButton.gridx = 0;
		gbc_yesButton.gridy = 7;
		add(yesButton, gbc_yesButton);
		
		noButton = new JButton("No!");
		noButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_noButton = new GridBagConstraints();
		gbc_noButton.insets = new Insets(0, 0, 5, 0);
		gbc_noButton.gridx = 0;
		gbc_noButton.gridy = 9;
		add(noButton, gbc_noButton);
		
		backButton = new JButton("<- Back");
		backButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.insets = new Insets(0, 0, 5, 0);
		gbc_backButton.gridx = 0;
		gbc_backButton.gridy = 11;
		add(backButton, gbc_backButton);
		
		authorLabel = new JLabel("  Created by: Benjamin Willms");
		authorLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		authorLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		authorLabel.setForeground(Color.GREEN);
		authorLabel.setFont(new Font("AR DESTINE", Font.BOLD | Font.ITALIC, 24));
		GridBagConstraints gbc_authorLabel = new GridBagConstraints();
		gbc_authorLabel.anchor = GridBagConstraints.LINE_START;
		gbc_authorLabel.gridx = 0;
		gbc_authorLabel.gridy = 13;
		add(authorLabel, gbc_authorLabel);
		
		this.setSize(size);
	    
	    yesButton.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            yesButtonActionPerformed();
	        }
	    });
	    noButton.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            noButtonActionPerformed();
	        }
	    });
	    backButton.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            backButtonActionPerformed();
	        }
	    });
	}
	
	protected void backButtonActionPerformed() {
		Game.game.setState(GameState.FRUIT_MENU);
	}

	protected void noButtonActionPerformed() {
		Game.game.setGapsOption(GameOptions.NO_GAPS);
		Game.game.setState(GameState.PLAYING);
	}

	protected void yesButtonActionPerformed() {
		Game.game.setGapsOption(GameOptions.GAPS);
		Game.game.setState(GameState.PLAYING);
	}
}
