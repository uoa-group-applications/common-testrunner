package nz.ac.auckland.common.testrunner;

import bathe.BatheInitializerProcessor;

import java.util.Enumeration;
import java.util.Properties;

/**
 * @author: Richard Vowles - https://plus.google.com/+RichardVowles
 */
public class BatheTestUtils {
    /*
    * Use props for all replacement strings.
     */
    public static void init(Class<?> klass, Properties props) {

        BatheCommandLine stp = klass.getAnnotation(BatheCommandLine.class);

        String[] args;

        if (stp != null) {
            args = new String[stp.value().length];
            int count = 0;

            for(String arg : stp.value()) {

                if(props!=null) {
                    for (Enumeration<String> e = (Enumeration<String>)props.propertyNames(); e.hasMoreElements();) {

                        String propertyName = e.nextElement();
                        arg = arg.replace(propertyName,props.getProperty(propertyName));
                    }
                }

                args[count++] = arg;
            }
        } else {
            args = new String[] {};
        }

        new BatheInitializerProcessor().process(args, "", klass.getClassLoader());

    }

    public static void init(Class<?> klass) {
        String userHome = System.getProperty("user.home");
        Properties homeOnlyProperty = new Properties();
        homeOnlyProperty.setProperty("$home",userHome);
	
        init(klass, homeOnlyProperty);
    }
}
