package principal.entities.creatures;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import principal.Constant;
import principal.Game;
import principal.entities.Entity;
import principal.graphics.Sprite;


public class Cloud extends Creature{
		
	private Sprite sprite;
	
	public Cloud(float x, float y){
		super(x,y);
		setDx(.2f);
		
		sprite = Game.animations.getCloud();
	}
	
	
	public void tick(ArrayList<Entity> creat, long beforeTime){
		if (getX() > Constant.WIDTH + sprite.getImage().getWidth(null)){
			reset();
		}
		setX(getX() + getDx());
		setY(getY() + getDy());
	}
	
	
	private void reset(){
		setX(- sprite.getImage().getWidth(null));
	}
	
	public void draw(Graphics2D g, long time){
		g.drawImage(sprite.getImage(), (int)getX(), (int)getY(), null);
	}


	@Override
	public String getName() {
		return "Cloud";
	}


	@Override
	public Rectangle getTopBounds() {
		return null;
	}


	@Override
	public Rectangle getLeftBounds() {
		return null;
	}


	@Override
	public Rectangle getRightBounds() {
		return null;
	}


	@Override
	public Rectangle getBotBounds() {
		return null;
	}


	@Override
	public Rectangle getBounds() {
		return null;
	}
	
}
