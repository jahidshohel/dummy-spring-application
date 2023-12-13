package com.greenfrog.learning.endpoint;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@CrossOrigin
@RestController
public class DefaultEndpoint {

    @RequestMapping(method = RequestMethod.GET, path = "/api/health")
    public String getHealth() {
        return getMessage();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String root() {
        return getMessage();
    }

    //@PreAuthorize("hasAuthority(@AppRole.MAINTAINER)")
    @RequestMapping(value = "/api/ping", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> pingApi() {
        return ResponseEntity
                .ok("{\"result\":\"ping back\"}");
    }

    private String getMessage() {
        return "{\"time\":" + new Date().getTime() + "}";
    }
}
