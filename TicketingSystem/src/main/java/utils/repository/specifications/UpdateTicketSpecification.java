package utils.repository.specifications;

import database.DatabaseConnection;
import javafx.util.Pair;
import model.Ticket;
import model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTicketSpecification extends SqlSpecification<Pair<User, Ticket>> {

    public UpdateTicketSpecification(Pair<User, Ticket> entity) {
        super(entity);
    }

    @Override
    public PreparedStatement getSpecification() throws SQLException {
        PreparedStatement statement = DatabaseConnection.getInstance().getConnection()
                .prepareStatement("UPDATE ticket SET status = ? WHERE resolver_id = ? AND id = ?");
        statement.setString(1, this.entity.getValue().getStatus().toString());
        statement.setInt(2, this.entity.getKey().getId());
        statement.setInt(3, this.entity.getValue().getId());
        return statement;
    }
}
