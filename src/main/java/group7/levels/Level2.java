package group7.levels;

import java.awt.Color;
import java.awt.image.BufferedImage;

import group7.helperClasses.AssetLoader;
import static group7.entities.inanimate.Inanimate.*;


/** 
* The class Level2 creates objects the player, all Enemies, traps, and collectable objects (such as 
* keys, eggs, and potions) for Level Two and spawns them in their designated positions onto the map.
*
* @author  Mohammad Parsaei
* @author  Salman Ayaz
* @author  Karmen Yung
* @author  Chen Min
* @version 1.0
* @since 2023-03-13
*/
public class Level2 extends Level {

    public Level2(int dinoNumber) {
        super(dinoNumber);
        addPlayer(1, 3, dinoNumber);

        addEnemy(5, 5, 2, 3, 1);
        addEnemy(6, 14, 2, 3, 2);
        addEnemy(13, 8, 2, 3, 3);
        addEnemy(18, 16, 2, 3,  4);

        addTrap(3, 14);
        addTrap(16, 6);
        addTrap(15, 15);
        addTrap(8, 7);

        addKey(17, 8); 
        addKey(3, 12);
        addKey(11, 16);
        addKey(14, 16);

        addEgg(2, 16, 500);
        addEgg(7, 3, 400);
        addEgg(16, 4, 300);
        addEgg(15, 12, 200);
        addEgg(9, 16, 100);

        addPotion(1, 9, PURPLE_SPEED_POTION );    
        addPotion(14, 13, PURPLE_SPEED_POTION );    
        addPotion(9, 12, GREEN_HEALTH_POTION );    
        addPotion(13, 5, GREEN_HEALTH_POTION );    
        addPotion(11, 8, GREEN_HEALTH_POTION );    
    }

    @Override
    protected void setLevelData() { //TEST MULTIPLE LEVELS
        BufferedImage img = AssetLoader.getSpriteAtlas("levels/level_maps/level_" + 2 + ".png"); //TEST MULTIPLE LEVELS, changed from AssetLoader.LEVEL_1 to filename

        this.width = img.getWidth();
        this.height = img.getHeight();

        levelSpriteData = new int[width][height];
        pathfinding = new Pathfinding(width, height);

        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                Color color = new Color(img.getRGB(x, y));
                int value = color.getRed() % 74; //73 is the clear tile

                levelSpriteData[x][y] = value;
                pathfinding.set(x, y, value != 13 ? false:true);
            }
        }
    }
}