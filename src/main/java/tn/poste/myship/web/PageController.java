package tn.poste.myship.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/passenger")
    public String passenger() {
        return "passenger/index";
    }

    @GetMapping("/suivie")
    public String suivi() {
        return "suivie/index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin/index";
    }

    @GetMapping("/agent")
    public String agent() {
        return "agent/index";
    }

    @GetMapping("/client")
    public String client() {
        return "client/index";
    }
}

