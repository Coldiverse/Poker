import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

	private Handler handler;
	private boolean sPressed, wPressed, aPressed, dPressed;
	
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				//key events for player 1
				
				
				if(key == KeyEvent.VK_W) {
					wPressed = true;
					tempObject.setVelY(-5);
				}
				if(key == KeyEvent.VK_S) {
					sPressed = true;
					tempObject.setVelY(+5);
				}	
				if(key == KeyEvent.VK_D) {
					dPressed = true;
					tempObject.setVelX(+5);
				}
				if(key == KeyEvent.VK_A) {
					aPressed = true;
					tempObject.setVelX(-5);	
				}
					
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
		
			if(tempObject.getId() == ID.Player) {
			//key events for player 1
			
				if(key == KeyEvent.VK_W) { 
					wPressed = false;
					if(sPressed) tempObject.setVelY(+5);
					else tempObject.setVelY(0);
				}				
			
				if(key == KeyEvent.VK_S) { 
					sPressed = false;
					if(wPressed) tempObject.setVelY(-5);
					else tempObject.setVelY(0);
				}				
				if(key == KeyEvent.VK_D) {
					dPressed = false;
					if(aPressed) tempObject.setVelX(-5);
					else tempObject.setVelX(0);
				}
				if(key == KeyEvent.VK_A) {
					aPressed = false;
					if(dPressed) tempObject.setVelX(+5);
					else tempObject.setVelX(0);
				}
				
			}
			
		}
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	
}
	
