package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JLayeredPane;
import java.awt.FlowLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import graphics.Renderer;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class GameFrame extends JFrame {

	private JPanel contentPane;
	private Renderer gamePanel;
	private MainMenu mainMenu;
	private PauseMenu pauseMenu;
	private HighScoresMenu highScoresMenu;
	
	private WindowState state;

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		setTitle("Snake Game");
		Dimension size = new Dimension(Game.GAME_SIZE + 6, Game.GAME_SIZE + 35);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(size);
		setResizable(false);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setSize(size);
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		mainMenu = new MainMenu();
		contentPane.add(mainMenu, "Main Menu");
		
		highScoresMenu = new HighScoresMenu();
		contentPane.add(highScoresMenu, "High Scores");
		
		gamePanel = new Renderer();
		contentPane.add(gamePanel, "Game");
//		gamePanel.setPreferredSize(size);
//		gamePanel.setMinimumSize(size);
//		gamePanel.setMaximumSize(size);
		
		pauseMenu = new PauseMenu();
		contentPane.add(pauseMenu, "Pause Menu");
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{mainMenu, highScoresMenu, gamePanel, pauseMenu}));
	}
	
//	public void setupGraphics() {
//		Component[] components = gamePanel.getComponents();
//		boolean isFound = false;
//		for (Component c : components) {
//			if (c == Game.game.getRenderer()) {
//				isFound = true;
//				break;
//			} else {
//				isFound = false;
//				continue;
//			}
//		}
//		if(!isFound) {
//			gamePanel.add(Game.game.getRenderer());
//		}
//	}
	
	/**
	 * @return the contentPane
	 */
	public JPanel getContentPane() {
		return contentPane;
	}
	
	public Renderer getGamePanel() {
		return gamePanel;
	}

}
