package TechChat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebMvcController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String hello(Model model) {
    	model.addAttribute("message", "Hello, World!");
        return "home";
    }

    @RequestMapping("/login")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "login";
    }
}