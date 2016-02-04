package principal.statemachine;

import java.awt.Graphics2D;

public interface GameState {
	
	void draw(final Graphics2D g,long time);

	void tick(long time);
	
}
