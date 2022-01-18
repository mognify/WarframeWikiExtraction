package data;

import java.io.IOException;

import org.jsoup.Jsoup;

public class Crawl {
	public static String grab(String url) throws IOException {
		return Jsoup.connect(url).get().toString();
	}
}
