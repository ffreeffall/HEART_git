package Controller;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.MEmployee;
import Model.MComboBoxAutoComplete;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CRegister implements Initializable {
	MEmployee new_employee;
	CList parent_controller;
	String image_path = null;
	MComboBoxAutoComplete<String> autocmb;
	
    @FXML
    private Button btnRegisterImage;

    @FXML
    private Button btnDone;

    @FXML
    private Button btnCancel;

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtName;

    @FXML
    private ComboBox<String> cmbDepart;

    @FXML
    private Button btnDepartInsert;

    @FXML
    private ImageView imvFace;
    
    @FXML
    void OnCancel(ActionEvent event) {
    	Stage thisStage = (Stage)this.btnCancel.getScene().getWindow();
    	thisStage.close();
    }

    @FXML
    void OnDepartInsert(ActionEvent event) {
    	TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Add new department");
		dialog.setHeaderText(null);
		dialog.setContentText("Type department name");
		dialog.showAndWait();
		
		/* Apply to view */
		this.cmbDepart.getItems().add(dialog.getEditor().getText());
    	autocmb = new MComboBoxAutoComplete<String>(this.cmbDepart);
    }

    @FXML
    void OnDone(ActionEvent event) {
    	/* Transfer data to parent controller */
    	new_employee = new MEmployee(this.txtName.getText(), this.txtDate.getEditor().getText(), this.cmbDepart.getValue(), this.image_path);
    	
    	/* If modifying, delete original information */
    	if(this.parent_controller.isModifying()) {
    		this.parent_controller.ModifyEmployee(new_employee);
    	} else {
        	this.parent_controller.RegisterEmployee(new_employee);
    	}
    	
    	/* Close window */
    	Stage thisStage = (Stage)this.btnDone.getScene().getWindow();
    	thisStage.close();
    }

    @FXML
    void OnRegisterImage(ActionEvent event) {
	    /* Choose file */
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File("."));
		File selectedFile = fc.showOpenDialog(null);    
		
		/*Set image*/
		Image image = new Image(selectedFile.toURI().toString());
		this.imvFace.setImage(image);
		this.image_path = selectedFile.getPath();
    }

    void setPerentController(CList controller) {
    	this.parent_controller = controller;
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		this.new_employee = null;
    	this.parent_controller = null;
    	this.cmbDepart.getItems().addAll("HILab", "MECSLab", "AIBILab");
    	autocmb = new MComboBoxAutoComplete<String>(this.cmbDepart);
	}
	
	public void setEmployee(MEmployee paramEmployee) {
		this.txtName.setText(paramEmployee.getName());
		this.txtDate.getEditor().setText(paramEmployee.getEnroll_date());
		this.cmbDepart.getSelectionModel().select(paramEmployee.getDepartment());
		this.image_path = paramEmployee.getImage_path();
		if(image_path != null) {
			Image image = new Image(new File(image_path).toURI().toString());
			this.imvFace.setImage(image);
		}
	}
}
