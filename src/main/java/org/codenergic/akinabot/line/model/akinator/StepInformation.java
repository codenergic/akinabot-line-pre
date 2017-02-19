package org.codenergic.akinabot.line.model.akinator;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StepInformation implements Serializable {
	private String question;
	private List<Answer> answers = new ArrayList<>();
	private String step;
	private String progression;
	private String questionid;
	private String infogain;
	private String statusMinibase;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getProgression() {
		return progression;
	}

	public void setProgression(String progression) {
		this.progression = progression;
	}

	public String getQuestionid() {
		return questionid;
	}

	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}

	public String getInfogain() {
		return infogain;
	}

	public void setInfogain(String infogain) {
		this.infogain = infogain;
	}

	@JsonProperty("status_minibase")
	public String getStatusMinibase() {
		return statusMinibase;
	}

	public void setStatusMinibase(String statusMinibase) {
		this.statusMinibase = statusMinibase;
	}

    @Override
    public String toString() {
        return "StepInformation{" +
                "question='" + question + '\'' +
                ", answers=" + answers +
                ", step='" + step + '\'' +
                ", progression='" + progression + '\'' +
                ", questionid='" + questionid + '\'' +
                ", infogain='" + infogain + '\'' +
                ", statusMinibase='" + statusMinibase + '\'' +
                '}';
    }
}
