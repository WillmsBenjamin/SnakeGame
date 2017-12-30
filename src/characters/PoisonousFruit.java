package characters;

import controls.Effect;

public class PoisonousFruit extends Fruit {
	
	public PoisonousFruit() {
		super();
		effect = Effect.POISON;
	}
	
	public PoisonousFruit(int x, int y) {
		super(x, y);
		effect = Effect.POISON;
	}

	@Override
	public void effect(Snake snake) {
		snake.shrink();
	}

}
