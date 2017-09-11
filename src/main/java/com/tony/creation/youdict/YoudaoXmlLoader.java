package com.tony.creation.youdict;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.tony.creation.db.bean.Vocabulary;
import com.tony.creation.db.daoimpl.VocabularyJDBCTemplate;

/**
 * YoudaoXmlLoader extracts information from youdao software's xml and performs
 * database operations with them.
 * 
 * I chose DOM for xml parsing. 
 * SAX is faster and simpler if I only plan to read some attributes/elements.
 * DOM creates an object tree which lets me access it randomly so it is better 
 * for complex XML manipulation and handling, which is what I need.
 * DOM4J allows both but it produces errors when reading the xml file. As my goal
 * is to get familiar with different aspects of full-stack programming, I decide to
 * move on and go with DOM at this point.
 */
public class YoudaoXmlLoader {
	
	public static final String YOUDAO_XML_PATH = "/Users/Hanxiao/Documents/STS_workspace/youdict/resources/vocabs.xml";
	public static final String TEST_XML_PATH = "/Users/Hanxiao/Documents/STS_workspace/youdict/resources/test.xml";
	
	public static final String ITEM_TAG = "item";
	public static final String WORD_TAG = "word";
	public static final String TRANS_TAG = "trans";
	public static final String PHONETIC_TAG = "phonetic";
	public static final String TAGS_TAG = "tags";
	public static final String PROGRESS_TAG = "progress";
	
	/**
	 * This method saves all vocabs in the xml file to the database.
	 * @return a boolean value that indicates if the save was successful
	 */
	public static boolean saveVocabsToDatabase() {
		System.out.println("Starting to save vocabs");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		VocabularyJDBCTemplate vjt = new VocabularyJDBCTemplate();
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document youdaoVocabDoc = documentBuilder.parse(TEST_XML_PATH);
			NodeList vocabs = youdaoVocabDoc.getElementsByTagName(ITEM_TAG);
			for (int i = 0; i < vocabs.getLength(); i++) {
				// for each vocab
				Vocabulary vocab = new Vocabulary();
				Node vocabNode = vocabs.item(i);
				NodeList vocabSubNodes = vocabNode.getChildNodes();
				for (int j = 0; j < vocabSubNodes.getLength(); j++) {
					Node vocabSubNode = vocabSubNodes.item(j);
					if (vocabSubNode.getNodeType() == Node.ELEMENT_NODE) {
						// for each non #text node
						String nodeName = vocabSubNode.getNodeName(); 
						String nodeValue = vocabSubNode.getTextContent();
						if (nodeName.equals(WORD_TAG)) {
							vocab.setWord(nodeValue);
						} else if (nodeName.equals(TRANS_TAG)) {
							vocab.setTrans(nodeValue);
						} else if (nodeName.equals(PHONETIC_TAG)) {
							vocab.setPhonetic(nodeValue);
						} else if (nodeName.equals(TAGS_TAG)) {
							vocab.setTags(nodeValue);
						} else if (nodeName.equals(PROGRESS_TAG)) {
							vocab.setProgress(Integer.parseInt(nodeValue));
						} 	
					}
				}
				vjt.insertVocabulary(vocab);
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return false;
		} catch (SAXException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		System.out.println("Done saving vocabs");
		return true;
	}
}
