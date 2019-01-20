package team3_final;

import java.io.IOException;
import java.util.ArrayList;

public class WebsiteRank
{
	ArrayList<Keyword> keywords = new KeywordList().add();
	ArrayList<WebTree> rank;

	public WebsiteRank()
	{
		this.rank = new ArrayList<>();
	}

	public void addTree(String title, String rootUrl) throws IOException
	{
		WebTree a = new WebTree(title, rootUrl);
		a.createTree();
		a.calTreeScore(keywords);
		rank.add(a);
	}

	public void output()
	{
		for (WebTree w : rank)
		{
			System.out.println(w.rootNode.webPage.title +" " + w.rootNode.webPage.url);
			System.out.println(w.score);
		}
	}

	public void sort()
	{
		this.rank = doQucikSort(this.rank);
	}

	private ArrayList<WebTree> doQucikSort(ArrayList<WebTree> list)
	{
		if (list.size() <= 1)
		{
			return list;
		}

		// less than
		ArrayList<WebTree> it = new ArrayList<>();
		// equal to
		ArrayList<WebTree> eq = new ArrayList<>();
		// greater than
		ArrayList<WebTree> gt = new ArrayList<>();
		// result
		ArrayList<WebTree> retVal = new ArrayList<>();

		int indexOfPivot = list.size() / 2;
		WebTree pivot = list.get(indexOfPivot);
		for (WebTree webTree : list)
		{
			if (webTree.score > pivot.score)
			{
				it.add(webTree);
			} else if (webTree.score < pivot.score)
			{
				gt.add(webTree);
			} else
			{
				eq.add(webTree);
			}
		}

		retVal.addAll(doQucikSort(it));
		retVal.addAll(eq);
		retVal.addAll(doQucikSort(gt));

		return retVal;
	}
}
