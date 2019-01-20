package team3_final;

import java.io.IOException;
import java.util.ArrayList;

public class WebTree 
{
	WebNode rootNode;
	WebPage rootPage;
	double score;
	ChildUrlSearch childSearch;
	ArrayList<String> childUrlList;

	public WebTree(String title, String url)
	{
		this.rootPage = new WebPage(url);
		this.rootPage.title = title;
		this.rootNode = new WebNode(rootPage);
		this.childSearch = new ChildUrlSearch(url);
		this.childUrlList = new ArrayList<>();
	}

	public void createTree()
	{
		try
		{
			childUrlList = childSearch.getResults();
			for (int i = 1; i < 4; i++)
			{
				String url = childUrlList.get(i);
				rootNode.appendChild(new WebNode(new WebPage(url)));
			}
		} catch (Exception ex)
		{
			return;
		}
	}

	public double calTreeScore(ArrayList<Keyword> keywords) throws IOException
	{
		score = rootNode.calNodeScore(keywords);
		return score;
	}
}
