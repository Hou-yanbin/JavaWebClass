package bookstore.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateCodeServlet
 */
@WebServlet("/ValidateCodeServlet")
public class ValidateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidateCodeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("image/jpeg");
		//字节流  字符流
		ServletOutputStream out=response.getOutputStream();
		int width=80;
		int height=20;
		BufferedImage  image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		String[] danci= {"落花流水",
				"一往无前",
				"落地生根",
				"天罗地网",
				"东山再起",
				"一事无成",
				"山清水秀",
				"语重心长",
				"别有洞天",
				"水深火热",
				"鸟语花香",
				"自以为是",};
		String code="";
		Random rd=new Random();
		code=danci[rd.nextInt(12)];
		Graphics g=image.getGraphics();
		g.setColor(Color.red);
		Font font=new Font("TimeNewRoman", Font.BOLD, 16);
		g.setFont(font);
		g.drawString(code, 5, 15);
		HttpSession session=request.getSession();//获取会话对象
		session.setAttribute("valcode", code); //把code放入会话属性 目的是会话跟踪  在其他servlet或者jsp页面可以把这个值取出来
		ImageIO.write(image, "jpeg", out);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
