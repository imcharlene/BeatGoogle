package team3_final;

import java.io.IOException;
import java.util.ArrayList;

public class WebPage {
	public String url;
	public String title;
	public KeywordCounter counter;
	public double score;

	public WebPage(String url){
		this.url = url;
		this.counter = new KeywordCounter(url);
	}

	public double calScore(ArrayList<Keyword> keywords) throws IOException {
		score = 0;
		// for each k in keywords
		for (Keyword k : keywords) {
			score += k.weight * counter.countKeyword(k.name);
		}
		return score;
	}
}
