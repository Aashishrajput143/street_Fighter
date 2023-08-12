package com.skillrisers.streetfightergame.canvas;

import java.io.File;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.skillrisers.streetfightergame.utils.Constants;

import jaco.mp3.player.MP3Player;

public class Splash extends JFrame implements Constants{
	private JLabel label = new JLabel();
	public Splash() {
	setTitle(TITLE);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(SCREENWIDTH,SCREENHEIGHT+100);
	setLocationRelativeTo(null);
	Icon icon = new ImageIcon(Splash.class.getResource("SplashScreen.png"));
	label.setIcon(icon);
	this.add(label);
	LoadMusic();
	setVisible(true);
	try {
		Thread.sleep(5000);
		setVisible(false);
		dispose();
		GameFrame obj = new GameFrame();
	} catch (IOException | InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	private void LoadMusic() {
	    new MP3Player(Splash.class.getResource("test.mp3")).play();
	}
	
	public static void main(String[] args) {
		Splash obj = new Splash();
	}
}
