package com.mq.handler;

import java.io.StringReader;

import javax.jms.*;
import javax.xml.bind.*;

import org.apache.log4j.Logger;

import com.mq.call.MessageReceiverCall;
import com.mq.message.MsgCommand;

/**
 * 
 * @author niuzhiwei
 *         <p>
 *         mq（Queue）消息处理类
 *         <p>
 *         各种消息的处理机制示例代码
 * 
 */
public class MessageQueueReceiverHandler {

	private static Logger logger = Logger.getLogger(MessageQueueReceiverHandler.class);

	private static MessageReceiverCall messageReceiverCall = new MessageReceiverCall();

	public void queueTextMessageHandler(final TextMessage textMessage) {

		JAXBContext context2;
		try {
			String cmdMessage = textMessage.getText();
			context2 = JAXBContext.newInstance(MsgCommand.class);
			Unmarshaller unmarshaller = context2.createUnmarshaller();
			MsgCommand cmd = (MsgCommand) unmarshaller.unmarshal(new StringReader(cmdMessage));
			logger.info("收到的cmd命令为" + cmd.getMsgBody());
			messageReceiverCall.queueTextMessageReceiverCall(cmd);
		} catch (JAXBException e) {
			logger.error(e.getMessage());
		} catch (JMSException e) {
			logger.error(e.getMessage());
		}
	}

	public void queueMapMessageHandler(final MapMessage mapMessage) {
		try {
			// 通过key查询
			mapMessage.getBoolean("");
			mapMessage.getByte("");
			mapMessage.getChar("");
			mapMessage.getDouble("");
			mapMessage.getFloat("");
			mapMessage.getInt("");
			mapMessage.getLong("");
			mapMessage.getObject("");
			mapMessage.getShort("");
			mapMessage.getString("");
		} catch (JMSException e) {
			logger.error(e.getMessage());
		}
	}

	public void queueStreamMessageHandler(final StreamMessage streamMessage) {

		try {
			streamMessage.readBoolean();
			streamMessage.readByte();
			streamMessage.readChar();
			streamMessage.readDouble();
			streamMessage.readFloat();
			streamMessage.readInt();
			streamMessage.readLong();
			streamMessage.readObject();
			streamMessage.readShort();
			streamMessage.readString();

		} catch (JMSException e) {
			logger.error(e.getMessage());
		}
	}

	public void queueBytesMessageHandler(final BytesMessage bytesMessage) {

		byte[] bytes = new byte[1024];
		int len = -1;
		String str = null;
		try {
			while ((len = bytesMessage.readBytes(bytes)) != -1) {
				str += new String(bytes, 0, len);
			}
			logger.info("字节消息为:" + str);
		} catch (JMSException e) {
			logger.error(e.getMessage());
		}
	}

	public void queueObjectMessageHandler(final ObjectMessage objectMessage) {

		try {
			MsgCommand cmd = (MsgCommand) objectMessage.getObject();
			messageReceiverCall.queueObjectMessageReceiverCall(cmd);
		} catch (JMSException e) {
			logger.error(e.getMessage());
		}
	}

}
