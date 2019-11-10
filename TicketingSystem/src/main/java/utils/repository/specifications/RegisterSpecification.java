package utils.repository.specifications;

import model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterSpecification extends SqlSpecification<User> {

    public RegisterSpecification(User entity) {
        super(entity);
    }

    @Override
    public PreparedStatement getSpecification() throws SQLException {
        AddUserSpecification addUserSpecification = new AddUserSpecification(this.entity);
        return addUserSpecification.getSpecification();
    }
}

