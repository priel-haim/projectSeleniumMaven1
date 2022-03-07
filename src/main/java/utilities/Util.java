package utilities;

public class Util {
	public static String ReadProperty(String key) {
	String Value="";
    try (java.io.InputStream input = new java.io.FileInputStream("./src/main/resources/configuration.properties")) {
        java.util.Properties prop = new java.util.Properties();
        // load a properties file
        prop.load(input);
          Value=prop.getProperty(key);
    } catch (Exception e) {
       
    }
	return Value;
}
}