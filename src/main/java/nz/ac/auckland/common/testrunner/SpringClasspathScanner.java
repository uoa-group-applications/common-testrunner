package nz.ac.auckland.common.testrunner;

import com.bluetrainsoftware.classpathscanner.ClasspathScanner;
import nz.ac.auckland.common.stereotypes.UniversityComponent;

import javax.annotation.PostConstruct;

/**
 * This is an LMZ leakthrough, sometimes we need to classpath scan to get data in the right place.
 *
 * @author: Richard Vowles - https://plus.google.com/+RichardVowles
 */
@UniversityComponent
public class SpringClasspathScanner {
	public SpringClasspathScanner() {
		if ("true".equals(System.getProperty("lmz.devmode"))) {
			ClasspathScanner.getInstance().scan(Thread.currentThread().getContextClassLoader());
		}
	}
}
