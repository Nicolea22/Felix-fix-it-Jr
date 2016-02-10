package principal.entities.creatures;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import principal.Constant;
import principal.Handler;
import principal.Score;
import principal.entities.Building;
import principal.entities.Entity;
import principal.entities.ID;
import principal.entities.windows.Window;
import principal.input.KeyBoard;
import principal.physics.Position;
import principal.statemachine.GameStatus;
import principal.statemachine.characterstates.felixstates.Falling;
import principal.statemachine.characterstates.felixstates.Fixing;
import principal.statemachine.characterstates.felixstates.Immune;
import principal.statemachine.characterstates.felixstates.Moving;
import principal.statemachine.characterstates.felixstates.Normal;

public class Felix extends Creature {
	
	/*
	 * Diferentes estados:
	 * 		Normal.getNormal() 	
	 * 		Moving.getMoving()
	 * 		Fixing.getFixing()
	 * 		Jumping.getJumping()
	 * 		Immune.getImmune()
	 */
	
	private final float JUMP_SPEED = -10f;
	private final float MAX_JUMP = -80;// la velocidad de salto es negativa y la gravedad positiva
	
	private final float VEL = 3f;
	
	private final long IMMUNE_DEATH = 2000;
	private final long IMMUNE_CAKE = 7000;
		
	private long immuneDuration;
	
	private long movDelay = System.currentTimeMillis();
	private long delay = System.currentTimeMillis();
	private long inmTime;
	private float max_jump = 0;
	
	private float death_x;
	private float death_y;
	
	private boolean dying;
	
	private boolean onObstacle;
	private boolean onGround;
	private boolean falling;
	
	private boolean isImmune;
	
	private int life;
	
	
	public Felix(float x, float y) {
		super(x, y);
		
		life = 3;
		state = Normal.getNormal();
			
		onObstacle = false;
		onGround = false;
		falling = false;
		isImmune = false;
		
		directionX = 1;
		id = ID.Felix;
		
		width = 20;
		height = 50;
	}	

	
	
	public void tick(ArrayList<Entity> ent, long beforeTime) {
		
		if (!dying){
			stopFalling();
			checkImmune(beforeTime);
			checkButtons(ent, beforeTime);
			collision(ent, beforeTime);
		}else{
			setY(getY() + 3f);
			if (Building.getBuilding().getActualSector().getBotBounds().y + 100 < getY()){
				dying = false;
				reset(death_x,death_y);
			}
		}
			
		checkStates();
		
	}



	private void checkButtons(ArrayList<Entity> ent, long beforeTime) {
		setDx(getInputX(ent));
		setX(getX() + getDx());
			    
		setDy(getInputY(ent,beforeTime));
		setY(getY() + getDy());
	}


	private void checkImmune(long beforeTime) {
		if (isImmune) {
			if (beforeTime - inmTime > immuneDuration) {
				isImmune = false;
			}
				
		}
	}

		
		
// 		setX(e.getX() + 17);
// 		setX(e.getX() + 269);
		
