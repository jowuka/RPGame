package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class entity {
	public int worldX, worldY;
	public int speed;
	public BufferedImage up1, up2, up3, up4, up5,up6, down1, down2, down3, down4, down5, down6, left1, left2, left3, left4, left5, left6, right1, right2, right3, right4, right5, right6, idleup1,idleup2,idleup3,idleup4,idleup5;
	public BufferedImage idleleft1,idleleft2,idleleft3,idleleft4,idleleft5,idleright1,idleright2,idleright3,idleright4,idleright5,idledown1,idledown2,idledown3,idledown4,idledown5;
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	public int spriteNumIdle = 1;

	public Rectangle solidArea;
	public boolean collisionOn = false;
}
