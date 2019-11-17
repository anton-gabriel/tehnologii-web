package model;

import utils.enums.TicketStatus;

import java.io.Serializable;

/**
 * The type Ticket.
 */
public class Ticket implements Serializable {

    private int id;
    private int userId;
    private int resolverId;
    private String message;
    private TicketStatus status;

    /**
     * Instantiates a new Ticket.
     *
     * @param builder the builder
     */
    public Ticket(TicketBuilder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.resolverId = builder.resolverId;
        this.message = builder.message;
        this.status = builder.status;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets resolver id.
     *
     * @return the resolver id
     */
    public int getResolverId() {
        return resolverId;
    }

    /**
     * Sets resolver id.
     *
     * @param resolverId the resolver id
     */
    public void setResolverId(int resolverId) {
        this.resolverId = resolverId;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public TicketStatus getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("id = %d, resolver id = %d, user id = %d, message = %s, status = %s",
                id, resolverId, userId, message, status);
    }

    /**
     * The type Ticket builder.
     */
    public static class TicketBuilder {

        private int id;
        private int userId;
        private int resolverId;
        private String message;
        private TicketStatus status;

        /**
         * Instantiates a new Ticket builder.
         *
         * @param userId  the user id
         * @param message the message
         */
        public TicketBuilder(int userId, String message) {
            this.userId = userId;
            this.message = message;
            this.status = TicketStatus.NEW;
        }

        /**
         * Sets resolver id.
         *
         * @param resolverId the resolver id
         * @return the resolver id
         */
        public TicketBuilder setResolverId(int resolverId) {
            this.resolverId = resolverId;
            return this;
        }

        /**
         * Sets status.
         *
         * @param status the status
         * @return the status
         */
        public TicketBuilder setStatus(TicketStatus status) {
            this.status = status;
            return this;
        }

        /**
         * Sets id.
         *
         * @param id the id
         * @return the id
         */
        public TicketBuilder setId(int id) {
            this.id = id;
            return this;
        }

        /**
         * Build ticket.
         *
         * @return the ticket
         */
        public Ticket build() {
            return new Ticket(this);
        }
    }
}
