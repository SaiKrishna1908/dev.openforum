package com.dev.openforum.MapService;

import com.dev.openforum.Model.Template;
import com.dev.openforum.Service.TemplateService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TemplateMapService extends AbstractMapService<Template, Long> implements TemplateService {




    @Override
    public Template save(Template template) {
        if(template != null) {
            if (template.getId() == null) {
                Template savedTemplate = super.save(template);
                template.setId(savedTemplate.getId());
            return savedTemplate;
            }
            return super.save(template);
        }
        else{
            return null;
        }
    }

    @Override
    public void delete(Template template) {
    super.delete(template);
    }

    @Override
    public Set<Template> findAll() {
        return super.findAll();
    }
}
