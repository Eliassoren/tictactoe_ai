package controller;

import data.Opponents;
import data.Session;
import repo.SessionRepository;

import java.util.Date;

/**
 * @author nilstes
 */
public class SessionController {

    private SessionRepository repo;

    public SessionController(SessionRepository repo) {
        this.repo = repo;
    }

    public Session createSession(String userName) {
        if (!repo.existsSession(userName)) {
            Session s = new Session();
            s.setUserName(userName);
            s.setLoggedOn(new Date());
            repo.addSession(s);
            return s;
        }
        return null;
    }

    public void removeSession(String userName) {
        // todo
    }

    public Opponents getPossibleOpponents(String myUserName) {
        throw null; // todo
    }
}