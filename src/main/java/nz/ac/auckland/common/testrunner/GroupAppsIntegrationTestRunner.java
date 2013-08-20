package nz.ac.auckland.common.testrunner;


import nz.ac.auckland.agent.AgentLoader;
import nz.ac.auckland.common.scanner.MultiModuleConfigScanner;
import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * This enables Java UTIL Logging bridging, Ebean Agent loading and system property loading before running Spring tests.
 *
 * author: Richard Vowles - http://gplus.to/RichardVowles
 */
public class GroupAppsIntegrationTestRunner extends SpringJUnit4ClassRunner {
  /**
   * Constructs a new {@code SpringJUnit4ClassRunner} and initializes a
   * {@link org.springframework.test.context.TestContextManager} to provide Spring testing functionality to
   * standard JUnit tests.
   *
   * @param clazz the test class to be run
   * @see #createTestContextManager(Class)
   */
  public GroupAppsIntegrationTestRunner(Class<?> clazz) throws InitializationError {
    super(clazz);

    MultiModuleConfigScanner.loadIntoSystemProperties();
  }

  static {
    GroupAppsUnitTestRunner.bridgeJavaUtilLogging();
    AgentLoader.findAgentInClasspath("avaje-ebeanorm-agent", "debug=3");
  }
}
