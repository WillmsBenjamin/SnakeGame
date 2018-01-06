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

	private JPanel contentPane, gamePanel;
	private Renderer renderer;
	private MainMenu mainMenu;
	private HighScoresMenu highScoresMenu;
	
	private WindowState state;
	private PauseMenu pauseMenu;

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
		
		gamePanel = new JPanel();
		renderer = new Renderer();
		contentPane.add(gamePanel, "Game");
		gamePanel.setLayout(null);
		
		gamePanel.add(renderer);
		
		pauseMenu = new PauseMenu();
		pauseMenu.setBounds(215, 215, 430, 430);
		pauseMenu.setOpaque(false);
		pauseMenu.setVisible(false);
//		GridBagLayout gridBagLayout = (GridBagLayout) pauseMenu.getLayout();
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
//		gridBagLayout.rowHeights = new int[]{40, 81, 24, 28, 37, 28, 37, 28};
//		gridBagLayout.columnWeights = new double[]{0.0};
//		gridBagLayout.columnWidths = new int[]{623};
		gamePanel.add(pauseMenu);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{mainMenu, highScoresMenu, gamePanel}));
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
	
	public Renderer getRenderer() {
		return renderer;
	}
	
	public PauseMenu getPauseMenu() {
		return pauseMenu;
	}

}
