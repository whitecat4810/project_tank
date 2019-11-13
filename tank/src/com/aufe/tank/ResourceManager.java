package com.aufe.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 静态资源管理类
 * @author whitecat
 *
 */
public class ResourceManager {
	
	public static BufferedImage tankL, tankU, tankR, tankD;
	public static BufferedImage bulletL, bulletR, bulletU, bulletD;
	//public static BufferedImage bulletA;
	public static BufferedImage[] explosions = new BufferedImage[16];
	
	static {
		
		try {
			/**
			 * 加载坦克图片
			 */
			tankU = ImageIO.read(ResourceManager.class.getClassLoader()
					.getResourceAsStream("images/friendlyForces1.png"));
			tankL = ImageUtil.rotateImage(tankU, -90);
			tankR = ImageUtil.rotateImage(tankU, 90);
			tankD = ImageUtil.rotateImage(tankU, 180);
			
			/**
			 * 加载子弹图片
			 */
			bulletU = ImageIO.read(ResourceManager.class.getClassLoader()
					.getResourceAsStream("images/bulletU.png"));
			bulletL = ImageUtil.rotateImage(bulletU, -90);
			bulletR = ImageUtil.rotateImage(bulletU, 90);
			bulletD = ImageUtil.rotateImage(bulletU, 180);
			//bulletA = ImageIO.read(ResourceManager.class.getClassLoader()
				//	.getResourceAsStream("images/bulletA.png"));
			
			/**
			 * 加载爆炸图片
			 */
			for (int i = 0; i < 16; i++) {
				explosions[i] = ImageIO.read(ResourceManager.class.getClassLoader()
						.getResourceAsStream("images/e" + (i+1) + ".gif"));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
