package br.com.dea.management.exceptions;

import java.util.List;

public class NotFoundExceptions extends RuntimeException {

    public NotFoundExceptions(String message) {
        super(message);
    }

    public NotFoundExceptions(Class<?> clazz, long id) {
        super(String.format("Entity %s with id %d not found", clazz.getSimpleName(), id));
    }

    public NotFoundExceptions(Class<?> clazz, List<Long> ids) {
        super(String.format("Entity %s with id %s not found", clazz.getSimpleName(), ids));
    }

    public NotFoundExceptions(Class<?> clazz, String id) {
        super(String.format("Entity %s with id %s not found", clazz.getSimpleName(), id));
    }

}