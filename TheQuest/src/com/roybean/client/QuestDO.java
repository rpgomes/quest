package com.roybean.client;

import com.google.gwt.safehtml.shared.SafeUri;

public class QuestDO {
	private SafeUri urlQuest;
	private SafeUri urlClue;
	private String answer;
	private boolean isAnswered = false;
	private String title;
	
	public QuestDO(String answer, String title) {
		setAnswer(answer);
		setTitle(title);
	}
	
	public SafeUri getUrlQuest() {
		return urlQuest;
	}
	public void setUrlQuest(SafeUri urlQuest) {
		this.urlQuest = urlQuest;
	}
	
	public SafeUri getUrlClue() {
		return urlClue;
	}	
	public void setUrlClue(SafeUri safeUri) {
		this.urlClue = safeUri;
	}
	
	public boolean isAnswered() {
		return isAnswered;
	}
	
	public void setAnswered(boolean isAnswered) {
		this.isAnswered = isAnswered;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
