package by.training.jwd.task3.parser;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.training.jwd.task3.entity.Node;

public class XmlFileParser {
	public static final String HEADTAG = "<(\\?xml).+?(\\?)>";
	public static final String OPENTAG = "<[^/].+?>";
	public static final String CLOSETAG = "</.+>$";
	public static final String ATTRIBUTE = "[\"\'].+[\"\']";
	public static final String COMMENTTAG = "<!--(.+)?-->";
	public static final String CONTENT = ">.+<";

	public Node parserNode(List<String> list) {

		Node node = new Node();

		LinkedList<Node> listOfNode = new LinkedList<Node>();

		Iterator<String> iterator = list.iterator();
		ListIterator<Node> listIter = listOfNode.listIterator();

		while (iterator.hasNext()) {

			String line = iterator.next();

			if (Pattern.compile(OPENTAG).matcher(line).find() && !Pattern.compile(COMMENTTAG).matcher(line).find()
					&& !Pattern.compile(HEADTAG).matcher(line).find()) {

				Node newNode = new Node();
				newNode.setName(getNameOfOpeningTagOfNode(line));

				if (isHasContent(line)) {
					newNode.setContent(getContent(line));
				}

				if (Pattern.compile(ATTRIBUTE).matcher(line).find()) {
					newNode.setAttribute(getAttributeFromList(line));
				}

				listOfNode.add(newNode);
			}

			if (Pattern.compile(CLOSETAG).matcher(line).find()) {

				if (listOfNode.size() > 2) {
					listIter = listOfNode.listIterator(listOfNode.size() - 1);
					listIter.previous().addChildNode(listOfNode.pollLast());

				} else if (listOfNode.size() == 2) {
					listOfNode.peekFirst().addChildNode(listOfNode.pollLast());
				}
			}
		}
		node = listOfNode.getFirst();

		return node;
	}

	public static String getNameOfOpeningTagOfNode(String line) {

		String name = null;

		Pattern pattern = Pattern.compile(OPENTAG);
		Matcher matcher = pattern.matcher(line);
		if (matcher.find()) {
			name = matcher.group();
		}

		name = name.replaceAll("[<>]", "");

		return name;
	}

	public static String getAttributeFromList(String line) {

		String name = null;

		Pattern pattern = Pattern.compile(ATTRIBUTE);
		Matcher matcher = pattern.matcher(line);
		if (matcher.find()) {
			name = matcher.group();
		}

		name = name.replaceAll("[\"\']", "");

		return name;

	}

	public static boolean isHasContent(String line) {

		Pattern pattern = Pattern.compile(CONTENT);
		Matcher matcher = pattern.matcher(line);

		if (matcher.find()) {
			return true;
		}

		return false;
	}

	public static String getContent(String line) {

		String name = null;

		Pattern pattern = Pattern.compile(CONTENT);
		Matcher matcher = pattern.matcher(line);

		if (matcher.find()) {
			name = matcher.group();
		}

		name = name.replaceAll("[<>]", "");

		return name;
	}
}