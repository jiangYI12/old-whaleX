package com.whalex.message.centre.api.constant;

/**
 * Description: 消息队列常量
 *
 * @author: 🐋鲸鱼
 * date: 2020/8/10 19:59
 */
public interface MqConstant {
    String X_MESSAGE_TTL = "x-message-ttl";
    String X_DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";
    String X_DEAD_LETTER_EXCHANGE  = "x-dead-letter-exchange";
}
