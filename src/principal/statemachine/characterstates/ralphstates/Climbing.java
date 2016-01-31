package principal.statemachine.characterstates.ralphstates;

import java.awt.Image;

import principal.graphics.Animation;
import principal.statemachine.characterstates.State;

public class Climbing extends State{

private static Climbing climb = new Climbing();
	
	String[] paths = {
		"images/ralph/Climbing/0.png",
		"images/ralph/Climbing/1.png",
	};
	
	
	private Climbing(){
		animation = new Animation(paths);
		animUpdate = 400;
	}
	
	public static Climbing getClimbing(){
		return climb;
	}
	
	@Override
	public Image getImage() {
		return animation.getActualFrame();
	}
	
}
