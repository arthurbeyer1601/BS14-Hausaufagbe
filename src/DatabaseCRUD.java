
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseCRUD {

    public static int maxID = 0;

    public static List<String> emails = new ArrayList<>();

    public static void createContact(Statement statement, Integer id , String username, String password, String email) throws SQLException {
        statement.execute("INSERT INTO " + createDatabase.TABLE_NAME + " VALUES " + "("+ id + ", '" + username + "', '" + password + "', '" + email + "')");
    }

    public static void readContact(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + createDatabase.TABLE_NAME);

        while(resultSet.next()) {
            System.out.println(resultSet.getString(createDatabase.COLUMN_USERNAME));
            System.out.println(resultSet.getString(createDatabase.COLUMN_EMAIL));
            System.out.println(resultSet.getString(createDatabase.COLUMN_PASSWORD));
        }
    }
    public static void readDatabankSize(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT user_ID FROM " + createDatabase.TABLE_NAME);

        while(resultSet.next()) {
            maxID++;
        }

        System.out.println(maxID);

        }

    public static void readUsername(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT Username FROM " + createDatabase.TABLE_NAME + " WHERE Email = '" + GetterSetter.getEmailInput() + "'");
        System.out.println(resultSet.getString(createDatabase.COLUMN_USERNAME));
    }

    public static void readEmail(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + createDatabase.TABLE_NAME);

        while(resultSet.next()) {
            System.out.println(resultSet.getString(createDatabase.COLUMN_EMAIL));
        }
    }

    public static void updateContact(Statement statement, String currentName, String newName) throws SQLException {
        statement.execute("UPDATE " + createDatabase.TABLE_NAME+ " SET " + createDatabase.COLUMN_USERNAME + " = '" + newName + "'" + " WHERE " + createDatabase.COLUMN_USERNAME + " = '" + currentName + "'" + " COLLATE NOCASE ");
    }

    public static void deleteContact(Statement statement, String name) throws SQLException {
        statement.execute("DELETE FROM " + createDatabase.TABLE_NAME + " WHERE " + createDatabase.COLUMN_USERNAME + " = '" + name + "'" + " COLLATE NOCASE");
    }

    public static void isEmailUnique(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + createDatabase.TABLE_NAME);
        while(resultSet.next()) {
            emails.add(resultSet.getString(createDatabase.COLUMN_EMAIL));
        }

    }
}
