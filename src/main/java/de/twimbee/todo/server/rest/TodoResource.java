/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.twimbee.todo.server.rest;

import de.twimbee.todo.server.service.TodoService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author stefan
 */
@Path("todo")
@RequestScoped
public class TodoResource {

    @Inject
    private Logger logger;

    @Inject
    private TodoService todoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> getAll() {
        return todoService.getAll();
    }

    @POST
    public Response save(@BeanParam Todo todo) {
        todoService.merge(todo);
        logger.log(Level.INFO, "Post erfolgreich! " + todo.getText());

        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        todoService.remove(id);
        logger.log(Level.INFO, "Delete erfolgreich! " + id);

        return Response.ok().header("Access-Control-Allow-Origin", "http://localhost:8383").build();
    }

}
