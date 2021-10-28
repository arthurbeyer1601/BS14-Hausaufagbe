import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Locale;

public class login {



    public login() throws SQLException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String emailInput;
        System.out.println("Bitte Email eingeben!");
        emailInput = reader.readLine();
        GetterSetter.setEmailInput(emailInput.toLowerCase(Locale.ROOT));

        DatabaseCRUD.readUsername(createDatabase.statement);





        new AuswahlInput();

    }





}
