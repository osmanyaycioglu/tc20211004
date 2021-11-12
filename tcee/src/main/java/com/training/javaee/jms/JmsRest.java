package com.training.javaee.jms;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/jms")
@RequestScoped
public class JmsRest {

    @Resource(lookup = "java:/jms/MyJMSQueue")
    private Queue      queue;

    @Resource(lookup = "java:/jms/MyJMSTopic")
    private Topic      topic;

    @Inject
    private JMSContext jmsContext;

    @Path("/send/to/queue")
    @GET
    public String sendToQueue(@QueryParam("message") final String message) {
        this.jmsContext.createProducer()
                       .send(this.queue,
                             message);
        return "OK";
    }

    @Path("/send/to/topic")
    @GET
    public String sendToTopic(@QueryParam("message") final String message) {
        this.jmsContext.createProducer()
                       .send(this.topic,
                             message);
        return "OK";
    }

}
