package com.dev.openforum.Controller;

import com.dev.openforum.Model.Template;
import com.dev.openforum.Service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
class TemplateController{


    private final TemplateService templateService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getData(Model model){
        model.addAttribute("list", templateService.findAll());
        return "home";
    }
}