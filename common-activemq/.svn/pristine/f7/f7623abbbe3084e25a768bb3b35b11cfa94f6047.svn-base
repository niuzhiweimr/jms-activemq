package com.mq.call;

import org.springframework.context.ApplicationEvent;

/**
 * 
 * @author niuzhiwei
 *         <p>
 *         消息处理类(事件产生类)
 *         <p>
 *         解耦合(依赖系统监听其产生的事件)
 * 
 */
public class MessageReceiverEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2000713111508204690L;
	private Object cmd;
	private String msgType;// 消息类型
	private String listerType;// 监听类型 如队列，发布者

	public MessageReceiverEvent(Object source, Object cmd, String msgType, String listerType) {
		super(source);
		this.cmd = cmd;
		this.msgType = msgType;
		this.listerType = listerType;
	}

	public Object getCmd() {
		return cmd;
	}

	public void setCmd(Object cmd) {
		this.cmd = cmd;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getListerType() {
		return listerType;
	}

	public void setListerType(String listerType) {
		this.listerType = listerType;
	}

}
