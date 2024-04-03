package com.junhyupa.springboot.myfirstwebapp.session;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Enumeration;

@RestController
public class SessionController {

//    @GetMapping("/session-attributes")
//    public String getSessionAttributes(NativeWebRequest request) {
//        // Get HttpSession object from NativeWebRequest
//        HttpSession session = request.getNativeRequest(javax.servlet.http.HttpServletRequest.class).getSession();
//
//        // Get all attribute names
//        Enumeration<String> attributeNames = session.getAttributeNames();
//
//        // Iterate through attribute names and print their values
//        StringBuilder result = new StringBuilder();
//        while (attributeNames.hasMoreElements()) {
//            String attributeName = attributeNames.nextElement();
//            Object attributeValue = session.getAttribute(attributeName);
//            result.append(attributeName).append(": ").append(attributeValue.toString()).append("\n");
//        }
//
//        return result.toString();
//    }

    @GetMapping("/session-attributes")
    public String getSessionAttributes() {
        // Get ServletRequestAttributes
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        // Null check for ServletRequestAttributes
        if (attributes != null) {
            // Get HttpServletRequest object
            HttpServletRequest request = attributes.getRequest();

            // Get HttpSession object
            HttpSession session = request.getSession();

            // Get all attribute names
            Enumeration<String> attributeNames = session.getAttributeNames();

            // Iterate through attribute names and print their values
            StringBuilder result = new StringBuilder();
            result.append(session);
            while (attributeNames.hasMoreElements()) {
                String attributeName = attributeNames.nextElement();
                Object attributeValue = session.getAttribute(attributeName);
                result.append(attributeName).append(": ").append(attributeValue.toString()).append("\n");
            }

            return result.toString();
        } else {
            // Handle the case where ServletRequestAttributes is null
            return "ServletRequestAttributes is null";
        }
    }
}