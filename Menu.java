import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.Thread.State;
import java.util.Random;

//yotee
public class Menu extends MouseAdapter{

	private Game game;
	private Handler handler;
	private Random r;
	
	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;

		r = new Random();
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState == Game.STATE.Menu && mouseOver(mx, my, Game.WIDTH /2 - 100, Game.HEIGHT - 600, 200, 64)) {
			game.gameState = Game.STATE.Game;
			handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
		}else if(game.gameState == Game.STATE.Menu && mouseOver(mx, my, Game.WIDTH / 2 - 100, Game.HEIGHT - 500, 200, 64)) {
			game.gameState = Game.STATE.Help;
		}else if(game.gameState == Game.STATE.Menu && mouseOver(mx, my, Game.WIDTH / 2 - 100, Game.HEIGHT - 400, 200, 64)) {
			System.exit(1);
		}else if(game.gameState == Game.STATE.Menu && mouseOver(mx, my, Game.WIDTH / 2 - 125, Game.HEIGHT - 300, 250, 128)) {
			game.gameState = Game.STATE.CharacterSelection;
		}else if(game.gameState == Game.STATE.Help && mouseOver(mx, my, Game.WIDTH / 2 - 125, Game.HEIGHT - 300, 250, 128)) {
			game.gameState = Game.STATE.Menu;
		}
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		if(game.gameState == Game.STATE.Menu) {
			Font title = new Font("arial", 1, 100);
			Font fnt = new Font("arial", 1, 45);

			g.setColor(Color.white);
			g.drawRect(Game.WIDTH / 2 - 100, Game.HEIGHT - 600, 200, 64);
			g.setColor(Color.white);
			g.setFont(fnt);
			g.drawString("Play", Game.HEIGHT /2 + 80, Game.HEIGHT - 555);
			
			g.setColor(Color.white);
			g.drawRect(Game.WIDTH / 2 - 100, Game.HEIGHT - 500, 200, 64);
			g.setColor(Color.white);
			g.setFont(fnt);
			g.drawString("Help", Game.HEIGHT /2 + 80, Game.HEIGHT - 455);
			
			g.setColor(Color.white);
			g.drawRect(Game.WIDTH / 2 - 100, Game.HEIGHT - 400, 200, 64);
			g.setColor(Color.white);
			g.setFont(fnt);
			g.drawString("Quit", Game.HEIGHT /2 + 80, Game.HEIGHT - 355);
			
			g.setColor(Color.white);
			g.drawRect(Game.WIDTH / 2 - 125, Game.HEIGHT - 300, 250, 128);
			g.setColor(Color.white);
			g.setFont(fnt);
			g.drawString("Character", Game.HEIGHT /2 + 25, Game.HEIGHT - 255);
			g.drawString("Selection", Game.HEIGHT /2 + 25, Game.HEIGHT - 200);
			
			g.setColor(Color.white);
			g.setFont(title);
			g.drawString("Menu", Game.HEIGHT /2, Game.HEIGHT - 650);	
			
		}else if(game.gameState == Game.STATE.Help) {
			Font title = new Font("arial", 1, 100);
			Font fnt = new Font("arial", 1, 30);
			
			g.setColor(Color.white);
			g.setFont(title);
			g.drawString("Help", Game.HEIGHT / 2, Game.HEIGHT - 650);
			
			g.setColor(Color.white);
			g.setFont(fnt);
			g.drawString("Use the WSAD keys to move around in the game", 10, Game.HEIGHT - 550);
			
			g.setColor(Color.white);
			g.setFont(fnt);
			g.drawString("Press P to pause the game", 10, Game.HEIGHT - 450);
			
			g.setColor(Color.white);
			g.drawRect(Game.WIDTH / 2 - 125, Game.HEIGHT - 300, 250, 128);
			g.setColor(Color.white);
			g.setFont(fnt);
			g.drawString("Back", Game.HEIGHT /2 + 85, Game.HEIGHT - 265);
			g.drawString("To", Game.HEIGHT /2 + 100, Game.HEIGHT - 225);
			g.drawString("Menu", Game.HEIGHT /2 + 85, Game.HEIGHT - 190);
			
		}else if(game.gameState == Game.STATE.CharacterSelection) {
			Font title = new Font("arial", 1, 100);
			Font fnt = new Font("arial", 1, 30);
			
			g.setColor(Color.white);
			g.setFont(title);
			g.drawString("Character", Game.HEIGHT / 2 - 100, Game.HEIGHT - 650);
			g.drawString("Selection", Game.HEIGHT / 2 - 100, Game.HEIGHT - 550);
			
			g.setColor(Color.white);
			g.drawRect(Game.WIDTH / 5, Game.HEIGHT - 400, 32, 32);
			
			g.setColor(Color.white);
			g.drawRect(Game.WIDTH / 5 + 200, Game.HEIGHT - 400, 32, 32);
			Color darkGreen = new Color(16, 132, 14);
			g.setColor(darkGreen);
			g.fillRect(Game.WIDTH / 5 + 200,Game.HEIGHT - 400,32,32);
			g.setColor(Color.black);
			g.fillRect(Game.WIDTH / 5 + 205,Game.HEIGHT - (400 - 5),8,8);
			g.fillRect(Game.WIDTH / 5 + 220,Game.HEIGHT - (400 - 5),8,8);
			g.fillRect(Game.WIDTH / 5 + 213,Game.HEIGHT - (400 - 11),7,12);
			g.fillRect(Game.WIDTH / 5 + 210,Game.HEIGHT - (400 - 15),4,10);
	        g.fillRect(Game.WIDTH / 5 + 219,Game.HEIGHT - (400 - 15),4,10);
			
			g.setColor(Color.white);
			g.drawRect(Game.WIDTH / 5 + 400, Game.HEIGHT - 400, 32, 32);
			
			g.setColor(Color.white);
			g.drawRect(Game.WIDTH / 5 + 600, Game.HEIGHT - 400, 32, 32);
		}

	}

}
