package ray.springframework.sfrpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.htm", "index.html"})
    public String index(){
        return "index";
    }

    @RequestMapping({"/oups"})
    public String oopsHandler(){
        return "notimplemented";
    }
}
