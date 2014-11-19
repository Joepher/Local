package com.joepher.servlet;

import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.dom4j.*;
import org.dom4j.io.*;

public class PlacardAddServlet extends HttpServlet
{
	private static final long serialVersionUID = -2717447164121014228L;

	@SuppressWarnings("deprecation")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException
	{
		// req.setCharacterEncoding("GBK");
		resp.setContentType("text/html;charset=GBK");

		String fileURL = req.getRealPath("/WEB-INF/xml/placard.xml"); // XML文件的路径
		File file = new File(fileURL);
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Document document = null;
		Element placard = null;
		DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");

		if (!file.exists())
		{
			document = DocumentHelper.createDocument(); // 创建XML文档对象
			placard = DocumentHelper.createElement("placard");// 创建普通节点
			document.setRootElement(placard); // 将placard设置为根节点
			placard.addAttribute("version", "2.0");// 为根节点添加属性version
			Element description = placard.addElement("description");// 添加description子节点
			description.setText("公告栏");
			Element createTime = placard.addElement("createTime");// 添加createTime子节点
			createTime.setText("创建于" + df.format(new Date()));
		}
		else
		{
			SAXReader reader = new SAXReader();// 实例化SAXReader对象
			try
			{
				document = reader.read(new File(fileURL));// 获取XML文件对应的XML文档对象
				placard = document.getRootElement();// 获取根节点
			}
			catch (DocumentException e)
			{
				e.printStackTrace();
			}
		}
		/* 添加公告信息 */
		String id = String.valueOf(placard.elements("info").size() + 1);// 获取当前公告的ID号
		Element info = placard.addElement("info");// 添加info节点
		info.addAttribute("id", id);// 为info节点设置ID属性
		Element title_info = info.addElement("title");// 添加title节点
		title_info.setText(title);// 设置title节点的内容
		Element content_item = info.addElement("content");// 添加content节点
		// 此处不能使用setText()方法，如果使用该方法，当内容中出现HTML代码时，程序将出错
		content_item.addCDATA(content);// 设置content节点的内容为CDATA段
		Element pubDate_item = info.addElement("pubDate");// 添加pubDate节点
		df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		pubDate_item.setText(df.format(new Date()));

		// 保存文件
		// 创建OutputFormat对象
		OutputFormat format = OutputFormat.createPrettyPrint();// 格式化为缩进方式
		format.setEncoding("GBK");// 设置写入流编码
		try
		{
			XMLWriter writer = new XMLWriter(new FileWriter(fileURL), format);
			writer.write(document);// 向流写入数据
			writer.close();// 关闭流
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// req.getRequestDispatcher("/WEB-INF/xml/placard.xml").forward(req,
		// resp);
		PrintWriter out = resp.getWriter();
		out
				.println("<script>alert('发布成功！');window.location.href='PlacardEditServlet?action=query';</script>");
	}
}
