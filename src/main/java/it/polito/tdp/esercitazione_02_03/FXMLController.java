/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.esercitazione_02_03;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FXMLController {

	// numero da indovinare:
	private int segreto;
	private final int TMAX = 8; // final indica che la variabile è una costante e non cambierà durante il gioco
	private final int NMAX = 100;
	// numero di tentativi fatti:
	private int tentativi; 
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnNuovaPartita"
    private Button btnNuovaPartita; // Value injected by FXMLLoader

    @FXML // fx:id="btnProva"
    private Button btnProva; // Value injected by FXMLLoader
    
    @FXML // fx:id="hBoxTentativi"
    private HBox hBoxTentativi; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultato"
    private TextArea txtRisultato; // Value injected by FXMLLoader

    @FXML // fx:id="txtTentativi"
    private TextField txtTentativi; // Value injected by FXMLLoader

    @FXML // fx:id="txtTentativo"
    private TextField txtTentativo; // Value injected by FXMLLoader

    @FXML
    void doNuovaPartita(ActionEvent event) {
    	
    	// gestione variabili
    	this.segreto = (int) (Math.random()*100+1);
    	this.tentativi = 0;
    	
    	// gestione interfaccia
    	this.txtTentativi.setText(""+TMAX); // oppure: this.txtTentativi.setText(Integer.toString(TMAX));
    	this.txtRisultato.clear(); // per pulire l'area di testo
    	
    	// rendo l'hBox abilitato
    	this.hBoxTentativi.setDisable(false);

    }

    @FXML
    void doTentativo(ActionEvent event) {
    	
    	// controllo dell'input
    	String ts = this.txtTentativo.getText(); // .getText() restituisce sempre una stringa
    	int intTentativo;
    	try {
    		intTentativo = Integer.parseInt(ts);
    	} catch(NumberFormatException e) {
    		txtRisultato.setText("Devi inserire un tentativo numerico tra 1 e 100!");
    		return;
    	}
    	
    	this.tentativi ++;
    	
    	// controllo tentativo
    	if(intTentativo==segreto) {
    		this.txtRisultato.setText("Hai indovinato con "+this.tentativi+" tentativi");
        	this.hBoxTentativi.setDisable(true); // disabilito l'hBox
    		return;
    	}
    	
    	if(this.tentativi==TMAX) {
    		this.txtRisultato.setText("Hai perso. Il numero era: "+this.segreto);
        	this.hBoxTentativi.setDisable(true); // disabilito l'hBox
    		return;
    	}
    	
    	if(intTentativo<this.segreto) {
    		txtRisultato.setText("Tentativo troppo basso");
    	} else {
    		txtRisultato.setText("Tentativo troppo alto");
    	}
    	
    	txtTentativi.setText(Integer.toString(TMAX-tentativi));

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnNuovaPartita != null : "fx:id=\"btnNuovaPartita\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnProva != null : "fx:id=\"btnProva\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativo != null : "fx:id=\"txtTentativo\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}

