package principal.statemachine;

import java.awt.Graphics2D;

public interface GameState {
	
	void tick();
	
	void draw(final Graphics2D g);
	
}
