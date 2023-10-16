package prog10;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculadoraController implements Initializable {

    private double resultado;
    private boolean primerOperando;
    private boolean limpiarTexto;
    private boolean sePuedeCalcular;
    private char ultimoOperando;

    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn1;
    @FXML
    private Button btn3;
    @FXML
    private Button btnPlus;
    @FXML
    private Button btn2;
    @FXML
    private Button btn0;
    @FXML
    private Button btn6;
    @FXML
    private Button btnClearall;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnEquals;
    @FXML
    private Button btnMinus;
    @FXML
    private Button btnDiv;
    @FXML
    private TextField txtResult;
    @FXML
    private Button btn9;
    @FXML
    private Button btn8;
    @FXML
    private Button btn7;
    @FXML
    private Button btnMult;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.primerOperando = true;
        this.resultado = 0;
        this.limpiarTexto = true;
        this.sePuedeCalcular = false;
    }

    @FXML
    private void handleNumberButton(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String buttonText = clickedButton.getText();

        if (limpiarTexto) {
            txtResult.setText(buttonText);
            limpiarTexto = false;
        } else {
            txtResult.appendText(buttonText);
        }
        sePuedeCalcular = true;
    }

    @FXML
    private void handleOperationButton(ActionEvent event) {
        if (sePuedeCalcular) {
            try {
                double operand = Double.parseDouble(txtResult.getText());

                if (primerOperando) {
                    resultado = operand;
                } else {
                    switch (ultimoOperando) {
                        case '+':
                            resultado += operand;
                            break;
                        case '-':
                            resultado -= operand;
                            break;
                        case '*':
                            resultado *= operand;
                            break;
                        case '/':
                            if (operand != 0) {
                                resultado /= operand;
                            } else {
                                System.out.println("No se puede dividir por 0.");                            }
                            break;
                    }
                }
                txtResult.setText(String.valueOf(resultado));
                primerOperando = false;
                limpiarTexto = true;
                sePuedeCalcular = false;
            } catch (NumberFormatException e) {
                System.out.println("ERROR. Solo se puede operar con números.");            }
        }
        Button clickedButton = (Button) event.getSource();
        ultimoOperando = clickedButton.getText().charAt(0);
    }

    @FXML
    private void handleClearAllButton(ActionEvent event) {
        txtResult.setText("");
        resultado = 0;
        primerOperando = true;
        limpiarTexto = true;
        sePuedeCalcular = false;
    }

    @FXML
    private void handleClearButton(ActionEvent event) {
        txtResult.setText("");
        primerOperando = false;
        limpiarTexto = true;
        sePuedeCalcular = false;
    }

    @FXML
    private void handleEqualsButton(ActionEvent event) {
        handleOperationButton(event);
    }
}
