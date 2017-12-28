package characters;

import controls.Effect;

public class NutritiousFruit extends Fruit {

	public NutritiousFruit() {
		super();
		effect = Effect.GROW;
	}
	
	public NutritiousFruit(int x, int y) {
		super(x, y);
		effect = Effect.GROW;
	}
	
	@Override
	public void effect(Snake snake) {
		snake.grow();
	}

}
