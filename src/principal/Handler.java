package principal;

import java.awt.Graphics2D;
import java.util.ArrayList;

import principal.entities.Building;
import principal.entities.ID;
import principal.entities.Entity;
import principal.entities.creatures.Bird;
import principal.entities.creatures.Brick;
import principal.entities.creatures.Creature;
import principal.statemachine.gamestate.GameManager;


public class Handler {
	
	public static ArrayList<Entity> objects;
	private Entity tempObject;
	
	private Building building;

	
	public Handler() {
		objects = new ArrayList<Entity>();
		this.building = Building.getBuilding();
	}

	
	
	public static boolean add(Entity object) {
		return objects.add(object);
	}
	
	
	
	public static boolean remove(Entity object) {
		return objects.remove(object);
	}

	
	public static void addBrick(float x, float y) {
		int actualSector = Building.getBuilding().getIndexActualSector();
		Brick brick = new Brick((int)x, (int)y , actualSector);
	}
	
	
	public static void removeAll() {
		for (int i = 0; i < objects.size(); i++) {
			Entity e = objects.get(i);
			if (e instanceof Brick || e instanceof Bird) {
				objects.remove(i);
			}
		}
	}
	
	public void tick(long time){
		building.tick(null, time);
		for (int i = 0; i < objects.size(); i++) {
			tempObject = objects.get(i);
			tempObject.tick(objects, time);
		}
	}

	
	
	public void draw(Graphics2D g, long time) {
		building.draw(g, time);
		for (int i = 0; i < objects.size(); i++) {
			tempObject = objects.get(i);
			tempObject.draw(g, time);
		}
	}
	
	public Building getBuilding() {
		return building;
	}
	
	

}
	
