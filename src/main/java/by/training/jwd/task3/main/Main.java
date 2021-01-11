package by.training.jwd.task3.main;

import java.util.List;

import by.training.jwd.task3.entity.Node;
import by.training.jwd.task3.parser.XmlFileParser;
import by.training.jwd.task3.reader.XmlFileReader;

import by.training.jwd.task3.view.PrintXmlFileInfo;

public class Main {
	public static void main(String[] args) {

		XmlFileReader reader = new XmlFileReader();
		List<String> list = reader.readFileInList("resource\\MyXmlFile.xml");
		XmlFileParser parser = new XmlFileParser();
		Node node = parser.parserNode(list);

		PrintXmlFileInfo.print(node);

	}
}