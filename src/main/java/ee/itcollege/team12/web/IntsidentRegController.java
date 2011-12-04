package ee.itcollege.team12.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ee.itcollege.i377.entities.Intsident;
import ee.itcollege.i377.entities.IsikIntsidendi;
import ee.itcollege.i377.entities.ObjektIntsidendi;
import ee.itcollege.i377.entities.PiirivalvurIntsidendi;
import ee.itcollege.i377.entities.VahtkondIntsidendi;

@RooWebScaffold(path = "intsidentreg", formBackingObject = Intsident.class)
@RequestMapping("/intsidentreg/**")
@Controller
public class IntsidentRegController {

	@RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Intsident intsident, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("intsident", intsident);
            addDateTimeFormatPatterns(uiModel);
            return "intsidentreg/create";
        }
        uiModel.asMap().clear();
        intsident.persist();
        return "redirect:/intsidentreg/createdetails/" + encodeUrlPathSegment(intsident.getIntsidentId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/createdetails/{intsident_ID}", method = RequestMethod.GET)
    public String createDetails(@PathVariable("intsident_ID") Long intsident_ID, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("intsident", Intsident.findIntsident(intsident_ID));
        uiModel.addAttribute("itemId", intsident_ID);
        return "intsidentreg/createdetails";
    }
	
	@RequestMapping(value = "/createdetails/{intsident_ID}", method = RequestMethod.GET, params = "object")
    public String close(@PathVariable("intsident_ID") Long intsident_ID, @RequestParam(value = "object", required = false) String objectDescription, Model uiModel, HttpServletRequest httpServletRequest) {
		
        String[] objectParams = objectDescription.split(",");
        
        if (objectParams[0].equals("isik")) {
        	IsikIntsidendi isikIntsidendis = IsikIntsidendi.findIsikIntsidendi(Long.parseLong(objectParams[1]));
        	isikIntsidendis.close();
        	isikIntsidendis.persist();
        }
        else if (objectParams[0].equals("objekt")) {
        	ObjektIntsidendi objektIntsidendis = ObjektIntsidendi.findObjektIntsidendi(Long.parseLong(objectParams[1]));
        	objektIntsidendis.close();
        	objektIntsidendis.persist();
        }
        else if (objectParams[0].equals("vahtkond")) {
        	VahtkondIntsidendi vahtkondIntsidendis = VahtkondIntsidendi.findVahtkondIntsidendi(Long.parseLong(objectParams[1]));
        	vahtkondIntsidendis.close();
        	vahtkondIntsidendis.persist();
        }
        else if (objectParams[0].equals("valvur")) {
        	PiirivalvurIntsidendi piirivalvurIntsidendis = PiirivalvurIntsidendi.findPiirivalvurIntsidendi(Long.parseLong(objectParams[1]));
        	piirivalvurIntsidendis.close();
        	piirivalvurIntsidendis.persist();
        }
        
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("intsident", Intsident.findIntsident(intsident_ID));
        uiModel.addAttribute("itemId", intsident_ID);
        return "redirect:/intsidentreg/createdetails/" + encodeUrlPathSegment(intsident_ID.toString(), httpServletRequest);
    }
}
