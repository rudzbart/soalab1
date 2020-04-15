package pl.rudz.soalab1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import pl.rudz.soalab1.wsdl.RegisterCallRequest;
import pl.rudz.soalab1.wsdl.RegisterCallResponse;
import pl.rudz.soalab1.wsdl.ResultsRequest;
import pl.rudz.soalab1.wsdl.ResultsResponse;

public class ApiPortClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(ApiPortClient.class);

    public RegisterCallResponse getRegisterCall(String value){

        RegisterCallRequest request = new RegisterCallRequest();
        request.setStudent(value);

        log.info("Value: " + value);

        return (RegisterCallResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/soap",
                        request);
    }

    public ResultsResponse getResults(String value){

        ResultsRequest request = new ResultsRequest();
        request.setStudent(value);

        log.info("Value: " + value);

        return (ResultsResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/soap",
                        request);
    }
}
