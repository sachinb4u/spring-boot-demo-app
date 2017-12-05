package com.sap.banking.loan.validations.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Pattern(regexp = "[0-9]*")
@Size
@Constraint(validatedBy = {})
@Documented
@Target({ ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {

	@OverridesAttribute.List({ @OverridesAttribute(constraint = Size.class, name = "message") })
	String message() default "Phone number should be of {min} digits";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@OverridesAttribute.List({ @OverridesAttribute(constraint = Size.class, name = "min"),
			@OverridesAttribute(constraint = Size.class, name = "max") })
	int size() default 10;
}
