// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team12.web;

import ee.itcollege.i377.entities.IntsidendiLiik;
import ee.itcollege.i377.entities.Intsident;
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

privileged aspect IntsidendiLiikController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String IntsidendiLiikController.create(@Valid IntsidendiLiik intsidendiLiik, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("intsidendiLiik", intsidendiLiik);
            addDateTimeFormatPatterns(uiModel);
            return "intsidendiliiks/create";
        }
        uiModel.asMap().clear();
        intsidendiLiik.persist();
        return "redirect:/intsidendiliiks/" + encodeUrlPathSegment(intsidendiLiik.getIntsidendiLiikId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String IntsidendiLiikController.createForm(Model uiModel) {
        uiModel.addAttribute("intsidendiLiik", new IntsidendiLiik());
        addDateTimeFormatPatterns(uiModel);
        return "intsidendiliiks/create";
    }
    
    @RequestMapping(value = "/{intsidendiLiikId}", method = RequestMethod.GET)
    public String IntsidendiLiikController.show(@PathVariable("intsidendiLiikId") Long intsidendiLiikId, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("intsidendiliik", IntsidendiLiik.findIntsidendiLiik(intsidendiLiikId));
        uiModel.addAttribute("itemId", intsidendiLiikId);
        return "intsidendiliiks/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String IntsidendiLiikController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("intsidendiliiks", IntsidendiLiik.findIntsidendiLiikEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) IntsidendiLiik.countIntsidendiLiiks() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("intsidendiliiks", IntsidendiLiik.findAllIntsidendiLiiks());
        }
        addDateTimeFormatPatterns(uiModel);
        return "intsidendiliiks/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String IntsidendiLiikController.update(@Valid IntsidendiLiik intsidendiLiik, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("intsidendiLiik", intsidendiLiik);
            addDateTimeFormatPatterns(uiModel);
            return "intsidendiliiks/update";
        }
        uiModel.asMap().clear();
        intsidendiLiik.merge();
        return "redirect:/intsidendiliiks/" + encodeUrlPathSegment(intsidendiLiik.getIntsidendiLiikId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{intsidendiLiikId}", params = "form", method = RequestMethod.GET)
    public String IntsidendiLiikController.updateForm(@PathVariable("intsidendiLiikId") Long intsidendiLiikId, Model uiModel) {
        uiModel.addAttribute("intsidendiLiik", IntsidendiLiik.findIntsidendiLiik(intsidendiLiikId));
        addDateTimeFormatPatterns(uiModel);
        return "intsidendiliiks/update";
    }
    
    @RequestMapping(value = "/{intsidendiLiikId}", method = RequestMethod.DELETE)
    public String IntsidendiLiikController.delete(@PathVariable("intsidendiLiikId") Long intsidendiLiikId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        IntsidendiLiik.findIntsidendiLiik(intsidendiLiikId).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/intsidendiliiks";
    }
    
    @ModelAttribute("intsidendiliiks")
    public Collection<IntsidendiLiik> IntsidendiLiikController.populateIntsidendiLiiks() {
        return IntsidendiLiik.findAllIntsidendiLiiks();
    }
    
    @ModelAttribute("intsidents")
    public Collection<Intsident> IntsidendiLiikController.populateIntsidents() {
        return Intsident.findAllIntsidents();
    }
    
    void IntsidendiLiikController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("intsidendiLiik_avatud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("intsidendiLiik_muudetud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("intsidendiLiik_suletud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    String IntsidendiLiikController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
