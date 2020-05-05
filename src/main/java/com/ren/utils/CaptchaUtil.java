package com.ren.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.experimental.theories.Theories;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * @ClassName: CaptchaUtil
 * @Description: 关于验证码的工具类
 * @author 无名
 */
public final class CaptchaUtil {
	
	private CaptchaUtil() {
	}

	/*
	 * 随机字符字典
	 */
	private static final char[] CHARS = { '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	/*
	 * 随机数
	 */
	private static Random random = new Random();

	/*
	 * 获取4位随机数
	 */
	private static String getRandomString() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			buffer.append(CHARS[random.nextInt(CHARS.length)]);
		}
		return buffer.toString();
	}

	/*
	 * 获取随机数颜色
	 */
	private static Color getRandomColor() {
		return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}

	

	public static void outputCaptcha(HttpServletRequest request, HttpServletResponse response,int width,int height)
			throws ServletException, IOException {

		response.setContentType("image/jpeg");

		String randomString = getRandomString();
		request.getSession(true).setAttribute("randomString", randomString);
		Color color = getRandomColor();
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 26));
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, width, height);
		g.setColor(color);
		g.drawString(randomString, 18, 28);
		for (int i = 0, n = random.nextInt(100)*2; i < n; i++) {
			g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
		}

		// 转成JPEG格式
		ServletOutputStream out = response.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(bi);
		out.flush();
		out.close();
	}
	
	/**
	 * 验证码验证
	 * @param request
	 * @param response
	 * @param userInputCode
	 * @return
	 */
	public static boolean verify(HttpServletRequest request, HttpServletResponse response,String userInputCode) {
		if (request.getSession(false) != null) {
			return userInputCode.toLowerCase().equals(request.getSession().getAttribute("randomString").toString().toLowerCase());
		}
		return false;
	}
	
}