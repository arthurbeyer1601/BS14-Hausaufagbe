import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class Main {

  static DatabaseCRUD crud = new DatabaseCRUD();
  static GetterSetter getter = new GetterSetter();
  static String oldtxtPath;
  static String txtPath;

  public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

    CreateDatabase.createDatabase();

    getter.setDbPath(System.getProperty("user.dir"));
    if (args[0].equalsIgnoreCase("-help") || args[0].equalsIgnoreCase("--help")) {
      System.out.println("-currentPath        current Databank-Path");
      System.out.println("-importMails        add Mails to Databank");
      System.out.println("-exportMails        export Mails to Text File");

    } else if (args[0].equalsIgnoreCase("-currentPath")) {
      System.out.println(System.getProperty("user.dir"));
    } else if (args[0].equalsIgnoreCase("-importMails")) {
      oldtxtPath = args[1];
      txtPath = oldtxtPath.replaceAll("\\\\", "/");
      List<String> temp = new ArrayList<>();

      try (Stream<String> stream = Files.lines(Paths.get(txtPath))) {
        stream.forEach(temp::add);
      }

      for (int i = 0; i < temp.toArray().length; i++) {
        crud.createContact(CreateDatabase.statement, null, temp.get(i));
      }
    } else if (args[0].equalsIgnoreCase("-exportMails")) {
      getter.setTxtName(args[1]);
      crud.readContact(CreateDatabase.statement);

      try {
        File myObj = new File(getter.getTxtName());
        if (myObj.createNewFile()) {
          System.out.println("Created: " + getter.getTxtName());
        } else {
          System.out.println("File already exists");
        }
      } catch (IOException e) {
        System.out.println("An error occurred");
        e.printStackTrace();
      }

      try {
        FileWriter myWriter = new FileWriter(getter.getTxtName());
        for (int i = 0; i < crud.temp.size(); i++) {
          myWriter.write(crud.temp.get(i) + "\n");
        }
        myWriter.close();
        System.out.println("Wrote to the file.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    } else {
      System.out.println("No known Command");
    }


  }

}
