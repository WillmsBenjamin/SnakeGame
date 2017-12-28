package graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import characters.Snake;

public class Draw {
	
	public static void paintSnake(Graphics2D g, Snake snake, boolean isPlayer) {
		if(isPlayer) {
			g.setColor(Color.cyan);
			for(Rectangle bodyPart : snake.getBodyParts()) {
				g.fillRect(bodyPart.x, bodyPart.y, bodyPart.width, bodyPart.height);
			}
		} else {
			g.setColor(Color.red);
			for(Rectangle bodyPart : snake.getBodyParts()) {
				g.fillRect(bodyPart.x, bodyPart.y, bodyPart.width, bodyPart.height);
			}
		}
	}
}
