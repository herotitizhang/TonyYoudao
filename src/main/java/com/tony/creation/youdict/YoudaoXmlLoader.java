package com.tony.creation.youdict;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class YoudaoXmlLoader {
	
	public static final String YOUDAO_XML_PATH = "/Users/Hanxiao/Documents/STS_workspace/youdict/resources/vocabs.xml";
	public static final String TEST_XML_PATH = "/Users/Hanxiao/Documents/STS_workspace/youdict/resources/test.xml";
	public static final String ITEM_TAG = "item";
	
	/*
	 * I chose DOM for xml parsing. 
	 * SAX is faster and simpler if I only plan to read some attributes/elements.
	 * DOM creates an object tree which lets me access it randomly so it is better 
	 * for complex XML manipulation and handling, which is what I need.
	 * DOM4J allows both but it produces errors when reading the xml file. As my goal
	 * is to get familiar with different aspects of full-stack programming, I decide to
	 * move on and go with DOM at this point.
	 */
	public static boolean fileExists() {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document youdaoVocabDoc = documentBuilder.parse(YOUDAO_XML_PATH);
			NodeList vocabs = youdaoVocabDoc.getElementsByTagName(ITEM_TAG);
			for (int i = 0; i < vocabs.getLength(); i++) {
				// for each vocab
				Node vocab = vocabs.item(i);
				NodeList vocabSubNodes = vocab.getChildNodes();
				for (int j = 0; j < vocabSubNodes.getLength(); j++) {
					Node vocabSubNode = vocabSubNodes.item(j);
					if (vocabSubNode.getNodeType() == Node.ELEMENT_NODE) {
						vocabSubNode.getNodeName(); // get name
						System.out.println(vocabSubNode.getTextContent()); // get value
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
}
