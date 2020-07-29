package com.dev.openforum.MapService;

import com.dev.openforum.Model.Template;
import com.dev.openforum.Service.TemplateService;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Service
public abstract class AbstractMapService<T extends Template , ID extends Long > {

    Map<Long,T> db = new HashMap<>();


    T save(T object){
        if(object.getId() == null)
            object.setId(getId());
         db.put(getId(), object);
         return object;
    }

    void delete(T object){
        db.remove(object);
    }

    Set<T> findAll(){
        return new HashSet<>(db.values());
    }
    Long getId(){
        return (long) (db.size() + 1);
    }
}
