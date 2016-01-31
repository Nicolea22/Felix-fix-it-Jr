package principal.statemachine.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import principal.statemachine.GameState;

public class GameRules implements GameState{

	public Rectangle playButton = new Rectangle(300,450,100,50);
	
	@Override
	public void tick() {
		
	}

	@Override
	public void draw(Graphics2D g) {
		
		g.setColor(Color.white);
		Font fnt1 = new Font("arial",Font.BOLD,15);
		g.setFont(fnt1);	
		String reglas = "Las reglas son muy faciles, para ganar hay que reparar el edificio";
		g.drawString(reglas,100,100);
		reglas = "Muevete con las flechas y con espacio arregla las ventanas. Pausa el juego con ESC.";
		g.drawString(reglas,100,200);
		reglas = "Recuerda esquivar todos los ladrillos y aves que cruces en tu camino.";
		g.drawString(reglas,100,300);
		reglas = "Buena suerte invocador y recuerda ARREGLA TODO!";
		g.drawString(reglas,100,400);
		
		g.drawString("Back",playButton.x+19,playButton.y+30);
		g.draw(playButton);
		
	}

}
