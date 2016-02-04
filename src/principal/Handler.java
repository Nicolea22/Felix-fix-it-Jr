package principal;

import java.awt.Graphics2D;
import java.util.ArrayList;

import principal.entities.Building;
import principal.entities.ID;
import principal.entities.creatures.Creature;


public class Handler {
	
	public static ArrayList<Creature> objects;
	private Creature tempObject;
	
	private Building building;

	
	public Handler() {
		objects = new ArrayList<Creature>();
		this.building = Building.getBuilding();
	}

	
	
	public boolean add(Creature object) {
		return objects.add(object);
	}
	
	
	
	public boolean remove(Creature object) {
		return objects.remove(object);
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
	
