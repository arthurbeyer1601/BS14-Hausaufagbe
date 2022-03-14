
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DatabaseCRUD {

    GetterSetter getter = new GetterSetter();
    public List<String> temp = new ArrayList<>();

  public void createContact(Statement statement, Integer id , String email) throws SQLException {
        statement.execute("INSERT INTO " + CreateDatabase.TABLE_NAME + " VALUES " + "("+ id + ", '" + email + "')");
    }

    public void readContact(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + CreateDatabase.TABLE_NAME);


        while(resultSet.next()) {
            System.out.println(resultSet.getString(CreateDatabase.COLUMN_EMAIL));
            temp.add(resultSet.getString(CreateDatabase.COLUMN_EMAIL));

        }
    }

    public void updateContact(Statement statement, String currentName, String newName) throws SQLException {
        statement.execute("UPDATE " + CreateDatabase.TABLE_NAME+ " SET " + CreateDatabase.COLUMN_EMAIL + " = '" + newName + "'" + " WHERE " + CreateDatabase.COLUMN_EMAIL + " = '" + currentName + "'" + " COLLATE NOCASE ");
    }

    public void deleteContact(Statement statement, String name) throws SQLException {
        statement.execute("DELETE FROM " + CreateDatabase.TABLE_NAME + " WHERE " + CreateDatabase.COLUMN_EMAIL + " = '" + name + "'" + " COLLATE NOCASE");
    }


}
