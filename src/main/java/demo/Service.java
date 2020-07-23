package demo;

import demo.model.Comment;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.UUID;

@ApplicationScoped
public class Service {


    @ConsumeEvent(value = "event", blocking = true)
    @Transactional
    public void doSomething(UUID commentId) throws InterruptedException {

        Comment.findById(commentId);


    }
}
