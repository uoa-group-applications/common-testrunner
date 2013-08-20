package nz.ac.auckland.common.testrunner;

import nz.ac.auckland.common.scanner.MultiModuleConfigScanner;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

import java.util.logging.LogManager;

/**
 * Use this class when you want to run a Unit test but you want your system properties loaded from your files and you want java util logging bridged.
 *
 */
public class GroupAppsUnitTestRunner extends BlockJUnit4ClassRunner {
  public static void bridgeJavaUtilLogging() {
    java.util.logging.Logger rootLogger = LogManager.getLogManager().getLogger("");

    for (java.util.logging.Handler julHandler : rootLogger.getHandlers()) {
      rootLogger.removeHandler(julHandler);
    }

    org.slf4j.bridge.SLF4JBridgeHandler.install();
  }

  public GroupAppsUnitTestRunner(Class<?> klass) throws InitializationError {
    super(klass);

    bridgeJavaUtilLogging();
    MultiModuleConfigScanner.loadIntoSystemProperties();
  }
}
