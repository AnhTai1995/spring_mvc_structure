package tai.example.demo.validate;

import tai.example.demo.validate.impl.DateValidateImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Annotation check format date
 *
 * @author TuMV
 */
@Documented
@Constraint(validatedBy = DateValidateImpl.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateValidate {
    String message() default "Date fail";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
