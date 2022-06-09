package com.company.exp;

import org.springframework.data.repository.CrudRepository;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message){
        super(message);
    }
}
