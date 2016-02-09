package whiteboard;

public class ValidationError {
    private final String field;
    private final String errorCode;

    public ValidationError(String field, String errorCode) {
        this.field = field;
        this.errorCode = errorCode;
    }

    @Override
    public boolean equals(Object o){
        if (initializedWithNulls()){
            return false;
        }

        if (o instanceof ValidationError){
            return fieldsEqual((ValidationError) o);
        }

        return false;
    }

    private boolean fieldsEqual(ValidationError otherError) {
        return field.equals(otherError.field) && errorCode.equals(otherError.errorCode);
    }

    private boolean initializedWithNulls() {
        return field == null || errorCode == null;
    }
}
