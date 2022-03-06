package alpha;

import org.apache.logging.log4j.*;

public class Demo {

	private static Logger log = LogManager.getLogger(Demo.class.getName());

	public static void main(String[] args) {

		log.debug("I am debugging alpha");
		log.error("Error messgae alpha");

		if (5 > 4)
			log.debug("Object is present alpha");
		log.info("test message alpha");
		log.error("object is not present alpha");

		log.fatal("this is fatal error alpha");

	}

}
