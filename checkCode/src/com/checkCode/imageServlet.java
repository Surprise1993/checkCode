package com.checkCode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class imageServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		创建图片设置图片大小格式
		BufferedImage bImage = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
//		颜色绘制设置
		Graphics g = bImage.getGraphics();
		Color color = new Color(200, 150, 225);
//		设置背景颜色
		g.setColor(color);
//		设置边框
		g.fillRect(0, 0, 68, 22);
//		设置图片上的文字
		char[] ch = "ABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789".toCharArray();

		Random random = new Random();
		int len = ch.length,index;
//		存储生成的验证码
		StringBuffer sBuffer = new StringBuffer();
		for(int i = 0; i < 4; i ++) {
//			生成随机数
			index = random.nextInt(len);
//			设置文字颜色
			g.setColor(new Color(random.nextInt(88), random.nextInt(188), random.nextInt(255)));
//			在图片上写文字
			g.drawString(ch[index] + "",(i*15)+3, 18);
//			保存在图片上写的文字
			sBuffer.append(ch[index]);
		}
//		将随机生成的文字保存到session
		req.getSession().setAttribute("piccode", sBuffer.toString());
//		将图片生成,保存到response中
		ImageIO.write(bImage, "JPG", resp.getOutputStream());
	}

}
