package principal.statemachine.init;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import principal.HUD;
import principal.Score;
import principal.entities.Building;
import principal.graphics.DrawingSurface;
import principal.input.MouseInput;
import principal.statemachine.GameState;
import principal.statemachine.GameStatus;
import principal.statemachine.gamestate.GameManager;

public class PrincipalMenu implements GameState{

	public Rectangle playButton = new Rectangle(200,150,100,50);
	public Rectangle scoreButton = new Rectangle(200,250,100,50);
	public Rectangle helpButton = new Rectangle(200,350,100,50);
	
	private Font font;
	
	public PrincipalMenu(){
		font = new Font("arial",Font.BOLD,50);
	}
	
	@Override
	public void tick(long beforeTime) {
		if (MouseInput.leftClick) {
			if (playButton.contains(MouseInput.getPointer())){
				GameStatus.states[1] = new GameManager();
				newGame();
			}else
				if (scoreButton.contains(MouseInput.getPointer())){
					GameStatus.changeState(3);
				}else
					if (helpButton.contains(MouseInput.getPointer())){
						GameStatus.changeState(4);
					}
		}
	}

	
	private void newGame() {
		Building.getBuilding().initSectors();
		Building.getBuilding().initActualSectors();
		Building.getBuilding().stopGM();
		HUD.getHud().reset();
		Score.getScore().reset();
		DrawingSurface.resetSurface();
		GameStatus.changeState(1);
	}
	
	@Override
	public void draw(Graphics2D g, long time) {
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Felix, Fix it", 50,100);
		
		
		Font fnt1 = new Font("arial",Font.BOLD,30);
		g.setFont(fnt1);
		
		g.drawString("Play",playButton.x+19,playButton.y+30);
		g.draw(playButton);
		
		g.drawString("Score",scoreButton.x+19,scoreButton.y+30);
		g.draw(scoreButton);
		
		g.drawString("Help",helpButton.x+19,helpButton.y+30);
		g.draw(helpButton);
		
		
	}
	
	
}
