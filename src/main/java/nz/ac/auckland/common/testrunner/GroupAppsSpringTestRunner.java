package nz.ac.auckland.common.testrunner;

import nz.ac.auckland.agent.AgentLoader;
import nz.ac.auckland.common.scanner.MultiModuleConfigScanner;
import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * This enables Java UTIL Logging bridging and system property loading before running Spring tests. Essentially it
 * does the same as the Unit Test Runner but uses Spring as its base class.
 *
 * author: Richard Vowles - http://gplus.to/RichardVowles
 */
public class GroupAppsSpringTestRunner extends SpringJUnit4ClassRunner {
  /**
   * Constructs a new {@code SpringJUnit4ClassRunner} and initializes a
   * {@link org.springframework.test.context.TestContextManager} to provide Spring testing functionality to
   * standard JUnit tests.
   *
   * @param clazz the test class to be run
   * @see #createTestContextManager(Class)
   */
  public GroupAppsSpringTestRunner(Class<?> clazz) throws InitializationError {
    super(clazz);

    MultiModuleConfigScanner.loadIntoSystemProperties();
  }

  static {
    GroupAppsUnitTestRunner.bridgeJavaUtilLogging();
  }
}
