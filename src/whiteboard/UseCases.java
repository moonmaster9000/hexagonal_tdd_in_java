package whiteboard;

import java.util.ArrayList;

public class UseCases {
    public static void createWhiteboard(String name, CreateWhiteboardObserver gui, WhiteboardRepo repo) {
        new CreateWhiteboardUseCase(name, gui, repo).execute();
    }

    private static class CreateWhiteboardUseCase {
        private String name;
        private CreateWhiteboardObserver gui;
        private WhiteboardRepo repo;
        private ArrayList<ValidationError> errors = new ArrayList<>();
        private Whiteboard whiteboard;

        public CreateWhiteboardUseCase(String name, CreateWhiteboardObserver gui, WhiteboardRepo repo) {
            this.name = name;
            this.gui = gui;
            this.repo = repo;
        }

        public void execute() {
            if (nameTaken()){
                reportError("name", "unique");
            } else if (nameNotProvided()){
                reportError("name", "required");
            } else {
                saveWhiteboard();
                reportId();
            }
        }

        private void reportId() {
            gui.whiteboardCreated(whiteboard.getId());
        }

        private boolean nameNotProvided() {
            return name == null;
        }

        private boolean nameTaken() {
            return repo.findByName(name) != null;
        }

        private void saveWhiteboard() {
            whiteboard = new Whiteboard(name, null);
            repo.save(whiteboard);
        }

        private void reportError(String field, String error) {
            errors.add(new ValidationError(field, error));
            gui.validationFailed(errors);
        }
    }
}
