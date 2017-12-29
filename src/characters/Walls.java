package characters;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.LinkedList;

import game.Game;

public class Walls {
	
	private LinkedList<Rectangle> edges;
	
	private boolean hasGaps;
	
	private Color wallColor;


	/**
	 * @author Benjamin Willms, 2017-12-29
	 * 
	 * Creates a generic set of 4 white rectangles that surround the playing
	 * area of the snake game. They are one BLOCK_SIZE thick, following the
	 * "grid" structure of the map.
	 */
	public Walls() {
		wallColor = Color.white;
		hasGaps = false;
		edges = new LinkedList<Rectangle>();
		edges.add(new Rectangle(0, 0, Game.GAME_SIZE, Game.BLOCK_SIZE));
		edges.add(new Rectangle(0, 0, Game.BLOCK_SIZE, Game.GAME_SIZE));
		edges.add(new Rectangle(0, Game.GAME_SIZE - Game.BLOCK_SIZE, Game.GAME_SIZE, Game.BLOCK_SIZE));
		edges.add(new Rectangle(Game.GAME_SIZE - Game.BLOCK_SIZE, 0, Game.BLOCK_SIZE, Game.GAME_SIZE));
	}
	
	/**
	 * @author Benjamin Willms, 2017-12-29
	 * 
	 * @param hasGaps	: Whether the walls have gaps (centered, on the top and bottom walls).
	 * @param wallColor	: The color that the walls should be painted.
	 * 
	 * Creates a set of rectangles along the outside of the playing area of the snake game. 
	 * These have a selectable color, and can have 2 gaps (one at the middle of the top wall,
	 * and one at the middle of the bottom wall). They are one BLOCK_SIZE thick, following the
	 * "grid" structure of the map.
	 */
	public Walls(boolean hasGaps, Color wallColor) {
		this.wallColor = wallColor;
		this.hasGaps = hasGaps;
		edges = new LinkedList<Rectangle>();
		if(this.hasGaps == true) {
			edges.add(new Rectangle(0, 0, Game.MIDDLE, Game.BLOCK_SIZE));
			edges.add(new Rectangle(Game.MIDDLE + Game.BLOCK_SIZE , 0, Game.MIDDLE, Game.BLOCK_SIZE));
			edges.add(new Rectangle(0, 0, Game.BLOCK_SIZE, Game.GAME_SIZE));
			edges.add(new Rectangle(0, Game.GAME_SIZE - Game.BLOCK_SIZE, Game.MIDDLE, Game.BLOCK_SIZE));
			edges.add(new Rectangle(Game.MIDDLE + Game.BLOCK_SIZE, Game.GAME_SIZE - Game.BLOCK_SIZE, Game.MIDDLE, Game.BLOCK_SIZE));
			edges.add(new Rectangle(Game.GAME_SIZE - Game.BLOCK_SIZE, 0, Game.BLOCK_SIZE, Game.GAME_SIZE));
		} else {
			edges.add(new Rectangle(0, 0, Game.GAME_SIZE, Game.BLOCK_SIZE));
			edges.add(new Rectangle(0, 0, Game.BLOCK_SIZE, Game.GAME_SIZE));
			edges.add(new Rectangle(0, Game.GAME_SIZE - Game.BLOCK_SIZE, Game.GAME_SIZE, Game.BLOCK_SIZE));
			edges.add(new Rectangle(Game.GAME_SIZE - Game.BLOCK_SIZE, 0, Game.BLOCK_SIZE, Game.GAME_SIZE));
		}
	}

	/**
	 * @return the edges
	 */
	public LinkedList<Rectangle> getEdges() {
		return edges;
	}

	/**
	 * @return whether the walls have 2 gaps or not.
	 */
	public boolean hasGaps() {
		return hasGaps;
	}

	/**
	 * @return the wallColor
	 */
	public Color getWallColor() {
		return wallColor;
	}
}
