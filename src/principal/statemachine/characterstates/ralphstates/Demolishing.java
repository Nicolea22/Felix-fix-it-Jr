package principal.statemachine.characterstates.ralphstates;

import java.awt.Image;
import principal.statemachine.characterstates.State;
import principal.statemachine.gamestate.GameManager;

public class Demolishing extends State{

	
	private static Demolishing demolishing = new Demolishing();

	private Demolishing(){
		animation = GameManager.animations.getRalphDemolition();
		animUpdate = 300;
	}
	
	public static Demolishing getDemolishing(){
		return demolishing;
	}
	
	@Override
	public Image getImage(int dir) {
		return animation.getActualFrame();
	}
	
}
	

