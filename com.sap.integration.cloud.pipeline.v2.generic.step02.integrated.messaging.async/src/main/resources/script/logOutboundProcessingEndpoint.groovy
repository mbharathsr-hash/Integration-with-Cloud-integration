import com.sap.gateway.ip.core.customdev.util.Message;
import src.main.resources.script.PipelineLogger;

def Message processData(Message message) {

	// adding information to audit log using helper PipelineLogger class
	PipelineLogger logger = PipelineLogger.newLogger(message, "auditLog")
	logger.addEntry("logOutboundProcessingEndpoint", "Bypass option: property bypassOption=" + (message.properties.bypassOption.toString() ?: "n/a") + ".")
	logger.addEntry("logOutboundProcessingEndpoint", "Header SAP_OutboundProcessingEndpoint=" + (message.headers.SAP_OutboundProcessingEndpoint.toString() ?: "n/a") + ".")
	if (logger.getLog()) { 
	    logger.saveToMessage(message)
	}
	
    return message;
}