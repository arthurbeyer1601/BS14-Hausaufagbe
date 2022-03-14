import java.util.ArrayList;
import java.util.List;

public class GetterSetter {

  private String dbPath;
  private String txtInputPath;
  private String txtName;

  public String getTxtName() {
    return txtName;
  }

  public void setTxtName(String txtName) {
    this.txtName = txtName;
  }

  public String getTxtInputPath() {
    return txtInputPath;
  }

  public void setTxtInputPath(String txtInputPath) {
    this.txtInputPath = txtInputPath;
  }

  public String getDbPath() {
    return dbPath;
  }

  public void setDbPath(String dbPath) {
    this.dbPath = dbPath;
  }
}
