package nz.ac.auckland.common.testrunner;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author: Richard Vowles - https://plus.google.com/+RichardVowles
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
public @interface BatheCommandLine {
	String[] value();
}
