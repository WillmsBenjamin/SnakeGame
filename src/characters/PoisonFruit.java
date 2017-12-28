package characters;

import controls.Effect;

public class PoisonFruit extends Fruit {
	
	public PoisonFruit() {
		super();
		effect = Effect.POISON;
	}
	
	public PoisonFruit(int x, int y) {
		super(x, y);
		effect = Effect.POISON;
	}

	@Override
	public void effect(Snake snake) {
		snake.shrink();
	}

}
