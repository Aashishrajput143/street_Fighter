package com.skillrisers.streetfightergame.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.skillrisers.streetfightergame.utils.Constants;

abstract public class CommonPlayer implements Constants {
	protected BufferedImage imagePlayer;
	protected int x ;
	protected int y ;
	protected int w ;
	protected int h ;
	protected int speed;
	protected int imageIndex;
	protected int currentMove;
	protected boolean isCollide;
	protected boolean isAttacking;
	protected int health;
	
	public CommonPlayer() {
		health = MAX_HEALTH;
	}
	public abstract BufferedImage defaultImage();
	
	public int getHealth() {
		return health;
	}
	public void setHealth() {
		this.health = (int)(health - MAX_HEALTH * 0.05);
	}
	public boolean isAttacking() {
		return isAttacking;
	}
	public void setAttacking(boolean isAttacking) {
		this.isAttacking = isAttacking;
	}
	public boolean isCollide() {
		return isCollide;
	}
	public void setCollide(boolean isCollide) {
		this.isCollide = isCollide;
	}
	public int getCurrentmove() {
		return currentMove;
	}
	public void setCurrentmove(int currentMove) {
		this.currentMove = currentMove;
	}
	public BufferedImage getImagePlayer() {
		return imagePlayer;
	}
	public void setImagePlayer(BufferedImage imagePlayer) {
		this.imagePlayer = imagePlayer;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void move() {
    	if(x<1) {
    		x = 1;
    	}
    	else if(x>1059) {
    		x = 1059;
    	}
    	else if(!isCollide) {
    		x = x + speed;
    	}
    }
    public void ShowPlayer(Graphics pen){
        pen.drawImage(defaultImage(), x, y, w,h,null);
    }
}