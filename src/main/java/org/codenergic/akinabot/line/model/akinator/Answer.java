package org.codenergic.akinabot.line.model.akinator;

public class Answer {
	private int ordinal;
	private String answer;

	public int getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Answer{" +
				"ordinal=" + ordinal +
				", answer='" + answer + '\'' +
				'}';
	}
}