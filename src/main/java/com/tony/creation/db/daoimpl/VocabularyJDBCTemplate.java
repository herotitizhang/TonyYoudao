package com.tony.creation.db.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.tony.creation.db.bean.Vocabulary;
import com.tony.creation.db.dao.VocabularyDao;

public class VocabularyJDBCTemplate implements VocabularyDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource ds) {
		this.dataSource = dataSource;
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public List<Vocabulary> queryVocabulary() throws Exception {
		return null;
	}

}
