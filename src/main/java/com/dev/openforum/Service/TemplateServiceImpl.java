package com.dev.openforum.Service;

import com.dev.openforum.Model.Template;
import com.dev.openforum.repository.TemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TemplateServiceImpl implements  TemplateService{

    private final TemplateRepository templateRepository;


    @Override
    @Transactional
    public Template save(Template template) {
        return templateRepository.save(template);
    }

    @Override
    @Transactional
    public void delete(Template template) {
        templateRepository.delete(template);

    }

    @Override
    @Transactional
    public Set<Template> findAll() {
       return  new HashSet<>(templateRepository.findAll());
    }
}
