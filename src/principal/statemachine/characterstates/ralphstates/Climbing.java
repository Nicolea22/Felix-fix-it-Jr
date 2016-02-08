package principal.statemachine.characterstates.ralphstates;

import java.awt.Image;

import principal.graphics.Animation;
import principal.statemachine.characterstates.State;
import principal.statemachine.gamestate.GameManager;

public class Climbing extends State{

	private static Climbing climb = new Climbing();

	private String[] ralphClimbing = {
		"images/ralph/Climbing/0.png",
		"images/ralph/Climbing/1.png",
	};

	

	private Climbing(){
		animation = new Animation(ralphClimbing);
		animUpdate = 600;
	}
	
	public static Climbing getClimbing(){
		return climb;
	}
	
	@Override
	public Image getImage(int dir) {
		return animation.getActualFrame();
	}

	
}
