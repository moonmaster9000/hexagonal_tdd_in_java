package whiteboard.tests;

import org.junit.Test;
import whiteboard.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateWhiteboardTest {
    CreateWhiteboardObserverSpy spy = new CreateWhiteboardObserverSpy();
    FakeWhiteboardRepo repo = new FakeWhiteboardRepo();

    @Test
    public void nameIsRequired(){
        UseCases.createWhiteboard(null, spy, repo);

        assertReceivedError("name", "required");
    }

    @Test
    public void nameDupeNotAllowed() {
        UseCases.createWhiteboard("whiteboard name", spy, repo);
        UseCases.createWhiteboard("whiteboard name", spy, repo);

        assertReceivedError("name", "unique");
    }

    @Test
    public void givenValidName_sendsIdBackToObserver() {
        UseCases.createWhiteboard("whiteboard name", spy, repo);

        assertTrue(spy.spyId() != null);
    }

    private void assertReceivedError(String field, String errorCode) {
        assertTrue(
            spy.spyValidationErrors().contains(
                new ValidationError(field, errorCode)
            )
        );
    }
}

class CreateWhiteboardObserverSpy implements CreateWhiteboardObserver {
    private List<ValidationError> spyValidationErrors;
    private Object id;

    public List<ValidationError> spyValidationErrors() {
        return spyValidationErrors;
    }

    @Override
    public void validationFailed(List<ValidationError> errors) {
        spyValidationErrors = errors;
    }

    @Override
    public void whiteboardCreated(Object id) {
        this.id = id;
    }

    public Object spyId() {
        return id;
    }
}