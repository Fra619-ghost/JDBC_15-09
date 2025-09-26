package models;

import java.time.LocalDateTime;

public class Visit {
    private long id;
    private String visitorName;
    private String visitorDocument;
    private String visitorEmail;
    private String hostName;
    private String reason;
    private LocalDateTime visitEntry;
    private LocalDateTime visitExit;

    public Visit() {
    }

    public Visit(long id, String visitorName, String visitorDocument, String visitorEmail,
                 String hostName, String reason, LocalDateTime visitEntry, LocalDateTime visitExit) {
        this.id = id;
        this.visitorName = visitorName;
        this.visitorDocument = visitorDocument;
        this.visitorEmail = visitorEmail;
        this.hostName = hostName;
        this.reason = reason;
        this.visitEntry = visitEntry;
        this.visitExit = visitExit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorDocument() {
        return visitorDocument;
    }

    public void setVisitorDocument(String visitorDocument) {
        this.visitorDocument = visitorDocument;
    }

    public String getVisitorEmail() {
        return visitorEmail;
    }

    public void setVisitorEmail(String visitorEmail) {
        this.visitorEmail = visitorEmail;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getVisitEntry() {
        return visitEntry;
    }

    public void setVisitEntry(LocalDateTime visitEntry) {
        this.visitEntry = visitEntry;
    }

    public LocalDateTime getVisitExit() {
        return visitExit;
    }

    public void setVisitExit(LocalDateTime visitExit) {
        this.visitExit = visitExit;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", visitorName='" + visitorName + '\'' +
                ", visitorDocument='" + visitorDocument + '\'' +
                ", visitorEmail='" + visitorEmail + '\'' +
                ", hostName='" + hostName + '\'' +
                ", reason='" + reason + '\'' +
                ", visitEntry=" + visitEntry +
                ", visitExit=" + visitExit +
                '}';
    }
}
