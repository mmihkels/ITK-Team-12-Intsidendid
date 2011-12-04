package ee.itcollege.team12.web;

import ee.itcollege.i377.entities.Vahtkond;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "vahtkonds", formBackingObject = Vahtkond.class)
@RequestMapping("/vahtkonds")
@Controller
public class VahtkondController {
}
