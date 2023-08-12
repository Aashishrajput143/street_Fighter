package com.skillrisers.streetfightergame.sprites;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PowerEffect extends CommonPlayer {
	public PowerEffect(int x, int y,BufferedImage img) {
		this.imagePlayer = img;
		this.x = x;
		this.y = y;
		w=50;
		h=50;
		speed = 70;
		
	}

	@Override
	public BufferedImage defaultImage() {
		// TODO Auto-generated method stub
		return imagePlayer.getSubimage(30,1028,98,82);
	}
	public void printpower(Graphics pen) {
    		pen.drawImage(defaultImage(), x, y, w, h, null);
    		move();
    }
}
