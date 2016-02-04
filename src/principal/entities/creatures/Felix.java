package principal.entities.creatures;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import principal.Constant;
import principal.Handler;
import principal.Score;
import principal.entities.Building;
import principal.entities.ID;
import principal.entities.windows.Window;
import principal.input.KeyBoard;
import principal.statemachine.GameStatus;
import principal.statemachine.characterstates.State;
import principal.statemachine.characterstates.felixstates.Fixing;
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
	
	private boolean fixing;
	
	private State state;
	
	private long movDelay = System.currentTimeMillis();
	private long delay = System.currentTimeMillis();
	private float max_jump = 0;
	
	private boolean onGround;
	private boolean falling;
	
	private int life;
	
	
	public Felix(float x, float y, Handler handler) {
		super(x, y, handler);
		
		life = 3;
		state = Normal.getNormal();
		
		onGround = false;
		falling = false;
		
		width = 28;
		height = 59;
		
		directionX = 1;
		id = ID.Felix;
		
	}	

	
	
	public void tick(ArrayList<Creature> creat, long beforeTime) {
		stopFalling();
				
		setDx(getInputX(creat));
		setX(getX() + getDx());
			    
		setDy(getInputY(creat,beforeTime));
		setY(getY() + getDy());
			    
		checkButtons();
		
		collision(creat, beforeTime);
	}

		
	
	private void checkButtons() {
		
		if (KeyBoard.fix && onGround) {
			state = Fixing.getFixing();
		}
			
		if (getDx() == 0 && getDy() == 0 && !KeyBoard.fix) {
			state = Normal.getNormal();
		}
			
		
		if (getDx() != 0 || getDy() != 0) {
			state = Moving.getMoving();
		}
	}
		
	
