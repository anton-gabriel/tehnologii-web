package utils.repository.specifications;

import database.DatabaseConnection;
import model.Ticket;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTicketSpecification extends SqlSpecification<Ticket> {

    public UpdateTicketSpecification(Ticket entity) {
        super(entity);
    }

    @Override
    public PreparedStatement getSpecification() throws SQLException {
        PreparedStatement statement = DatabaseConnection.getInstance().getConnection()
                .prepareStatement("UPDATE ticket SET status = ?, resolver_id = ? WHERE id = ?");
        statement.setString(1, this.entity.getStatus().toString().trim());
        statement.setInt(2, this.entity.getResolverId());
        statement.setInt(3, this.entity.getId());
        return statement;
    }
}
