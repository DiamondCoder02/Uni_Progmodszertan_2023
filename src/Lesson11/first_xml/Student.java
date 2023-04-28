package Lesson11.first_xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Student {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	private String major;
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

	private int year;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	public Student(String name, String major, int year) {
		this.name = name;
		this.major = major;
		this.year = year;
	}

	// methods
	public String toString() {
		return "Name: " + this.name + ", Major: " + this.major + ", Year: " + this.year + ". PTE University.";
	}

	// CRUD - Create Read Update Delete
	// xml
	public static List<Student> getStudentsFromXml(File f){
		List <Student> students = new ArrayList<>();
		try{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document dom = db.parse(f);
			dom.normalize();
			// nodelist
			NodeList studentNodes = dom.getElementsByTagName("student");

			for(int i = 0; i < studentNodes.getLength(); i++){
				Node n = studentNodes.item(i);
				if (n.getNodeType() == Node.ELEMENT_NODE){
					Element e = (Element)n;
					String name = e.getElementsByTagName("name").item(0).getTextContent().trim();
					String major = e.getElementsByTagName("major").item(0).getTextContent().trim();
					int year = Integer.parseInt(e.getElementsByTagName("year").item(0).getTextContent().trim());
				}
			}
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (SAXException e) {
			throw new RuntimeException(e);
		}
	}
}
