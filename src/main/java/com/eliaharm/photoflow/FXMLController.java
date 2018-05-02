package com.eliaharm.photoflow;

import java.net.URL;
import java.util.ResourceBundle;

import com.eliaharm.photoflow.mtp.MTPFileManager;
import com.eliaharm.photoflow.mtp.MTPUtil;
import com.eliaharm.photoflow.util.ProgramDirectoryUtilities;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import jmtp.PortableDevice;




public class FXMLController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        try {
        	System.out.println(ProgramDirectoryUtilities.getProgramDirectory());
        	System.out.println(System.getProperty("user.dir"));
            System.out.println(this.getClass().getProtectionDomain().getCodeSource().getLocation());
			MTPUtil.addLibraryPath(System.getProperty("user.dir")+"\\target\\");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        MTPUtil.printAll();
        MTPFileManager jMTPmng = new MTPFileManager();
        PortableDevice[] devices =jMTPmng.getDevices();
        for (int i = 0; i < devices.length; i++){
            System.out.println(devices[i].toString());
        jMTPmng.openDevice(devices[i]);
        }
        jMTPmng.close();
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
