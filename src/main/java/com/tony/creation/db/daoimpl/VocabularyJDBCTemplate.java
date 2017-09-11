package com.tony.creation.db.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.sqlite.SQLiteDataSource;

import com.tony.creation.db.bean.Vocabulary;
import com.tony.creation.db.dao.VocabularyDao;

public class VocabularyJDBCTemplate implements VocabularyDao {

	// data source
	private SQLiteDataSource dataSource;
	private static final String DATABASE_URL = "jdbc:sqlite:/Users/Hanxiao/Documents/STS_workspace/youdict/resources/vocab_info.db";
	
	private JdbcTemplate springJdbcTemplate;
	
	public VocabularyJDBCTemplate() {
		this.dataSource = new SQLiteDataSource();
		this.dataSource.setUrl(DATABASE_URL);
	    this.springJdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insertVocabulary(Vocabulary vocab) {
		String sql = "insert into vocabs (word, trans, phonetic, tags, progress) values (?, ?, ?, ?, ?)";
		try {
			springJdbcTemplate.update(sql, 
					vocab.getWord(), vocab.getTrans(), vocab.getPhonetic(), vocab.getTags(), vocab.getProgress());
		} catch (DataAccessException dae) {
			System.out.println("Error sql: " + sql + ". Cannot access database!");
		}
		return;
	}
	
}
