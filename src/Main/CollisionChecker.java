package Main;

import entity.entity;

public class CollisionChecker {
	GamePanel gp;
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
		
	}
	public void checkTile(entity Entity) {
		int entityLeftWorldX = Entity.worldX + Entity.solidArea.x;
		int entityRightWorldX = Entity.worldX + Entity.solidArea.x + Entity.solidArea.width;
		int entityTopWorldY = Entity.worldY + Entity.solidArea.y;
		int entityBottomWorldY = Entity.worldY + Entity.solidArea.y + Entity.solidArea.height;
		
		int entityLeftCol = entityLeftWorldX / gp.tileSize;
		int entityRightCol = entityRightWorldX / gp.tileSize;
		int entityTopRow = entityTopWorldY / gp.tileSize;
		int entityBottomRow = entityBottomWorldY / gp.tileSize;
		
		int tileNum1, tileNum2;
		
		switch (Entity.direction) {
		case "up":
			entityTopRow = (entityTopWorldY + Entity.speed) / gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityLeftCol];
			if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				Entity.collisionOn = true;
			}
			break;
		case "down":
			entityBottomRow = (entityBottomWorldY - Entity.speed) / gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				Entity.collisionOn = true;
			}
			break;
		case "left":
			entityLeftCol = (entityLeftWorldX + Entity.speed) / gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				Entity.collisionOn = true;
			}
			break;
		case "right":
			entityRightCol = (entityRightWorldX - Entity.speed) / gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				Entity.collisionOn = true;
			}
			break;
		}
	}
}
