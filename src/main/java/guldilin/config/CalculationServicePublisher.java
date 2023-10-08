//package guldilin.config;
//
//import guldilin.service.CalculationServiceImpl;
//import lombok.SneakyThrows;
//
//import javax.xml.ws.Endpoint;
//import java.net.URL;
//import java.util.Optional;
//
//public class CalculationServicePublisher {
//    @SneakyThrows
//    public static void main(String[] args) {
//        String hostUrl = Optional.ofNullable(System.getenv("ACTIONS_DEPLOY_BASE_URL"))
//                .orElse(Optional.ofNullable(System.getProperty("ACTIONS_DEPLOY_BASE_URL"))
//                        .orElse("http://localhost"));
//        String port = Optional.ofNullable(System.getenv("ACTIONS_DEPLOY_PORT"))
//                .orElse(Optional.ofNullable(System.getProperty("ACTIONS_DEPLOY_PORT"))
//                        .orElse("8080"));
//        String baseUrl = String.format("%s:%s/actions", hostUrl, port);
//        URL homeUrl = new URL(baseUrl);
//        Endpoint.publish(new URL(homeUrl, "calculation-service").toString(), new CalculationServiceImpl());
////        Endpoint.publish(new URL(homeUrl, "calculation-service").toString(), new CalculationServiceImpl());
//    }
//}
