package facade;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.interceptor.Interceptors;

import business.LoggingInterceptor;
import business.MeasurementInterface;
import dao.IoTDao;
import model.Iotdevice;
import model.Measurement;
import model.Sensor;


//@EJB(beanInterface = MeasurementFacade.class, name = "MeasurementFacade")
@Named
public class MeasurementFacade {
    MeasurementInterface measurementInterface;
    
    public List<Iotdevice> getMeasurements(){
    	IoTDao iotDao = new IoTDao();      
		List<Iotdevice> listData = iotDao.getDevices();
		return listData;
    }    
    public List<Sensor> getSensors(){
    	 try{
         	IoTDao iotDao = new IoTDao();      
         	List<Sensor> sensorList = iotDao.readSensors();
         	return sensorList;
         } catch (Exception e) {
             throw e;
         }
    }
    public void addMeasurement(Sensor sensor){
        try{
        	IoTDao iotDao = new IoTDao();      
        	iotDao.saveNewSensor(sensor);
        } catch (Exception e) {
            throw e;
        }
    }


}
