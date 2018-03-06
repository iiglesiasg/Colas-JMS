package com.Colas.Jms.Sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Colas.Jms.Model.MailModel;


@RestController
@RequestMapping("/colas")
public class SendController {

	@Autowired private JmsTemplate jmsTemplate;
	
	@PostMapping("/send")
	  public void send(@RequestBody MailModel transaction) {
	    System.out.println("Sending a transaction.");
	    jmsTemplate.convertAndSend(
	        "mailbox", transaction);
	    System.out.println("finalizado");
	  }
}
