package com.aufe.tank;

/**
 * 程序入口
 * @author whitecat
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		MainFrame frame = new MainFrame();
		
		int initTankCount = Integer.parseInt((String) PropertyManager.getKey("initTankCount"));
		
		/**
		 * 初始化敌方tank
		 */
		for (int i = 0; i < initTankCount; i++) {
			frame.enemies.add(new Tank(100 + i*130, 50, 
					Direction.DOWN, Team.HOS_FORCES, frame));
		}
		
//		new Thread(()->new Audio("audio/bgwar.wav").loop()).start();;
		
		while (true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			frame.repaint();
		}
		
	}
	
}
