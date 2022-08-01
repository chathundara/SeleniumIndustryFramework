package stuffs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jtest {
	//put below line in every class, then replace the sysout with log.info or log.error
	private static final Logger log = LogManager.getLogger(Log4jtest.class.getName());

	public static void main(String[] args) {

		 System.out.println(Log4jtest.class.getName());
		log.trace("Trace message printed");
		log.debug("debug message printed");
		log.info("info message printed");
		log.error("error message printed");
		log.fatal("fatal message printed");
	}

}
