package principal;

import principal.physics.Position;

public class Camera {

	private Position position;
	
	
	public Camera(float x, float y){
		position = new Position(x,y);
	}
	
	
	public void tick(){
		position.setY(getY() + .9f);
	}
	
	public float getX(){
		return position.getX();
	}
	
	
	public float getY(){
		return position.getY();
	}

	
	public void setX(float x){
		position.setX(x);
	}
	
	
	public void setY(float y){
		position.setY(y);
	}
	
}
