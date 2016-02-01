package principal.statemachine.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import principal.Score;
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
		
		for (int i=0; i<4;i++){
			String reglas = Score.getScore().getCertainNamee(i)+": "+Score.getScore().getCertainScore(i);
			g.drawString(reglas,100,(i+1)*100);
		}

		g.drawString("Back",playButton.x+19,playButton.y+30);
		g.draw(playButton);
		
		
	}

}
