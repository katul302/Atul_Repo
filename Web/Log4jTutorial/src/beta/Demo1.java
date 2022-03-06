package beta;

import org.apache.logging.log4j.*;

public class Demo1 {

	private static Logger log = LogManager.getLogger(Demo1.class.getName());

	public static void main(String[] args) {

		log.debug("I am debugging beta");
		log.error("Error messgae beta");

		if (5 > 4)
			log.debug("Object is present beta");
		log.info("test message beta ");
		log.error("object is not present beta");

		log.fatal("this is fatal error beta");

	}

}
