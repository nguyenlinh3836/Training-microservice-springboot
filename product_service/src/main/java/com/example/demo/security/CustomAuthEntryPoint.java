//package com.example.demo.security;
//
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//@Component
//public class CustomAuthEntryPoint implements AuthenticationEntryPoint {
//    private static final Logger logger = LoggerFactory.getLogger(CustomAuthEntryPoint.class);
//
//    @Override
//    public void commence(HttpServletRequest request,
//                         HttpServletResponse response,
//                         AuthenticationException e)
//            throws IOException {
//
//        logger.error("Unauthorized error. Message - {}", e.getMessage());
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error -> Unauthorized");
//    }
//}
