package principal.statemachine.characterstates.felixstates;

import java.awt.Image;

import principal.Game;
import principal.statemachine.characterstates.State;


public class Fixing extends State{
	
	private final static Fixing fixing = new Fixing();
	
//	private String[] paths = {
//		"images/felix/fixing/0.png",
//		"images/felix/fixing/1.png"
//	};
	
	private Fixing() {
		animUpdate = 300;
	}
	
	public static Fixing getFixing(){
		return fixing;
	}
	
		
	@Override
	public Image getImage(int dir) {
		if (dir == -1){
			animation = Game.animations.getFelixFixingLeft();
		}else
			animation = Game.animations.getFelixFixingRight();
		return animation.getActualFrame();
	}


	
	
}
