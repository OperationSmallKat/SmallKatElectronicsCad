import eu.mihosoft.vrl.v3d.CSG
import eu.mihosoft.vrl.v3d.Cube
import eu.mihosoft.vrl.v3d.Cylinder
import eu.mihosoft.vrl.v3d.parametrics.*;

import com.neuronrobotics.bowlerstudio.scripting.ScriptingEngine
import com.neuronrobotics.bowlerstudio.vitamins.Vitamins;

import com.neuronrobotics.bowlerstudio.vitamins.Vitamins;
import javafx.scene.paint.Color;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;



import eu.mihosoft.vrl.v3d.parametrics.*;
CSG getNut(){
	String type= "smallKatElectronics"

	if(args==null)
		args=["dji-mavic-pro-battery"]
	String sizeVar = args.get(0)
	StringParameter size = new StringParameter(	type+" Default",
			sizeVar,
			Vitamins.listVitaminSizes(type))
	String stl = "Battery.stl"
	
	if(size.getString().contentEquals("motherboard")) {
		stl = "motherboard.stl"
	}
	if(size.getString().contentEquals("batteryInterface")) {
		stl = "batteryInterface.stl"
	}
	return Vitamins.get(ScriptingEngine.fileFromGit(
			"hhttps://github.com/OperationSmallKat/SmallKatElectronicsCad.git",
			stl))
			.setParameter(size)
			.setRegenerate({getNut()})
}
//println "Hello World from Cap Screw script!"
return getNut()