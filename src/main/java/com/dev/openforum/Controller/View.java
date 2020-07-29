package com.dev.openforum.Controller;

import com.dev.openforum.MapService.TemplateMapService;
import com.dev.openforum.Model.Template;
import com.dev.openforum.Service.TemplateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

class TemplateController{


    private final TemplateService templateService;

    TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @RequestMapping(value = {"/todo", "/"}, method = RequestMethod.GET)
    public String getData(Model model){
        model.addAttribute("list", templateService.findAll());
        model.addAttribute("task", new Template());
        return "home";
    }

    @RequestMapping(value = "/" , method = RequestMethod.POST)
    public String postData(@ModelAttribute Template template, Model model){

        //todo check if template is null


        if(template != null && template.getDescription()!=null && template.getDescription().length()>1)
        templateService.save(template);

        model.addAttribute("list", templateService.findAll());
        return "redirect:/todo";
    }

    @RequestMapping(value = "/done/{id}",method = RequestMethod.GET)
    public String doneTemplate(@PathVariable Long id, Model model){
        templateService.setStatusDone(id);
        return "redirect:/todo";
    }
}