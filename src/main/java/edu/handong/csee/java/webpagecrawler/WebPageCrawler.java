package edu.handong.csee.java.webpagecrawler;

/**
 * This is the Bonus Homework WebPageCralwer
 * Save the URL path as a HTML file
 * @author LeeSangHyun
 **/

import java.io.File;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class WebPageCrawler {

	String inputUrlPath;
	String outputHTMLPath;
	boolean help;

	public static void main(String[] args) {
		WebPageCrawler WPC = new WebPageCrawler();
		WPC.run(args);
	}

	public void run(String[] args) {
		Options options = createOptions();

		if(parseOptions(options, args)){
			if (help){
				printHelp(options);
				return;
			}
		}
	}
	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {
			CommandLine cmd = parser.parse(options, args);

			inputUrlPath = cmd.getOptionValue("i");
			outputHTMLPath = cmd.getOptionValue("o");
			help = cmd.hasOption("h");
			File fp;
			fp = new File(outputHTMLPath);
			if(!fp.isDirectory()) {
				System.out.println("Wrong path! Please fill up the accurate path! \n");
			}

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}

	// Definition Stage
	private Options createOptions() {
		Options options = new Options();

		// add options by using OptionBuilder
		options.addOption(Option.builder("p").longOpt("path")
				.desc("Set a path of a directory or a file to display")
				.hasArg()
				.argName("Path name to display")
				.required()
				.build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("v").longOpt("verbose")
				.desc("Display detailed messages!")
				//.hasArg()     // this option is intended not to have an option value but just an option
				.argName("verbose option")
				//.required() // this is an optional option. So disabled required().
				.build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help")
				.build());

		return options;
	}

	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "Save URL as a HTML File";
		String footer ="\nPlease report issues at https://github.com/leesanghyun499/WebPageCrawler/issues";
		formatter.printHelp("-i inputUrlPath, -o outputHTMLPath, and -h help ", header, options, footer, true);
	}

}

