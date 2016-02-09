package principal.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import principal.Camera;
import principal.Constant;
import principal.HUD;
import principal.entities.Building;
import principal.input.KeyBoard;
import principal.input.MouseInput;
import principal.statemachine.GameStatus;
import principal.statemachine.gamestate.GameManager;


// Se extiende a Canvas ya que esta clase es la que puede crear el buffer Strategy por eso no hicimos un JPanel 
public class DrawingSurface extends Canvas {

	private static final long serialVersionUID = -4338850574868182269L;
	
	private KeyBoard inputKeys; 
	private static Camera cam;
	private static boolean prevGM = false;
	private static int piso;
	
	public DrawingSurface() {
		cam = new Camera(0, 0);
		inputKeys = new KeyBoard();
		addKeyListener(inputKeys);
		addMouseListener(new MouseInput());
		setFocusable(true);
		setIgnoreRepaint(true);
		requestFocus();
		piso = 237;
	}
	

	// esto se va a usar para cuando cambie de sector asi translada la imagen al segundo sector
	// como el juego de disney lo comentado dentro era solo para hacer debug si ejecutas esa linea
	// la camara se va a mover hasta la punta del edificio
	
	public void tick() {
		
		inputKeys.tick();
		
		HUD.getHud().tick();
		
		if (GameStatus.actualState instanceof GameManager){	
			if (Building.getBuilding().getGM()) {
				if (cam.getY() < piso) {
					cam.tick();
					prevGM = true;		
				}else{
					Building.getBuilding().stopGM();
				}
			}else{	
				if(prevGM){
					piso = piso + 203;
					prevGM = false;
				}
			}
		}
	}
		
	public static void resetSurface() {
		prevGM = false;
		cam.setY(0);
		piso = 237;
	}
	
	// el buffer strategy lo que hace es armar un buffer de imagenes e ir reproduciendolas, es decir, antes de producir la imagen es creada y guardada
	// en memoria (en una cola) porque en caso de que ocurra algo con el programa las imagenes van a estar dibujadas de ante mano y no va a haber problemas 
	// ya que procesar y dibujar ni bien es creada la imagen puede causar errores de dibujo.
	public void draw(GameStatus gs, long time) {
		
	
		BufferStrategy bufferStrat = getBufferStrategy();
		if (bufferStrat == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics2D g = (Graphics2D) bufferStrat.getDrawGraphics();
		
		clean(g);
		
		if (GameStatus.actualState instanceof GameManager)
			g.translate(0, cam.getY());
		
		gs.draw(g, time);
		
		g.translate(0, -cam.getY());
		
		if (GameStatus.actualState instanceof GameManager)
			HUD.getHud().draw(g);
		
		// esta linea evita el screen tearing, es decir, que no se vean multiples frames a la vez coordinando los refresh rates del monitor
		// con los frames a mostrar
		Toolkit.getDefaultToolkit().sync();
		
		
		g.dispose();
		
		// apunta a la siguiente imagen a mostrar que se encuentra en la cola
		bufferStrat.show();
	}


	private void clean(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Constant.WIDTH, Constant.HEIGHT);
	}
	
	
}
