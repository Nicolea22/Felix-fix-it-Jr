package principal.statemachine.characterstates.felixstates;

import java.awt.Image;

import principal.graphics.Animation;
import principal.statemachine.characterstates.State;

public class Falling extends State{

	private String[] paths = {
		"images/felix/jump/0.png",
		"images/felix/jump/1.png"
	};
	
	private static Falling jump = new Falling();
	
	private Falling() {
		animation  = new Animation(paths);
		animUpdate = 2000;
	}
	
	public static State getJumping(){
		return jump;
	}
	
	@Override
	public Image getImage() {
		return animation.getActualFrame();
	}	
	
}
