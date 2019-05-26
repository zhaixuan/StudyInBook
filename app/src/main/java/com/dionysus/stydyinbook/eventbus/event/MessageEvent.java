package com.dionysus.stydyinbook.eventbus.event;

/**
 * @className: MessageEvent
 * @author: Dionysus
 * @date: 2019/5/26 14:49
 * @Description: 消息事件
 * 3.创建event事件消息类
 */
public class MessageEvent {
    public String strContent;

    public MessageEvent(String strConent) {
        this.strContent = strConent;
    }
}
