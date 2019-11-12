package com.aufe.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame{

	public TankFrame() {
		
		setVisible(true);	//设置窗口可见
		setResizable(false);	//设置不可改变窗口大小
		setSize(800, 600);	//设置窗口宽度800px 长度600px
		setTitle("Tanks War");	//设置标题
		
		this.addKeyListener(new KeyListener());	//创建键盘监听
		
		addWindowListener(new WindowAdapter() {	
			
			/**
			 * 窗口关闭功能
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
	}
	
	@Override
	public void paint(Graphics g) {
		
		
	}
	
	/**
	 * 键盘监听内部类
	 * @author whitecat
	 *
	 */
	class KeyListener extends KeyAdapter {

		/**
		 * 按下键盘事件监听
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("dd");
		}
		
		/**
		 * 抬起键盘事件监听
		 */
		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("aa");
		}
		
		
	}
	
	
	
}
