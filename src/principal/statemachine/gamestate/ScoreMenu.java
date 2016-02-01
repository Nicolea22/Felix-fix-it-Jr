package principal.statemachine.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import principal.statemachine.GameState;

public class ScoreMenu implements GameState{

	public Rectangle playButton = new Rectangle(300,450,100,50);
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.white);
		Font fnt1 = new Font("arial",Font.BOLD,15);
		g.setFont(fnt1);	
		String reglas = "NICOLEA 10000000000";
		g.drawString(reglas,100,100);
		
		g.drawString(reglas,100,200);
		
		g.drawString(reglas,100,300);
		
		g.drawString(reglas,100,400);
		
		g.drawString("Back",playButton.x+19,playButton.y+30);
		g.draw(playButton);
		
		
	}

}
