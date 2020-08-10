package com.whalex.message.centre.service;




/**
 * Description: 创建订单消息队列
 *
 * @author: 🐋鲸鱼
 * date: 2020/8/10 20:22
 */
public interface ICreateOrderMessageService {
    Boolean createOrderSendMsg(String id);
}
