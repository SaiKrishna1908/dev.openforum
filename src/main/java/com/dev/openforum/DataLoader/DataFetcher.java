package com.dev.openforum.DataLoader;

import com.dev.openforum.Model.Template;
import com.dev.openforum.Service.TemplateService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DataFetcher implements CommandLineRunner {

    private final TemplateService templateService;

    public DataFetcher(TemplateService templateService) {
        this.templateService = templateService;
    }


    @Override
    public void run(String... args) throws Exception {
//        loadTemplateData();

    }

    private void loadTemplateData() {
        Template template = new Template();
        template.setDescription("Cut all tree on earth");
        template.setPriority(2);

        Template savedTemplate = templateService.save(template);

        System.out.println("saved intital template data");

        Template template1 = new Template();

        template1.setDescription("Dry all lakes on earth");
        template1.setPriority(3);
        templateService.save(template1);

        Template template2 = new Template();
        template2.setDescription("Mine all coal in India");
        template2.setPriority(1);
        templateService.save(template2);
    }
}
