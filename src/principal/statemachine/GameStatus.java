package principal.statemachine;

import java.awt.Graphics2D;
import principal.Constant;
import principal.statemachine.gamestate.*;
import principal.statemachine.init.*;

public class GameStatus implements GameState{
	
	public static GameState[] states;
	public static GameState actualState;
	
	
	public GameStatus(){
		initState();
		initActualState();
	}


	private void initState() {
		states = new GameState[Constant.STATES];
		states[0] = new PrincipalMenu();
		states[1] = new GameManager();
		states[2] = new PauseMenu();
		states[3] = new ScoreMenu();
		states[4] = new GameRules();
	}

	
	private void initActualState(){
		actualState = states[0];
	}

	
	public static void changeState(int i) {
		actualState = states[i];
	}
	
	
	@Override
	public void tick(long time) {
		actualState.tick(time);
	}


	@Override
	public void draw(Graphics2D g, long time) {
		actualState.draw(g, time);
	}
	
	
	public GameState getActualState(){
		return actualState;
	}

	
	
}

