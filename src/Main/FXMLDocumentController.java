/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Algorithm.InfixToPostfix;
import Algorithm.InfixToPrefix;
import Algorithm.PostfixToInfix;
import Algorithm.PostfixToPrefix;
import Algorithm.PrefixToInfix;
import Algorithm.PrefixToPostfix;
import static Util.Helper.Normalized.standardize;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author HIPPY
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField tbPrefix;
    @FXML
    private TextField tbInfix;
    @FXML
    private TextField tbPostfix;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void ResetField(ActionEvent event) {
        tbPrefix.setText(null);
        tbInfix.setText(null);
        tbPostfix.setText(null);
    }

    @FXML
    private void EnableWrite(MouseEvent event) {
        if (tbPrefix.isFocused()) {
            tbInfix.setText(null);
            tbPostfix.setText(null);
        }

        if (tbInfix.isFocused()) {
            tbPrefix.setText(null);
            tbPostfix.setText(null);
        }

        if (tbPostfix.isFocused()) {
            tbPrefix.setText(null);
            tbInfix.setText(null);
        }
    }

    @FXML
    private void ConvertPrefixTo(ActionEvent event) {

        if (!tbPrefix.getText().isEmpty()) {
            tbInfix.setText(null);
            tbPostfix.setText(null);
            
            String s = standardize(tbPrefix.getText());

            PrefixToInfix PrTI = new PrefixToInfix();
            tbInfix.setText(PrTI.Convert(s));

            PrefixToPostfix PrTP = new PrefixToPostfix();
            tbPostfix.setText(PrTP.Convert(s));
        }
    }

    @FXML
    private void ConvertInfixTo(ActionEvent event) {

        if (!tbInfix.getText().isEmpty()) {
            tbPrefix.setText(null);
            tbPostfix.setText(null);

            String s = standardize(tbInfix.getText());

            InfixToPrefix ITPr = new InfixToPrefix();
            tbPrefix.setText(ITPr.Convert(s));

            InfixToPostfix ITP = new InfixToPostfix();
            tbPostfix.setText(ITP.Convert(s));

        }
    }

    @FXML
    private void ConvertPostfixTo(ActionEvent event) {

        if (!tbPostfix.getText().isEmpty()) {
            tbPrefix.setText(null);
            tbInfix.setText(null);
            
            String s = standardize(tbPostfix.getText());

            PostfixToPrefix PTPr = new PostfixToPrefix();
            tbPrefix.setText(PTPr.Convert(s));

            PostfixToInfix PTI = new PostfixToInfix();
            tbInfix.setText(PTI.Convert(s));

        }
    }

}