	private void checkStates() {
		
		if (dying) {
			state = Falling.getFalling();
		}
		
		if (KeyBoard.fix && onGround && !dying) {
			state = Fixing.getFixing();
		}
		
		if (isImmune && !KeyBoard.fix && !dying){
			state = Immune.getImmune();
		}
		
		if (getDx() == 0 && getDy() == 0 && !KeyBoard.fix && !isImmune && !dying) {
			state = Normal.getNormal();
		}
			
		
		if ((getDx() != 0 || getDy() != 0) && !isImmune) {
			state = Moving.getMoving();
		}
	}
	
	
	private void collision(ArrayList<Entity> ent, long beforeTime) {
		buildingCollision();
		windowCollision(beforeTime);
		
		for (int i = 0; i < ent.size(); i++) {
			Entity e = ent.get(i);
			ralphCollision(e);
			brickCollision(e, beforeTime);
			birdCollision(e, beforeTime);
			cakeCollision(e, beforeTime);
		}
	}
	

	
	private void windowCollision(long beforeTime) {	
		Window[] windows = Building.getBuilding().getActualWindows();
		for (int i = 0; i < windows.length; i++) {
			Window w = windows[i];
			
			// 300 ms entre cada golpe de delay para coordinarlo con el arreglo
			if(w.getBounds().contains(getBounds()) && KeyBoard.fix && beforeTime - movDelay > 300) {
				movDelay = System.currentTimeMillis();
				w.removeNicelander();
				w.getFixed();
			}
			
			if (getBotBounds().intersects(w.getBotBounds())) {
				onGround = true;
			}
			
			doubleDoorsCollision(w);
			obstacleCollision(w);
		}
	}
	
	
	 private void obstacleCollision(Window w) {
		 
//		  if(getTopBounds().intersects(w.getTopBounds()) && w.hasRoof()){
//			  setY(w.getY());
//		  }
//		  
//		  if(getBotBounds().intersects(w.getTopBounds()) && w.hasRoof()){
//			  setY(w.getY()- 32);
//		  }
//		  
//		  if(getTopBounds().intersects(w.getBotBounds()) && w.hasFlowerPot()){
//			  setY(w.getY()+ 32);
//		  }
//		  
//		  if(getBotBounds().intersects(w.getBotBounds()) && w.hasFlowerPot()){
//			  setY(w.getY());
//		  }
	}
	

	private void doubleDoorsCollision(Window w) {
		if (getLeftBounds().intersects(w.getLeftBounds())) {
			setX(w.getX() - 6);
		}
		
		if (getRightBounds().intersects(w.getLeftBounds())) {
			setX(w.getX() - 19);
		}
		
		if (getLeftBounds().intersects(w.getRightBounds())) {
			setX(w.getX() + 27);
		}
		
		if (getRightBounds().intersects(w.getRightBounds())) {
			setX(w.getX() + 12);
		}
		
		if (getBotBounds().intersects(w.getRightBounds()) || getBotBounds().intersects(w.getLeftBounds())) {
			onObstacle = true;
			onGround = true;
		}
	}
	
	
	
	private void brickCollision(Entity e, long beforeTime) {
//		if (e.getID() == ID.Brick) {
		if (e instanceof Brick) {
			if(getTopBounds().intersects(e.getBounds()) && !isImmune) {
				setY(getY());
				savePosition(e);
				decLife(beforeTime);
				Handler.remove(e);
				setImmune(IMMUNE_DEATH);
			}
		}
	}

	private void birdCollision(Entity e, long beforeTime) {
//		if (e.getID() == ID.Bird) {
		if (e instanceof Bird) {
			if(getAllBounds().intersects(e.getBounds()) && !isImmune) {	
				setY(getY());
				savePosition(e);
				decLife(beforeTime);
				Handler.remove(e);
				setImmune(IMMUNE_DEATH);
			}
		}
	}

	

	private void ralphCollision(Entity e) {
//		if (e.getID() == ID.Ralph){
		if (e instanceof Ralph)
			if (getTopBounds().intersects(e.getBounds())) {
				setY(e.getY() + 82);
				max_jump = MAX_JUMP;
			}
//		}
	}

	
	private void cakeCollision(Entity e, long beforeTime) {
		if (e.getID() == ID.Cake) { 
			if (getAllBounds().intersects(e.getBounds())) {
				setImmune(IMMUNE_CAKE);
				Handler.remove(e);
			}
		}
	}
	
	
	private void setImmune(long immuneTime) {
		inmTime = System.currentTimeMillis();
		isImmune = true;
		immuneDuration = immuneTime;
	}
	
	
	private void savePosition(Entity e) {
		death_x = e.getX() - 10;
		death_y = e.getY() - 10;
	}
	
	
	private void buildingCollision() {
		
		Building b = Building.getBuilding();
		
		
		if (getLeftBounds().intersects(b.getLeftBounds())){
			setX(Building.getBuilding().getX() + 6);
		}
		
		
		if (getRightBounds().intersects(b.getRightBounds())){
			setX(b.getX() + 278);
		}
		
		
		if (getBotBounds().intersects(b.getTopBounds()) && b.isChangingSector()) {
			Building.getBuilding().changeSector();
			onGround = true;
			isImmune = false;
		}
		
		
		if (getBotBounds().intersects(b.getBotBounds()) ){		
			onGround = true;
		}else 
			onGround = false;
		
	}

		
	
	
	private float getInputX(ArrayList<Entity> ent) {
		
		// Mover derecha
		if (KeyBoard.right && !KeyBoard.fix) {
			directionX = 1;
			return VEL;
		}
		
		// Mover izquierda
		if (KeyBoard.left && !KeyBoard.fix){
			directionX = -1;
			return -VEL;
		}
			
		return 0;
	}
		
		
		
