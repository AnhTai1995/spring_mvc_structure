package tai.example.demo.validate.impl;

import tai.example.demo.validate.DateValidate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Annotation validate date implementation
 *
 * @author TuMV
 */
public class DateValidateImpl implements ConstraintValidator<DateValidate, String> {
    @Override
    public void initialize(DateValidate constraintAnnotation) {
    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext constraintValidatorContext) {
        return contactField != null && contactField.matches(
                "^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$"
                + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
                + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
                + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$")
                && (contactField.length() > 8) && (contactField.length() < 14);
    }
}
