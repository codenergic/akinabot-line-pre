package org.codenergic.akinabot.line;

import com.linecorp.bot.model.ReplyMessage;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by diasa on 2/18/17.
 */
@SpringBootApplication
@LineMessageHandler
public class AkinaApplication {
    public static final Logger LOG = LoggerFactory.getLogger(AkinaApplication.class);
    public static void main(String [] args) {
        SpringApplication.run(AkinaApplication.class, args);
    }
    @EventMapping
    public ReplyMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        LOG.info("event: {}", event);
        TextMessage textMessage = new TextMessage("hello");
        ReplyMessage replyMessage = new ReplyMessage(
                event.getReplyToken(),
                textMessage
        );

        return replyMessage;
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        LOG.info("event: {}", event);
    }
}
