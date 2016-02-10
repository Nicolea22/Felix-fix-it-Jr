package principal.statemachine.characterstates.ralphstates;

import java.awt.Image;

import principal.Game;
import principal.statemachine.characterstates.State;


public class Climbing extends State{

//	private String[] ralphClimbing = {
//	"images/ralph/Climbing/0.png",
//	"images/ralph/Climbing/1.png",
//	};	
	private static Climbing climb = new Climbing();	


	private Climbing(){
		animation = Game.animations.getClimbing();
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
