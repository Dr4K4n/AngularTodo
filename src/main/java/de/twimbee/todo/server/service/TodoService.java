/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.twimbee.todo.server.service;

import de.twimbee.todo.server.rest.Todo;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author stefan
 */
@Stateless
public class TodoService {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager em;

    public List<Todo> getAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Todo> criteria = cb.createQuery(Todo.class);
        Root<Todo> todo = criteria.from(Todo.class);
        criteria.select(todo);
        return em.createQuery(criteria).getResultList();
    }

    public void merge(Todo todo) {
        em.merge(todo);
    }

    public void remove(Long id) {
        Todo todo = em.find(Todo.class, id);
        if (todo != null) {
            em.remove(todo);
        }
    }

    public Todo findById(Long id) {
        return em.find(Todo.class, id);
    }
}