	private float getInputY(ArrayList<Entity> ent, long beforeTime) {

		// Mover arriba
		if (KeyBoard.up && !falling && max_jump > MAX_JUMP && beforeTime - movDelay > 150) {
			directionY = -1;
			max_jump += JUMP_SPEED;
				
			return JUMP_SPEED;
		}
				
		// Mover abajo
		if (KeyBoard.down && onGround && !onObstacle && getY() < 503 && beforeTime - movDelay > 100
				&& !getBotBounds().intersects(Building.getBuilding().getBotBounds())) {
			
			movDelay = System.currentTimeMillis();
			directionY = 1; 
				
			return Constant.GRAVITY;
		}
			
		if (!onGround) {
			movDelay = System.currentTimeMillis();
			falling = true;
			onObstacle = false;
			return Constant.GRAVITY;	
		}
			
		return 0;
	}
		
		
	
	private void  stopFalling() {
		if(onGround && falling) {
			falling = false;
			max_jump = 0;
		}
	}
		
	
	
	private void decLife(long beforeTime) {
		dying = true;
		if (!isImmune){
			if (beforeTime - delay > 20) {
				delay = System.currentTimeMillis();
				life--;
				if (life > 0)	
					Score.getScore().loseHP();	

			}
		}
	}

		
	
	@Override
	public void draw(Graphics2D g, long time) {
		state.update();
		g.drawImage(state.getImage(directionX), (int)getX(), (int)getY(), null);
		
		g.setColor(Color.RED);
//		g.draw(getBounds());
		
		g.setColor(Color.GREEN);
//		g.draw(getBotBounds());
//		g.draw(getLeftBounds());
//		g.draw(getRightBounds());
//		g.draw(getTopBounds());
//		g.draw(getAllBounds());
	}

	
	@Override
	public String getName() {
		return "Felix";
	}

	public int getLife() {
		return life;
	}
	
	
	// limites
	@Override
	public Rectangle getTopBounds() {
		return new Rectangle((int)getX() + 12, (int)getY(), 15, 3);
	}


	@Override
	public Rectangle getLeftBounds() {
		return new Rectangle((int)getX() + 7 ,(int)getY() + 6 , 3, 39);
	}


	@Override
	public Rectangle getRightBounds() {
		return new Rectangle((int)getX() + 15, (int)getY() + 6, 3, 39);
	}


	@Override
	public Rectangle getBotBounds() {
		if (directionX == -1){
			return new Rectangle((int)getX() + 12, (int)getY() + 52, 12, 2);
		}
		return new Rectangle((int)getX() + 6, (int)getY() + 52, 12, 2);
	}

	
	public Rectangle getAllBounds(){
		if (directionX == -1){
			return new Rectangle((int)getX() + 10, (int)getY(), width, height);
		}
		return new Rectangle((int)getX(), (int)getY(), width, height);
	}
	
	
	@Override
	public Rectangle getBounds() {
		if (directionX == -1){
			return new Rectangle((int)getX() + 6, (int)getY() + 30, 7, 7);
		}
		return new Rectangle((int)getX() + 26, (int)getY() + 30, 7, 7);
	}


	public void resetAll(float x, float y){
		setXY(x,y);
		life = 3;
		isImmune = false;
		dying = false;
	}


	public void reset(float x, float y) {
		setXY(x,y);
	}

	
}
