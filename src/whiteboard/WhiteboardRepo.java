package whiteboard;

public interface WhiteboardRepo {
    Whiteboard findByName(String name);
    void save(Whiteboard whiteboard);
}

