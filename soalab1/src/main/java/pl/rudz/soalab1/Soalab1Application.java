package pl.rudz.soalab1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.rudz.soalab1.wsdl.RegisterCallResponse;

@SpringBootApplication
public class Soalab1Application {

    public static void main(String[] args) {
        SpringApplication.run(Soalab1Application.class, args);
    }

    @Bean
    CommandLineRunner lookup(ApiPortClient client){
        return args -> {
            String value = "Rudź";

            if(args.length > 0){
                value = args[0];
            }
            RegisterCallResponse response = client.getRegisterCall(value);
            System.err.println(response.getExercise().getName());
        };
    }

}
