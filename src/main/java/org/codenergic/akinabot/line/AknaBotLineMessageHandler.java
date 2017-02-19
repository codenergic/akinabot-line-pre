package org.codenergic.akinabot.line;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by diasa on 2/19/17.
 */
@LineMessageHandler
public class AknaBotLineMessageHandler {

    public static final Logger LOG = LoggerFactory.getLogger(Akinabot.class);

    @EventMapping
    public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        LOG.info("handleTextMessageEvent: {}", event);
        if (Akinabot.BUTTON_START.equalsIgnoreCase(event.getMessage().getText())){

        }
        return new TextMessage(event.getMessage().getText());
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        LOG.info("handleDefaultMessageEvent: {}", event);
    }
}
