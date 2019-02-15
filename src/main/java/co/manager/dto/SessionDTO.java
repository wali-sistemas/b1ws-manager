package co.manager.dto;

public class SessionDTO {
    private String sessionID;
    private boolean closedID;

    public SessionDTO() {
    }

    public SessionDTO(String sessionID, boolean closedID) {
        this.sessionID = sessionID;
        this.closedID = closedID;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public boolean isClosedID() {
        return closedID;
    }

    public void setClosedID(boolean closedID) {
        this.closedID = closedID;
    }

    @Override
    public String toString() {
        return "SessionDTO{" +
                "sessionID='" + sessionID + '\'' +
                ", closedID=" + closedID +
                '}';
    }
}