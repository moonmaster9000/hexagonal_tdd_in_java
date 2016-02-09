package whiteboard.tests;

import whiteboard.Whiteboard;
import whiteboard.WhiteboardRepo;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

class FakeWhiteboardRepo implements WhiteboardRepo {
    private ArrayList<Whiteboard> whiteboards = new ArrayList<>();

    @Override
    public Whiteboard findByName(String name) {
        Optional<Whiteboard> whiteboard = getWhiteboard(name);

        if (whiteboard.isPresent())
            return whiteboard.get();

        return null;
    }

    private Optional<Whiteboard> getWhiteboard(String name) {
        return whiteboards.stream().filter(
                w -> w.getName().equals(name)
            ).findFirst();
    }

    @Override
    public void save(Whiteboard whiteboard) {
        whiteboards.add(whiteboard);
        whiteboard.setId(UUID.randomUUID().toString());
    }
}
