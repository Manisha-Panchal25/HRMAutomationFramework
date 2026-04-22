package helperUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;

public class PropFileHandler {

	Properties properties;
	File file;
	PropFileHandler propFileInstance;
	String filePath = System.getProperty("user.dir");

	private static PropFileHandler PropFileHandlerInstance = null;
	
	public static PropFileHandler getInstance(String fileName) { // For thread safety
		if (PropFileHandlerInstance == null) {
			synchronized (PropFileHandler.class) {
				PropFileHandlerInstance = new PropFileHandler(fileName);
			}
		}
		return PropFileHandlerInstance;
	}
	private  PropFileHandler(String fileName) {
		properties = new Properties();
		System.out.println(fileName);
		file = new File(filePath);
		if (!file.exists())
			file.mkdir();
		filePath = filePath + File.separator + fileName + ".properties";
		file = new File(filePath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

	/**
	 * This method is used to read the value of the given property from the
	 * properties file.
	 * 
	 * @param property : the property whose value is to be fetched.
	 * @return the value of the given property.
	 */

	public String readProperty(String property) {
		InputStream inPropFile = null;
		try {

			inPropFile = new FileInputStream(filePath);
			properties.load(inPropFile);
		} catch (IOException e) {
		}
		String value = properties.getProperty(property);

		return value;
	}

	/**
	 * This method is used to write the value of the property in property file.
	 * 
	 * @param property
	 * @param value
	 * @throws IOException
	 */
	public synchronized void writeToFile(String property, String value) {
		try {
			InputStream inPropFile = new FileInputStream(filePath);
			properties.load(inPropFile);
			inPropFile.close();
			OutputStream outPropFile = new FileOutputStream(filePath);
			properties.setProperty(property, value);
			properties.store(outPropFile, null);
			outPropFile.close();
		} catch (IOException e) {
			System.out.println("Unable to write value in property file");
			e.printStackTrace();
		}
	}

	public void writeToFile(Map<String, String> storedData) {
		try {
			System.out.println(filePath);
			InputStream inPropFile = new FileInputStream(filePath);
			properties.load(inPropFile);
			inPropFile.close();
			OutputStream outPropFile = new FileOutputStream(filePath);
			properties.putAll(storedData);
			properties.store(outPropFile, null);
			outPropFile.close();
		} catch (Exception e) {
			System.out.println("Unable to write value in property file");
			e.printStackTrace();
		}
	}

}
