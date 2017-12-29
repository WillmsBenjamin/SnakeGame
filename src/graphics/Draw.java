package graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import characters.Snake;
import characters.Walls;
import game.Game;

public class Draw {
	
	public static void paintSnake(Graphics2D g, Snake snake, Color snakeColor) {
		g.setColor(snakeColor);
		for(Rectangle bodyPart : snake.getBodyParts()) {
			g.fillRect(bodyPart.x, bodyPart.y, bodyPart.width, bodyPart.height);
		}
	}
	
	public static void paintWalls(Graphics2D g, Walls walls) {
		g.setColor(walls.getWallColor());
		for(Rectangle wall : walls.getEdges()) {
			g.fillRect(wall.x, wall.y, wall.width, wall.height);
		}
	}
	
	public static void paintBackground(Graphics2D g) {
		g.setColor(Game.BACKGROUND_COLOR);
		g.fillRect(0, 0, Game.GAME_SIZE, Game.GAME_SIZE);
	}
}
