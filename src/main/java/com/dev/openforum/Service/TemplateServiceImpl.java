package com.dev.openforum.Service;

import com.dev.openforum.Model.Template;
import com.dev.openforum.repository.TemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Profile("default")
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

    @Override
    public Template setStatusDone(Long id) {
        Optional<Template> templateOptional = templateRepository.findById(id);


        if(!templateOptional.isPresent()){
         Template  template = templateOptional.get();
            template.setStatus("Done");
            templateRepository.save(template);
            return template;
        }

        return templateRepository.findById(id).get();
    }
}
