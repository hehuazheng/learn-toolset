package com.activemq;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicMessageProducerDemo1 {

	public static void main(String[] args) {
		new Thread(new TopicMessageProducer()).start();
	}

	static class TopicMessageProducer implements Runnable {
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
				MessageProducer producer = sess.createProducer(destination);
				producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
				for (int i = 0; i < 10; i++) {
					System.out.println("i is: " + i);
					producer.send(sess.createTextMessage("msg" + i));
				}
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
