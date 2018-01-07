package game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Dimension;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import graphics.Renderer;

import java.awt.Component;

public class GameFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2502638443874663551L;
	
	private JPanel contentPane;
	private Renderer renderer;
	private MainMenu mainMenu;
	private FruitOptionsMenu fruitMenu;
	private GapsOptionsMenu gapsMenu;
	private HighScoresMenu highScoresMenu;
	
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
		
		fruitMenu = new FruitOptionsMenu();
		contentPane.add(fruitMenu, "Fruit Menu");
		
		gapsMenu = new GapsOptionsMenu();
		contentPane.add(gapsMenu, "Gaps Menu");
		
		highScoresMenu = new HighScoresMenu();
		contentPane.add(highScoresMenu, "High Scores");
		
		renderer = new Renderer();
		contentPane.add(renderer, "Game");
		renderer.setLayout(null);
		
		pauseMenu = new PauseMenu();
		pauseMenu.setBounds(215, 215, 430, 430);
		pauseMenu.setOpaque(false);
		pauseMenu.setVisible(false);
//		GridBagLayout gridBagLayout = (GridBagLayout) pauseMenu.getLayout();
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
//		gridBagLayout.rowHeights = new int[]{40, 81, 24, 28, 37, 28, 37, 28};
//		gridBagLayout.columnWeights = new double[]{0.0};
//		gridBagLayout.columnWidths = new int[]{623};
		renderer.add(pauseMenu);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{mainMenu, fruitMenu, gapsMenu, highScoresMenu, renderer}));
	}
	
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
