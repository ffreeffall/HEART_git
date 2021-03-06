package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CSpecimenSelector extends AbsMetaController implements Initializable {

    @FXML
    private TableView<?> tblSpecimen;

    @FXML
    private CheckBox checkDateBegin;

    @FXML
    private DatePicker dateBegin;

    @FXML
    private CheckBox checkDateEnd;

    @FXML
    private DatePicker dateEnd;

    @FXML
    private CheckBox checkCountry;

    @FXML
    private TextField txtCountry;

    @FXML
    private CheckBox checkAlias;

    @FXML
    private TextField txtAlias;

    @FXML
    private CheckBox checkButterflyName;

    @FXML
    private TextField txtAlias1;

    @FXML
    private CheckBox checkButterflyClass;

    @FXML
    private TextField txtAlias11;

    @FXML
    private CheckBox checkStorageRoom;

    @FXML
    private ComboBox<?> comboStorageRoom;

    @FXML
    private CheckBox checkStorageCabinet;

    @FXML
    private ComboBox<?> comboStorageCabinet;

    @FXML
    private CheckBox checkStorageChest;

    @FXML
    private ComboBox<?> comboStorageChest;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSelect;

    @FXML
    void OnAlias(ActionEvent event) {

    }

    @FXML
    void OnButterflyClass(ActionEvent event) {

    }

    @FXML
    void OnButterflyName(ActionEvent event) {

    }

    @FXML
    void OnCancel(ActionEvent event) {
        Stage thisStage = (Stage)this.btnCancel.getScene().getWindow();
        thisStage.close();
    }

    @FXML
    void OnCountry(ActionEvent event) {

    }

    @FXML
    void OnDateBegin(ActionEvent event) {

    }

    @FXML
    void OnDateEnd(ActionEvent event) {

    }

    @FXML
    void OnSearch(ActionEvent event) {

    }

    @FXML
    void OnSelect(ActionEvent event) {
        /* Data Insert */
        Stage thisStage = (Stage)this.btnSelect.getScene().getWindow();
        thisStage.close();
    }

    @FXML
    void OnStorageCabinet(ActionEvent event) {

    }

    @FXML
    void OnStorageChest(ActionEvent event) {

    }

    @FXML
    void OnStorageRoom(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
