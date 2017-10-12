package com.mq.call;

import org.apache.log4j.Logger;
import com.mq.message.MsgCommand;

/**
 * 
 * @author niuzhiwei
 *         <p>
 *         消息处理类
 * 
 */
public class MessageReceiverCall {

	private static Logger logger = Logger.getLogger(MessageReceiverCall.class);

	// 订阅模式文本处理调用
	public void topicTextMessageReceiverCall(MsgCommand cmd) {
		logger.info("进入消息处理类(MessageReceiverCall),消息命令为:" + cmd.getCmd());
	}

	// 队列模式调用
	public void queueTextMessageReceiverCall(MsgCommand cmd) {
		logger.info("进入消息处理类(MessageReceiverCall),消息命令为:" + cmd.getCmd());
	}

	// 订阅模式对象处理调用
	public void topicObjectMessageReceiverCall(MsgCommand cmd) {
		logger.info("进入消息处理类(MessageReceiverCall),消息命令为:" + cmd.getCmd());
	}

	// 队列模式调用
	public void queueObjectMessageReceiverCall(MsgCommand cmd) {
		logger.info("进入消息处理类(MessageReceiverCall),消息命令为:" + cmd.getCmd());
	}

}
