package az.orient.webservices.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RespStatus {
    private Integer statusCode;
    private String statusMessage;
    
    private static final Integer SUCCESS_CODE=1;
    private static final String SUCCESS_MESSAGE="success";
    
    private static final Integer ERROR_CODE=0;
    private static final String ERROR_MESSAGE="error";

    public RespStatus() {
    }

    public RespStatus(Integer statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
    
    public static RespStatus getSuccessMessage(){
        return new RespStatus(SUCCESS_CODE, SUCCESS_MESSAGE);
    }
    
    public static RespStatus getErrorMessage(){
        return new RespStatus(ERROR_CODE, ERROR_MESSAGE);
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    @Override
    public String toString() {
        return "RespStatusu{" + "statusCode=" + statusCode + ", statusMessage=" + statusMessage + '}';
    }
    
    
}
