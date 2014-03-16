package nz.ac.auckland.common.testrunner;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author: Richard Vowles - https://plus.google.com/+RichardVowles
 */
public class SimpleSpringRunner extends BlockJUnit4ClassRunner {
	protected final ContextConfiguration contextConfiguration;
	protected ApplicationContext ctx;

	/**
	 * Creates a BlockJUnit4ClassRunner to run {@code klass}
	 *
	 * @param klass
	 * @throws org.junit.runners.model.InitializationError if the test class is malformed.
	 */
	public SimpleSpringRunner(Class<?> klass) throws InitializationError {
		super(klass);

		BatheTestUtils.init(klass);

		contextConfiguration = klass.getAnnotation(ContextConfiguration.class);
	}

	@Override
	protected Statement withBeforeClasses(Statement statement) {
		if (contextConfiguration != null) {
			ctx = new ClassPathXmlApplicationContext(contextConfiguration.value());
		}

		return super.withBeforeClasses(statement);
	}

	@Override
	protected Object createTest() throws Exception {
		Object test = super.createTest();

		if (ctx != null) {
			AutowiredAnnotationBeanPostProcessor bpp = new AutowiredAnnotationBeanPostProcessor();
			bpp.setBeanFactory(ctx.getAutowireCapableBeanFactory());
			bpp.processInjection(test);
		}

		return test;
	}
}
