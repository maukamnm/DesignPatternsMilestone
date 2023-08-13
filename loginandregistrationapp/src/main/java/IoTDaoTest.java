
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import business.IoTManager;
import model.Measurement;

class IoTDaoTest {

	Connection conn;
	
	@Before
    public void testConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException exc) {
            throw new RuntimeException(exc);
        }
        String url1 = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "";

        try {
            conn = DriverManager.getConnection(url1, user, password);
            if (conn != null) {
                System.out.println("Connected to the database");
            }
        } catch (SQLException exc) {
            throw new RuntimeException(exc);
        }
    }
    @Test
    public void testGetDevices() {
        IoTManager manager = new IoTManager();
        manager.getDevices();
    }

	@Test
	void getMeasurements() {
		 IoTManager manager = new IoTManager();
	        manager.getAllMeasurements();
	}
	
	 @Test
	    public void testGetSensors() {
	        IoTManager manager = new IoTManager();
	        manager.getSensors();
	    }
	 
   @Test
   public void saveNewSensor() {
       IoTManager manager = new IoTManager();
       manager.saveNewSensor();
   }

}
