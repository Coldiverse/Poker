import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.Thread.State;
import java.util.Random;

import Game.STATE;


public class Menu extends MouseAdapter{

	Game game;
	Handler handler;
	private Random r;
	
	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;

		r = new Random();
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(mouseOver(mx, my, Game.WIDTH /2 - 100, Game.HEIGHT - 600, 200, 64)) {
			game.gameState = STATE.Game;
			handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
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
		Font menu = new Font("arial", 1, 100);
		Font fnt = new Font("arial", 1, 64);

		g.setColor(Color.white);
		g.drawRect(Game.WIDTH / 2 - 100, Game.HEIGHT - 600, 200, 64);
		g.setColor(Color.white);
		g.setFont(fnt);
		g.drawString("Play", Game.HEIGHT /2, Game.HEIGHT - 650);
		
		g.setColor(Color.white);
		g.drawRect(Game.WIDTH / 2 - 100, Game.HEIGHT - 500, 200, 64);
		g.setColor(Color.white);
		g.setFont(fnt);
		g.drawString("Help", Game.HEIGHT /2, Game.HEIGHT - 650);
		
		g.setColor(Color.white);
		g.drawRect(Game.WIDTH / 2 - 100, Game.HEIGHT - 400, 200, 64);
		g.setColor(Color.white);
		g.setFont(fnt);
		g.drawString("Quit", Game.HEIGHT /2, Game.HEIGHT - 650);
		
		g.setColor(Color.white);
		g.setFont(menu);
		g.drawString("Menu", Game.HEIGHT /2, Game.HEIGHT - 650);
		
		
	}
}
