package controls;

import java.awt.Rectangle;
import java.util.ArrayList;

import game.Game;
import game.GameMode;
import game.GameState;

public class SnakeAI {

	public SnakeAI() {
		
	}
	
	
	/**
	 * The idea is to check valid moves (not back along the snake's body). The AI then refines these through rules:
	 * 1. If the valid move hits a wall, poisonous fruit, or snake, set it as invalid.
	 * 2. If there are no valid moves, select the one that hits the poisonous fruit (if it exists). Otherwise, select one at
	 * 		random.
	 * 3. The snake now only has valid moves. So it selects the one that results in the shortest distance to the good fruit.
	 * NOTE: The snake ignores wall gaps, for the sake of complexity. I also realize that the snake may wall itself in,
	 * but the AI should be good enough for our purposes. 
	 * 
	 * @author Benjamin Willms, 2018-01-07
	 */
	public static void calculateComputerMove() {
		ArrayList<Direction> validMoves = new ArrayList<Direction>();
		Direction badFruitMove = null, bestMove = null;
		int[] checkCoord = new int[2], bestMoveDist = new int[2];

		//Set up initial valid moves (no turning back rule)
		switch(Game.game.getComputerSnake().getHeadDirection()) {
		case NORTH : {
			validMoves.add(Direction.NORTH);
			validMoves.add(Direction.EAST);
			validMoves.add(Direction.WEST);
			break;
		}
		case SOUTH : {
			validMoves.add(Direction.SOUTH);
			validMoves.add(Direction.EAST);
			validMoves.add(Direction.WEST);
			break;
		}
		case EAST : {
			validMoves.add(Direction.NORTH);
			validMoves.add(Direction.EAST);
			validMoves.add(Direction.SOUTH);
			break;
		}
		case WEST : {
			validMoves.add(Direction.NORTH);
			validMoves.add(Direction.SOUTH);
			validMoves.add(Direction.WEST);
			break;
		}
		default : {
			break;
		}
		}

		//Check the valid moves for hitting walls, snakes, or poisonous fruit (keep track of the poisonous fruit move).
		for(int i = 0; i<validMoves.size(); i++) {

			//Setup the coordinate that the valid move would bring the head to.
			switch(validMoves.get(i)) {
			case NORTH : {
				checkCoord[0] = Game.game.getComputerSnake().getBodyParts().getFirst().x;
				checkCoord[1] = Game.game.getComputerSnake().getBodyParts().getFirst().y - Game.BLOCK_SIZE;
				break;
			}
			case SOUTH : {
				checkCoord[0] = Game.game.getComputerSnake().getBodyParts().getFirst().x;
				checkCoord[1] = Game.game.getComputerSnake().getBodyParts().getFirst().y + Game.BLOCK_SIZE;
				break;
			}
			case EAST : {
				checkCoord[0] = Game.game.getComputerSnake().getBodyParts().getFirst().x + Game.BLOCK_SIZE;
				checkCoord[1] = Game.game.getComputerSnake().getBodyParts().getFirst().y;
				break;
			}
			case WEST : {
				checkCoord[0] = Game.game.getComputerSnake().getBodyParts().getFirst().x - Game.BLOCK_SIZE;
				checkCoord[1] = Game.game.getComputerSnake().getBodyParts().getFirst().y;
				break;
			}
			default : {
				break;
			}
			}

			//Check if the coordinate hits an obstacle (keep track of the poisonous fruit move).
			if(checkCoord[0] == Game.game.getBadFruit().getFruit().x && checkCoord[1] == Game.game.getBadFruit().getFruit().y) { //Poisonous fruit hitting.
				badFruitMove = validMoves.remove(i);
			} else if(checkCoord[0] == 0 || checkCoord[0] == Game.GAME_SIZE-Game.BLOCK_SIZE ||
					checkCoord[1] == 0 || checkCoord[1] == Game.GAME_SIZE-Game.BLOCK_SIZE) { //Wall hitting.
				validMoves.remove(i);
			}
			for(Rectangle rect : Game.game.getPlayerOneSnake().getBodyParts()) { //Player snake hitting
				if(checkCoord[0] == rect.x && checkCoord[1] == rect.y) {
					validMoves.remove(i);
					break;
				}
			}
			for(Rectangle rect : Game.game.getComputerSnake().getBodyParts()) { //Snake hitting itself;
				if(checkCoord[0] == rect.x && checkCoord[1] == rect.y) {
					validMoves.remove(i);
					break;
				}
			}
		}

		//Select the best valid move.
		if(validMoves.size() == 0 && badFruitMove != null) {
			Game.game.setComputerControl(badFruitMove);
		} else if(validMoves.size() == 0) {
			//let the snake go straight to its doom (do not change the control).
		} else {
			bestMoveDist[0] = Game.GAME_SIZE;
			bestMoveDist[1] = Game.GAME_SIZE;
			for(int i = 0; i<validMoves.size(); i++) {
				int[] moveDist = new int[2];

				//Setup the coordinate that the valid move would bring the head to.
				switch(validMoves.get(i)) {
				case NORTH : {
					checkCoord[0] = Game.game.getComputerSnake().getBodyParts().getFirst().x;
					checkCoord[1] = Game.game.getComputerSnake().getBodyParts().getFirst().y - Game.BLOCK_SIZE;
					break;
				}
				case SOUTH : {
					checkCoord[0] = Game.game.getComputerSnake().getBodyParts().getFirst().x;
					checkCoord[1] = Game.game.getComputerSnake().getBodyParts().getFirst().y + Game.BLOCK_SIZE;
					break;
				}
				case EAST : {
					checkCoord[0] = Game.game.getComputerSnake().getBodyParts().getFirst().x + Game.BLOCK_SIZE;
					checkCoord[1] = Game.game.getComputerSnake().getBodyParts().getFirst().y;
					break;
				}
				case WEST : {
					checkCoord[0] = Game.game.getComputerSnake().getBodyParts().getFirst().x - Game.BLOCK_SIZE;
					checkCoord[1] = Game.game.getComputerSnake().getBodyParts().getFirst().y;
					break;
				}
				default : {
					break;
				}
				}

				//Check the distance to the fruit.
				moveDist[0] = (int) Math.abs(Game.game.getGoodFruit().getFruit().x - checkCoord[0]);
				moveDist[1] = (int) Math.abs(Game.game.getGoodFruit().getFruit().y - checkCoord[1]);

				if(moveDist[0] + moveDist[1] < bestMoveDist[0] + bestMoveDist[1]) {
					bestMoveDist = moveDist;
					bestMove = validMoves.get(i);
				}
			}
			Game.game.setComputerControl(bestMove);

		}			
	}	
}
