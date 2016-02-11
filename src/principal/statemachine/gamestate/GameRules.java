package principal.statemachine.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import principal.input.MouseInput;
import principal.statemachine.GameState;
import principal.statemachine.GameStatus;

public class GameRules implements GameState{

	public Rectangle backButton = new Rectangle(300,450,100,50);
	
	private Font font;
	
	public GameRules(){
		font = new Font("Arial",Font.BOLD,15);
	}
	
	@Override
	public void tick(long time) {
		if (MouseInput.leftClick) {
			if (backButton.contains(MouseInput.getPointer())){
				GameStatus.changeState(0);
			}
		}
	}

	@Override
	public void draw(Graphics2D g, long time) {
		
		g.setColor(Color.white);
		g.setFont(font);	
		
		String rules = "Para ganar tenes que arreglar el edificio completo";
		g.drawString(rules,100, 150);
		
		rules = "Movete con las flechas y con el espacio arreglas las ventanas. Pausa el juego con ESC.";
		g.drawString(rules,100,200);
		
		rules = "Esquiva todos los ladrillos y aves que cruces en tu camino.";
		g.drawString(rules,100,250);
		
		rules = "Los nicelander te ofrecen pasteles ¡cuidado no los golpees con el martillo!.";
		g.drawString(rules,100,300);
		
		rules = "También podes elegir el nivel en el que quieras empezar a jugar.";
		g.drawString(rules,100,350);
		
		g.drawString("Back",backButton.x + 19, backButton.y+ 30);
		g.draw(backButton);
		
	}

}
