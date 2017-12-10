package pkgApp.controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {
	
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	
	@FXML
	private TextField txtAnnualReturnWorking;
	
	@FXML
	private TextField txtYearsRetired;
	
	@FXML
	private TextField txtAnnualReturnRetirement;
	
	@FXML
	private TextField txtRequiredIncome;
	
	@FXML
	private TextField txtMonthlySSI;
	
	@FXML
	private TextField txtSaveEachMonth;
	
	@FXML
	private TextField txtWhatYouNeedToSave;
	

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
		
         
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		
        txtYearsToWork.clear();
        txtAnnualReturnWorking.clear();
        txtYearsRetired.clear();
        txtAnnualReturnRetirement.clear();
        txtRequiredIncome.clear();
        txtMonthlySSI.clear();
		txtSaveEachMonth.clear();
        txtWhatYouNeedToSave.clear();
       
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		System.out.println("Calculate Pressed");
		if(isInputValid()) {
		Retirement retirement = new Retirement(Integer.parseInt(txtYearsToWork.getText()),Double.parseDouble(txtAnnualReturnWorking.getText()),Integer.parseInt(txtYearsRetired.getText()),Double.parseDouble(txtAnnualReturnRetirement.getText()),Double.parseDouble(txtRequiredIncome.getText()),Double.parseDouble(txtMonthlySSI.getText()));
		
		DecimalFormat df = new DecimalFormat(".##");
		
		String totalamountsaved = df.format(retirement.TotalAmountSaved());
		String amounttosave = df.format(retirement.AmountToSave());

		txtSaveEachMonth.setText(amounttosave);
        txtWhatYouNeedToSave.setText(totalamountsaved);
		
		}	
	}
	
	private boolean isInputValid() {
        String errorMessage = "";

        if (txtYearsToWork.getText() == null || txtYearsToWork.getText().length() == 0) {
            errorMessage += "Invalid years to work!\n"; 
        } else {
            try {
                Integer.parseInt(txtYearsToWork.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Invalid years to work!\n"; 
            }
        }
        
        if (txtAnnualReturnWorking.getText() == null || txtAnnualReturnWorking.getText().length() == 0) {
            errorMessage += "Invalid annual return (working)!\n"; 
        } else {
            try {
                Double.parseDouble(txtAnnualReturnWorking.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Invalid annual return (working)!\n"; 
            }
        }
        
        if (txtYearsRetired.getText() == null || txtYearsRetired.getText().length() == 0) {
            errorMessage += "Invalid years retired!\n"; 
        } else {
            try {
                Integer.parseInt(txtYearsRetired.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Invalid years retired!\n"; 
            }
        }
        
        if (txtAnnualReturnRetirement.getText() == null || txtAnnualReturnRetirement.getText().length() == 0) {
            errorMessage += "Invalid annual return (retired)!\n"; 
        } else {
            try {
                Double.parseDouble(txtAnnualReturnRetirement.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Invalid annual return (retired)!\n"; 
            }
        }
        
        if (txtRequiredIncome.getText() == null || txtRequiredIncome.getText().length() == 0) {
            errorMessage += "Invalid required income!\n"; 
        } else {
            try {
                Double.parseDouble(txtRequiredIncome.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Invalid required income!\n"; 
            }
        }
        
        if (txtMonthlySSI.getText() == null || txtMonthlySSI.getText().length() == 0) {
            errorMessage += "Invalid monthly SSI!\n"; 
        } else {
            try {
                Double.parseDouble(txtMonthlySSI.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Invalid monthly SSI!\n"; 
            }
        }
        
        if (txtSaveEachMonth.getText().length() != 0) {
            errorMessage += "Save each month must be clear!\n"; 
        }
        
        if (txtWhatYouNeedToSave.getText().length() != 0){
            errorMessage += "Total amount to save must be clear!\n"; 
        }


        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}



