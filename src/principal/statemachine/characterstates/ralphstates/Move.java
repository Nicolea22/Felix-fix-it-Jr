package principal.statemachine.characterstates.ralphstates;

import java.awt.Image;

import principal.Game;
import principal.graphics.Animation;
import principal.statemachine.characterstates.State;
import principal.statemachine.gamestate.GameManager;

public class Move extends State{

	private static Move move = new Move();
	
//	String[] paths = {
//		"images/ralph/Moving/0.png",
//		"images/ralph/Moving/1.png",
//	};
	
	
	private Move(){
		animation = Game.animations.getRalphMove();
		animUpdate = 300;
	}
	
	public static Move getMove(){ 
		return move;
	}
	 
	@Override
	public Image getImage(int dir) {
		return animation.getActualFrame();
	}

			
	
	
}
