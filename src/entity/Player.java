package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.KeyHandler;

public class Player extends entity {
	GamePanel gp;
	KeyHandler keyH;
	public final int screenX;
	public final int screenY;
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
		screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
		setDefaultValues();
		getPlayerImage();
		
	}

	public void setDefaultValues() {
		worldX = gp.tileSize * 8;
		worldY = gp.tileSize * 6;
		speed = 3;
		direction = "idledown";
	}

	public void getPlayerImage() {					// all images of player
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player_up_walk/_up walk.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player_up_walk/_up walk1.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/player_up_walk/_up walk2.png"));
			up4 = ImageIO.read(getClass().getResourceAsStream("/player_up_walk/_up walk3.png"));
			up5 = ImageIO.read(getClass().getResourceAsStream("/player_up_walk/_up walk4.png"));
			up6 = ImageIO.read(getClass().getResourceAsStream("/player_up_walk/_up walk5.png"));

			down1 = ImageIO.read(getClass().getResourceAsStream("/player_down_walk/_down walk.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player_down_walk/_down walk1.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/player_down_walk/_down walk2.png"));
			down4 = ImageIO.read(getClass().getResourceAsStream("/player_down_walk/_down walk3.png"));
			down5 = ImageIO.read(getClass().getResourceAsStream("/player_down_walk/_down walk4.png"));
			down6 = ImageIO.read(getClass().getResourceAsStream("/player_down_walk/_down walk5.png"));

			left1 = ImageIO.read(getClass().getResourceAsStream("/player_left_walk/side_walk.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player_left_walk/side_walk1.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/player_left_walk/side_walk2.png"));
			left4 = ImageIO.read(getClass().getResourceAsStream("/player_left_walk/side_walk3.png"));
			left5 = ImageIO.read(getClass().getResourceAsStream("/player_left_walk/side_walk4.png"));
			left6 = ImageIO.read(getClass().getResourceAsStream("/player_left_walk/side_walk5.png"));

			right1 = ImageIO.read(getClass().getResourceAsStream("/player_right_walk/Rside_walk.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player_right_walk/Rside_walk1.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/player_right_walk/Rside_walk2.png"));
			right4 = ImageIO.read(getClass().getResourceAsStream("/player_right_walk/Rside_walk3.png"));
			right5 = ImageIO.read(getClass().getResourceAsStream("/player_right_walk/Rside_walk4.png"));
			right6 = ImageIO.read(getClass().getResourceAsStream("/player_right_walk/Rside_walk5.png"));
			
			idleup1 = ImageIO.read(getClass().getResourceAsStream("/player_up_idle/up_idle.png"));
			idleup2 = ImageIO.read(getClass().getResourceAsStream("/player_up_idle/up_idle1.png"));
			idleup3 = ImageIO.read(getClass().getResourceAsStream("/player_up_idle/up_idle2.png"));
			idleup4 = ImageIO.read(getClass().getResourceAsStream("/player_up_idle/up_idle3.png"));
			idleup5 = ImageIO.read(getClass().getResourceAsStream("/player_up_idle/up_idle4.png"));
			
			idleleft1 = ImageIO.read(getClass().getResourceAsStream("/player_left_idle/_side idle.png"));
			idleleft2 = ImageIO.read(getClass().getResourceAsStream("/player_left_idle/_side idle1.png"));
			idleleft3 = ImageIO.read(getClass().getResourceAsStream("/player_left_idle/_side idle2.png"));
			idleleft4 = ImageIO.read(getClass().getResourceAsStream("/player_left_idle/_side idle4.png"));
			idleleft5 = ImageIO.read(getClass().getResourceAsStream("/player_left_idle/_side idle5.png"));
			
			idleright1 = ImageIO.read(getClass().getResourceAsStream("/player_right_idle/right idle.png"));
			idleright2 = ImageIO.read(getClass().getResourceAsStream("/player_right_idle/right idle1.png"));
			idleright3 = ImageIO.read(getClass().getResourceAsStream("/player_right_idle/right idle3.png"));
			idleright4 = ImageIO.read(getClass().getResourceAsStream("/player_right_idle/right idle4.png"));
			idleright5 = ImageIO.read(getClass().getResourceAsStream("/player_right_idle/right idle5.png"));
			
			idledown1 = ImageIO.read(getClass().getResourceAsStream("/player_idle/_down idle.png"));
			idledown2 = ImageIO.read(getClass().getResourceAsStream("/player_idle/_down idle1.png"));
			idledown3 = ImageIO.read(getClass().getResourceAsStream("/player_idle/_down idle2.png"));
			idledown4 = ImageIO.read(getClass().getResourceAsStream("/player_idle/_down idle3.png"));
			idledown5 = ImageIO.read(getClass().getResourceAsStream("/player_idle/_down idle4.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update() {
		if (keyH.upPressed == true) {
			direction = "up";
			worldY -= speed;
		} 
		else if (keyH.downPressed == true) {
			direction = "down";
			worldY += speed;
		} else if (keyH.leftPressed == true) {
			direction = "left";
			worldX -= speed;
		} else if (keyH.rightPressed == true) {
			direction = "right";
			worldX += speed;
		} 
		
		if (keyH.upPressed == true || keyH.leftPressed == true || keyH.rightPressed == true
				|| keyH.downPressed == true) {
			spriteCounter++;
			if (spriteCounter > 6) {					 // how many frames image changes!
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 3;
				} else if (spriteNum == 3) {
					spriteNum = 4;
				} else if (spriteNum == 4) {
					spriteNum = 5;
				} else if (spriteNum == 5) {
					spriteNum = 6;
				} else if (spriteNum == 6) {
					spriteNum = 1;

				}
				spriteCounter = 0;
			}
		}
		
		else {
			if (keyH.idleDirection == 1) {
				direction = "idleup";
			}
			else if (keyH.idleDirection == 2) {
				direction = "idledown";
			}
			else if (keyH.idleDirection == 3) {
				direction = "idleleft";
			}
			else if (keyH.idleDirection == 4) {
				direction = "idleright";
			}
			spriteCounter++;
			if (spriteCounter > 12) {					 // how many frames image changes!
				if (spriteNumIdle == 1) {
					spriteNumIdle = 2;
				} else if (spriteNumIdle == 2) {
					spriteNumIdle = 3;
				} else if (spriteNumIdle == 3) {
					spriteNumIdle = 4;
				} else if (spriteNumIdle == 4) {
					spriteNumIdle = 5;
				} else if (spriteNumIdle == 5) {
					spriteNumIdle = 1;
					
				}
			spriteCounter = 0;
			}
		}
		
	}
	

	public void draw(Graphics2D g2) {

		BufferedImage image = null;
		switch (direction) {
		case "up":
			if (spriteNum == 1)
				image = up1;
			if (spriteNum == 2)
				image = up2;
			if (spriteNum == 3)
				image = up3;
			if (spriteNum == 4)
				image = up4;
			if (spriteNum == 5)
				image = up5;
			if (spriteNum == 6)
				image = up6;
			break;
		case "down":
			if (spriteNum == 1)
				image = down1;
			if (spriteNum == 2)
				image = down2;
			if (spriteNum == 3)
				image = down3;
			if (spriteNum == 4)
				image = down4;
			if (spriteNum == 5)
				image = down5;
			if (spriteNum == 6)
				image = down6;
			break;
		case "left":
			if (spriteNum == 1)
				image = left1;
			if (spriteNum == 2)
				image = left2;
			if (spriteNum == 3)
				image = left3;
			if (spriteNum == 4)
				image = left4;
			if (spriteNum == 5)
				image = left5;
			if (spriteNum == 6)
				image = left6;
			break;
		case "right":
			if (spriteNum == 1)
				image = right1;
			if (spriteNum == 2)
				image = right2;
			if (spriteNum == 3)
				image = right3;
			if (spriteNum == 4)
				image = right4;
			if (spriteNum == 5)
				image = right5;
			if (spriteNum == 6)
				image = right6;
			break;
		case "idleup":
			if (spriteNumIdle == 1)
				image = idleup1;
			if (spriteNumIdle == 2)
				image = idleup2;
			if (spriteNumIdle == 3)
				image = idleup3;
			if (spriteNumIdle == 4)
				image = idleup4;
			if (spriteNumIdle == 5)
				image = idleup5;
			break;
		case "idledown":
			if (spriteNumIdle == 1)
				image = idledown1;
			if (spriteNumIdle == 2)
				image = idledown2;
			if (spriteNumIdle == 3)
				image = idledown3;
			if (spriteNumIdle == 4)
				image = idledown4;
			if (spriteNumIdle == 5)
				image = idledown5;
			break;
		case "idleleft":
			if (spriteNumIdle == 1)
				image = idleleft1;
			if (spriteNumIdle == 2)
				image = idleleft2;
			if (spriteNumIdle == 3)
				image = idleleft3;
			if (spriteNumIdle == 4)
				image = idleleft4;
			if (spriteNumIdle == 5)
				image = idleleft5;
			break;
		case "idleright":
			if (spriteNumIdle == 1)
				image = idleright1;
			if (spriteNumIdle == 2)
				image = idleright2;
			if (spriteNumIdle == 3)
				image = idleright3;
			if (spriteNumIdle == 4)
				image = idleright4;
			if (spriteNumIdle == 5)
				image = idleright5;
			break;
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

	}
}
