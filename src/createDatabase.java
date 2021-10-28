import java.sql.*;

public class createDatabase{

    public static final String DB_NAME = "AccountManager.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\NIKUFS\\IdeaProjects\\Freetime\\src\\" + DB_NAME;
    public static final String TABLE_NAME = "Daten";
    public static final String COLUMN_USERNAME = "Username";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_EMAIL = "Email";
    public static final String COLUMN_ID = "user_ID";

    public static final String url = CONNECTION_STRING;

    public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Statement statement;

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public createDatabase() throws SQLException {





        try{
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "( " + COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_USERNAME + " TEXT , " + COLUMN_PASSWORD + " TEXT, " + COLUMN_EMAIL + " TEXT)");

        } catch(Exception e) {
            System.out.println(e);
        }

    }
}
