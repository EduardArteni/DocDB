package com.docdb.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
public class PingController {


    /**
     * ping web service to check if the service is up and running
     * @return flag showing the status
     */
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public boolean ping()  {
        return true;
    }

}
