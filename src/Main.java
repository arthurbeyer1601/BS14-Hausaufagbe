import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws IOException, SQLException {
        Scanner scan = new Scanner(System.in);
        new createDatabase();
        DatabaseCRUD.readDatabankSize(createDatabase.statement);
        new AuswahlInput();





    }

}
