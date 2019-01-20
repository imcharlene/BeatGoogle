package team3_final;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;


public class Main
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		WebsiteRank rank = new WebsiteRank();
		
		while (sc.hasNextLine())
		{
			
			String searchKeyword1 = sc.nextLine();
			
			String searchKeyword = searchKeyword1.replaceAll("\\W","");
			
			
			GoogleQuery gSearch = new GoogleQuery(searchKeyword);    ////?
			HashMap<String, String> results = gSearch.query();   
			for (Entry<String, String> entry : results.entrySet())
			{
				String title = entry.getKey();
				String url = entry.getValue();
				
				rank.addTree(title,url);
			}

			rank.sort();
			rank.output();

		}
		sc.close();
	}
}
