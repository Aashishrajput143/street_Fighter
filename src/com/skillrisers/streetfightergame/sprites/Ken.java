package com.skillrisers.streetfightergame.sprites;

import javax.imageio.ImageIO;

import com.skillrisers.streetfightergame.utils.Constants;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Ken extends CommonPlayer implements Constants {
    private BufferedImage idleImages[] = new BufferedImage[4];
    private BufferedImage kickImages[] = new BufferedImage[5];
    public Ken() throws IOException{
        x = SCREENWIDTH-300;
        y = SCREENHEIGHT-h-330;
        w = 150;
        h = 230;
        speed = 0;
        imagePlayer = ImageIO.read(Ken.class.getResource(PLAYER_KEN));
        loadIdleImages();
        loadkickImages();
    }
    
    private void loadIdleImages() {
    	idleImages[0] = imagePlayer.getSubimage(1347, 244, 114, 245);
    	idleImages[1] = imagePlayer.getSubimage(1116, 240, 118, 249);
    	idleImages[2] = imagePlayer.getSubimage(890, 242, 118, 247);
    	idleImages[3] = imagePlayer.getSubimage(672, 242, 117, 247);
    }
    private void loadkickImages() {
    	kickImages[0] = imagePlayer.getSubimage(1327, 1457, 126, 245);
    	kickImages[1] = imagePlayer.getSubimage(1118, 1457, 131, 245);
    	kickImages[2] = imagePlayer.getSubimage(840, 1462, 221, 240);
    	kickImages[3] = imagePlayer.getSubimage(1118, 1457, 131, 245);
    	kickImages[4] = imagePlayer.getSubimage(1327, 1457, 126, 245);
    }
    public BufferedImage printIdleImages() {
    	if(imageIndex>3) {
    		imageIndex = 0;
    	}
    	BufferedImage img = idleImages[imageIndex];
    	imageIndex++;
		return img;
    }
    public BufferedImage printkickImages() {
    	if(imageIndex>4) {
    		imageIndex = 0;
    		currentMove = IDLE;
    	}
    	BufferedImage img = kickImages[imageIndex];
    	imageIndex++;
		return img;
    }
	@Override
	public BufferedImage defaultImage() {
		isAttacking = false;
		if(currentMove == WALK) {
			return printIdleImages();
		}
		else if(currentMove == KICK) {
			return printkickImages();
		}
		else {
			return printIdleImages();
		}
	}
}
