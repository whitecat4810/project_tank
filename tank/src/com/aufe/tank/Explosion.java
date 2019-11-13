package com.aufe.tank;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 子弹类
 * @author whitecat
 *
 */
public class Explosion {
	
	private int x, y;	//子弹位置
	private int count = 0;	//记录动态图加载到第几个
	private boolean alive = true;	//子弹是否出界/爆炸,true为未出界
	public static final int WIDTH = 
			ResourceManager.explosions[0].getWidth(), 
			HEIGHT = ResourceManager.explosions[0].getHeight(); //子弹高度宽度
	private MainFrame frame = null;	//主框架的引用
	
	/**
	 * 创建爆炸特效
	 * @param g
	 */
	public void paint(Graphics g) {
		
		g.drawImage(ResourceManager.explosions[count++], x, y, null);
		
		if (count >= ResourceManager.explosions.length) frame.explosions.remove(this);	
		
	}

	public Explosion(int x, int y, MainFrame frame) {
		this.x = x;
		this.y = y;
		this.frame = frame;
		
		//new Thread(()->new Audio("audio/explode.wav").loop()).start();	//爆炸音效
		
	}

}
