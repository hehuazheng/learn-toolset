package com.activemq;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicMessageConsumerDemo1 {

	public static void main(String[] args) throws JMSException {
		new Thread(new TopicMessageConsumer()).start();
	}

	static class TopicMessageConsumer implements Runnable {
		@Override
		public void run() {
			try {
				String brokerUrl = "tcp://activemq.com:61616";
				Connection connection = new ActiveMQConnectionFactory(
						ActiveMQConnection.DEFAULT_USER,
						ActiveMQConnection.DEFAULT_PASSWORD, brokerUrl)
						.createConnection();
				connection.start();
				Session sess = connection.createSession(false,
						Session.AUTO_ACKNOWLEDGE);
				String topicName = "testTopic";
				Destination destination = sess.createTopic(topicName);
				MessageConsumer consumer = sess.createConsumer(destination);
				System.out.println("c1");
				consumer.setMessageListener(new MessageListener() {
					@Override
					public void onMessage(Message message) {
						try {
							System.out
									.println("message received: " + ((TextMessage)message).getText());
						} catch (JMSException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
