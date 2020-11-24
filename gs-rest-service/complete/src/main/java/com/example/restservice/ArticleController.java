package com.example.restservice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private static String json;

	static {
		try {
			json = readUrl("https://api.nytimes.com/svc/topstories/v2/arts.json?api-key=9vssILxEpAfR2V136VRp80nO2dh2Jevl");
		} catch (Exception e) {
			e.printStackTrace();
		}
		json.replace("\"","\"");
		//System.exit(0);
	}


	@GetMapping("/articles")
	public Article article(@RequestParam String name) {
		return new Article(0034557657, json);

	}

	public static String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		StringBuffer buffer;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

		} finally {
			if (reader != null)
				reader.close();
		}
		String returned = buffer.toString();
		return returned;

	}
}
