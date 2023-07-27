package com.docdb.user;

import com.docdb.DataBaseConnection;
import com.docdb.user.domain.User;
import com.docdb.user.dto.AccountType;
import com.docdb.user.dto.Status;
import org.springframework.stereotype.Service;
import java.sql.*;

@Service
public class UserDAO {

    public User findUserById(long id) throws SQLException {

        User foundUser = null;
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT username, password, status, account_type FROM public.users WHERE id = ?");
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            foundUser = new User();

            foundUser.setId(id);
            foundUser.setUsername(rs.getString("username"));
            foundUser.setPassword(rs.getString("password"));
            String status = rs.getString("status");
            switch (status) {
                case "ACTIVE" -> foundUser.setStatus(Status.ACTIVE);
                case "DELETED" -> foundUser.setStatus(Status.DELETED);
                case "SUSPENDED" -> foundUser.setStatus(Status.SUSPENDED);
            }
            String accountType = rs.getString("account_type");
            switch (accountType) {
                case "DOCTOR" -> foundUser.setAccountType(AccountType.DOCTOR);
                case "ASSISTANT" -> foundUser.setAccountType(AccountType.ASSISTANT);
                case "PATIENT" -> foundUser.setAccountType(AccountType.PATIENT);
            }

        }
        return foundUser;

    }

    public User createUser(User user) throws SQLException {

        ResultSet generatedKeys = null;

        try (Connection connection = DataBaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO public.users (username, password, status, account_type) VALUES (?,?,?,?);", Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getStatus().toString());
            preparedStatement.setString(4, user.getAccountType().toString());

            preparedStatement.executeUpdate();

            generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            user.setId(generatedKeys.getLong(1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public void deleteUser(long id) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM public.users WHERE id = ?");
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    public User updateUser(User user) throws SQLException {

        ResultSet generatedKeys = null;

        try (Connection connection = DataBaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.users SET username = ?, password = ?, status = ?, account_type = ? WHERE id = ?")) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getStatus().toString());
            preparedStatement.setString(4, user.getAccountType().toString());
            preparedStatement.setLong(5, user.getId());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }


}