// 		setX(e.getX() + 17);
// 		setX(e.getX() + 269);
		
	
	private void collision(ArrayList<Creature> creat, long beforeTime) {
			
		buildingCollision();
		windowCollision(beforeTime);
		
		for (int i = 0; i < creat.size(); i++) {
			Creature c = creat.get(i);
			ralphCollision(c);
			brickCollision(c, beforeTime);
			birdCollision(c, beforeTime);
		}
	}
	

	
	private void windowCollision(long beforeTime) {	
		Window[] windows = Building.getBuilding().getWindows();
		for (int i = 0; i < windows.length; i++) {
			Window w = windows[i];
			
			// 300 ms entre cada golpe de delay para coordinarlo con el arreglo
			if(w.getBounds().contains(getBounds()) && KeyBoard.fix && beforeTime - movDelay > 300) {
				movDelay = System.currentTimeMillis();
				w.getFixed();
			}
			
			if (getBotBounds().intersects(w.getBotBounds())) {
				onGround = true;
			}
			
			doubleDoorsCollision(w);
		}
	}
	
	

	private void doubleDoorsCollision(Window w) {
		if (getLeftBounds().intersects(w.getLeftBounds())) {
			setX(w.getX() - 6);
		}
		
		if (getRightBounds().intersects(w.getLeftBounds())) {
			setX(w.getX() - 34);
		}
		
		if (getLeftBounds().intersects(w.getRightBounds())) {
			setX(w.getX() + 27);
		}
		
		if (getRightBounds().intersects(w.getRightBounds())) {
			setX(w.getX());
		}
	}
	
	
	
	private void brickCollision(Creature c, long beforeTime) {
//		if (c.getID() == ID.Brick) {
//			if(getTopBounds().intersects(c.getBounds())) {
//				handler.remove(c);
//				decLife(beforeTime);
//			}
//		}
	}
	
	
	
	private void birdCollision(Creature c, long beforeTime){
		if (c.getID() == ID.Bird){
			if (getTopBounds().intersects(c.getBounds()) || getBotBounds().intersects(c.getBounds())
				|| getLeftBounds().intersects(c.getBounds()) || getRightBounds().intersects(c.getBounds())){
					decLife(beforeTime);
					handler.remove(c);
			}
		}
	}
	
	
	
	

	private void ralphCollision(Creature c) {
//		if (c.getID() == ID.Ralph){
//			if (getTopBounds().intersects(c.getBounds())) {
//				setY(c.getY() + 82);
//				max_jump = MAX_JUMP;
//			}
//		}
	}

	
	
	private void buildingCollision() {
		
		Building b = Building.getBuilding();
		
		
		if (getLeftBounds().intersects(b.getLeftBounds())){
			setX(Building.getBuilding().getX() + 6);
		}
		
		
		if (getRightBounds().intersects(b.getRightBounds())){
			setX(b.getX() + 264);
		}
		
		
		if (getBotBounds().intersects(b.getTopBounds()) && b.isChangingSector()) {
			Building.getBuilding().changeSector();
			onGround = true;
		}
		
		
		if (getBotBounds().intersects(b.getBotBounds()) ){		
			onGround = true;
		}else 
			onGround = false;
	}

		
	
	
	private float getInputX(ArrayList<Creature> creat) {
		
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
		
		
		
	private float getInputY(ArrayList<Creature> creat, long beforeTime) {

		// Mover arriba
		if (KeyBoard.up && !falling && max_jump > MAX_JUMP && beforeTime - movDelay > 150) {
			directionY = -1;
			max_jump += JUMP_SPEED;
				
			return JUMP_SPEED;
		}
				
		// Mover abajo
		if (KeyBoard.down && onGround && getY() < 503 && beforeTime - movDelay > 100
				&& !getBotBounds().intersects(Building.getBuilding().getBotBounds())) {
			
			movDelay = System.currentTimeMillis();
			directionY = 1; 
				
			return Constant.GRAVITY;
		}
			
		if (!onGround && getY() < 503) {
			movDelay = System.currentTimeMillis();
			falling = true;
			return Constant.GRAVITY;	
		}
			
		return 0;
	}
		
		
	
	private void  stopFalling() {
		if(onGround && falling) {
			falling = false;
			max_jump = 0;
			Score.getScore().jump();
		}
	}
		
	
	
	private void decLife(long beforeTime) {
		if (beforeTime - delay > 20) {
			
			delay = System.currentTimeMillis();
			
			life--;
			
			if (life > 0)	
				Score.getScore().loseHP();
			
			if(life == 0){
				Score.getScore().saveScore();
				GameStatus.changeState(0);
			}
			
			
			
		}
	}
		
	
	@Override
	public void draw(Graphics2D g, long time) {
		state.update(time);
		g.drawImage(state.getImage(directionX), (int)getX(), (int)getY(), null);
		
		g.setColor(Color.GREEN);
//		g.draw(getBounds());
//		g.draw(getBotBounds());
//		g.draw(getLeftBounds());
//		g.draw(getRightBounds());
//		g.draw(getTopBounds());
	}

	
	@Override
	public String getName() {
		return "Felix";
	}

	public int getLife(){
		return life;
	}
	
	
	public boolean getFixing() {
		return fixing;
	}
	
	
	public void getFixing(boolean fixing) {
		this.fixing = fixing;
	}
	
	
	// limites
	
	@Override
	public Rectangle getTopBounds() {
		return new Rectangle((int)getX() + 12, (int)getY(), 15, 3);
	}


	@Override
	public Rectangle getLeftBounds() {
		return new Rectangle((int)getX() + 10 ,(int)getY() + 6 , 3, 39);
	}


	@Override
	public Rectangle getRightBounds() {
		return new Rectangle((int)getX() + 30, (int)getY() + 6, 3, 39);
	}


	@Override
	public Rectangle getBotBounds() {
		return new Rectangle((int)getX() + 10, (int)getY() + 52, 25, 2);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)getX() + 6, (int)getY() + 30, 7, 7);
	}

	
}
