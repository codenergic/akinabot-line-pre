package org.codenergic.akinabot.line.service;

import com.linecorp.bot.model.event.message.TextMessageContent;
import org.codenergic.akinabot.line.model.akinator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Component
public class AkinatorApiService {

    @Autowired
    private RestTemplate restTemplate;

    @Async
    public Future<NewSessionResponse> sendOpenSession() throws InterruptedException {
        String requestUri = QuestionAnswerUtils.buildOpenSessionUrl(1, "Akinabot");
        NewSessionResponse newSessionResponse = restTemplate.getForObject(requestUri, NewSessionResponse.class);
        return new AsyncResult<>(newSessionResponse);
    }

    @Async
    public Future<AnswerResponse> sendAnswer(Identification identification, StepInformation stepInformation, TextMessageContent textMessageContent) throws InterruptedException {
        int answerOrdinal = QuestionAnswerUtils.answerOrdinal(textMessageContent.getText(), stepInformation);
        String requestUri = QuestionAnswerUtils.buildAnswerUrl(identification.getSession(),
                identification.getSignature(), stepInformation.getStep(), answerOrdinal);
        AnswerResponse answerResponse = restTemplate.getForObject(requestUri, AnswerResponse.class);
        return new AsyncResult<>(answerResponse);
    }

    @Async
    public Future<ListResponse> getResult(Identification identification, StepInformation stepInformation) throws InterruptedException {
        String requestUri = QuestionAnswerUtils.buildResultUrl(identification.getSession(),
                identification.getSignature(), stepInformation.getStep());
        ListResponse listResponse = restTemplate.getForObject(requestUri, ListResponse.class);
        return  new AsyncResult<>(listResponse);
    }
}
