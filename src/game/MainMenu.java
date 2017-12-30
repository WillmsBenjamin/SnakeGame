package game;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

public class MainMenu extends JPanel {
	
	private static final long serialVersionUID = -1646811647253165349L;

	private JButton soloButton;
	private JButton soloVSButton;
	private JButton localMultiplayerButton;
	private JButton onlineMultiplayerButton;
	private JButton highScoresButton;
	private JButton yesButton;
	private JButton noButton;
	private JButton backButton;
	
	private JLabel mainTitleLabel;
	private JLabel authorLabel;
	private JLabel fruitLabel;
	private JLabel gapsLabel;
	
	/** Creates new form MainMenu */
	public MainMenu() {
	    initComponents();
	}
	
	private void initComponents() {
		
		Dimension size = new Dimension(Game.GAME_SIZE, Game.GAME_SIZE);
		
		setSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		

		setBorder(new CompoundBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 0), new Color(0, 255, 0)), new MatteBorder(18, 18, 18, 18, (Color) new Color(255, 0, 0))), new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 0), new Color(0, 255, 0))));
		setBackground(Color.BLACK);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{816, 0};
		gridBagLayout.rowHeights = new int[] {50, 130, 70, 46, 40, 46, 40, 46, 40, 46, 40, 46, 130, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{50.0, 130.0, 70.0, 46.0, 40.0, 46.0, 40.0, 46.0, 40.0, 46.0, 40.0, 46.0, 130.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		soloButton = new JButton("Solo Game");
		soloButton.setForeground(Color.BLACK);
		soloButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_soloButton = new GridBagConstraints();
		gbc_soloButton.insets = new Insets(0, 0, 5, 0);
		gbc_soloButton.gridx = 0;
		gbc_soloButton.gridy = 3;
		add(soloButton, gbc_soloButton);
		
		soloVSButton = new JButton("Player VS Computer");
		soloVSButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_soloVSButton = new GridBagConstraints();
		gbc_soloVSButton.insets = new Insets(0, 0, 5, 0);
		gbc_soloVSButton.gridx = 0;
		gbc_soloVSButton.gridy = 5;
		add(soloVSButton, gbc_soloVSButton);
		
		fruitLabel = new JLabel("Poisonous Fruits?");
		fruitLabel.setForeground(Color.GREEN);
		fruitLabel.setVerticalAlignment(SwingConstants.TOP);
		fruitLabel.setFont(new Font("AR DESTINE", Font.PLAIN, 29));
		fruitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_fruitLabel = new GridBagConstraints();
		gbc_fruitLabel.insets = new Insets(0, 0, 5, 0);
		gbc_fruitLabel.gridx = 0;
		gbc_fruitLabel.gridy = 5;
		fruitLabel.setVisible(false);
		add(fruitLabel, gbc_fruitLabel);
		
		gapsLabel = new JLabel("Wall Gaps?");
		gapsLabel.setForeground(Color.GREEN);
		gapsLabel.setVerticalAlignment(SwingConstants.TOP);
		gapsLabel.setFont(new Font("AR DESTINE", Font.PLAIN, 29));
		gapsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_gapsLabel = new GridBagConstraints();
		gbc_gapsLabel.insets = new Insets(0, 0, 5, 0);
		gbc_gapsLabel.gridx = 0;
		gbc_gapsLabel.gridy = 5;
		gapsLabel.setVisible(false);
		add(gapsLabel, gbc_gapsLabel);
		
		localMultiplayerButton = new JButton("Local Multiplayer");
		localMultiplayerButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_localMultiplayerButton = new GridBagConstraints();
		gbc_localMultiplayerButton.insets = new Insets(0, 0, 5, 0);
		gbc_localMultiplayerButton.gridx = 0;
		gbc_localMultiplayerButton.gridy = 7;
		add(localMultiplayerButton, gbc_localMultiplayerButton);
		
		yesButton = new JButton("Yes!");
		yesButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_yesButton = new GridBagConstraints();
		gbc_yesButton.insets = new Insets(0, 0, 5, 0);
		gbc_yesButton.gridx = 0;
		gbc_yesButton.gridy = 7;
		yesButton.setEnabled(false);
		yesButton.setVisible(false);
		add(yesButton, gbc_yesButton);
		
		onlineMultiplayerButton = new JButton("Online Multiplayer");
		onlineMultiplayerButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_onlineMultiplayerButton = new GridBagConstraints();
		gbc_onlineMultiplayerButton.insets = new Insets(0, 0, 5, 0);
		gbc_onlineMultiplayerButton.gridx = 0;
		gbc_onlineMultiplayerButton.gridy = 9;
		add(onlineMultiplayerButton, gbc_onlineMultiplayerButton);
		
		noButton = new JButton("No!");
		noButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_noButton = new GridBagConstraints();
		gbc_noButton.insets = new Insets(0, 0, 5, 0);
		gbc_noButton.gridx = 0;
		gbc_noButton.gridy = 9;
		noButton.setEnabled(false);
		noButton.setVisible(false);
		add(noButton, gbc_noButton);
		
		highScoresButton = new JButton("High Scores");
		highScoresButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_highScoresButton = new GridBagConstraints();
		gbc_highScoresButton.insets = new Insets(0, 0, 5, 0);
		gbc_highScoresButton.gridx = 0;
		gbc_highScoresButton.gridy = 11;
		add(highScoresButton, gbc_highScoresButton);
		
		backButton = new JButton("<- Back");
		backButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.insets = new Insets(0, 0, 5, 0);
		gbc_backButton.gridx = 0;
		gbc_backButton.gridy = 11;
		backButton.setEnabled(false);
		backButton.setVisible(false);
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

		resetView();
	    refreshData();
	    
	    soloButton.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            soloButtonActionPerformed();
	        }
	    });
	    soloVSButton.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            soloVSButtonActionPerformed();
	        }
	    });
	    localMultiplayerButton.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            localMultiplayerButtonActionPerformed();
	        }
	    });
	    onlineMultiplayerButton.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            onlineMultiplayerButtonActionPerformed();
	        }
	    });
	    highScoresButton.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            highScoresButtonActionPerformed();
	        }
	    });
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
		if(gapsLabel.isVisible()) {
			enableFruitOptionsView();
		} else if(fruitLabel.isVisible()) {
			resetView();							//TODO: Implement this method to reset to the original button visibility. 
		}
		
	}

	protected void noButtonActionPerformed() {
		if(gapsLabel.isVisible()) {
			
			Game.game.setGapsOption(GameOptions.NO_GAPS);
			Game.game.setState(GameState.PLAYING);
			
		} else if(fruitLabel.isVisible()) {
			
			Game.game.setFruitOption(GameOptions.ONE_FRUIT);
			enableGapsOptionsView();
			
		}
	}

	protected void yesButtonActionPerformed() {
		if(gapsLabel.isVisible()) {
			
			Game.game.setGapsOption(GameOptions.GAPS);
			Game.game.setState(GameState.PLAYING);
			
		} else if(fruitLabel.isVisible()) {
			
			Game.game.setFruitOption(GameOptions.TWO_FRUITS);
			enableGapsOptionsView();
			
		}
	}

	protected void soloButtonActionPerformed() {
		Game.game.setMode(GameMode.SOLO);
		enableFruitOptionsView();
	}

	private void resetView() {
		soloButton.setEnabled(true);
		soloButton.setVisible(true);
		
		soloVSButton.setEnabled(true);
		soloVSButton.setVisible(true);
		
		localMultiplayerButton.setEnabled(true);
		localMultiplayerButton.setVisible(true);
		
		onlineMultiplayerButton.setEnabled(true);
		onlineMultiplayerButton.setVisible(true);
		
		highScoresButton.setEnabled(true);
		highScoresButton.setVisible(true);
		
		//Disable and hide secondary buttons and labels
		gapsLabel.setVisible(false);
		fruitLabel.setVisible(false);
		
		yesButton.setEnabled(false);
		yesButton.setVisible(false);
		
		noButton.setEnabled(false);
		noButton.setVisible(false);
		
		backButton.setEnabled(false);
		backButton.setVisible(false);
		
		//refresh menu
		refreshData();
		
	}
	
	private void enableFruitOptionsView() {
		soloButton.setEnabled(false);
		soloButton.setVisible(false);
		
		soloVSButton.setEnabled(false);
		soloVSButton.setVisible(false);
		
		localMultiplayerButton.setEnabled(false);
		localMultiplayerButton.setVisible(false);
		
		onlineMultiplayerButton.setEnabled(false);
		onlineMultiplayerButton.setVisible(false);
		
		highScoresButton.setEnabled(false);
		highScoresButton.setVisible(false);
		
		gapsLabel.setVisible(false);
		
		//Set buttons visible and enabled
		fruitLabel.setVisible(true);
		
		yesButton.setEnabled(true);
		yesButton.setVisible(true);
		
		noButton.setEnabled(true);
		noButton.setVisible(true);
		
		backButton.setEnabled(true);
		backButton.setVisible(true);
		
		//refresh menu
		refreshData();
	}
	
	private void enableGapsOptionsView() {
		
		fruitLabel.setVisible(false);
		
		//Set buttons visible and enabled
		gapsLabel.setVisible(true);

		//refresh menu
		refreshData();
	}

	protected void soloVSButtonActionPerformed() {
		Game.game.setMode(GameMode.SOLO_VS);
		enableFruitOptionsView();
	}
	
	protected void localMultiplayerButtonActionPerformed() {
		Game.game.setMode(GameMode.LOCAL_MULTIPLAYER);
		enableFruitOptionsView();
	}

	protected void onlineMultiplayerButtonActionPerformed() {
		//No timetable to add online support, but I designed the menu with the possibility in mind.
	}
	
	protected void highScoresButtonActionPerformed() {
		Game.game.setState(GameState.HIGH_SCORES);
	}
	
	private void refreshData() {
		this.revalidate();
		this.repaint();
	}
}