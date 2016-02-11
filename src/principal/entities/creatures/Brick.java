package principal.entities.creatures;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import principal.Constant;
import principal.Game;
import principal.Handler;
import principal.Level;
import principal.entities.Building;
import principal.entities.Entity;
import principal.entities.ID;
import principal.graphics.Animation;
import principal.statemachine.gamestate.GameManager;

public class Brick extends Creature {
	
	private Animation brick;
	
	private int actualSector; 
	
	public Brick(float x, float y, int actualSector) {
		super(x,y);
		brick = Game.animations.getBrick();
		
		vel = Level.getLevel().getBrickVel();
		
//		System.out.println( "brick: " + Level.getLevel().getBrickVel());
		
		this.actualSector = actualSector;
		id = ID.Brick;
		brick = Game.animations.getBrick();
		
		Handler.add(this);
	}

	@Override
	public String getName() {
		return "Brick";
	}

	@Override
	public void draw(Graphics2D g, long time) {
		brick.tick();
		g.drawImage(brick.getActualFrame(), (int)getX(), (int)getY(), null);
		
//		g.draw(getBounds());
	}

	@Override
	public void tick(ArrayList<Entity> creat, long BeforeTime) {
				
		Building b = Building.getBuilding();
		
		setY(getY() + vel);

		if (getY() > b.getSector(actualSector).getBotBounds().y + 100) {
			Handler.remove(this);
		}
	}

	
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)getX(), (int)getY(), 18, 12);
	}

	@Override
	public Rectangle getTopBounds() {
		return new Rectangle(0,0,0,0);
	}

	@Override
	public Rectangle getLeftBounds() {
		return new Rectangle(0,0,0,0);
	}

	@Override
	public Rectangle getRightBounds() {
		return new Rectangle(0,0,0,0);
	}

	@Override
	public Rectangle getBotBounds() {
		return new Rectangle(0,0,0,0);
	}
	
	
}
