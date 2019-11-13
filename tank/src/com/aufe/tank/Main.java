package com.aufe.tank;

/**
 * 程序入口
 * @author whitecat
 *
 */
public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		MainFrame frame = new MainFrame();
		
		/**
		 * 初始化敌方tank
		 */
		for (int i = 0; i < 5; i++) {
			frame.enemies.add(new Tank(100 + i*130, 50, 
					Direction.DOWN, Team.HOS_FORCES, frame));
		}
		
		//new Thread(()->new Audio("audio/bgwar.wav").loop()).start();;
		
		while (true) {
			Thread.sleep(50);
			frame.repaint();
		}
		
	}
	
}
