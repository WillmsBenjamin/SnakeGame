package graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import characters.NutritiousFruit;
import characters.PoisonousFruit;
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
	
	public static void paintNutritiousFruit(Graphics2D g, NutritiousFruit fruit) {
		g.setColor(Color.red.brighter());
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
		g.fill(fruit.getFruit());
	}
	
	public static void paintPoisonousFruit(Graphics2D g, PoisonousFruit fruit) {
		g.setColor(Color.green.brighter());
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
		g.fill(fruit.getFruit());
	}
}
