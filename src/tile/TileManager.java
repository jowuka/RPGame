package tile;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.*;

import Main.GamePanel;

public class TileManager {
	GamePanel gp;
	Tile[] tile;
	int mapTileNum[][];
	String FirstMap = "/map/map.txt";
	public TileManager(GamePanel gp) {
		this.gp = gp;
		tile = new Tile[10];
		mapTileNum = new int[gp.maxWorldcol][gp.maxWorldrow];
		getTileImage();
		loadMap(FirstMap);
	}
	public void getTileImage() {		// Tile Images Each Index of Array Contains a Picture!!!
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/32greengrass.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sprite_0182.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sprite_0183.png"));
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sprite_0184.png"));
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sprite_0001.png"));
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sprite_0002.png"));
			
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sprite_0003.png"));
			
			
		} catch (Exception e) {
			
		}
	}
	public void loadMap(String dest) {
		
		try {
			InputStream is = getClass().getResourceAsStream(dest);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldcol && row < gp.maxWorldrow) {
				
				String line = br.readLine();
				while(col < gp.maxWorldcol) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				if (col == gp.maxWorldcol) {
					col = 0;
					row++;
				}
			}
			br.close();
		} catch (Exception e) {
			
		}
	}
	public void draw(Graphics g2) {
		int worldCol = 0;
		int worldRow = 0;

		while (worldCol < gp.maxWorldcol && worldRow < gp.maxWorldrow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
					worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
					worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
					worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
					g2.drawImage(tile[0].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
				if (tileNum != 0)
					g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			}
				worldCol++;
			
			if(worldCol == gp.maxWorldcol) {
				worldCol = 0;
				worldRow++;
			}
		}
	}
}
