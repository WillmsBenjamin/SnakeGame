package characters;

import java.awt.geom.Ellipse2D;

import controls.Effect;
import game.Game;

public abstract class Fruit {
	
	private Ellipse2D.Double fruit;

	protected Effect effect;
	
	public Fruit() {
		fruit = new Ellipse2D.Double(0, 0, Game.BLOCK_SIZE, Game.BLOCK_SIZE);
	}
	
	public Fruit(int x, int y) { 
		fruit = new Ellipse2D.Double(x, y, Game.BLOCK_SIZE, Game.BLOCK_SIZE);
	}
	
	public abstract void effect(Snake snake);
	
	/**
	 * @return the fruit
	 */
	public Ellipse2D.Double getFruit() {
		return fruit;
	}

	/**
	 * @return the effect
	 */
	public Effect getEffect() {
		return effect;
	}
}
