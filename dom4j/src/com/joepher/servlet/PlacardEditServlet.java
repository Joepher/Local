package com.joepher.servlet;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.dom4j.*;
import org.dom4j.io.*;

import com.joepher.entity.*;

public class PlacardEditServlet extends HttpServlet
{
	private static final long serialVersionUID = -8835837299294740336L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException
	{
		resp.setContentType("text/html;charset=GBK");
		String action = req.getParameter("action");

		if ("query".equals(action))
			query(req, resp);
		else if ("modify_query".equals(action))
			this.modify_query(req, resp);
		else if ("del".equals(action))
			this.del(req, resp);
		else if ("clearAll".equals(action))
			this.clearAll(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException
	{
		String action = req.getParameter("action");
		if ("modify".equals(action))
			this.modify(req, resp);
	}

	@SuppressWarnings( { "deprecation", "unchecked" })
	private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException
	{
		resp.setContentType("text/html;charset=GBK");
		String fileURL = req.getRealPath("/WEB-INF/xml/placard.xml");
		File file = new File(fileURL);
		Document document = null;
		Element placard = null;
		List<PlacardForm> list = null;
		String description = "";
		String createTime = "";

		if (file.exists())
		{
			SAXReader reader = new SAXReader();// ʵ����SAXReader����
			try
			{
				document = reader.read(new File(fileURL));// ��ȡXML�ļ���Ӧ��XML�ĵ�����
				placard = document.getRootElement();// ��ȡ���ڵ�
				List<Element> list_item = placard.elements("info");
				description = placard.element("description").getText();
				createTime = placard.element("createTime").getText();
				int id = 0;
				String title = "";
				String content = "";
				String pubDate = "";

				if (list_item.size() > 0)
					list = new ArrayList<PlacardForm>();

				for (int i = list_item.size(); i > 0; i--)
				{
					PlacardForm f = new PlacardForm();
					Element item = (Element) list_item.get(i - 1);
					id = Integer.parseInt(item.attribute("id").getValue());
					f.setId(id);

					if (item.element("title").getText() != null)
						title = item.element("title").getText();
					else
						title = "���ޱ���";
					f.setTitle(title);

					if (item.element("content").getText() != null)
						content = item.element("content").getText();
					else
						content = "��������";
					f.setContent(content);

					if (item.element("pubDate").getText() != null)
						pubDate = item.element("pubDate").getText();
					else
						pubDate = "����ʱ��";
					f.setPubDate(pubDate);

					list.add(f);
				}
			}
			catch (DocumentException e)
			{
				e.printStackTrace();
			}
		}
		req.setAttribute("createTime", createTime);
		req.setAttribute("description", description);
		req.setAttribute("rssContent", list);
		req.getRequestDispatcher("/WEB-INF/jsp/listPlacard.jsp").forward(req, resp);
	}

	@SuppressWarnings("deprecation")
	private void modify_query(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException
	{
		resp.setContentType("text/html;charset=GBK");
		String fileURL = req.getRealPath("/WEB-INF/xml/placard.xml");
		File file = new File(fileURL);
		Document document = null;
		Element placard = null;
		int id = Integer.parseInt(req.getParameter("id"));
		PlacardForm f = new PlacardForm();

		if (file.exists())
		{
			SAXReader reader = new SAXReader();
			try
			{
				document = reader.read(new File(fileURL));// ��ȡXML�ļ���Ӧ��XML�ĵ�����
				placard = document.getRootElement();// ��ȡ���ڵ�
				Element item = (Element) placard.selectSingleNode("/placard/info[@id=" + id + "]");

				if (item != null)
				{
					String title = "";
					String content = "";
					String pubDate = "";

					id = Integer.parseInt(item.attributeValue("id"));
					f.setId(id);

					if (item.element("title").getText() != null)
						title = item.element("title").getText();
					else
						title = "���ޱ���";
					f.setTitle(title);

					if (item.element("content").getText() != null)
						content = item.element("content").getText();
					else
						content = "��������";
					f.setContent(content);

					if (item.element("pubDate").getText() != null)
						pubDate = item.element("pubDate").getText();
					else
						pubDate = "����ʱ��";
					f.setPubDate(pubDate);

					document.clearContent();// �ͷ���Դ
				}
			}
			catch (DocumentException e)
			{
				e.printStackTrace();
			}
		}
		req.setAttribute("placardContent", f);// ���湫����Ϣ
		req.getRequestDispatcher("/WEB-INF/jsp/modifyPlacard.jsp").forward(req, resp);
	}

	@SuppressWarnings("deprecation")
	private void modify(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException
	{
		resp.setContentType("text/html;charset=GBK");
		String fileURL = req.getRealPath("/WEB-INF/xml/placard.xml");
		File file = new File(fileURL);
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		DateFormat df = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��");
		String pubDate = df.format(new Date());
		int id = Integer.parseInt(req.getParameter("id"));
		Document document = null;
		Element placard = null;

		if (file.exists())
		{
			SAXReader reader = new SAXReader();
			try
			{
				document = reader.read(new File(fileURL));// ��ȡXML�ļ���Ӧ��XML�ĵ�����
				placard = document.getRootElement();// ��ȡ���ڵ�
				Element item = (Element) placard.selectSingleNode("/placard/info[@id=" + id + "]");

				if (item != null)
				{
					item.element("title").setText(title);
					item.element("content").setText(content);
					item.element("pubDate").setText(pubDate);
				}
			}
			catch (DocumentException e)
			{
				e.printStackTrace();
			}
		}

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
		PrintWriter out = resp.getWriter();
		out
				.println("<script>alert('�޸ĳɹ���');window.location.href='PlacardEditServlet?action=query';</script>");
	}

	@SuppressWarnings("deprecation")
	private void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException
	{
		resp.setContentType("text/html;charset=GBK");
		String fileURL = req.getRealPath("/WEB-INF/xml/placard.xml");
		File file = new File(fileURL);
		int id = Integer.parseInt(req.getParameter("id"));
		Document document = null;
		Element placard = null;

		if (file.exists())
		{
			SAXReader reader = new SAXReader();
			try
			{
				document = reader.read(new File(fileURL));// ��ȡXML�ļ���Ӧ��XML�ĵ�����
				placard = document.getRootElement();// ��ȡ���ڵ�
				Element item = (Element) placard.selectSingleNode("/placard/info[@id=" + id + "]");

				if (item != null)
				{
					placard.remove(item);
				}
			}
			catch (DocumentException e)
			{
				e.printStackTrace();
			}
		}

		OutputFormat format = OutputFormat.createPrettyPrint();// ��ʽ��Ϊ������ʽ
		format.setEncoding("GBK");// ����д��������
		try
		{
			XMLWriter writer = new XMLWriter(new FileWriter(fileURL), format);
			writer.write(document);// ����д������
			writer.close();// �ر���
			document.clearContent();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		PrintWriter out = resp.getWriter();
		out
				.println("<script>alert('ɾ���ɹ���');window.location.href='PlacardEditServlet?action=query';</script>");
	}

	@SuppressWarnings("deprecation")
	private void clearAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException
	{
		resp.setContentType("text/html;charset=GBK");
		String fileURL = req.getRealPath("/WEB-INF/xml/placard.xml");
		File file = new File(fileURL);
		Document document = null;

		if (file.exists())
		{
			SAXReader reader = new SAXReader();
			try
			{
				document = reader.read(new File(fileURL));// ��ȡXML�ļ���Ӧ��XML�ĵ�����
				document.getRootElement().elements("info").clear();// ɾ��ȫ��info�ڵ�
			}
			catch (DocumentException e)
			{
				e.printStackTrace();
			}
		}

		OutputFormat format = OutputFormat.createPrettyPrint();// ��ʽ��Ϊ������ʽ
		format.setEncoding("GBK");// ����д��������
		try
		{
			XMLWriter writer = new XMLWriter(new FileWriter(fileURL), format);
			writer.write(document);// ����д������
			writer.close();// �ر���
			document.clearContent();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		PrintWriter out = resp.getWriter();
		out
				.println("<script>alert('ɾ��ȫ������ɹ���');window.location.href='PlacardEditServlet?action=query';</script>");
	}
}
