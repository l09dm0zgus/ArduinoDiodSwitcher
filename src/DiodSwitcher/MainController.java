package DiodSwitcher;

import com.fazecast.jSerialComm.SerialPort;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    SerialPort port = SerialPort.getCommPorts()[0];
    @FXML
    private ImageView bulbOnImage;
    @FXML
    private ImageView bulbOffImage;
    @FXML
    private void on(MouseEvent event) throws IOException {
        bulbOffImage.setVisible(false);
        bulbOnImage.setVisible(true);
        port.getOutputStream().write('1');
    }
    @FXML
    private  void  off(MouseEvent event) throws IOException {
        bulbOffImage.setVisible(true);
        bulbOnImage.setVisible(false);
        port.getOutputStream().write('0');
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        port.setComPortParameters(9600,8,1,0);
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING,0,0);
        if(port.openPort()){
            System.out.println("Port is open.");
        } else {
            System.out.println("Failed to open port!");
            return;
        }
    }
}
