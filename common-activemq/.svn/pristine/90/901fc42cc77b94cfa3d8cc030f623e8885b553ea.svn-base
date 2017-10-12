package com.mq.event;

import javax.jms.*;
import javax.servlet.*;
import org.apache.log4j.Logger;

import com.mq.constant.Constant;
import com.mq.service.impl.*;
import com.mq.util.ActiveMqConnectionUtil;

/**
 * 
 * @author niuzhiwei
 *         <p>
 *         实现了servlet上下文监听
 *         <p>
 *         在tomcat启动时运行类中
 *         <p>
 *         （contextInitialized(ServletContextEvent arg0) ）方法
 *         <p>
 *         完成active的topic订阅者和queue的消费者
 */
public class StartEvent implements ServletContextListener {

	private static Logger logger = Logger.getLogger(StartEvent.class);

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent arg0) {
		try {
			// 初始化topic发布/订阅监听
			Connection topicConnection = ActiveMqConnectionUtil.getConnection();
			topicConnection.start();
			Session topicSession = topicConnection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			Destination topicDestination = topicSession.createTopic(Constant.MQ_MESSAGE_TOPIC);
			MessageConsumer topicMessageConsumer = topicSession.createConsumer(topicDestination);
			topicMessageConsumer.setMessageListener(new MessageTopicReceiver());
			// 初始queue队列监听
			Connection queueConnection = ActiveMqConnectionUtil.getConnection();
			queueConnection.start();
			Session queueSession = queueConnection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			Destination queueDestination = queueSession.createQueue(Constant.MQ_MESSAGE_QUEUE);
			MessageConsumer queueMessageConsumer = queueSession.createConsumer(queueDestination);
			queueMessageConsumer.setMessageListener(new MessageQueueReceiver());
			logger.info("初始化监听成功");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
