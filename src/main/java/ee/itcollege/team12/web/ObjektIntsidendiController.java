package ee.itcollege.team12.web;

import ee.itcollege.i377.entities.ObjektIntsidendi;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "objektintsidendis", formBackingObject = ObjektIntsidendi.class)
@RequestMapping("/objektintsidendis")
@Controller
public class ObjektIntsidendiController {
}
