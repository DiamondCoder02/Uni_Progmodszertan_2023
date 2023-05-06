package lesson12.first_xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

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
	public static List<Student> getStudentsFromXml(File f) {
		List<Student> students = new ArrayList<>();
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document dom = db.parse(f);
			dom.normalize();
			// nodelist
			NodeList studentNodes = dom.getElementsByTagName("student");

			for (int i = 0; i < studentNodes.getLength(); i++) {
				Node n = studentNodes.item(i);
				if (n.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) n;
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

		return students;
	}

	// write xml

	public static void writeStudentsFromXml(List<Student> stlist){
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document dom = db.newDocument();

            //root element
            Element rootElement = dom.createElement("students");
            dom.appendChild(rootElement);

			for(Student st: stlist){
				Element eStudent = dom.createElement("student");
				Element eName = dom.createElement("name");
				Element eMajor = dom.createElement("major");
				Element eYear = dom.createElement("year");

				eStudent.appendChild(eName);
				eStudent.appendChild(eMajor);
				eStudent.appendChild(eYear);

				eName.appendChild(dom.createTextNode(st.getName()));
				eMajor.appendChild(dom.createTextNode(st.getMajor()));
				eYear.appendChild(dom.createTextNode(Integer.toString(st.getYear())));

				rootElement.appendChild(eStudent);
			}

			DOMSource source = new DOMSource(dom);
			StreamResult result = new StreamResult("students_out.xml");
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.transform(source, result);

        } catch (ParserConfigurationException e){
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
			throw new RuntimeException(e);
		} catch (TransformerException e) {
			throw new RuntimeException(e);
		}
    }

	public static void getStudents(File f){

	}
	public static void getStudents(int id, String name, String mayou, int year){
		
	}

	public static void deleteStudent(int id){

	}

	public static void updateStudent(int id){
		
	}
}