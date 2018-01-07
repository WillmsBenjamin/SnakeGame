package game;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

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
	
	private JLabel mainTitleLabel;
	private JLabel authorLabel;
	
	/** Creates new form MainMenu */
	public MainMenu() {
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
		
		localMultiplayerButton = new JButton("Local Multiplayer");
		localMultiplayerButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_localMultiplayerButton = new GridBagConstraints();
		gbc_localMultiplayerButton.insets = new Insets(0, 0, 5, 0);
		gbc_localMultiplayerButton.gridx = 0;
		gbc_localMultiplayerButton.gridy = 7;
		add(localMultiplayerButton, gbc_localMultiplayerButton);
		
		onlineMultiplayerButton = new JButton("Online Multiplayer");
		onlineMultiplayerButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_onlineMultiplayerButton = new GridBagConstraints();
		gbc_onlineMultiplayerButton.insets = new Insets(0, 0, 5, 0);
		gbc_onlineMultiplayerButton.gridx = 0;
		gbc_onlineMultiplayerButton.gridy = 9;
		add(onlineMultiplayerButton, gbc_onlineMultiplayerButton);
		
		highScoresButton = new JButton("High Scores");
		highScoresButton.setFont(new Font("AR DESTINE", Font.ITALIC, 29));
		GridBagConstraints gbc_highScoresButton = new GridBagConstraints();
		gbc_highScoresButton.insets = new Insets(0, 0, 5, 0);
		gbc_highScoresButton.gridx = 0;
		gbc_highScoresButton.gridy = 11;
		add(highScoresButton, gbc_highScoresButton);
		
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
//		this.setPreferredSize(size);
//		this.setMinimumSize(size);
//		this.setMaximumSize(size);

		//resetView();
	    
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
	}

	protected void soloButtonActionPerformed() {
		Game.game.setMode(GameMode.SOLO);
		Game.game.setState(GameState.FRUIT_MENU);
	}

	protected void soloVSButtonActionPerformed() {
		Game.game.setMode(GameMode.SOLO_VS);
		Game.game.setState(GameState.FRUIT_MENU);
	}
	
	protected void localMultiplayerButtonActionPerformed() {
		Game.game.setMode(GameMode.LOCAL_MULTIPLAYER);
		Game.game.setState(GameState.FRUIT_MENU);
	}

	protected void onlineMultiplayerButtonActionPerformed() {
		//No timetable to add online support, but I designed the menu with the possibility in mind.
	}
	
	protected void highScoresButtonActionPerformed() {
		Game.game.setState(GameState.HIGH_SCORES);
	}
	
}