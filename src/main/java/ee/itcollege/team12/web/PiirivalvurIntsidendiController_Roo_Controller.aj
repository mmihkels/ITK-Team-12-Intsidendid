// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team12.web;

import ee.itcollege.i377.entities.Intsident;
import ee.itcollege.i377.entities.Piirivalvur;
import ee.itcollege.i377.entities.PiirivalvurIntsidendi;
import ee.itcollege.i377.entities.VahtkondIntsidendi;
import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect PiirivalvurIntsidendiController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String PiirivalvurIntsidendiController.create(@Valid PiirivalvurIntsidendi piirivalvurIntsidendi, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("piirivalvurIntsidendi", piirivalvurIntsidendi);
            addDateTimeFormatPatterns(uiModel);
            return "piirivalvurintsidendis/create";
        }
        uiModel.asMap().clear();
        piirivalvurIntsidendi.persist();
        return "redirect:/piirivalvurintsidendis/" + encodeUrlPathSegment(piirivalvurIntsidendi.getPiirivalvurIntsidendisId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String PiirivalvurIntsidendiController.createForm(Model uiModel) {
        uiModel.addAttribute("piirivalvurIntsidendi", new PiirivalvurIntsidendi());
        addDateTimeFormatPatterns(uiModel);
        return "piirivalvurintsidendis/create";
    }
    
    @RequestMapping(value = "/{piirivalvurIntsidendisId}", method = RequestMethod.GET)
    public String PiirivalvurIntsidendiController.show(@PathVariable("piirivalvurIntsidendisId") Long piirivalvurIntsidendisId, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("piirivalvurintsidendi", PiirivalvurIntsidendi.findPiirivalvurIntsidendi(piirivalvurIntsidendisId));
        uiModel.addAttribute("itemId", piirivalvurIntsidendisId);
        return "piirivalvurintsidendis/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String PiirivalvurIntsidendiController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("piirivalvurintsidendis", PiirivalvurIntsidendi.findPiirivalvurIntsidendiEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) PiirivalvurIntsidendi.countPiirivalvurIntsidendis() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("piirivalvurintsidendis", PiirivalvurIntsidendi.findAllPiirivalvurIntsidendis());
        }
        addDateTimeFormatPatterns(uiModel);
        return "piirivalvurintsidendis/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String PiirivalvurIntsidendiController.update(@Valid PiirivalvurIntsidendi piirivalvurIntsidendi, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("piirivalvurIntsidendi", piirivalvurIntsidendi);
            addDateTimeFormatPatterns(uiModel);
            return "piirivalvurintsidendis/update";
        }
        uiModel.asMap().clear();
        piirivalvurIntsidendi.merge();
        return "redirect:/piirivalvurintsidendis/" + encodeUrlPathSegment(piirivalvurIntsidendi.getPiirivalvurIntsidendisId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{piirivalvurIntsidendisId}", params = "form", method = RequestMethod.GET)
    public String PiirivalvurIntsidendiController.updateForm(@PathVariable("piirivalvurIntsidendisId") Long piirivalvurIntsidendisId, Model uiModel) {
        uiModel.addAttribute("piirivalvurIntsidendi", PiirivalvurIntsidendi.findPiirivalvurIntsidendi(piirivalvurIntsidendisId));
        addDateTimeFormatPatterns(uiModel);
        return "piirivalvurintsidendis/update";
    }
    
    @RequestMapping(value = "/{piirivalvurIntsidendisId}", method = RequestMethod.DELETE)
    public String PiirivalvurIntsidendiController.delete(@PathVariable("piirivalvurIntsidendisId") Long piirivalvurIntsidendisId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        PiirivalvurIntsidendi.findPiirivalvurIntsidendi(piirivalvurIntsidendisId).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/piirivalvurintsidendis";
    }
    
    @ModelAttribute("intsidents")
    public Collection<Intsident> PiirivalvurIntsidendiController.populateIntsidents() {
        return Intsident.findAllIntsidents();
    }
    
    @ModelAttribute("piirivalvurs")
    public Collection<Piirivalvur> PiirivalvurIntsidendiController.populatePiirivalvurs() {
        return Piirivalvur.findAllPiirivalvurs();
    }
    
    @ModelAttribute("piirivalvurintsidendis")
    public Collection<PiirivalvurIntsidendi> PiirivalvurIntsidendiController.populatePiirivalvurIntsidendis() {
        return PiirivalvurIntsidendi.findAllPiirivalvurIntsidendis();
    }
    
    @ModelAttribute("vahtkondintsidendis")
    public Collection<VahtkondIntsidendi> PiirivalvurIntsidendiController.populateVahtkondIntsidendis() {
        return VahtkondIntsidendi.findAllVahtkondIntsidendis();
    }
    
    void PiirivalvurIntsidendiController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("piirivalvurIntsidendi_alates_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("piirivalvurIntsidendi_avatud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("piirivalvurIntsidendi_kuni_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("piirivalvurIntsidendi_muudetud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("piirivalvurIntsidendi_suletud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    String PiirivalvurIntsidendiController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        }
        catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
