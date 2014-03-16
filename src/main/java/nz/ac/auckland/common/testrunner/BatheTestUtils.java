package nz.ac.auckland.common.testrunner;

import bathe.BatheInitializerProcessor;

/**
 * @author: Richard Vowles - https://plus.google.com/+RichardVowles
 */
public class BatheTestUtils {
	public static void init(Class<?> klass) {
		BatheCommandLine stp = klass.getAnnotation(BatheCommandLine.class);

		String []args;

		if (stp != null) {
			args = new String[stp.value().length];
			String userHome = System.getProperty("user.home");
			int count = 0;

			for(String arg : stp.value()) {
				args[count++] = arg.replace("$home", userHome);
			}
		} else {
			args = new String[] {};
		}

		new BatheInitializerProcessor().process(args, "", klass.getClassLoader());
	}
}
