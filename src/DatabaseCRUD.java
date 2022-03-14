
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DatabaseCRUD {

    GetterSetter getter = new GetterSetter();
    public List<String> temp = new ArrayList<>();

  public void createContact(Statement statement, Integer id , String email) throws SQLException {
        statement.execute("INSERT INTO " + createDatabase.TABLE_NAME + " VALUES " + "("+ id + ", '" + email + "')");
    }

    public void readContact(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + createDatabase.TABLE_NAME);


        while(resultSet.next()) {
            System.out.println(resultSet.getString(createDatabase.COLUMN_EMAIL));
            temp.add(resultSet.getString(createDatabase.COLUMN_EMAIL));

        }
    }

    public void updateContact(Statement statement, String currentName, String newName) throws SQLException {
        statement.execute("UPDATE " + createDatabase.TABLE_NAME+ " SET " + createDatabase.COLUMN_EMAIL + " = '" + newName + "'" + " WHERE " + createDatabase.COLUMN_EMAIL + " = '" + currentName + "'" + " COLLATE NOCASE ");
    }

    public void deleteContact(Statement statement, String name) throws SQLException {
        statement.execute("DELETE FROM " + createDatabase.TABLE_NAME + " WHERE " + createDatabase.COLUMN_EMAIL + " = '" + name + "'" + " COLLATE NOCASE");
    }


}
