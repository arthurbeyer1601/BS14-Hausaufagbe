import java.sql.*;

public class CreateDatabase {


  static GetterSetter get = new GetterSetter();
  public static final String DB_NAME = "Database.db";
  public static final String CONNECTION_STRING = "jdbc:sqlite:" + get.getDbPath() + "Database.db";
  public static final String TABLE_NAME = "Daten";
  public static final String COLUMN_EMAIL = "Email";
  public static final String url = CONNECTION_STRING;
  public static final String COLUMN_ID = "user_ID";
  public static Connection connection;
  public static Statement statement;

  static {
    try {
      connection = DriverManager.getConnection(url);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  static {
    try {
      statement = connection.createStatement();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public static void createDatabase() {
    try {
      statement.execute(
          "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "( " + COLUMN_ID + " INTEGER PRIMARY KEY, "
              + COLUMN_EMAIL + " TEXT)");

    } catch (Exception ignored) {

    }
  }



}
