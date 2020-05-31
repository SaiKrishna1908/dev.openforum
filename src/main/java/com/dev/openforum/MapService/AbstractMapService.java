package com.dev.openforum.MapService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T , ID extends Long > {

    Map<Long,T> db = new HashMap<>();

    T save(T object){
        return db.put(getId(), object);
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
