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
import java.awt.Component;

public class GameFrame extends JFrame {

	private JPanel contentPane, gamePanel;
	private MainMenu mainMenu;
	private PauseMenu pauseMenu;
	private HighScoresMenu highScoresMenu;
	private JLayeredPane gamePane;
	
	private WindowState state;

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		setTitle("Snake Game");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Game.GAME_SIZE/* + 18*/, Game.GAME_SIZE /*+ 47*/);
		setVisible(true);
		
		Dimension size = new Dimension(Game.GAME_SIZE, Game.GAME_SIZE);
		
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		mainMenu = new MainMenu();
		contentPane.add(mainMenu, "Main Menu");
		
		highScoresMenu = new HighScoresMenu();
		contentPane.add(highScoresMenu, "High Scores");
		
		gamePane = new JLayeredPane();
		contentPane.add(gamePane, "Game");
		
		gamePanel = new JPanel();
		gamePanel.setSize(size);
		gamePanel.setMinimumSize(size);
		gamePanel.setMaximumSize(size);
		gamePane.add(gamePanel);
		
		pauseMenu = new PauseMenu();
		pauseMenu.setSize(size);
		pauseMenu.setMinimumSize(size);
		pauseMenu.setMaximumSize(size);
		pauseMenu.setOpaque(false);
		gamePane.add(pauseMenu);
		
		gamePane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{gamePanel, pauseMenu}));
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{mainMenu, highScoresMenu, gamePane}));
	}
	
	public void showPauseMenu() {
		setupGraphics();
		gamePane.setLayer(pauseMenu, 0);
		gamePane.setLayer(Game.game.getRenderer(), 1);
	}
	
	public void hidePauseMenu() {
		setupGraphics();
		gamePane.setLayer(pauseMenu, 1);
		gamePane.setLayer(Game.game.getRenderer(), 0);
	}
	
	public void setupGraphics() {
		Component[] components = gamePanel.getComponents();
		boolean isFound = false;
		for (Component c : components) {
			if (c == Game.game.getRenderer()) {
				isFound = true;
				break;
			} else {
				isFound = false;
				continue;
			}
		}
		if(!isFound) {
			gamePanel.add(Game.game.getRenderer());
		}
	}
	
	/**
	 * @return the contentPane
	 */
	public JPanel getContentPane() {
		return contentPane;
	}

}
