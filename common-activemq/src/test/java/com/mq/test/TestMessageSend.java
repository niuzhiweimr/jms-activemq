package com.mq.test;

import com.mq.call.*;
import com.mq.exception.MsgException;
import com.mq.message.MsgCommand;

public class TestMessageSend extends MessageReceiverCall {
	// 消息测试
	public static void main(String[] args) {
		MsgCommand cmd = CommandFactory.getMsgCommand();
		cmd.setCmd("123");
		try {
			MessageSendCall.topicProxyOjbectMessageSend(cmd);
		} catch (MsgException e) {
			e.printStackTrace();
		}
	}

	// 消息处理示例代码
	@Override
	public void topicObjectMessageReceiverCall(MsgCommand cmd) {
		System.out.println(cmd.getCmd());
	}

}
