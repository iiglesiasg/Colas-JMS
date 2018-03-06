package com.Colas.Jms.Sender;



import javax.jms.Queue;

import org.springframework.jms.core.JmsTemplate;

import com.Colas.Jms.Model.MailModel;

public class Sender {

	private JmsTemplate jmsTemplate;
    private Queue queue;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public void simpleSend() {
        jmsTemplate.send(queue, s -> s.createTextMessage("hello queue world"));
    }

    public void sendMessage(final MailModel employee) {
        this.jmsTemplate.convertAndSend(employee);
    }
}
