import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

public class AuswahlInput {

    public static Scanner scanInput = new Scanner(System.in);
    public static BufferedReader readerInput = new BufferedReader(new InputStreamReader(System.in));




    public AuswahlInput() throws SQLException, IOException {
        //Auswahl der Optionen

        System.out.println("Bitte Wählen sie zwischen:");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        String options = readerInput.readLine();

        while(!options.matches("^[1-3\\s]")) {
            System.out.println("Ungültige Eingabe!");
            System.out.println("Bitte eingabe wiederholen!");
            options = readerInput.readLine();
        }

        if(options.equals("1")) {
            new register();
        }

        if(options.equals("2")) {
            new login();
        }

        if(options.equals("3")) {
            System.out.println("CLOSED!");
            System.exit(1);
        }



    }

}
