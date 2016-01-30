package principal.entities.creatures;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import principal.Constant;
import principal.Handler;
import principal.entities.Building;
import principal.entities.ID;
import principal.entities.windows.Window;
import principal.input.KeyBoard;
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
	private final float MAX_JUMP = -85;// la velocidad de salto es negativa y la gravedad positiva
	private final float VEL = 3f; 
	
	private State state;
	
	private long time = System.currentTimeMillis();
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

	
	public void tick(ArrayList<Creature> creat) {
		
		stopFalling();
				
		setDx(getInputX(creat));
		setX(getX() + getDx());
			    
		setDy(getInputY(creat));
		setY(getY() + getDy());
			    
		checkButtons();
		
		collision(creat);
		
	}

		
	private void checkButtons() {
		if (KeyBoard.pause)
			System.exit(1);
			
		if (KeyBoard.fix && onGround) 
			state = Fixing.getFixing();
			
		if (getDx() == 0 && getDy() == 0 && !KeyBoard.fix) 
			state = Normal.getNormal();
		
		if (getDx() != 0 || getDy() != 0) 
			state = Moving.getMoving();
	}
		
		
// 		setX(e.getX() + 17);
// 		setX(e.getX() + 269);
		
	private void collision(ArrayList<Creature> creat) {
			
		buildingCollision();
		windowCollision();
		
		for (int i = 0; i < creat.size(); i++) {
			Creature c = creat.get(i);
			ralphCollision(c);
			brickCollision(c);
			
		}
		
	}

	private void windowCollision() {
		
		Window[] windows = Building.getBuilding().getWindows();
		if(windows != null){
		for (int i = 0; i < windows.length; i++) {
			Window w = windows[i];
			// 300 ms entre cada golpe de delay para coordinarlo con el arreglo
			if(w.getBounds().contains(getBounds()) && KeyBoard.fix && System.currentTimeMillis() - time > 300){
				time = System.currentTimeMillis();
				w.getFixed();
			}
			
			if(w.getBotBounds() != null){
			if (getBotBounds().intersects(w.getBotBounds())) {
				onGround = true;
			}
			}
		}
		}
	}

	private void brickCollision(Creature c) {
		if (c.getID() == ID.Brick) {
			if(getTopBounds().intersects(c.getBounds())) {
				handler.remove(c);
				decLife();
			}
		}
	}

	private void ralphCollision(Creature c) {
		if (c.getID() == ID.Ralph){
			if (getTopBounds().intersects(c.getBounds())) {
				setY(c.getY() + 82);
				max_jump = MAX_JUMP;
			}
		}
	}

	private void buildingCollision() {
		Building b = Building.getBuilding();
		
		if (getLeftBounds().intersects(b.getLeftBounds())){
			setX(Building.getBuilding().getX() + 17);
		}
			
		if (getRightBounds().intersects(b.getRightBounds())){
			setX(b.getX() + 261);
		}
		
		
		if (getBotBounds().intersects(b.getBotBounds()) && b.isChangingSector()){
			onGround = true;
		}else 
			onGround = false;
		
		if (getBotBounds().intersects(Building.getBuilding().getTopBounds())) {
			Building.getBuilding().changeSector();
		}
		
	}

		
	private float getInputX(ArrayList<Creature> creat) {
			
		if (KeyBoard.right && !KeyBoard.fix) {
			directionX = 1;
				
			return VEL;
		}
			
		if (KeyBoard.left && !KeyBoard.fix){
			directionX = -1;
			return -VEL;
		}
			
		return 0;
	}
		
		
		
	private float getInputY(ArrayList<Creature> creat) {

		if (KeyBoard.up && !falling && max_jump > MAX_JUMP && System.currentTimeMillis() - time > 150) {
			directionY = -1;
			max_jump += JUMP_SPEED;
				
			return JUMP_SPEED;
		}
				
		if (KeyBoard.down && onGround && getY() < 503 && System.currentTimeMillis() - time > 100) {
			time = System.currentTimeMillis();
			directionY = 1; 
				
			return Constant.GRAVITY;
		}
			
		if (!onGround && getY() < 503) {
			time = System.currentTimeMillis();
			falling = true;
				
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
		
	private void decLife() {
		if (System.currentTimeMillis() - time > 20){
			time = System.currentTimeMillis();
			life--;
		}
	}
		
	@Override
	public void draw(Graphics2D g) {
		state.update();
		g.drawImage(state.getImage(), (int)getX(), (int)getY(), null);
		
		g.setColor(Color.GREEN);
		g.draw(getBounds());
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
	
	
	@Override
	public Rectangle getTopBounds() {
		return new Rectangle((int)getX() + 4, (int)getY(), 15, 3);
	}


	@Override
	public Rectangle getLeftBounds() {
		return new Rectangle((int)getX() ,(int)getY() + 6 , 3, 30);
	}


	@Override
	public Rectangle getRightBounds() {
		return new Rectangle((int)getX() + 30, (int)getY() + 6, 3, 30);
	}


	@Override
	public Rectangle getBotBounds() {
		return new Rectangle((int)getX() +14, (int)getY() + 52, 15, 2);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)getX() + 6, (int)getY() + 30, 7, 7);
	}

	
}
