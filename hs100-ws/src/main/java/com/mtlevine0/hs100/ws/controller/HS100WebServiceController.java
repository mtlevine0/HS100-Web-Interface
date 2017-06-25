package com.mtlevine0.hs100.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class HS100WebServiceController {

    @Controller
    static class Route {

        @RequestMapping({
                "/",
                "temps",
                "devices",
                "about"
        })
        public String index() {
            return "index.html";
        }
    }
}
