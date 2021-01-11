package by.training.jwd.task3.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Node implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String attribute;
	private List<Node> listNode;
	private String content;

	public Node() {
	}

	public Node(String name, String attribute, List<Node> listNode, String content) {
		super();
		this.name = name;
		this.attribute = attribute;
		this.listNode = listNode;
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public List<Node> getListNode() {
		return listNode;
	}

	public void setListNode(List<Node> listNode) {
		this.listNode = listNode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void addChildNode(Node node) {
		if (listNode == null) {
			listNode = new ArrayList<Node>();
		}
		this.listNode.add(node);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attribute == null) ? 0 : attribute.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((listNode == null) ? 0 : listNode.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (attribute == null) {
			if (other.attribute != null)
				return false;
		} else if (!attribute.equals(other.attribute))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (listNode == null) {
			if (other.listNode != null)
				return false;
		} else if (!listNode.equals(other.listNode))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node [name=" + name + ", attribute=" + attribute + ", listNode=" + listNode + ", content=" + content
				+ "]";
	}
}
