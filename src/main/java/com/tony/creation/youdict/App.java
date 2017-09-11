package com.tony.creation.youdict;

import com.tony.creation.db.daoimpl.VocabularyJDBCTemplate;
import com.tony.creation.db.bean.Vocabulary;;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(YoudaoXmlLoader.saveVocabsToDatabase());
    }
}
