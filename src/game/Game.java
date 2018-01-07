package game;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import characters.NutritiousFruit;
import characters.PoisonousFruit;
import characters.Snake;
import characters.Walls;
import controls.Direction;
import controls.SnakeAI;
import graphics.Draw;
import graphics.Renderer;

public class Game implements ActionListener, KeyListener {

	public static final int GRID_SIZE = 43, BLOCK_SIZE = 20, GAME_SIZE = GRID_SIZE*BLOCK_SIZE, SPEED = 10,
			MIDDLE = (int) (BLOCK_SIZE*(Math.floor(Math.abs((GAME_SIZE/2)/BLOCK_SIZE))));
	
	public static Color PLAYER_ONE_COLOR = Color.cyan.darker(), PLAYER_TWO_COLOR = Color.green.darker(),
			COMPUTER_COLOR = Color.red.darker(), BOUNDARY_COLOR = Color.gray, BACKGROUND_COLOR = Color.black;
	
	public static Game game;
	
	private Timer timer;
	private Renderer renderer;
	private Snake playerOneSnake, playerTwoSnake, computerSnake;
	private PoisonousFruit badFruit;
	private NutritiousFruit goodFruit;
	private Walls gapsWalls, noGapsWalls;
	
	private Random rand;
	
	private KeyEvent playerOneControl, playerTwoControl, pauseControl;
	private Direction computerControl;

	private GameState state;
	
	private GameMode mode;
	private GameOptions fruitOption, gapsOption;

	private GameFrame gameWindow;
	
	public static void main(String[] args) {
		game = new Game();
	}
	
	public Game() {
		
		gameWindow = new GameFrame();
		
		rand = new Random(System.currentTimeMillis());
		
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.addKeyListener(this);
		gameWindow.setVisible(true);
		
		gapsWalls = new Walls(true, BOUNDARY_COLOR);
		noGapsWalls = new Walls(false, BOUNDARY_COLOR);

		setupGame();
		
		mode = GameMode.NONE;
		state = GameState.MAIN_MENU;
	}
	
	public void repaint(Graphics2D g) {
		
		Draw.paintBackground(g);
		if(gapsOption == GameOptions.GAPS) {
			Draw.paintWalls(g, gapsWalls);
		} else {
			Draw.paintWalls(g, noGapsWalls);
		}
		switch(mode) {
			case LOCAL_MULTIPLAYER: {
				Draw.paintSnake(g, playerTwoSnake, PLAYER_TWO_COLOR);
				Draw.paintSnake(g, playerOneSnake, PLAYER_ONE_COLOR);
				Draw.paintNutritiousFruit(g, goodFruit);
				if(fruitOption == GameOptions.TWO_FRUITS) {
					Draw.paintPoisonousFruit(g, badFruit);
				}
				break;
			}
			case ONLINE_MULTIPLAYER: {
				
				break;
			}
			case SOLO: {
				Draw.paintSnake(g, playerOneSnake, PLAYER_ONE_COLOR);
				Draw.paintNutritiousFruit(g, goodFruit);
				if(fruitOption == GameOptions.TWO_FRUITS) {
					Draw.paintPoisonousFruit(g, badFruit);
				}
				break;
			}
			case SOLO_VS: {
				Draw.paintSnake(g, computerSnake, COMPUTER_COLOR);
				Draw.paintSnake(g, playerOneSnake, PLAYER_ONE_COLOR);
				Draw.paintNutritiousFruit(g, goodFruit);
				if(fruitOption == GameOptions.TWO_FRUITS) {
					Draw.paintPoisonousFruit(g, badFruit);
				}
				break;
			}
			case NONE: {
				
				break;
			}
			default: {
				break;
			}
		}
	}
	
	public void resetGoodFruit() {
		goodFruit = new NutritiousFruit(BLOCK_SIZE + (int) (BLOCK_SIZE*(Math.floor(Math.abs((rand.nextInt(GAME_SIZE - (3*BLOCK_SIZE)))/BLOCK_SIZE)))),
				BLOCK_SIZE + (int) (BLOCK_SIZE*(Math.floor(Math.abs((rand.nextInt(GAME_SIZE - (3*BLOCK_SIZE)))/BLOCK_SIZE)))));
		
		for(Rectangle rect : playerOneSnake.getBodyParts()) {
			if(rect.intersects(goodFruit.getFruit().getFrame())) {
				resetGoodFruit();
				break;
			}
		}
		
		for(Rectangle rect : playerTwoSnake.getBodyParts()) {
			if(rect.intersects(goodFruit.getFruit().getFrame())) {
				resetGoodFruit();
				break;
			}
		}
		
		for(Rectangle rect : computerSnake.getBodyParts()) {
			if(rect.intersects(goodFruit.getFruit().getFrame())) {
				resetGoodFruit();
				break;
			}
		}
	}
	
