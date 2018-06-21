package edu.handong.csee.java.webpagecrawler;

/**
 * Change the URL path to save as HTML file
 * This class is for reading URL before the construction
 * @author LeeSangHyun
 **/

import java.net.*;
import java.io.*;

public class URLReader {

	String inputUrlPath;
	String readURL="";

	public URLReader (String inputUrlPath) {
		this.inputUrlPath = inputUrlPath;
	}

	public String readURL(String inputUrlPath) throws Exception{

		URL oracle = new URL("http://www.oracle.com/");
		BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

		String inputLine;
		while ((inputLine = in.readLine()) != null)
			readURL = readURL+inputLine;
		in.close();

		return readURL;
	}
}
