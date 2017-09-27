package controller;

import data.Session;
import junit.framework.TestCase;
import org.junit.Test;
import repo.SessionRepository;

/**
 * @author nilstes
 */
public class SessionControllerTest extends TestCase {

    @Test
    public void testThatUserCanLogOnWithOnlyUsername() {
        SessionController c = new SessionController(new SessionRepository());
        Session session = c.createSession("player");
        assertTrue(session.getUserName().equals("player"));
        c.removeSession("player");
    }

    @Test
    public void testRefusingLoginIfUserAlreadyLoggedIn() {
        SessionController c = new SessionController(new SessionRepository());
        c.createSession("player1");
        Session session = c.createSession("player1");
        assertNull(session);
        c.removeSession("player1");
    }
}