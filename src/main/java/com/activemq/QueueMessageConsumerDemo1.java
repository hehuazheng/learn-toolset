package com.activemq;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class QueueMessageConsumerDemo1 {

	public static void main(String[] args) throws JMSException {
		new Thread(new QueueMessageConsumer()).start();
	}

	static class QueueMessageConsumer implements Runnable {
		@Override
		public void run() {
			try {
				String brokerUrl = "tcp://activemq.com:61616";
				Connection connection = new ActiveMQConnectionFactory(
						ActiveMQConnection.DEFAULT_USER,
						ActiveMQConnection.DEFAULT_PASSWORD, brokerUrl)
						.createConnection();
				connection.start();
				Session sess = connection.createSession(true,
						Session.AUTO_ACKNOWLEDGE);
				String queueName = "testQueue2";
				Destination destination = sess.createQueue(queueName);
				MessageConsumer consumer = sess.createConsumer(destination);
				for (int i = 0; i < 10; i++) {
					TextMessage message = (TextMessage) consumer.receive();
					System.out
							.println("message received: " + message.getText());
				}
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
