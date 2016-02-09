package whiteboard.tests;

import org.junit.Test;
import whiteboard.ValidationError;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ValidationErrorTest {
    @Test
    public void nullFieldsEqualNothing() {
        ValidationError nullError = new ValidationError(null, null);
        ValidationError otherNullError = new ValidationError(null, null);

        assertFalse(nullError.equals(otherNullError));
    }

    @Test
    public void givenRandomObject_EqualsFalse() {
        ValidationError error = new ValidationError("field", "error");
        assertFalse(error.equals("random object"));
    }

    @Test
    public void exactMatchingFields() {
        ValidationError error = new ValidationError("field", "error");
        ValidationError sameError = new ValidationError("field", "error");

        ArrayList<ValidationError> errors = new ArrayList<>();
        errors.add(error);

        assertTrue(error.equals(sameError));
        assertTrue(sameError.equals(error));
        assertTrue(errors.contains(error));
        assertTrue(errors.contains(sameError));
    }
}