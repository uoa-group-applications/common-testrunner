package nz.ac.auckland.common.testrunner;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

/**
 * @author: Richard Vowles - https://plus.google.com/+RichardVowles
 */
public class SimpleTestRunner extends BlockJUnit4ClassRunner {
	/**
	 * Creates a BlockJUnit4ClassRunner to run {@code klass}
	 *
	 * @param klass
	 * @throws org.junit.runners.model.InitializationError if the test class is malformed.
	 */
	public SimpleTestRunner(Class<?> klass) throws InitializationError {
		super(klass);

		BatheTestUtils.init(klass);
	}
}
