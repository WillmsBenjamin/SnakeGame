package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

import characters.Snake;
import controls.Direction;
import graphics.Draw;
import graphics.Renderer;

public class Game implements ActionListener, KeyListener {

	public static final int BLOCK_SIZE = 10, GAME_SIZE = 530, SPEED = 3, MIDDLE = (int) (10*(Math.floor(Math.abs((GAME_SIZE/2)/10))));
	
	public static Game game;
	
	public Renderer renderer;
	
	public Snake playerSnake;
	
	public Random rand;
	
	public static void main(String[] args) {
		game = new Game();
	}
	
	public Game() {
		JFrame gameWindow = new JFrame("Snake Game");
		Timer timer = new Timer(20, this);
		
		renderer = new Renderer();
		rand = new Random();
		
		gameWindow.add(renderer);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setSize(GAME_SIZE+18, GAME_SIZE+47);
		gameWindow.addKeyListener(this);
		gameWindow.setVisible(true);
		
		playerSnake = new Snake(MIDDLE, GAME_SIZE - 40, 1, Direction.NORTH);
		
		timer.start();
	}

	public void findMiddle() {
		
	}
	
	public void repaint(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, GAME_SIZE, GAME_SIZE);
		
		Draw.paintSnake(g, playerSnake, true);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
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
