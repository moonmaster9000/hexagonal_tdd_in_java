package whiteboard;

import java.util.List;

public interface CreateWhiteboardObserver {
    void validationFailed(List<ValidationError> errors);

    void whiteboardCreated(Object id);
}
