package com.cubas.onlinebank.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * The @ symbol denotes an annotation type definition.
 * 
 * Creating an annotation guide: https://www.baeldung.com/java-custom-annotation
 *
 * Following these steps for this: https://www.baeldung.com/registration-with-spring-mvc-and-spring-security
 */

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Documented
public @interface PasswordMatches {
	
	String message() default "Passwords don't match";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
