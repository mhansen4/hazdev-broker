package gov.usgs.launcher;

import gov.usgs.consumerclient.ConsumerClient;
import gov.usgs.producerclient.ProducerClient;

/**
 * a launcher class used to support launching either the ConsumerClient or the
 * ProducerClient from the HazDevBroker JAR
 *
 * @author U.S. Geological Survey &lt;jpatton at usgs.gov&gt;
 */
public class Launcher {
	/**
	 * main function for launcher
	 * 
	 * @param args
	 *            - A String[] containing the command line arguments.
	 */
	public static void main(String[] args) {

		// check number of arguments
		if (args == null || args.length == 0) {
			System.out
					.println("Usage: hazdev-broker <clientType> <configfile>");
			System.exit(1);
		}

		String option = args[0];
		String[] args2 = new String[0];

		if (args.length > 1) {
			args2 = new String[args.length - 1];
			System.arraycopy(args, 1, args2, 0, args2.length);
		}

		if (option.equals("ConsumerClient")) {
			new ConsumerClient();
			ConsumerClient.main(args2);
		} else if (option.equals("ProducerClient")) {
			new ProducerClient();
			ProducerClient.main(args2);
		} else {
			System.out.println(
					"Invalid hazdev-broker <clientType> provided, only ConsumerClient or ProducerClient supported.");
		}

	}
}
