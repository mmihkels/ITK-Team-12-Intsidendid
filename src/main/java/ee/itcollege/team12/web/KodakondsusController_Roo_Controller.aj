// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team12.web;

import ee.itcollege.i377.entities.Kodakondsus;
import ee.itcollege.i377.entities.Piiririkkuja;
import ee.itcollege.i377.entities.Riik;
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

privileged aspect KodakondsusController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String KodakondsusController.create(@Valid Kodakondsus kodakondsus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("kodakondsus", kodakondsus);
            addDateTimeFormatPatterns(uiModel);
            return "kodakondsuses/create";
        }
        uiModel.asMap().clear();
        kodakondsus.persist();
        return "redirect:/kodakondsuses/" + encodeUrlPathSegment(kodakondsus.getKodakondsusId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String KodakondsusController.createForm(Model uiModel) {
        uiModel.addAttribute("kodakondsus", new Kodakondsus());
        addDateTimeFormatPatterns(uiModel);
        return "kodakondsuses/create";
    }
    
    @RequestMapping(value = "/{kodakondsusId}", method = RequestMethod.GET)
    public String KodakondsusController.show(@PathVariable("kodakondsusId") Long kodakondsusId, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("kodakondsus", Kodakondsus.findKodakondsus(kodakondsusId));
        uiModel.addAttribute("itemId", kodakondsusId);
        return "kodakondsuses/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String KodakondsusController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("kodakondsuses", Kodakondsus.findKodakondsusEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Kodakondsus.countKodakondsuses() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("kodakondsuses", Kodakondsus.findAllKodakondsuses());
        }
        addDateTimeFormatPatterns(uiModel);
        return "kodakondsuses/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String KodakondsusController.update(@Valid Kodakondsus kodakondsus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("kodakondsus", kodakondsus);
            addDateTimeFormatPatterns(uiModel);
            return "kodakondsuses/update";
        }
        uiModel.asMap().clear();
        kodakondsus.merge();
        return "redirect:/kodakondsuses/" + encodeUrlPathSegment(kodakondsus.getKodakondsusId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{kodakondsusId}", params = "form", method = RequestMethod.GET)
    public String KodakondsusController.updateForm(@PathVariable("kodakondsusId") Long kodakondsusId, Model uiModel) {
        uiModel.addAttribute("kodakondsus", Kodakondsus.findKodakondsus(kodakondsusId));
        addDateTimeFormatPatterns(uiModel);
        return "kodakondsuses/update";
    }
    
    @RequestMapping(value = "/{kodakondsusId}", method = RequestMethod.DELETE)
    public String KodakondsusController.delete(@PathVariable("kodakondsusId") Long kodakondsusId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Kodakondsus.findKodakondsus(kodakondsusId).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/kodakondsuses";
    }
    
    @ModelAttribute("kodakondsuses")
    public Collection<Kodakondsus> KodakondsusController.populateKodakondsuses() {
        return Kodakondsus.findAllKodakondsuses();
    }
    
    @ModelAttribute("piiririkkujas")
    public Collection<Piiririkkuja> KodakondsusController.populatePiiririkkujas() {
        return Piiririkkuja.findAllPiiririkkujas();
    }
    
    @ModelAttribute("riiks")
    public Collection<Riik> KodakondsusController.populateRiiks() {
        return Riik.findAllRiiks();
    }
    
    void KodakondsusController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("kodakondsus_avatud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("kodakondsus_kuni_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("kodakondsus_muudetud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("kodakondsus_suletud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    String KodakondsusController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
