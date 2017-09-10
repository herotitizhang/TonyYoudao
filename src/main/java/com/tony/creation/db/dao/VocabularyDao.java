package com.tony.creation.db.dao;

import java.util.List;

import javax.sql.DataSource;

import com.tony.creation.db.bean.Vocabulary;

public interface VocabularyDao {
	
	public void setDataSource(DataSource ds);
	
	public List<Vocabulary> queryVocabulary() throws Exception ;
	
	//TODO findOne, addVocab(insert splitter) 
}
