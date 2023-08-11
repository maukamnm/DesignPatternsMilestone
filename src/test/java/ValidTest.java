import fullApplication.IoTDeviceLogic.business.IoTManager;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class ValidTest {
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
        String password = "root";

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
    public void testGetMeasurements() {
        IoTManager manager = new IoTManager();
        manager.getAllMeasurements();
    }

    @Test
    public void testGetSensors() {
        IoTManager manager = new IoTManager();
        manager.getSensors();
    }

//    @Test
//    public void saveNewSensor() {
//        IoTManager manager = new IoTManager();
//        manager.saveNewSensor();
//    }
//        @Test
//    public void testGetMeasurements(){
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        Measurement measurement = new Measurement();
//        try {
//            String selectSql = "SELECT * FROM measurement where measurementID = " + 1;// can change id
//            stmt = conn.prepareStatement(selectSql);
//            try (PreparedStatement preparedStatement = conn.prepareStatement(selectSql);
//                 ResultSet resultSet = preparedStatement.executeQuery()) {
//                while (resultSet.next()) {
//                    measurement.setMeasurementId(resultSet.getInt("measurementID"));
//                    measurement.setSensorId(resultSet.getInt("sensorID"));
//                    measurement.setValue(resultSet.getLong("value"));
//                    measurement.setTimeStamp(resultSet.getTimestamp("timestamp"));
//                    System.out.println(measurement);
//            }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
