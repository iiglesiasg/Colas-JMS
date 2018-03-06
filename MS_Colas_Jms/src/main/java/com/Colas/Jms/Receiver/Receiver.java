package com.Colas.Jms.Receiver;

import java.util.concurrent.TimeUnit;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.Colas.Jms.Model.MailModel;

@Component
public class Receiver {

	@JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(MailModel email) {
        System.out.println("Received <" + email + ">");
        try {
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Procesado "+email.getTo());
    }
}
