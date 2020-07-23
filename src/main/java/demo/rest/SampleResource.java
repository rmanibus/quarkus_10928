package demo.rest;

import demo.model.Comment;
import demo.model.Comment2;
import io.vertx.core.eventbus.EventBus;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.time.OffsetDateTime;

@RequestScoped
@Path("/")
public class SampleResource {

    @Inject
    EventBus bus;

    @GET
    @Transactional
    public String get() {
        Comment.listAll();
        Comment2.listAll();

        Comment comment = Comment.builder()
                .content("the content")
                .createdAt(OffsetDateTime.now())
                .build();

        comment.persistAndFlush();

        bus.publish("event", comment.getId());

        return "";
    }

    @POST
    public void post() {
        System.out.println("message");
    }
}
