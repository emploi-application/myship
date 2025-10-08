//package tn.poste.myship.config;
//
//import jakarta.servlet.http.HttpSessionEvent;
//import jakarta.servlet.http.HttpSessionListener;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebMvc
//public class WebConfig implements WebMvcConfigurer {
//
//    @Bean
//    public HttpSessionListener httpSessionListener() {
//        return new HttpSessionListener() {
//            @Override
//            public void sessionCreated(HttpSessionEvent se) {
//                se.getSession().setMaxInactiveInterval(30 * 60); // 30 minutes
//            }
//
//            @Override
//            public void sessionDestroyed(HttpSessionEvent se) {
//                // Session détruite automatiquement après timeout
//            }
//        };
//    }
//}