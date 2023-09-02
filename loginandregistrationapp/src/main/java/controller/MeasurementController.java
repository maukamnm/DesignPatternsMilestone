//package controller;
//
//import javax.annotation.ManagedBean;
//import javax.ejb.EJB;
//import javax.ejb.Local;
//import javax.ejb.LocalBean;
//import javax.ejb.Stateless;
//import javax.enterprise.inject.Alternative;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.RequestScoped;
//import javax.faces.context.FacesContext;
//import javax.interceptor.Interceptors;
//
//import business.IoTManagerInterface;
//import business.LoggingInterceptor;
//import facade.MeasurementFacade;
//import model.Iotdevice;
//import model.Measurement;
//
////@ManagedBean("measurementController")
//@Stateless
//@LocalBean
//@Local(IoTManagerInterface.class)
//@Alternative
////@RequestScoped
//@Interceptors(LoggingInterceptor.class)
//public class MeasurementController {
//	@EJB
//    MeasurementFacade mFacade;
//    public MeasurementController(){
//        mFacade = new MeasurementFacade();
//    }
//    
//    public String register() {
//		FacesContext context = FacesContext.getCurrentInstance();
//		Iotdevice measurement = context.getApplication().evaluateExpressionGet(context, "#{iotmodel}", Iotdevice.class);
//
//			try {
//				this.mFacade.addMeasurement(measurement);
//			} catch (Exception e) {
//				context.addMessage(null, new FacesMessage("Unable to add measurement. Try again later."));
//				context.getExternalContext().getSessionMap().clear();
//				return "";
//			}
//		return "login.xhtml";
//	}
//
////    public String onSubmit(Measurement measurement) {
////        try {
////            Measurement newMeasurement = mFacade.addMeasurement(measurement);
////            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("measurement", newMeasurement);
////            return "something.xhtml"; //TODO change
////        } catch (Exception e) {
////            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No matching sensor", "No matching sensor to that ID number were found");
////            FacesContext.getCurrentInstance().addMessage(null, message);
////            return null; // Or navigate to an error page
////        }
////    }
//}
