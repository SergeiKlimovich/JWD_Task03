package by.training.jwd.task3.view;

import java.util.List;

import by.training.jwd.task3.entity.Node;

public class PrintXmlFileInfo {
	public static void print(Node node) {

		String print = getStringToPrint(node).toString();

		System.out.println(print);

	}

	public static StringBuilder getStringToPrint(Node node) {

		StringBuilder print = new StringBuilder();

		print.append(printAttribute(node.getAttribute())).append(printContent(node.getContent()))
				.append(printList(node.getListNode()));

		return print;
	}

	public static String printAttribute(String attribute) {

		String line = attribute == null ? "" : attribute + ". " + "\n";

		return line;
	}

	public static String printContent(String content) {

		String line = content == null ? "" : "- " + content;

		return line;
	}

	public static String printList(List<Node> listNode) {

		String list = "";

		if (listNode == null) {

			list = " ";

		} else {

			for (Node node : listNode) {
				list += getStringToPrint(node);
			}

			list += "\n";

		}
		return list;
	}


}
