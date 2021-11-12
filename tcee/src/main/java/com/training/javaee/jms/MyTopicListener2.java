package com.training.javaee.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


@MessageDriven(activationConfig = {
                                    @ActivationConfigProperty(propertyName = "destinationType",
                                                              propertyValue = "javax.jms.Topic"),
                                    @ActivationConfigProperty(propertyName = "destination",
                                                              propertyValue = "MyJMSTopic")

})
public class MyTopicListener2 implements MessageListener {

    public MyTopicListener2() {
    }

    @Override
    public void onMessage(final Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage messageLoc = (TextMessage) message;
                System.out.println("Topic Listener 2 : " + messageLoc.getText());
            }
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
        }
    }

}
