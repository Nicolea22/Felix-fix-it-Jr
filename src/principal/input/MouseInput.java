package principal.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import principal.HUD;
import principal.entities.Building;
import principal.graphics.DrawingSurface;

import principal.statemachine.GameStatus;
import principal.statemachine.gamestate.GameManager;
import principal.statemachine.gamestate.GameRules;
import principal.statemachine.gamestate.PauseMenu;
import principal.statemachine.gamestate.ScoreMenu;
import principal.statemachine.init.PrincipalMenu;

public class MouseInput implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {	
		int mx = e.getX();
		int my = e.getY();
	
		if(mx >= 200 && mx <= 300){
			if(my >= 150 && my <= 200){
				//NEW GAME
				if(GameStatus.actualState instanceof PrincipalMenu){
					//GameStatus.states[1] = new GameManager();
					GameStatus.changeState(1);	
				}
				//MAIN MENU
				if(GameStatus.actualState instanceof PauseMenu){
					GameStatus.changeState(0);	
				}
			}
		}
		
		if(mx >= 200 && mx <= 300){
			if(my >= 250 && my <= 300){
				//SCORE BUTTON
				if(GameStatus.actualState instanceof PrincipalMenu)
					GameStatus.changeState(3);
				//RESUME BUTTON
				if(GameStatus.actualState instanceof PauseMenu){
					GameStatus.changeState(1);	
				}
			}
		}
		
		if(mx >= 200 && mx <= 300){
			if(my >= 350 && my <= 400){
				//HELP BUTTON
				if(GameStatus.actualState instanceof PrincipalMenu)
					GameStatus.changeState(4);
				//RESTART BUTTON
				if(GameStatus.actualState instanceof PauseMenu){
					GameStatus.states[1] = new GameManager();
					Building.getBuilding().initSectors();
					Building.getBuilding().initActualSectors();
					Building.getBuilding().stopGM();
					HUD.getHud().reset();
					DrawingSurface.resetSurface();
					GameStatus.changeState(1);	
				}
			
			}
			
		}
		
		if(mx >= 300 && mx <= 400){
			if(my >= 450 && my <= 500){
				if(GameStatus.actualState instanceof GameRules || GameStatus.actualState instanceof ScoreMenu)
					GameStatus.changeState(0);	
			}
		}
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
