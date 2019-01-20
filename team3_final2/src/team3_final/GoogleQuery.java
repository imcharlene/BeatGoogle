package team3_final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleQuery 
{
	public String searchKeyword;
	public String url;
	public String content;
	public GoogleQuery(String searchKeyword)
	{
		this.searchKeyword = searchKeyword;   
		
	}
	
	private String fetchContent() throws IOException
	{
		url = "http://www.google.com/search?q="+searchKeyword+"電競"+"&num=20&oe=utf8";
		String retVal = "";
		URL u = new URL(url);
		URLConnection conn = u.openConnection();
		conn.setRequestProperty("User-agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
		InputStream in = conn.getInputStream();
		InputStreamReader inReader = new InputStreamReader(in,"utf-8");
		BufferedReader bufReader = new BufferedReader(inReader);
		
		String line = null;
		while((line=bufReader.readLine())!=null)
		{
			retVal += line;
		}
		
		return retVal;
	}
	
	public HashMap<String, String> query() throws IOException
	{
		if(content==null)
		{
			content= fetchContent();
		}
		HashMap<String, String> retVal = new HashMap<String, String>();
		
		Document doc = Jsoup.parse(content);
		
		Elements lis = doc.select("div.g");
		
		for(Element li : lis)
		{
			try 
			{
				Element h3 = li.select("h3.r").get(0);
				String title = h3.text();
				
				Element cite = li.getElementsByTag("a").first();
				String citeUrl = "https://www.google.com.tw"+cite.attr("href");
//				System.out.println(title+" "+citeUrl);
				
				retVal.put(title, citeUrl);
				
			} catch (IndexOutOfBoundsException e) {
				
			}
			
		}
		
		return retVal;
	}
	
	
}