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

		String fileURL = req.getRealPath("/WEB-INF/xml/placard.xml"); // XML�ļ���·��
		File file = new File(fileURL);
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Document document = null;
		Element placard = null;
		DateFormat df = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��");

		if (!file.exists())
		{
			document = DocumentHelper.createDocument(); // ����XML�ĵ�����
			placard = DocumentHelper.createElement("placard");// ������ͨ�ڵ�
			document.setRootElement(placard); // ��placard����Ϊ���ڵ�
			placard.addAttribute("version", "2.0");// Ϊ���ڵ��������version
			Element description = placard.addElement("description");// ���description�ӽڵ�
			description.setText("������");
			Element createTime = placard.addElement("createTime");// ���createTime�ӽڵ�
			createTime.setText("������" + df.format(new Date()));
		}
		else
		{
			SAXReader reader = new SAXReader();// ʵ����SAXReader����
			try
			{
				document = reader.read(new File(fileURL));// ��ȡXML�ļ���Ӧ��XML�ĵ�����
				placard = document.getRootElement();// ��ȡ���ڵ�
			}
			catch (DocumentException e)
			{
				e.printStackTrace();
			}
		}
		/* ��ӹ�����Ϣ */
		String id = String.valueOf(placard.elements("info").size() + 1);// ��ȡ��ǰ�����ID��
		Element info = placard.addElement("info");// ���info�ڵ�
		info.addAttribute("id", id);// Ϊinfo�ڵ�����ID����
		Element title_info = info.addElement("title");// ���title�ڵ�
		title_info.setText(title);// ����title�ڵ������
		Element content_item = info.addElement("content");// ���content�ڵ�
		// �˴�����ʹ��setText()���������ʹ�ø÷������������г���HTML����ʱ�����򽫳���
		content_item.addCDATA(content);// ����content�ڵ������ΪCDATA��
		Element pubDate_item = info.addElement("pubDate");// ���pubDate�ڵ�
		df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		pubDate_item.setText(df.format(new Date()));

		// �����ļ�
		// ����OutputFormat����
		OutputFormat format = OutputFormat.createPrettyPrint();// ��ʽ��Ϊ������ʽ
		format.setEncoding("GBK");// ����д��������
		try
		{
			XMLWriter writer = new XMLWriter(new FileWriter(fileURL), format);
			writer.write(document);// ����д������
			writer.close();// �ر���
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// req.getRequestDispatcher("/WEB-INF/xml/placard.xml").forward(req,
		// resp);
		PrintWriter out = resp.getWriter();
		out
				.println("<script>alert('�����ɹ���');window.location.href='PlacardEditServlet?action=query';</script>");
	}
}
