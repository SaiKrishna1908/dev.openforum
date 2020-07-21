package com.dev.openforum.Controller;

import com.dev.openforum.Model.Template;
import com.dev.openforum.Service.TemplateService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Route("/")
public class View extends VerticalLayout{

    @Autowired
    TemplateService templateService;

    //String label, String initialValue, String placeholder
    View(TemplateService templateService){

        VerticalLayout layout = new VerticalLayout();
        this.templateService = templateService;
        this.setWidth("100%");
        layout.setWidth("500px");
        layout.getStyle().set("border", "4px solid #9E9E9E");
        layout.getStyle().set("position", "absolute");
        layout.getStyle().set("left", "40em");

        layout.setAlignItems(Alignment.CENTER);
        layout.setJustifyContentMode(JustifyContentMode.BETWEEN);

        Grid<Template> grid = new Grid<>(Template.class);
        grid.setColumns("priority", "description");


        List<Template> templateData = new ArrayList<>(templateService.findAll());
        templateData.sort( (A,B) -> {
            return A.getPriority() - B.getPriority();
        });
        grid.setItems(templateData);

        TextField description = new TextField();
        description.setLabel("New Task");

        Notification notification = new Notification("Task Added.", 2000);
        notification.setPosition(Notification.Position.BOTTOM_CENTER);

        TextField priority = new TextField();
        priority.setLabel("Priority ");
        priority.setValue("5");
       // layout.setHorizontalComponentAlignment(Alignment.CENTER, grid);
        layout.add(grid);
        HorizontalLayout layout1 = new HorizontalLayout();

        Button add = new Button("Add", buttonClickEvent -> {
            try{
                Template template = new Template();
                template.setDescription(description.getValue());
                template.setPriority(Integer.parseInt(priority.getValue()));
                if(template.getDescription().length() > 0 && template  != null) {
                    templateService.save(template);
                    description.clear();
                    priority.clear();

                    grid.setItems(templateService.findAll());

                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        });

        add.addClickListener(event -> notification.open());
        add.getElement().setAttribute("aria-label", "Click me");

        layout1.add(description);
        layout1.add(priority);
        layout.add(layout1);
        layout.add(add);
        this.add(layout);
        //this.add()
    }


}
