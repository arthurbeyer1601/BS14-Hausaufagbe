import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class register {

    public static Scanner scan = new Scanner(System.in);
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public register() throws IOException, SQLException {




                DatabaseCRUD.isEmailUnique(createDatabase.statement);
                System.out.println("Register");
                System.out.println("Username:");
                String username = reader.readLine();
                GetterSetter.setUsername(username);

                while (!GetterSetter.getUsername().matches("^[A-Za-z0-9\\s]+") || GetterSetter.getUsername().length() < 3) {
                    System.out.println("Der Benutzername muss mindestens 3 Buchstaben lang sein und darf keine Sonderzeichen enthalten");
                    System.out.println("Bitte wiederholen:");
                    username = reader.readLine();
                    GetterSetter.setUsername(username);
                }

                System.out.println("Es wurde der Benutzername " + GetterSetter.getUsername() + " gesetzt");

                System.out.println("E-Mail:");
                String email = reader.readLine();
                GetterSetter.setEmail(email);

                boolean alreadyExists = false;

                for(int i = 0; i < DatabaseCRUD.emails.toArray().length; i++) {
                    if(!GetterSetter.getEmail().equals(DatabaseCRUD.emails.get(i))) {
                        alreadyExists = true;
                    }
                }

                while(alreadyExists) {
                    System.out.println("Diese Email wird bereits verwendet!");
                    System.out.println("Eingabe bitte wiederholen:");
                    email = reader.readLine();
                }



                while (!GetterSetter.getEmail().matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?!-)(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) {
                    System.out.println("Keine gültige Mailadresse ");
                    System.out.println("Eingabe bitte wiederholen:");
                    email = reader.readLine();
                    GetterSetter.setEmail(email);
                }








                System.out.println("Es wurde die Mailadresse " + GetterSetter.getEmail() + " gesetzt");

                System.out.println("Password:");
                String password = reader.readLine();
                GetterSetter.setPassword(password);

                while (GetterSetter.getPassword().length() < 7) {
                    System.out.println("Das Passwort muss aus mindestens 7 zeichen bestehen!");
                    System.out.println("Bitte wiederholen sie ihre eingabe");
                    password = reader.readLine();
                    GetterSetter.setPassword(password);
                }

                DatabaseCRUD.createContact(createDatabase.statement, null ,GetterSetter.getUsername(), GetterSetter.getPassword(), GetterSetter.getEmail().toLowerCase(Locale.ROOT));
                System.out.println("Account created!");
                new AuswahlInput();


            }
        }



