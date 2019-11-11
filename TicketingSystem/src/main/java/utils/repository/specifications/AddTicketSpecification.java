package utils.repository.specifications;

import database.DatabaseConnection;
import model.Ticket;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddTicketSpecification extends SqlSpecification<Ticket> {

    public AddTicketSpecification(Ticket entity) {
        super(entity);
    }

    @Override
    public PreparedStatement getSpecification() throws SQLException {
        PreparedStatement statement = DatabaseConnection.getInstance().getConnection()
                .prepareStatement("INSERT INTO ticket(user_id, message, status) values (?,?,?)");
        statement.setInt(1, this.entity.getUserId());
        statement.setString(2, this.entity.getMessage().trim());
        statement.setString(3, this.entity.getStatus().toString().trim());
        return statement;
    }
}
