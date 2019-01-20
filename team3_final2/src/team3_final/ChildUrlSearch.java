package team3_final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ChildUrlSearch
{
	String rootUrl;
	String content;

	public ChildUrlSearch(String rootUrl)
	{
		this.rootUrl = rootUrl;
	}

	public String fetchContent() throws IOException
	{
		URL url = new URL(rootUrl);
		URLConnection conn = url.openConnection();

		InputStream in = conn.getInputStream();

		BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));

		String retVal = "";

		String line = null;

		while ((line = br.readLine()) != null)
		{
			retVal = retVal + line + "\n";
		}
		return retVal;
	}

	public ArrayList<String> getResults() throws IOException
	{
		ArrayList<String> retval = new ArrayList<>();
		if (content == null)
		{
			try
			{
				content = fetchContent();

			} catch (Exception e)
			{
				return null;
			}

		}

		Document doc = Jsoup.parse(content);

		Elements aTags = doc.select("a");

		for (Element aTag : aTags)
		{
			try
			{
				String href = aTag.attr("href");
				if (href.startsWith("h") || href.startsWith("#") || href.startsWith("/") || href.isEmpty())
				{

				} else
				{
					String url = rootUrl + href;
					retval.add(url);
				}

			} catch (IndexOutOfBoundsException ex)
			{
			}
		}
		return retval;
	}
}
