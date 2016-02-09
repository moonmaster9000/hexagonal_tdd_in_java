package whiteboard;

public class Whiteboard {
    private final String name;
    private Object id;

    public Whiteboard(String name, Object id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id){
        this.id = id;
    }
}
