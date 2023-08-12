package com.skillrisers.streetfightergame.sprites;


import com.skillrisers.streetfightergame.utils.Constants;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Ryu extends CommonPlayer implements Constants {
    private BufferedImage idleImages[] = new BufferedImage[5];
    private BufferedImage walkImages[] = new BufferedImage[6];
    private BufferedImage punchImages[] = new BufferedImage[5];
    private BufferedImage kickImages[] = new BufferedImage[5];
    private BufferedImage powerImages[] = new BufferedImage[4];
    private BufferedImage hitImages[] = new BufferedImage[3];
    
    private int force;
    public Ryu() throws IOException{
        x = 200;
        y = SCREENHEIGHT-h-330;
        w = 150;
        h = 230;
        speed = 0;
        force = 0;
        imageIndex = 0;
        imagePlayer = ImageIO.read(Ryu.class.getResource(PLAYER_RYU));
        loadIdleImages();
        loadwalkImages();
        loadpunchImages();
        loadpowerImages();
        loadhitImages();
    }
    public void jump() {
    	if(y>70) {
    	force = -40;
    	
    	}
    }
    public void fall() {
    	if(y+force > GROUND) {
    		return;
    	}
    	force = force+GRAVITY;
    	y = y + force;
    	}
    private void loadIdleImages() {
    	idleImages[0] = imagePlayer.getSubimage(7, 11, 60, 93);//getspritexy.com to know the coordinates.
    	idleImages[1] = imagePlayer.getSubimage(73, 12, 64, 92);
    	idleImages[2] = imagePlayer.getSubimage(140, 12, 61, 92);
    	idleImages[3] = imagePlayer.getSubimage(211, 9, 57, 95);
    	idleImages[4] = imagePlayer.getSubimage(276, 9, 60, 95);
    }
    private void loadwalkImages() {
    	walkImages[0] = imagePlayer.getSubimage(10, 135, 54, 86);
    	walkImages[1] = imagePlayer.getSubimage(78, 130, 64, 91);
    	walkImages[2] = imagePlayer.getSubimage(151, 126, 67, 95);
    	walkImages[3] = imagePlayer.getSubimage(228, 126, 66, 95);
    	walkImages[4] = imagePlayer.getSubimage(305, 126, 57, 95);
    	walkImages[5] = imagePlayer.getSubimage(369, 126, 54, 95);
    }
    private void loadpunchImages() {
    	punchImages[0] = imagePlayer.getSubimage(6, 465, 60, 96);
    	punchImages[1] = imagePlayer.getSubimage(85, 465, 74, 96);
    	punchImages[2] = imagePlayer.getSubimage(174, 465, 112, 96);
    	punchImages[3] = imagePlayer.getSubimage(85, 465, 74, 96);
    	punchImages[4] = imagePlayer.getSubimage(6, 465, 60, 96);
    }
    private void loadpowerImages() {
    	powerImages[0] = imagePlayer.getSubimage(31, 7, 154, 226);
    	powerImages[1] = imagePlayer.getSubimage(239, 7, 161, 226);
    	powerImages[2] = imagePlayer.getSubimage(441, 7, 193, 226);
    	powerImages[3] = imagePlayer.getSubimage(660, 7, 195, 226);
    }
    private void loadhitImages() {
    	hitImages[0] = imagePlayer.getSubimage(167, 2151, 67, 91);
    	hitImages[1] = imagePlayer.getSubimage(236, 2151, 70, 91);
    	hitImages[2] = imagePlayer.getSubimage(315, 2151, 70, 91);
    }
    public BufferedImage printIdleImages() {
    	if(imageIndex>4) {
    		imageIndex = 0;
    	}
    	BufferedImage img = idleImages[imageIndex];
    	imageIndex++;
		return img;
    }
    public BufferedImage printwalkImages() {
    	if(imageIndex>5) {
    		imageIndex = 0;
    		currentMove = IDLE;
    	}
    	BufferedImage img = walkImages[imageIndex];
    	imageIndex++;
		return img;
    }
    public BufferedImage printpunchImages() {
    	if(imageIndex>4) {
    		imageIndex = 0;
    		currentMove = IDLE;
    	}
    	BufferedImage img = punchImages[imageIndex];
    	imageIndex++;
		return img;
    }
    public BufferedImage printpowerImages() {
    	if(imageIndex>3) {
    		imageIndex = 0;
    		currentMove = IDLE;
    	}
    	BufferedImage img = powerImages[imageIndex];
    	imageIndex++;
		return img;
    }
    private ArrayList<PowerEffect> powers = new ArrayList<>();
    
    public  ArrayList<PowerEffect> getPowers(){
    	return powers;
    }
    public void showpower() {
    	powers.add(new PowerEffect(x+w-50,y+h/2 - 70,imagePlayer));
    }
    public BufferedImage printhitImages() {
    	if(imageIndex>2) {
    		imageIndex = 0;
    		currentMove = IDLE;
    	}
    	BufferedImage img = hitImages[imageIndex];
    	imageIndex++;
		return img;
    }
//    private void LoadPlayer() throws IOException{
//        imagePlayer = ImageIO.read(Ryu.class.getResource(PLAYER_RYU));
//        imagePlayer = imagePlayer.getSubimage(7, 11, 60, 93);
//    }
	@Override
	public BufferedImage defaultImage() {
		isAttacking = false;
		if(currentMove == WALK) {
			return printwalkImages();
		}
		else if(currentMove == PUNCH) {
			return printpunchImages();
		}
		else if(currentMove == POWER) {
			return printpowerImages();
		}
		else if(currentMove == HIT) {
			return printhitImages();
		}
		else {
		return printIdleImages();
		}
	}
}
