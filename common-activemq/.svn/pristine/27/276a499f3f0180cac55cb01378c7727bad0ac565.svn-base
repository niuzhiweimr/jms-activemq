package com.mq.call;

import java.io.ByteArrayOutputStream;

import javax.jms.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import org.apache.log4j.Logger;
import com.mq.message.MsgCommand;
import com.mq.exception.MsgException;
import com.mq.handler.*;
import com.mq.service.*;
import com.mq.service.impl.*;
import com.mq.util.ActiveMqConnectionUtil;

/**
 * 
 * @author niuzhiwei
 *         <p>
 *         消息处理类
 * 
 */
public class MessageSendCall {

	private static Logger logger = Logger.getLogger(MessageSendCall.class);

	// topic 发送Textmessage消息 系统之间进行xml互转
	public synchronized static void topicProxyTextMessageSend(MsgCommand cmd) throws MsgException {
		// 实例化代理对象
		MessageInvocationHandler messageInvocationHandler = new MessageInvocationHandler(new MessageTopicSender());
		// 进行对象绑定
		IMessageTopicSender messageTopicSend = (IMessageTopicSender) messageInvocationHandler
				.bind(new MessageTopicSender());
		try {
			// 命令对象不能空 ，发送消息对象不能空
			boolean isNull = cmd == null ? true : false;
			if (isNull)
				return;
			// 实现xml与对象的互转
			JAXBContext context = JAXBContext.newInstance(MsgCommand.class);
			// 根据上下文获取marshaller对象
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			// 设置编码字符集
			// 格式化XML输出，有分行和缩进
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			marshaller.marshal(cmd, baos);
			String xmlObj = new String(baos.toByteArray());
			messageTopicSend.sendTopicTextMessage(xmlObj);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	// topic 发送Objectmessage消息 直接进行对象转换即可取出参数
	public synchronized static void topicProxyOjbectMessageSend(MsgCommand cmd) throws MsgException {
		// 实例化代理对象
		MessageInvocationHandler messageInvocationHandler = new MessageInvocationHandler(new MessageTopicSender());
		// 进行对象绑定
		IMessageTopicSender messageTopicSend = (IMessageTopicSender) messageInvocationHandler
				.bind(new MessageTopicSender());
		Connection connection = null;
		Session session = null;
		try {
			// 命令对象不能空 ，发送消息对象不能空
			boolean isNull = cmd == null ? true : false;
			if (isNull)
				return;
			connection = ActiveMqConnectionUtil.getConnection();
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			ObjectMessage objectMessage = session.createObjectMessage();
			objectMessage.setObject(cmd);
			// 发送对象
			messageTopicSend.sendTopicObjectMessage(objectMessage);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (session != null)
					session.close();
			} catch (JMSException e) {
				logger.error(e.getMessage());
			}
		}
	}

	// queue 发送Textmessage消息 系统之间进行xml互转
	public synchronized static void queueProxyTextMessageSend(MsgCommand cmd) throws MsgException {
		// 实例化代理对象
		MessageInvocationHandler messageInvocationHandler = new MessageInvocationHandler(new MessageQueueSender());
		// 进行对象绑定
		IMessageQueueSender messageQueueSend = (IMessageQueueSender) messageInvocationHandler
				.bind(new MessageQueueSender());

		try {
			// 命令对象不能空 ，发送消息对象不能空
			boolean isNull = cmd == null ? true : false;
			if (isNull)
				return;
			// 实现xml与对象的互转
			JAXBContext context = JAXBContext.newInstance(MsgCommand.class);
			// 根据上下文获取marshaller对象
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			// 设置编码字符集
			// 格式化XML输出，有分行和缩进
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			marshaller.marshal(cmd, baos);
			String xmlObj = new String(baos.toByteArray());
			messageQueueSend.sendQueueTextMessage(xmlObj);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	// queue 发送Objectmessage消息 直接进行对象转换即可取出参数
	public synchronized static void queueProxyOjbectMessageSend(MsgCommand cmd) throws MsgException {
		// 实例化代理对象
		MessageInvocationHandler messageInvocationHandler = new MessageInvocationHandler(new MessageQueueSender());
		// 进行对象绑定
		IMessageQueueSender messageQueueSend = (IMessageQueueSender) messageInvocationHandler
				.bind(new MessageQueueSender());

		Connection connection = null;
		Session session = null;
		try {
			// 命令对象不能空 ，发送消息对象不能空
			boolean isNull = cmd == null ? true : false;
			if (isNull)
				return;
			connection = ActiveMqConnectionUtil.getConnection();
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			ObjectMessage objectMessage = session.createObjectMessage();
			objectMessage.setObject(cmd);
			// 发送对象
			messageQueueSend.sendQueueObjectMessage(objectMessage);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (session != null)
					session.close();
			} catch (JMSException e) {
				logger.error(e.getMessage());
			}
		}
	}
}
