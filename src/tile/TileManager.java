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
		tile = new Tile[40];
		mapTileNum = new int[gp.maxWorldcol][gp.maxWorldrow];
		getTileImage();
		loadMap(FirstMap);
	}
	public void getTileImage() {		// Tile Images Each Index of Array Contains a Picture!!!
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/GreenCave/Ground/GreenGround1.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/GreenCave/Ground/GreenGround2.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/GreenCave/Ground/GreenGround3.png"));
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/GreenCave/Ground/GreenGround4.png"));
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/GreenCave/Decoration/GreenDecoration1.png"));
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/GreenCave/Decoration/GreenDecoration2.png"));
			
			tile[6] = new Tile();
<<<<<<< Updated upstream
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sprite_0003.png"));
			/*
=======
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/GreenCave/Decoration/GreenDecoration3.png"));
			
>>>>>>> Stashed changes
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/GreenCave/Decoration/GreenDecoration4.png"));

			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/GreenCave/Decoration/GreenDecoration5.png"));
			
			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/GreenCave/Decoration/GreenDecoration6.png"));
			
			tile[10] = new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/GreenCave/Decoration/GreenDecoration7.png"));
			
			tile[11] = new Tile();
<<<<<<< Updated upstream
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sprite_0028.png"));
			
			tile[12] = new Tile();
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sprite_0029.png"));

			tile[13] = new Tile();
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Grass98x98.png"));

*/
			//tile[14] = new Tile();
			//tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bed.png"));

			//tile[15] = new Tile();
			//tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/CasaUp.png"));


			//tile[16] = new Tile();
			//tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/houseDown.png"));

			tile[17] = new Tile();
			tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sprite_3026.png"));


			tile[18] = new Tile();
			tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sprite_3027.png"));

			tile[19] = new Tile();
			tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sprite_3039.png"));


			tile[20] = new Tile();
			tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sprite_3040.png"));

=======
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/GreenCave/Decoration/GreenDecoration8.png"));
>>>>>>> Stashed changes
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
				if(tileNum == 0)
					if (worldCol % 2 == 0) 
						if(worldRow % 2 == 0)
						g2.drawImage(tile[0].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
						else 
							g2.drawImage(tile[1].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
					else 
						if(worldRow % 2 == 0)
							g2.drawImage(tile[2].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
						else 
							g2.drawImage(tile[3].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
				else {
					g2.drawImage(tile[0].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
					g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
				}
				
			}
			worldCol++;
			
			if(worldCol == gp.maxWorldcol) {
				worldCol = 0;
				worldRow++;
			}
		}
	}
}
