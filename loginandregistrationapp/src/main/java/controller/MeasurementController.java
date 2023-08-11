//package controller;
//
//import fullApplication.IoTDeviceLogic.facade.MeasurementFacade;
//import fullApplication.IoTDeviceLogic.model.Measurement;
//import fullApplication.IoTDeviceLogic.util.SensorNotFoundException;
//
//import javax.annotation.ManagedBean;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.RequestScoped;
//import javax.faces.context.FacesContext;
//
//@ManagedBean("measurementController")
//@RequestScoped
//public class MeasurementController {
//    MeasurementFacade mFacade;
//    public MeasurementController(){
//        mFacade = new MeasurementFacade();
//    }
//
//    public String onSubmit(Measurement measurement) {
//        try {
//            Measurement newMeasurement = mFacade.addMeasurement(measurement);
//            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("measurement", newMeasurement);
//            return "something.xhtml"; //TODO change
//        } catch (SensorNotFoundException e) {
//            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No matching sensor", "No matching sensor to that ID number were found");
//            FacesContext.getCurrentInstance().addMessage(null, message);
//            return null; // Or navigate to an error page
//        }
//    }
//}