	public void resetBadFruit() {
		badFruit = new PoisonousFruit(BLOCK_SIZE + (int) (BLOCK_SIZE*(Math.floor(Math.abs((rand.nextInt(GAME_SIZE - (3*BLOCK_SIZE)))/BLOCK_SIZE)))),
				BLOCK_SIZE + (int) (BLOCK_SIZE*(Math.floor(Math.abs((rand.nextInt(GAME_SIZE - (3*BLOCK_SIZE)))/BLOCK_SIZE)))));
		
		for(Rectangle rect : playerOneSnake.getBodyParts()) {
			if(rect.intersects(badFruit.getFruit().getFrame())) {
				resetBadFruit();
				break;
			}
		}
		
		for(Rectangle rect : playerTwoSnake.getBodyParts()) {
			if(rect.intersects(badFruit.getFruit().getFrame())) {
				resetBadFruit();
				break;
			}
		}
		
		for(Rectangle rect : computerSnake.getBodyParts()) {
			if(rect.intersects(badFruit.getFruit().getFrame())) {
				resetBadFruit();
				break;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_D) {
			switch(playerOneSnake.getHeadDirection()) {
				case WEST : {
					if(e.getKeyCode() != KeyEvent.VK_D) {
						playerOneControl = e;
					}
					break;
				}
				case NORTH : {
					if(e.getKeyCode() != KeyEvent.VK_S) {
						playerOneControl = e;
					}
					break;
				}
				case EAST : {
					if(e.getKeyCode() != KeyEvent.VK_A) {
						playerOneControl = e;
					}
					break;
				}
				case SOUTH : {
					if(e.getKeyCode() != KeyEvent.VK_W) {
						playerOneControl = e;
					}
					break;
				}
				default : {
					playerOneControl = e;
					break;
				}
			}
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			switch(playerTwoSnake.getHeadDirection()) {
				case SOUTH : {
					if(e.getKeyCode() != KeyEvent.VK_UP) {
						playerTwoControl = e;
					}
					break;
				}
				case NORTH : {
					if(e.getKeyCode() != KeyEvent.VK_DOWN) {
						playerTwoControl = e;
					}
					break;
				}
				case WEST : {
					if(e.getKeyCode() != KeyEvent.VK_RIGHT) {
						playerTwoControl = e;
					}
					break;
				}
				case EAST : {
					if(e.getKeyCode() != KeyEvent.VK_LEFT) {
						playerTwoControl = e;
					}
					break;
				}
				default : {
					playerTwoControl = e;
					break;
				}
			}
		} else if(e.getKeyCode() == KeyEvent.VK_ESCAPE || e.getKeyCode() == KeyEvent.VK_SPACE) {
			pauseControl = e;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(renderer == null) {
			renderer = game.gameWindow.getRenderer();
		}
		
		if(pauseControl.getKeyCode() == KeyEvent.VK_ESCAPE || pauseControl.getKeyCode() == KeyEvent.VK_SPACE) {
			game.setState(GameState.PAUSED);
			pauseControl = new KeyEvent(gameWindow, 0, 0, 0, KeyEvent.VK_0, '0');
		}
		
		if(state == GameState.PLAYING) {
			switch(playerOneControl.getKeyCode()) {
				case KeyEvent.VK_A : {
					playerOneSnake.slither(Direction.WEST);
					break;
				}
				case KeyEvent.VK_S : {
					playerOneSnake.slither(Direction.SOUTH);
					break;
				}
				case KeyEvent.VK_D : {
					playerOneSnake.slither(Direction.EAST);
					break;
				}
				case KeyEvent.VK_W : {
					playerOneSnake.slither(Direction.NORTH);
					break;
				}
				default : {
					break;
				}
			}
			if (mode == GameMode.SOLO_VS) {
				SnakeAI.calculateComputerMove();
				computerSnake.slither(computerControl);
			}
			
			if (mode == GameMode.LOCAL_MULTIPLAYER || mode == GameMode.ONLINE_MULTIPLAYER) {
				switch (playerTwoControl.getKeyCode()) {
					case KeyEvent.VK_LEFT: {
						playerTwoSnake.slither(Direction.WEST);
						break;
					}
					case KeyEvent.VK_DOWN: {
						playerTwoSnake.slither(Direction.SOUTH);
						break;
					}
					case KeyEvent.VK_RIGHT: {
						playerTwoSnake.slither(Direction.EAST);
						break;
					}
					case KeyEvent.VK_UP: {
						playerTwoSnake.slither(Direction.NORTH);
						break;
					}
					default: {
						break;
					}
				}
				
				//Fruit Collisions
				if(playerTwoSnake.getBodyParts().getFirst().intersects(goodFruit.getFruit().getFrame())) {
					playerTwoSnake.grow();
					resetGoodFruit();
				}
				if (fruitOption == GameOptions.TWO_FRUITS) {
					if (playerTwoSnake.getBodyParts().getFirst().intersects(badFruit.getFruit().getFrame())) {
						if(playerTwoSnake.getBodyParts().size() == 1) {
							game.setState(GameState.GAMEOVER);
							return;
						}
						playerTwoSnake.shrink();
						resetBadFruit();
					} 
				}
				
				//Wall collisions
				if (gapsOption == GameOptions.GAPS) {
					for (Rectangle rect : gapsWalls.getEdges()) {
						if (playerTwoSnake.getBodyParts().getFirst().intersects(rect)) {
							game.setState(GameState.GAMEOVER);
							return;
						}
					} 
				} else {
					for (Rectangle rect : noGapsWalls.getEdges()) {
						if (playerTwoSnake.getBodyParts().getFirst().intersects(rect)) {
							game.setState(GameState.GAMEOVER);
							return;
						}
					} 
				}
				
				//Snake collisions
				for (Rectangle rect : playerTwoSnake.getBodyParts()) {
					if (playerOneSnake.getBodyParts().getFirst().intersects(rect)) {
						game.setState(GameState.GAMEOVER);
						return;
					}
				}
				for (Rectangle rect : playerOneSnake.getBodyParts()) {
					if (playerTwoSnake.getBodyParts().getFirst().intersects(rect)) {
						game.setState(GameState.GAMEOVER);
						return;
					}
				} 
				for (Rectangle rect : playerTwoSnake.getBodyParts()) {
					if (playerTwoSnake.getBodyParts().getFirst().intersects(rect) && rect != playerTwoSnake.getBodyParts().getFirst()) {
						game.setState(GameState.GAMEOVER);
						return;
					}
				}
			}
			
			//Fruit Collisions
			if(playerOneSnake.getBodyParts().getFirst().intersects(goodFruit.getFruit().getFrame())) {
				playerOneSnake.grow();
				resetGoodFruit();
			}
			if (fruitOption == GameOptions.TWO_FRUITS) {
				if (playerOneSnake.getBodyParts().getFirst().intersects(badFruit.getFruit().getFrame())) {
					if(playerOneSnake.getBodyParts().size() == 1) {
						game.setState(GameState.GAMEOVER);
						return;
					}
					playerOneSnake.shrink();
					resetBadFruit();
				} 
			}
			if(mode == GameMode.SOLO_VS) {
				if(computerSnake.getBodyParts().getFirst().intersects(goodFruit.getFruit().getFrame())) {
					computerSnake.grow();
					resetGoodFruit();
				}
				if (fruitOption == GameOptions.TWO_FRUITS) {
					if (computerSnake.getBodyParts().getFirst().intersects(badFruit.getFruit().getFrame())) {
						if(computerSnake.getBodyParts().size() == 1) {
							game.setState(GameState.GAMEOVER);
							return;
						}
						computerSnake.shrink();
						resetBadFruit();
					} 
				}
			}
			
			//Wall collisions
			if (gapsOption == GameOptions.GAPS) {
				for (Rectangle rect : gapsWalls.getEdges()) {
					if (playerOneSnake.getBodyParts().getFirst().intersects(rect)) {
						game.setState(GameState.GAMEOVER);
						return;
					}
				} 
			} else {
				for (Rectangle rect : noGapsWalls.getEdges()) {
					if (playerOneSnake.getBodyParts().getFirst().intersects(rect)) {
						game.setState(GameState.GAMEOVER);
						return;
					}
				} 
			}
			if(mode == GameMode.SOLO_VS) {
				if (gapsOption == GameOptions.GAPS) {
					for (Rectangle rect : gapsWalls.getEdges()) {
						if (computerSnake.getBodyParts().getFirst().intersects(rect)) {
							game.setState(GameState.GAMEOVER);
							return;
						}
					} 
				} else {
					for (Rectangle rect : noGapsWalls.getEdges()) {
						if (computerSnake.getBodyParts().getFirst().intersects(rect)) {
							game.setState(GameState.GAMEOVER);
							return;
						}
					} 
				}
			}
			
			//Snake collisions
			for (Rectangle rect : playerOneSnake.getBodyParts()) {
				if (playerOneSnake.getBodyParts().getFirst().intersects(rect) && rect != playerOneSnake.getBodyParts().getFirst()) {
					game.setState(GameState.GAMEOVER);
					return;
				}
			}
			if (mode == GameMode.SOLO_VS) {
				for (Rectangle rect : playerOneSnake.getBodyParts()) {
					if (computerSnake.getBodyParts().getFirst().intersects(rect)) {
						game.setState(GameState.GAMEOVER);
						return;
					}
				}
				for (Rectangle rect : computerSnake.getBodyParts()) {
					if (playerOneSnake.getBodyParts().getFirst().intersects(rect)) {
						game.setState(GameState.GAMEOVER);
						return;
					}
				}
				for (Rectangle rect : computerSnake.getBodyParts()) {
					if (computerSnake.getBodyParts().getFirst().intersects(rect) && rect != computerSnake.getBodyParts().getFirst()) {
						game.setState(GameState.GAMEOVER);
						return;
					}
				}
			}
			
		}
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
		JPanel pauseContent = game.gameWindow.getPauseMenu();
		CardLayout layout = (CardLayout) content.getLayout();
		CardLayout pauseLayout = (CardLayout) pauseContent.getLayout();
		switch(this.state) {
			case MAIN_MENU: {
				layout.invalidateLayout(content);
				layout.show(content, "Main Menu");
				break;
			}
			case FRUIT_MENU: {
				layout.invalidateLayout(content);
				layout.show(content, "Fruit Menu");
				break;
			}
			case GAPS_MENU: {
				layout.invalidateLayout(content);
				layout.show(content, "Gaps Menu");
				break;
			}
			case PAUSED: {
				layout.invalidateLayout(content);
				layout.show(content, "Game");
				pauseLayout.show(pauseContent, "Pause");
				game.gameWindow.getPauseMenu().setVisible(true);
				timer.stop();
				break;
			}
			case HIGH_SCORES: {
				layout.invalidateLayout(content);
				layout.show(content, "High Scores");
				break;
			}
			case PLAYING: {
				layout.invalidateLayout(content);
				layout.show(content, "Game");
				game.gameWindow.getPauseMenu().setVisible(false);
				game.gameWindow.requestFocus();
				timer = new Timer(1000/SPEED, this);
				timer.start();
				break;
			}
			case GAMEOVER: {
				timer.stop();
				pauseLayout.show(pauseContent, "Game Over");
				game.gameWindow.getPauseMenu().setVisible(true);
				break;
			}
			default: {
				break;
			}
		}
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

	public void resetAll() {
		timer.stop();
		mode = GameMode.NONE;
		fruitOption = null;
		gapsOption = null;
		setupGame();
	}

	public void setupGame() {
		playerOneSnake = new Snake(MIDDLE, GAME_SIZE - 5*BLOCK_SIZE, 3, Direction.NORTH);
		playerTwoSnake = new Snake(MIDDLE, 4*BLOCK_SIZE, 3, Direction.SOUTH);
		computerSnake = new Snake(MIDDLE, 4*BLOCK_SIZE, 3, Direction.SOUTH);
		
		resetGoodFruit();
		resetBadFruit();
		
		playerOneControl = new KeyEvent(gameWindow, 0, 0, 0, KeyEvent.VK_0, '0');
		playerTwoControl = new KeyEvent(gameWindow, 0, 0, 0, KeyEvent.VK_0, '0');
		pauseControl = new KeyEvent(gameWindow, 0, 0, 0, KeyEvent.VK_0, '0');
	}
	
	/**
	 * @return the computerSnake
	 */
	public Snake getComputerSnake() {
		return computerSnake;
	}
	
	/**
	 * @return the playerOneSnake
	 */
	public Snake getPlayerOneSnake() {
		return playerOneSnake;
	}

	/**
	 * @return the badFruit
	 */
	public PoisonousFruit getBadFruit() {
		return badFruit;
	}

	/**
	 * @return the goodFruit
	 */
	public NutritiousFruit getGoodFruit() {
		return goodFruit;
	}
	
	/**
	 * @param computerControl the computerControl to set
	 */
	public void setComputerControl(Direction computerControl) {
		this.computerControl = computerControl;
	}
}
