package team3_final;

import java.io.IOException;
import java.util.ArrayList;

public class WebNode {
	public WebNode parent;
	public ArrayList<WebNode> children;
	public WebPage webPage;
	public double nodeScore;
	public int depth;

	public WebNode(WebPage webPage)	{
		this.webPage = webPage;
		this.children = new ArrayList<>();
	}

	public void appendChild(WebNode childNode){
		childNode.parent = this;
		children.add(childNode);
	}

	public double calNodeScore(ArrayList<Keyword> keywords) throws IOException {
		nodeScore = 0;
		for (WebNode child : children){
			nodeScore += child.calNodeScore(keywords);
		}
		nodeScore += webPage.calScore(keywords);

		return nodeScore;
	}

	public int calDepth(){
		WebNode currNode = this;
		int depth = 0;
		while (currNode.parent != null){
			depth++;
			currNode = currNode.parent;
		}
		return depth;
	}
}
