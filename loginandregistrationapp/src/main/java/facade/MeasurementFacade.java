//package fullApplication.IoTDeviceLogic.facade;
//
//import fullApplication.IoTDeviceLogic.business.MeasurementInterface;
//import fullApplication.IoTDeviceLogic.util.SensorNotFoundException;
//import fullApplication.IoTDeviceLogic.model.Measurement;
//
//import javax.ejb.EJB;
//
//@EJB
//public class MeasurementFacade {
//    MeasurementInterface measurementInterface;
//    public Measurement addMeasurement(Measurement measurement){
//        try{
//            Measurement newMeasurement = measurementInterface.addMeasurement(measurement);
//            return newMeasurement;
//        } catch (SensorNotFoundException e) {
//            throw e;
//        }
//    }
//
//
//}
