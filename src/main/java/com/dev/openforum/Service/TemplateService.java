package com.dev.openforum.Service;

import com.dev.openforum.Model.Template;

import java.util.Set;

public interface TemplateService {

    Template save(Template template);

    void delete(Template template);

    Set<Template> findAll();

    Template setStatusDone(Long id);

    void deleteById(Long id);
}
