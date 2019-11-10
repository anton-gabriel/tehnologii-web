package model;

import utils.enums.TicketStatus;

import java.io.Serializable;

public class Ticket  implements Serializable {

    private int id;
    private int userId;
    private int resolverId;
    private String message;
    private TicketStatus status;

    public Ticket(TicketBuilder builder) {
        this.userId = builder.userId;
        this.resolverId = builder.resolverId;
        this.message = builder.message;
        this.status = builder.status;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getResolverId() {
        return resolverId;
    }

    public void setResolverId(int resolverId) {
        this.resolverId = resolverId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public static class TicketBuilder {

        private int userId;
        private int resolverId;
        private String message;
        private TicketStatus status;

        public TicketBuilder(int userId, String message) {
            this.userId = userId;
            this.message = message;
        }

        public TicketBuilder setResolverId(int resolverId) {
            this.resolverId = resolverId;
            return this;
        }

        public TicketBuilder setStatus(TicketStatus status) {
            this.status = status;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }
}
