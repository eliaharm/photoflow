package com.eliaharm.photoflow;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eliaharm.photoflow.jpa.Imported_files;
import com.eliaharm.photoflow.mtp.MTPFileManager;
import com.eliaharm.photoflow.mtp.MTPUtil;
import com.eliaharm.photoflow.util.ProgramDirectoryUtilities;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import jmtp.PortableDevice;

import io.ebean.Ebean;
import io.ebean.EbeanServer;

public class FXMLController implements Initializable {

	final static Logger logger = LoggerFactory.getLogger(MainApp.class);

	private static EbeanServer server = Ebean.getServer(null);

	@FXML
	private Label label;

	@FXML
	private void handleButtonAction(ActionEvent event) {
		logger.info("Entering application: handleButtonAction");
		System.out.println("You clicked me!");
		label.setText("Hello World!");
		try {
			System.out.println(ProgramDirectoryUtilities.getProgramDirectory());
			System.out.println(System.getProperty("user.dir"));
			System.out.println(this.getClass().getProtectionDomain().getCodeSource().getLocation());
			MTPUtil.addLibraryPath(System.getProperty("user.dir") + "\\target\\classes\\");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MTPUtil.printAll();
		MTPFileManager jMTPmng = new MTPFileManager();
		PortableDevice[] devices = jMTPmng.getDevices();
		for (int i = 0; i < devices.length; i++) {
			System.out.println(devices[i].toString());
			jMTPmng.openDevice(devices[i]);
		}
		jMTPmng.close();

	}

	@FXML
	private void handleButton2Action(ActionEvent event) {
		logger.info("Entering application: handleButton2Action DB");

		Imported_files Files = Ebean.find(Imported_files.class, 1);
		logger.info(Files.getFile_name_path());
		logger.info(Files.toString());

		List<Imported_files> query = Ebean.find(Imported_files.class).findList();
		logger.info(query.iterator().toString());
		
		//t3et push

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}
}
