package com.dionysus.stydyinbook.eventbus.event;

/**
 * @className: StickyEvent
 * @author: Dionysus
 * @date: 2019/5/26 15:03
 * @Description: StickyEvent
 * 2-1.创建一个sticky消息事件
 */
public class StickyEvent {

    public String strMsg;

    public StickyEvent(String strMsg) {
        this.strMsg = strMsg;
    }
}
