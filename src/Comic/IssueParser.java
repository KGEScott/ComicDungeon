package Comic;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class IssueParser {

	public static String[] getImageUrls() throws IOException {
		Document doc = Jsoup.connect("https://www.comics.org/issue/" + LoginInfo.getComicsID() + "/cover/4/").get();
		Elements imgElements = doc.select("div.issue_covers a img");
		String[] imgUrls = new String[imgElements.size()];
		for (int i = 0; i < imgElements.size(); i++) {
			imgUrls[i] = imgElements.get(i).attr("src");
		}
		return imgUrls;
	}
}
