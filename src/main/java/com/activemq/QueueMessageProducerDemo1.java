package com.activemq;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class QueueMessageProducerDemo1 {

	public static void main(String[] args) {
		new Thread(new QueueMessageProducer()).start();
	}

	static class QueueMessageProducer implements Runnable {
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
				MessageProducer producer = sess.createProducer(destination);
				producer.setDeliveryMode(DeliveryMode.PERSISTENT);
				for (int i = 0; i < 10; i++) {
					System.out.println("i is: " + i);
					producer.send(sess.createTextMessage("msg" + i));
				}
				sess.commit();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
