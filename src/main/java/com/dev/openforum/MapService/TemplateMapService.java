package com.dev.openforum.MapService;

import com.dev.openforum.Model.Template;
import com.dev.openforum.Service.TemplateService;

import java.util.Set;

public class TemplateMapService extends AbstractMapService<Template, Long> implements TemplateService {
    @Override
    public Template save(Template template) {
        return super.save(template);
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
