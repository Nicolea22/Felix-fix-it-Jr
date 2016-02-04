package principal.statemachine.characterstates.felixstates;

import java.awt.Image;

import principal.graphics.Animation;
import principal.statemachine.characterstates.State;

public class Fixing extends State{
	
	private final static Fixing fixing = new Fixing();
	
	private String[] paths = {
		"images/felix/fixing/0.png",
		"images/felix/fixing/1.png"
	};
	
	private Fixing() {
		animation  = new Animation(paths);
		animUpdate = 300;
	}
	
	public static Fixing getFixing(){
		return fixing;
	}
	
		
	@Override
	public Image getImage(int dir) {
		return animation.getActualFrame();
	}


	
	
}
