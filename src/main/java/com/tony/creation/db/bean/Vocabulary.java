package com.tony.creation.db.bean;

public class Vocabulary {

	private String word;
	private String trans;
	private String phonetic;
	private String tags;
	private int progress;
	
	public Vocabulary() {

	}

	public Vocabulary(String word, String trans, String phonetic, String tags, int progress) {
		this.word = word;
		this.trans = trans;
		this.phonetic = phonetic;
		this.tags = tags;
		this.progress = progress;
	}
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getTrans() {
		return trans;
	}
	public void setTrans(String trans) {
		this.trans = trans;
	}
	public String getPhonetic() {
		return phonetic;
	}
	public void setPhonetic(String phonetic) {
		this.phonetic = phonetic;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
}
