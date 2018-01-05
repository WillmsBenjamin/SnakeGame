package characters;

import java.awt.Rectangle;
import java.util.LinkedList;

import controls.Direction;
import game.Game;

/**
 * @author Benjamin Willms. Completed 2017-12-28.
 * 
 * Represents a snake for the snake game. A snake consists of a LinkedList of Rectangles
 * known as bodyParts (sized according to Game.BLOCK_SIZE), and a direction of travel.
 * The class allows a snake of any size to be created, and allows slithering by one block
 * per call of slither(). It also allows the snake to grow in size by calling eat(). The
 * snake grows by one body part per call of eat().
 *
 */
public class Snake {
	
	private LinkedList<Rectangle> bodyParts;
	
	private Direction headDirection;

	public Snake() {
		bodyParts = new LinkedList<Rectangle>();
		headDirection = Direction.NONE;
	}
	
	/**
	 * @author Benjamin Willms, 2017-12-28
	 * 
	 * @param startX			: The starting x-coordinate of the new snake.
	 * @param startY			: The starting y-coordinate of the new snake.
	 * @param length			: The selected length of the new snake.
	 * @param startDirection	: The direction that the new snake will be facing.
	 * 
	 * Creates a new snake of the specified length, facing the specified direction,
	 * beginning at the specified coordinates (top left of the head). 
	 */
	public Snake(int startX, int startY, int length, Direction startDirection) {
		bodyParts = new LinkedList<Rectangle>();
		
		headDirection = startDirection;
		
		/*
		 * This sets the starting snake to be built with proper coordinates of each piece,
		 * based on the selected starting direction (where it is facing). 
		 */
		switch(startDirection) {
			case NORTH:  {
				addPartsStart(startX, startY, length, 0, Game.BLOCK_SIZE);
				break;
			}
			case EAST: {
				addPartsStart(startX, startY, length, Game.BLOCK_SIZE * (-1), 0);
				break;
			}
			case SOUTH: {
				addPartsStart(startX, startY, length, 0, Game.BLOCK_SIZE * (-1));
				break;
			}
			case WEST: {
				addPartsStart(startX, startY, length, Game.BLOCK_SIZE, 0);
				break;
			}
			default: {
				break;
			}
		}
			
		
	}

	/**
	 * @author Benjamin Willms, 2017-12-28
	 * 
	 * @param startX   	: The starting X-coordinate of the head (top left).
	 * @param startY   	: The starting Y-coordinate of the head (top left).
	 * @param numParts 	: The number of body parts to be added.
	 * @param shiftX   	: The amount of space in the x-direction that separates 2 body parts.
	 * @param shiftY   	: The amount of space in the y-direction that separates 2 body parts.
	 * 
	 * Adds the selected number of body parts to the snake, with coordinates controlled by the shift and start values.
	 * Each body part's size is controlled by Game.BLOCK_SIZE.
	 * SHOULD ONLY BE USED WHEN INITIALIZING A NEW SNAKE.
	 * 
	 */
	private void addPartsStart(int startX, int startY, int numParts, int shiftX, int shiftY) {
		for (int i = 0; i < numParts; i++) {
			bodyParts.addLast(new Rectangle(startX + (i * shiftX), startY + (i * shiftY), Game.BLOCK_SIZE, Game.BLOCK_SIZE));
		}
	}
	
	/**
	 * @author Benjamin Willms, 2017-12-28
	 * 
	 * Causes the snake's length to grow, by adding a duplicate last rectangle.
	 * This avoids collisions due to tail growth, and lets the new rectangle be viewed
	 * the next time slither(direction) is called.
	 */
	public void grow() {
		bodyParts.addLast(new Rectangle(bodyParts.getLast().x, bodyParts.getLast().y, Game.BLOCK_SIZE, Game.BLOCK_SIZE));
	}
	
	/**
	 * @author Benjamin Willms, 2017-12-28
	 * 
	 * Causes the snake's length to shrink, by removing the last rectangle.
	 */
	public void shrink() {
		bodyParts.removeLast();
	}
	
	/**
	 * @author Benjamin Willms, 2017-12-28
	 * 
	 * @param direction	: The selected direction of snake motion.
	 * 
	 * Moves the snake by one BLOCK_SIZE in the selected direction, keeping the snake length constant.
	 */
	public void slither(Direction direction) {
		
		Rectangle currentHead = bodyParts.getFirst();
		
		headDirection = direction;
		bodyParts.removeLast();
		
		switch(headDirection) {
			case NORTH:  {
				if (currentHead.y - Game.BLOCK_SIZE < 0) {
					bodyParts.addFirst(new Rectangle(currentHead.x, Game.GAME_SIZE - Game.BLOCK_SIZE, Game.BLOCK_SIZE,
							Game.BLOCK_SIZE));
				} else {
					bodyParts.addFirst(new Rectangle(currentHead.x, currentHead.y - Game.BLOCK_SIZE, Game.BLOCK_SIZE,
							Game.BLOCK_SIZE));
				}
				break;
			}
			case EAST: {
				bodyParts.addFirst(new Rectangle(currentHead.x + Game.BLOCK_SIZE, currentHead.y, Game.BLOCK_SIZE, Game.BLOCK_SIZE));
				break;
			}
			case SOUTH: {
				if (currentHead.y + Game.BLOCK_SIZE >= Game.GAME_SIZE) {
					bodyParts.addFirst(new Rectangle(currentHead.x, 0, Game.BLOCK_SIZE,
							Game.BLOCK_SIZE));
				} else {
					bodyParts.addFirst(new Rectangle(currentHead.x, currentHead.y + Game.BLOCK_SIZE, Game.BLOCK_SIZE,
							Game.BLOCK_SIZE));
				}
				break;
			}
			case WEST: {
				bodyParts.addFirst(new Rectangle(currentHead.x - Game.BLOCK_SIZE, currentHead.y, Game.BLOCK_SIZE, Game.BLOCK_SIZE));
				break;
			}
			default: {
				break;
			}
		}
	}
	
	/**
	 * @author Benjamin Willms, 2017-12-28
	 * 
	 * @return the list of bodyParts.
	 */
	public LinkedList<Rectangle> getBodyParts() {
		return bodyParts;
	}
	
	/**
	 * @return the headDirection
	 */
	public Direction getHeadDirection() {
		return headDirection;
	}
}
