package ee.itcollege.team12.web;

import ee.itcollege.i377.entities.Intsident;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "intsidents", formBackingObject = Intsident.class)
@RequestMapping("/intsidents")
@Controller
public class IntsidentController {
}
