package game;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import characters.NutritiousFruit;
import characters.PoisonousFruit;
import characters.Snake;
import characters.Walls;
import controls.Direction;
import graphics.Draw;
import graphics.Renderer;

public class Game implements ActionListener, KeyListener {

	public static final int GRID_SIZE = 43, BLOCK_SIZE = 20, GAME_SIZE = GRID_SIZE*BLOCK_SIZE, SPEED = 3,
			MIDDLE = (int) (BLOCK_SIZE*(Math.floor(Math.abs((GAME_SIZE/2)/BLOCK_SIZE))));
	
	public static Color PLAYER_ONE_COLOR = Color.cyan.darker(), PLAYER_TWO_COLOR = Color.green.darker(),
			COMPUTER_ONE_COLOR = Color.red.darker(), BOUNDARY_COLOR = Color.gray, BACKGROUND_COLOR = Color.black;
	
	public static Game game;
	
	private Timer timer;
	private Renderer renderer;
	private Snake playerOneSnake, playerTwoSnake, computerSnake;
	private PoisonousFruit badFruit;
	private NutritiousFruit goodFruit;
	private Walls boundaries;
	
	private Random rand;
	
	private HashSet<KeyEvent> pressedKeys;
	
	private GameState state;
	private GameMode mode;
	private GameOptions fruitOption, gapsOption;

	private GameFrame gameWindow;

	private JPanel pauseMenu, gameOverMenu;
	
	public static void main(String[] args) {
		game = new Game();
	}
	
	public Game() {
		renderer = new Renderer();
		gameWindow = new GameFrame();
		
		rand = new Random(System.currentTimeMillis());
		pressedKeys = new HashSet<KeyEvent>();
		
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setSize(GAME_SIZE + 18, GAME_SIZE + 47);             //I hate to use magic numbers, but I'm not sure why the window didn't hold the correct size rectangle
		gameWindow.setResizable(false);
		gameWindow.addKeyListener(this);
		gameWindow.setVisible(true);
		
		boundaries = new Walls(true, BOUNDARY_COLOR);
		playerOneSnake = new Snake(MIDDLE, GAME_SIZE - 5*BLOCK_SIZE, 1, Direction.NORTH);
		playerTwoSnake = new Snake(MIDDLE, 5*BLOCK_SIZE, 1, Direction.SOUTH);
		computerSnake = new Snake(MIDDLE, 5*BLOCK_SIZE, 1, Direction.SOUTH);
		badFruit = new PoisonousFruit(BLOCK_SIZE + rand.nextInt(GAME_SIZE - (3*BLOCK_SIZE)), BLOCK_SIZE + rand.nextInt(GAME_SIZE - (3*BLOCK_SIZE)));
		goodFruit = new NutritiousFruit(BLOCK_SIZE + rand.nextInt(GAME_SIZE - (3*BLOCK_SIZE)), BLOCK_SIZE + rand.nextInt(GAME_SIZE - (3*BLOCK_SIZE)));
		
		mode = GameMode.NONE;
		state = GameState.MENU;
		
		gameWindow.setContentPane(new MainMenu());

		timer = new Timer(1000/SPEED, this);
		timer.start();
		
	}
	
	public void repaint(Graphics2D g) {
		switch(state) {
			case PLAYING: {
				Draw.paintBackground(g);
				Draw.paintWalls(g, boundaries);
				Draw.paintNutritiousFruit(g, goodFruit);
				Draw.paintPoisonousFruit(g, badFruit);
				Draw.paintSnake(g, playerOneSnake, PLAYER_ONE_COLOR);
			}
			case MENU: {
				
			}
			case PAUSED: {
				
			}
			case HIGH_SCORES: {
				
			}
			case GAMEOVER: {
				
			}
		}
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_D 
				|| e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT
				|| e.getKeyCode() == KeyEvent.VK_ESCAPE || e.getKeyCode() == KeyEvent.VK_SPACE) {
			pressedKeys.add(e);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_D 
				|| e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT
				|| e.getKeyCode() == KeyEvent.VK_ESCAPE || e.getKeyCode() == KeyEvent.VK_SPACE) {
			pressedKeys.remove(e);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		renderer.repaint();
	}
	
	/**
	 * @return the state
	 */
	public GameState getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(GameState state) {
		this.state = state;
		JPanel content = game.gameWindow.getContentPane();
		CardLayout layout = (CardLayout) content.getLayout();
		switch(this.state) {
			case MENU: {
				layout.show(content, "Main Menu");
				break;
			}
			case PAUSED: {
				layout.show(content, "Game");
				game.gameWindow.showPauseMenu();
				break;
			}
			case HIGH_SCORES: {
				layout.show(content, "High Scores");
				break;
			}
			case PLAYING: {
				layout.show(content, "Game");
				game.gameWindow.hidePauseMenu();
				break;
			}
			case GAMEOVER: {
				break;
			}
			default: {
				break;
			}
		}
		game.gameWindow.repaint();				//TODO: Fix the card layout so that it actually shows the correct cards.
	}

	/**
	 * @return the mode
	 */
	public GameMode getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(GameMode mode) {
		this.mode = mode;
	}
	
	/**
	 * @return the fruitOption
	 */
	public GameOptions getFruitOption() {
		return fruitOption;
	}

	/**
	 * @param fruitOption the fruitOption to set
	 */
	public void setFruitOption(GameOptions fruitOption) {
		this.fruitOption = fruitOption;
	}

	/**
	 * @return the gapsOption
	 */
	public GameOptions getGapsOption() {
		return gapsOption;
	}

	/**
	 * @param gapsOption the gapsOption to set
	 */
	public void setGapsOption(GameOptions gapsOption) {
		this.gapsOption = gapsOption;
	}
	
	/**
	 * @return the gameWindow
	 */
	public JFrame getGameWindow() {
		return gameWindow;
	}
	
	/**
	 * @return the renderer
	 */
	public Renderer getRenderer() {
		return renderer;
	}

}
