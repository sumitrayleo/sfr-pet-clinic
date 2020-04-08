package ray.springframework.sfrpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    @RequestMapping({"", "/", "/index", "/index.html", "/index.htm"})
    public String listOwners(){
        return "owners/index";
    }
}
