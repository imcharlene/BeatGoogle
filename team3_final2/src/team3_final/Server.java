package team3_final;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;

import team3_final.Result.Content;

/**
 * Servlet implementation class server
 */
@WebServlet("/Server")
public class Server extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Server()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if(request.getParameter("keyword")==null) {  
			String requestUri = request.getRequestURI();
			request.setAttribute("requestUri", requestUri);
			request.getRequestDispatcher("Search.jsp").forward(request, response);
			return;
		}
		
		WebsiteRank rank = new WebsiteRank();
		GoogleQuery gSearch = new GoogleQuery(request.getParameter("keyword"));
		HashMap<String, String> results = gSearch.query();
		for (Entry<String, String> entry : results.entrySet())
		{
			String title = entry.getKey();
			String url = entry.getValue();

			rank.addTree(title, url);
		}

		rank.sort();     
		
		
		HashMap<String, String> endresults = new HashMap<String, String>();
		for (WebTree w : rank.rank)
		{
			String webtitle= w.rootPage.title;
			String webUrl=w.rootPage.url;
			endresults.put(webtitle, webUrl);
		}
		
		
		
		String[][] s = new String[endresults.size()][2];
		request.setAttribute("final", s);
		int num = 0;
		for(Entry<String, String> entry : endresults.entrySet()) {
		    String printkey = entry.getKey();
		    String printvalue = entry.getValue();
		    s[num][0] = printkey;
		    s[num][1] = printvalue;
		    num++;
		}
		
		 
		
		request.getRequestDispatcher("googleitem.jsp")
		 .forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
