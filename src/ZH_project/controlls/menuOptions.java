package controlls;

import java.time.LocalDate;
import java.util.Scanner;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class menuOptions {
	public static void topThings(){
		/* Print to console that looks like this:
		----------------------------------------------------------------- // 65 characters
		|id    | developer                      | played_version        | // 6|32|23 6+32+23=61+4=65
		| LastUpdate | name                                             | // 12|50 12+50=62+3=65
		-----------------------------------------------------------------
		|999999| asd     				  		| v0.1.1something		|
		| 6969-69-69  | asdasdasdasdasdasda								|
		-----------------------------------------------------------------
		*/
		System.out.print("\033[H\033[2J");
		System.out.flush();
		System.out.println("---------------------------------------------------------------------");
		System.out.println("|id    | developer                          | played_version        |");
		System.out.println("| LastUpdate | name                                                 |");
		System.out.println("---------------------------------------------------------------------");
	}

	public static void textEasy(Boolean flush, Boolean top, Boolean bottom, String text){
		if (flush) {System.out.print("\033[H\033[2J");System.out.flush();}
		if (top) {System.out.println("---------------");}
		System.out.println(text);
		if (bottom) {System.out.println("---------------");}
	}
	// Thanks to above code from ~140 print lines to ~20 print lines

	public static void uploadNewVersion(Document dom){
		try {
			DOMSource domsource = new DOMSource(dom);
			StreamResult result = new StreamResult("test_out.xml");
			// StreamResult result = new StreamResult(file);
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.transform(domsource, result);
		} catch (TransformerConfigurationException e) {
			System.out.println(e);
		} catch (TransformerException e) {
			System.out.println(e);
		}
	}

	public static void listAllGamesControl(Document dom) {
		try {
			NodeList source = dom.getElementsByTagName("source");
			topThings();
			for (int i = 0; i < source.getLength(); i++) {
				Node sourceNode = source.item(i);
				if (sourceNode.getNodeType() == Node.ELEMENT_NODE) {
					NodeList game = sourceNode.getChildNodes();
					for (int j = 0; j < game.getLength(); j++) {
						Node gameNode = game.item(j);
						if (gameNode.getNodeType() == Node.ELEMENT_NODE) {
							Element e = (Element) gameNode;
							String id = e.getAttribute("id").trim();
							// For some reason the for loop below doesn't work
							// also other loops are buggy? 
							//for (int k = 0; k < 6 - id.length(); k++) {id = "0"+id;}
							if (id.length() == 1) {id = "00000"+id;}
							else if (id.length() == 2) {id = "0000"+id;}
							else if (id.length() == 3) {id = "000"+id;}
							else if (id.length() == 4) {id = "00"+id;}
							else if (id.length() == 5) {id = "0"+id;}
							String name = e.getElementsByTagName("name").item(0).getTextContent().trim();
							for (int k = 0; k < 50 - name.length(); k++) {name += " ";}
							String developer = e.getElementsByTagName("developer").item(0).getTextContent().trim();
							for (int k = 0; k < 32 - developer.length(); k++) {developer += " ";}
							String played_version = e.getElementsByTagName("played_version").item(0).getTextContent().trim();
							for (int k = 0; k < 23 - played_version.length(); k++) {played_version += " ";}
							String dateof_lastupate = e.getElementsByTagName("dateof_lastupate").item(0).getTextContent().trim();
							System.out.println("|" + id + "| " + developer + " | " + played_version + " |");
							System.out.println("| " + dateof_lastupate + " | " + name + " |");
							System.out.println("---------------------------------------------------------------------");
						}
					}
				}
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public static void addGameControl(Document dom, Scanner keyboardScan) {
		boolean wantToContinue = true;
		try {
			//Element root = dom.getDocumentElement();
			//Element source = (Element) root.getElementsByTagName("source").item(0);
			keyboardScan.nextLine();
			while (wantToContinue) {
				textEasy(true, true, false, "Enter game id: ");
				String id = keyboardScan.nextLine();
				NodeList source = dom.getElementsByTagName("source");
				for (int i = 0; i < source.getLength(); i++) {
					Node sourceNode = source.item(i);
					if (sourceNode.getNodeType() == Node.ELEMENT_NODE) {
						NodeList game = sourceNode.getChildNodes();
						for (int j = 0; j < game.getLength(); j++) {
							Node gameNode = game.item(j);
							if (gameNode.getNodeType() == Node.ELEMENT_NODE) {
								Element e = (Element) gameNode;
								String ids = e.getAttribute("id").trim();
								if (ids.equals(id)) {
									textEasy(true, true, false, "Game with id: "+id+" already exists");
									break;
								} else {
									textEasy(false, true, false, "Enter game name: ");
									String name = keyboardScan.nextLine();
									textEasy(false, true, false, "Enter developer name:");
									String developer = keyboardScan.nextLine();
									textEasy(false, true, false, "Enter played version:");
									String played_version = keyboardScan.nextLine();
									String currentTimeAsOfRunning = LocalDate.now().toString();
									String dateof_lastupate = String.format(currentTimeAsOfRunning, "yyyy-mm-dd");

									Element newGame = dom.createElement("game");
									Element newName = dom.createElement("name");
									Element newDeveloper = dom.createElement("developer");
									Element newPlayed_version = dom.createElement("played_version");
									Element newDateof_lastupate = dom.createElement("dateof_lastupate");
									newGame.setAttribute("id", id);
									newName.setTextContent(name);
									newDeveloper.setTextContent(developer);
									newPlayed_version.setTextContent(played_version);
									newDateof_lastupate.setTextContent(dateof_lastupate);
									newGame.appendChild(newName);
									newGame.appendChild(newDeveloper);
									newGame.appendChild(newPlayed_version);
									newGame.appendChild(newDateof_lastupate);
									sourceNode.appendChild(newGame);

									uploadNewVersion(dom);
									textEasy(true, true, false, "Game with id: "+id+" has been added");
									break;
								}
							}
						}
					}
				}
				textEasy(false, true, false, "Do you want to add another game? (y/n)");
				String answer = keyboardScan.nextLine();
				if (answer.equals("n")) { wantToContinue = false; }
			}
			textEasy(true, true, true, "Game(s) saved");
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public static void removeGameControl(Document dom, Scanner keyboardScan) {
		boolean wantToContinue = true;
		try {
			keyboardScan.nextLine();
			NodeList source = dom.getElementsByTagName("source");
			while (wantToContinue){
				Boolean foundThing = false;
				textEasy(true, true, false, "Enter game id: ");
				String id = keyboardScan.nextLine();
				for (int i = 0; i < source.getLength(); i++) {
					Node sourceNode = source.item(i);
					if (sourceNode.getNodeType() == Node.ELEMENT_NODE) {
						NodeList game = sourceNode.getChildNodes();
						for (int j = 0; j < game.getLength(); j++) {
							Node gameNode = game.item(j);
							if (gameNode.getNodeType() == Node.ELEMENT_NODE) {
								Element e = (Element) gameNode;
								String ids = e.getAttribute("id").trim();
								if (ids.equals(id)) {
									String name = e.getElementsByTagName("name").item(0).getTextContent().trim();
									textEasy(false, true, false, name+" with id: "+ids+" has been removed");
									sourceNode.removeChild(gameNode);
									uploadNewVersion(dom);
									foundThing = true;
									break;
								}
							}
						}
					}
				}
				if (!foundThing) {textEasy(true, true, false, "Game with id: "+id+" was not found");}
				textEasy(false, true, false, "Do you want to remove another game? (y/n)");
				String answer = keyboardScan.nextLine();
				if (answer.equals("n")) {wantToContinue = false;}
			}
			textEasy(true, true, true, "Game(s) removed");
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public static void updateGameControl(Document dom, Scanner keyboardScan) {
		boolean wantToContinue = true;
		try {
			keyboardScan.nextLine();
			NodeList source = dom.getElementsByTagName("source");
			while (wantToContinue){
				Boolean foundThing = false;
				textEasy(true, true, false, "Enter game id to update: ");
				String id = keyboardScan.nextLine();
				for (int i = 0; i < source.getLength(); i++) {
					Node sourceNode = source.item(i);
					if (sourceNode.getNodeType() == Node.ELEMENT_NODE) {
						NodeList game = sourceNode.getChildNodes();
						for (int j = 0; j < game.getLength(); j++) {
							Node gameNode = game.item(j);
							if (gameNode.getNodeType() == Node.ELEMENT_NODE) {
								Element e = (Element) gameNode;
								String ids = e.getAttribute("id").trim();
								if (ids.equals(id)) {
									topThings();
									String oldname = e.getElementsByTagName("name").item(0).getTextContent().trim();
									String olddeveloper = e.getElementsByTagName("developer").item(0).getTextContent().trim();
									String oldplayed_version = e.getElementsByTagName("played_version").item(0).getTextContent().trim();
									String olddateof_lastupate = e.getElementsByTagName("dateof_lastupate").item(0).getTextContent().trim();
									if (ids.length() == 1) {ids = "00000"+ids;}else if (ids.length() == 2) {ids = "0000"+ids;}else if (ids.length() == 3) {ids = "000"+ids;}else if (ids.length() == 4) {ids = "00"+ids;}else if (ids.length() == 5) {ids = "0"+ids;}
									System.out.println("|"+ids+"| "+olddeveloper+"| "+oldplayed_version+"|");
									System.out.println("| "+olddateof_lastupate+" | "+oldname+"|");
									System.out.println("---------------------------------------------------------------------");
									textEasy(false, false, false, "Enter new game name: ");
									String newname = keyboardScan.nextLine();
									textEasy(false, true, false, "Enter new developer name: ");
									String newdeveloper = keyboardScan.nextLine();
									textEasy(true, true, false, "Enter new played version: ");
									String newplayed_version = keyboardScan.nextLine();
									// set date as current date
									String currentTimeAsOfRunning = LocalDate.now().toString();
									String newdateof_lastupate = String.format(currentTimeAsOfRunning, "yyyy-mm-dd");

									topThings();
									System.out.println("|"+ids+"| "+olddeveloper+"| "+oldplayed_version+"|");
									System.out.println("| "+olddateof_lastupate+" | "+oldname+"|");
									System.out.println("-/\\-old-----new-\\/-------------------------------------------------");
									System.out.println("|"+ids+"| "+newdeveloper+"| "+newplayed_version+"|");
									System.out.println("| "+newdateof_lastupate+" | "+newname+"|");
									System.out.println("---------------------------------------------------------------------");

									textEasy(false, true, false, "Do you want to update this game? (y/n)");
									String answer2 = keyboardScan.nextLine();
									if (answer2.equals("n")) {break;}
									e.getElementsByTagName("name").item(0).setTextContent(newname);
									e.getElementsByTagName("developer").item(0).setTextContent(newdeveloper);
									e.getElementsByTagName("played_version").item(0).setTextContent(newplayed_version);
									e.getElementsByTagName("dateof_lastupate").item(0).setTextContent(newdateof_lastupate);
									uploadNewVersion(dom);
									textEasy(true, true, false, "Game with id: "+ids+" has been updated");
									foundThing = true;
									break;
								}
							}
						}
					}
				}
				if (!foundThing) {textEasy(true, true, false, "Game with id: "+id+" was not found or terminated");}
				textEasy(false, true, false, "Do you want to update another game? (y/n)");
				String answer = keyboardScan.nextLine();
				if (answer.equals("n")) {wantToContinue = false;}
				textEasy(true, true, true, "Game(s) updated");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
