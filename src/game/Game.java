package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

import characters.Snake;
import characters.Walls;
import controls.Direction;
import graphics.Draw;
import graphics.Renderer;

public class Game implements ActionListener, KeyListener {

	public static final int BLOCK_SIZE = 20, GAME_SIZE = 43*BLOCK_SIZE, SPEED = 3,
			MIDDLE = (int) (BLOCK_SIZE*(Math.floor(Math.abs((GAME_SIZE/2)/BLOCK_SIZE))));
	
	public static Color PLAYER_ONE_COLOR = Color.cyan.darker(), PLAYER_TWO_COLOR = Color.green.darker(),
			COMPUTER_ONE_COLOR = Color.red.darker(), BOUNDARY_COLOR = Color.gray, BACKGROUND_COLOR = Color.black;
	
	public static Game game;
	
	public Renderer renderer;
	public Snake playerOneSnake, playerTwoSnake, computerSnake;
	public Walls boundaries;
	
	public Random rand;
	
	public HashSet<KeyEvent> pressedKeys;
	
	public GameState state;
	public GameType mode;
	
	public static void main(String[] args) {
		game = new Game();
	}
	
	public Game() {
		JFrame gameWindow = new JFrame("Snake Game");
		Timer timer = new Timer(20, this);
		
		renderer = new Renderer();
		rand = new Random();
		pressedKeys = new HashSet<KeyEvent>();
		
		gameWindow.add(renderer);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setSize(GAME_SIZE + 18, GAME_SIZE + 47);             //I hate to use magic numbers, but I'm not sure why the window didn't hold the correct size rectangle
		gameWindow.addKeyListener(this);
		gameWindow.setVisible(true);
		
		mode = GameType.SOLO; //TODO: Make this a user choice. 
		
		boundaries = new Walls(true, BOUNDARY_COLOR);
		playerOneSnake = new Snake(MIDDLE, GAME_SIZE - 5*BLOCK_SIZE, 1, Direction.NORTH);
		playerTwoSnake = new Snake(MIDDLE, 5*BLOCK_SIZE, 1, Direction.SOUTH);
		computerSnake = new Snake(MIDDLE, 5*BLOCK_SIZE, 1, Direction.SOUTH);
		
		state = GameState.PLAYING;	//TODO: Make this dynamic based on menu selections and gameplay events.
		
		timer.start();
	}
	
	public void repaint(Graphics2D g) {
		
		Draw.paintBackground(g);
		Draw.paintWalls(g, boundaries);
		Draw.paintSnake(g, playerOneSnake, PLAYER_ONE_COLOR);
	}

	@Override
	public void keyPressed(KeyEvent e) {		//TODO: Fix this. Must be a simple way without repeating e.getKeyCode().
//		if(e.getKeyCode() == KeyEvent.VK_A || KeyEvent.VK_S || KeyEvent.VK_W || KeyEvent.VK_D 
//				|| KeyEvent.VK_DOWN || KeyEvent.VK_UP || KeyEvent.VK_LEFT || KeyEvent.VK_RIGHT
//				|| KeyEvent.VK_ESCAPE || KeyEvent.VK_SPACE) {
//			pressedKeys.add(e);
//		}
	}

	@Override
	public void keyReleased(KeyEvent e) {		//TODO: Fix this. Must be a simple way without repeating e.getKeyCode().
//		if(e.getKeyCode() == KeyEvent.VK_A || KeyEvent.VK_S || KeyEvent.VK_W || KeyEvent.VK_D 
//				|| KeyEvent.VK_DOWN || KeyEvent.VK_UP || KeyEvent.VK_LEFT || KeyEvent.VK_RIGHT
//				|| KeyEvent.VK_ESCAPE || KeyEvent.VK_SPACE) {
//			pressedKeys.remove(e);
//		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		renderer.repaint();
		
	}
	
}
