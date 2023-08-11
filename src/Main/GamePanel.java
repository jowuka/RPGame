package Main;
import java.awt.*;

import javax.swing.*;
import entity.Player;
import tile.TileManager;
public class GamePanel extends JPanel implements Runnable{
	final int originalTileSize = 16;						
	final int scale = 5;									// Cube Size tileSize * scale
	public final int tileSize = originalTileSize * scale;			// tileSize = 16 * scale
	public final int maxScreenCol = 16;							// Col Cube's
	public final int maxScreenRow = 12;							// Row Cube's
	public final int screenWidth = tileSize * maxScreenCol;		// 768px
	public final int screenHeight = tileSize * maxScreenRow;		// 576px
	
	// WORLD SETTINGS
	public final int maxWorldcol = 24;
	public final int maxWorldrow = 24;
	public final int worldWidth = tileSize * maxWorldcol;
	public final int worldHeight = tileSize * maxWorldrow;
	
	TileManager tileM = new TileManager(this);
	Thread gameThread;
	KeyHandler keyH = new KeyHandler();						//Reading Key Stroke's
	public Player player = new Player(this,keyH);
	
	int fps = 60; 											// FPS SETTING
	public GamePanel () {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);							// adding KeyHandler to the panel
		this.setFocusable(true);
		
	}
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	public void run() {										// run
		
		double drawInterval = 1000000000 / fps;
		long lastTime = System.nanoTime();
		double delta = 0;
		long CurrentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) {							// functions always till game continue
			CurrentTime = System.nanoTime();
			delta += (CurrentTime - lastTime) / drawInterval;
			timer += (CurrentTime - lastTime);
			lastTime = CurrentTime;
			if(delta >= 1) {
			update();								
			repaint();										// set 
			delta--;
			drawCount++;
			}
			if (timer >= 1000000000) {
				System.out.println("Fps = " +drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
	
	}
	public void update() {
		player.update();
			
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		tileM.draw(g2);
		player.draw(g2);
		g2.dispose();
	}
}
