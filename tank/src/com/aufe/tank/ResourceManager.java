package com.aufe.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceManager {
	
	public static BufferedImage tankL, tankU, tankR, tankD;
	
	static {
		
		try {
			tankL = ImageIO.read(ResourceManager.class.getClassLoader()
					.getResourceAsStream("images/tankL.gif"));
			tankU = ImageIO.read(ResourceManager.class.getClassLoader()
					.getResourceAsStream("images/tankU.gif"));
			tankR = ImageIO.read(ResourceManager.class.getClassLoader()
					.getResourceAsStream("images/tankR.gif"));
			tankD = ImageIO.read(ResourceManager.class.getClassLoader()
					.getResourceAsStream("images/tankD.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
