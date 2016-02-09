package whiteboard.tests;

import org.junit.Before;
import org.junit.Test;
import whiteboard.Whiteboard;
import whiteboard.WhiteboardRepo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public abstract class WhiteboardRepoContractTest {
    protected WhiteboardRepo repo;

    Whiteboard ny = new Whiteboard("NY", null);
    Whiteboard sf = new Whiteboard("SF", null);

    @Before
    public void before(){
        createRepo();
        repo.save(ny);
        repo.save(sf);
    }

    protected abstract void createRepo();

    @Test
    public void findsByName() {
        assertEquals(ny, repo.findByName(ny.getName()));
        assertEquals(sf, repo.findByName(sf.getName()));
    }

    @Test
    public void createsUniqueId() {
        assertTrue(ny.getId() != null);
        assertTrue(sf.getId() != null);
        assertNotEquals(ny.getId(), sf.getId());
    }
}

