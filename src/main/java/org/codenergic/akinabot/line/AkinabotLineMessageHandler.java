package org.codenergic.akinabot.line;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.codenergic.akinabot.line.model.akinator.NewSessionResponse;
import org.codenergic.akinabot.line.service.AkinatorApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by diasa on 2/19/17.
 */
@LineMessageHandler
public class AkinabotLineMessageHandler {

    public static final Logger LOG = LoggerFactory.getLogger(Akinabot.class);

    @Autowired
    private AkinatorApiService akinatorApiService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @EventMapping
    public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        LOG.info("handleTextMessageEvent: {}", event);
        if (Akinabot.BUTTON_START.equalsIgnoreCase(event.getMessage().getText())){
            try {
                NewSessionResponse newSessionResponse = akinatorApiService.sendOpenSession();
                if ("OK".equalsIgnoreCase(newSessionResponse.getCompletion())){
                    redisTemplate.boundValueOps(newSessionResponse.getParameters().getIdentification().getSession()).set(newSessionResponse);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new TextMessage(event.getMessage().getText());
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        LOG.info("handleDefaultMessageEvent: {}", event);
    }
}
