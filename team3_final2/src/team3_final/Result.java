package team3_final;

import java.util.ArrayList;
import java.util.List;

public class Result
{
	private List<Content> results = new ArrayList<>();

	public List<Content> getResults()
	{
		return results;
	}

	public void setResults(List<Content> results)
	{
		this.results = results;
	}

	public static class Content
	{
		private String title;
		private String url;
		private double score;

		public String getTitle()
		{
			return title;
		}

		public void setTitle(String title)
		{
			this.title = title;
		}

		public String getUrl()
		{
			return url;
		}

		public void setUrl(String url)
		{
			this.url = url;
		}

		public double getScore()
		{
			return score;
		}

		public void setScore(double score)
		{
			this.score = score;
		}

	}
}
