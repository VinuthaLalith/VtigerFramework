package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods related to Property file
 * @author vinuv
 *
 */
public class PropertyFileUtility {
	/**
	 * This method will read from Property file and return value to caller
	 * @param key
	 * @return
	 * @throws IOException
	 */

	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IConstantutility.propertyFilePath);
		Properties prop=new Properties();
		prop.load(fis);
		String value=prop.getProperty(key);
		return value;

	}

}
