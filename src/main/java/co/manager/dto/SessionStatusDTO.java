package co.manager.dto;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author dbotero
 */
public class SessionStatusDTO {
    private ConcurrentHashMap<String, LinkedBlockingQueue<B1WSSession>> availableSessions = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, B1WSSession> borrowedSessions = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, LinkedBlockingQueue<B1WSSession>> getAvailableSessions() {
        return availableSessions;
    }

    public void setAvailableSessions(ConcurrentHashMap<String, LinkedBlockingQueue<B1WSSession>> availableSessions) {
        this.availableSessions = availableSessions;
    }

    public ConcurrentHashMap<String, B1WSSession> getBorrowedSessions() {
        return borrowedSessions;
    }

    public void setBorrowedSessions(ConcurrentHashMap<String, B1WSSession> borrowedSessions) {
        this.borrowedSessions = borrowedSessions;
    }
}