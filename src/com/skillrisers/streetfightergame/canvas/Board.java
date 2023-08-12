  package com.skillrisers.streetfightergame.canvas;

import javax.imageio.ImageIO;
import javax.swing.Timer;
import javax.swing.JPanel;

import com.skillrisers.streetfightergame.sprites.Health;
import com.skillrisers.streetfightergame.sprites.Ken;
import com.skillrisers.streetfightergame.sprites.PowerEffect;
import com.skillrisers.streetfightergame.sprites.Ryu;
import com.skillrisers.streetfightergame.utils.Constants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Board extends JPanel implements Constants {
    BufferedImage imageBg;
    private Ryu ryu;
    private Ken ken;
    private Timer timer;
    private Health ryu_health;
    private Health ken_health;
    private boolean gameOver;
    
    public Board() throws IOException{
        ryu = new Ryu();
        ken = new Ken();
        setFocusable(true);
        loadBackground();
        bindEvents();
        gameloop();
        loadHealth();
    }
    // @Override
    // protected void paintComponent(Graphics pen) {
    //     super.paintComponent(pen);
    //     pen.setColor(Color.GREEN);
    //     pen.fillRect(10,10,100,100);
    //     pen.setColor(Color.RED);
    //     pen.drawOval(200,200,100,100);
    //     pen.fillOval(200, 200, 100, 100);
    // }
    
    private void gameloop() {
    	timer = new Timer(300,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ryu.fall();
				collision();
				isGameOver();
				repaint();
				if(gameOver) {
					timer.stop();
				}
			}
    	});
    	timer.start();
    }
    private void loadHealth() {
    	ryu_health = new Health(30,"RYU");
    	ken_health = new Health(SCREENWIDTH-560,"KEN");
    }
    private void printHealth(Graphics pen) {
    	ryu_health.printHealth(pen);
    	ken_health.printHealth(pen);
    }
    private boolean isCollide(){
    	int xDist = Math.abs(ryu.getX()-ken.getX());
    	int yDist = Math.abs(ryu.getY()-ken.getY());
    	int maxH = Math.max(ryu.getH(), ken.getH());
    	int maxW = Math.max(ryu.getW(), ryu.getW());
    	return xDist<=maxW && yDist<=maxH;
    }
    private void collision() {
    	if(isCollide()) {
    		if(ryu.isAttacking() && ken.isAttacking()) {
    			
    		}
    		else if(ken.isAttacking()) {
    			ryu.setCurrentmove(HIT);
    			ryu_health.setHealth();
    		}
    		else if(ryu.isAttacking()) {
    			ken.setCurrentmove(HIT);
    			ken_health.setHealth();
    		}
    		ryu.setCollide(true);
    		ryu.setSpeed(0);
    		ken.setCollide(true);
    		ken.setSpeed(0);
    	}
    	else {
    		ryu.setCollide(false);
    		ryu.setSpeed(SPEED);
    		ken.setCollide(false);
    		ken.setSpeed(SPEED);
    	}
    } 
    private void isGameOver() {
    	if(ryu_health.getHealth() <=0 || ken_health.getHealth() <=0) {
    		gameOver = true;
    	}
    }
    private void printGameOver(Graphics pen) {
    	if(gameOver) {
    		pen.setColor(Color.RED);
    		pen.setFont(new Font("times",Font.BOLD,100));
    		pen.drawString("GAME OVER", 250,300);
    		
    	}
    }
    @Override
    protected void paintComponent(Graphics g) {
        ShowBackground(g);
        ryu.ShowPlayer(g);
        ken.ShowPlayer(g);
        printPower(g);
        printHealth(g);
        printGameOver(g);
    }
    
    private void ShowBackground(Graphics pen){
        pen.drawImage(imageBg, 0, 0, SCREENWIDTH,SCREENHEIGHT-35,null);
    }
    private void printPower(Graphics pen){
        for(PowerEffect power:ryu.getPowers()) {
        	power.printpower(pen);
        }
    }

    private void loadBackground() throws IOException{
        imageBg = ImageIO.read(Board.class.getResource(BACKGROUND_IMAGE));
    }
    void bindEvents() {
    	this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				//System.out.println("typed..." + e.getKeyCode());
			}

			@Override
			public void keyReleased(KeyEvent e) {
				//System.out.println("released..."+e.getKeyCode());
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println("pressed..."+e.getKeyCode());
				if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
					ryu.setSpeed(-SPEED);
					ryu.move();
					ryu.setCollide(false);
					ryu.setCurrentmove(WALK);
					//repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
					ryu.setSpeed(SPEED);
					ryu.move();
					ryu.setCurrentmove(WALK);
					//repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
					ryu.jump();
					ryu.setCurrentmove(WALK);
					//repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_S) {
					ryu.setCurrentmove(PUNCH);
					ryu.setAttacking(true);
					//repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_F) {
					ryu.setCurrentmove(POWER);
					ryu.setAttacking(true);
					ryu.showpower();
					//repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_J) {
					ken.setSpeed(-SPEED);
					ken.move();
					ken.setCurrentmove(WALK);
					//repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_P) {
					ken.setCurrentmove(KICK);
					ken.setAttacking(true);
					//repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_L) {
					ken.setSpeed(SPEED);
					ken.setCollide(false);
					ken.move();
					ken.setCurrentmove(WALK);
					//repaint();
				}
			}
    	});
    }
}
