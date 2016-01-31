package principal.statemachine.characterstates.felixstates;

import java.awt.Image;

import principal.graphics.Animation;
import principal.statemachine.characterstates.State;

public class Moving extends State{
	
	private final static Moving moving = new Moving();
	
	private String[] paths = {
		"images/felix/moving/0.png",
		"images/felix/moving/1.png",
		"images/felix/moving/2.png",
		"images/felix/moving/3.png",
	};
	
	private Moving() {
		animation  = new Animation(paths);
		animUpdate = 300;
	}
	
	public static Moving getMoving(){
		return moving;
	}
	
		
	@Override
	public Image getImage() {
		return animation.getActualFrame();
	}
	
	
	

}

