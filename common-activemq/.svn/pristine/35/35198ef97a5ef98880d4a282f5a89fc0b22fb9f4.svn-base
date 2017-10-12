package com.mq.service;

import javax.jms.*;

public interface IMessageQueueSender {

	// 发送队列文本消息
	void sendQueueTextMessage(String message);

	// 发送队列键对值消息
	void sendQueueMapMessage(MapMessage mapMessage);

	// 发送队列流消息
	void sendQueueStreamMessage(StreamMessage streamMessage);

	// 发送队列字节消息
	void sendQueueBytesMessage(BytesMessage byteMessage);

	// 发送队列对象消息
	void sendQueueObjectMessage(ObjectMessage objectMessage);
}
