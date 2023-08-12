package com.skillrisers.streetfightergame.canvas;

import java.io.IOException;

import javax.swing.JFrame;

import com.skillrisers.streetfightergame.utils.Constants;


public class GameFrame extends JFrame implements Constants {
	private Board board;
	public GameFrame() throws IOException {
		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(SCREENWIDTH,SCREENHEIGHT);
		board = new Board();
		add(board);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	public static void main(String[] args) throws IOException {
		//new GameFrame();
	}

}
