package pl.rudz.soalab1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class StudentConfig {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("pl.rudz.soalab1.wsdl");
        return marshaller;
    }

    @Bean
    public ApiPortClient apiPortClient(Jaxb2Marshaller marshaller){
        ApiPortClient client = new ApiPortClient();
        client.setDefaultUri("http://localhost:8088/soap");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }
}
