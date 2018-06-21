package edu.handong.csee.java.webpagecrawler;

/**
 * Change the URL path to save as HTML file
 * This class is for constructing the HTML file
 * @author LeeSangHyun
 **/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class HTMLConstructor {

	public void saveasHTML (String inputUrlPath, String urlAddress) throws IOException{
		String urlForm = ".html";
		String fileName = urlAddress+urlForm;

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName))));

		out.write(inputUrlPath);
		out.close();
	}
}
