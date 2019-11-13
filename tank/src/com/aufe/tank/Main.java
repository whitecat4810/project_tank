package com.aufe.tank;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		TankFrame frame = new TankFrame();
		
		/**
		 * 初始化敌方tank
		 */
		for (int i = 0; i < 5; i++) {
			frame.enemies.add(new Tank(100 + i*130, 50, Direction.DOWN,frame));
		}
		
		while (true) {
			Thread.sleep(50);
			frame.repaint();
		}
		
	}
}
