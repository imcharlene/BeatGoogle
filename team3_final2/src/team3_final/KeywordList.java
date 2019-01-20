package team3_final;

import java.util.ArrayList;

public class KeywordList
{
	public ArrayList<Keyword> list;

	public KeywordList()
	{
		this.list = new ArrayList<>();
	}

	public ArrayList<Keyword> add()
	{
		list.add(new Keyword("選手", 80));
		list.add(new Keyword("介紹", 50));
		list.add(new Keyword("基本資料", 50));
		list.add(new Keyword("戰隊", 50));
		list.add(new Keyword("比賽", 40));
		list.add(new Keyword("線上遊戲", 40));
		
		return list;
	}
}

