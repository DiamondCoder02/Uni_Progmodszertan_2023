package Lesson10;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// files:
// Szövege stream/folyam -> 1 egység: 1 karakter
// Bináris stream/folyam -> 1 egység: 1 byte

public class filesystem {
	public static void main(String[] args) {
		// Szövege stream/folyam

		try (FileWriter fw = new FileWriter("test.txt")) {
			fw.write(65); // A
			fw.write(66); // B
			fw.write(67); // C

			fw.write(10);
			fw.write(13);

			fw.write("X");
			fw.write(68);

			fw.write(10);
			fw.write(13);
			for (int i = 0; i < 127; i++) {
				fw.write(i);
			}

			fw.write(10);
			fw.write(13);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileReader fr = new FileReader("test.txt")) {
			int charCode;
			while ((charCode = fr.read()) != -1) {
				char character = (char) charCode;
				System.out.print(character);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Bináris stream/folyam
		// InputStream;
		// OutputStream;

		try (FileInputStream in = new FileInputStream("proba.pdf");
				FileOutputStream out = new FileOutputStream("proba_out.pdf")) {
			while (true) {
				int readByte = in.read();
				if (readByte == -1)
					break;
				out.write(readByte);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// string pdf
		try (FileReader in = new FileReader("proba.pdf");
				FileWriter out = new FileWriter("proba_text.pdf")) {
			while (true) {
				int readCharacter = in.read();
				if (readCharacter == -1)
					break;
				out.write(readCharacter);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// PrintWriter
		try (PrintWriter pw = new PrintWriter("proba.txt")) {
			for (int i = 1; i < 21; i++) {
				pw.println(i + ". line");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// BufferedReader
		try (BufferedReader br = new BufferedReader(new FileReader("proba.txt"))) {
			String line;
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// primitive types
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.bin"))){
			dos.writeBoolean(true);
			dos.writeByte(127);
			dos.writeChar('A');
			dos.writeDouble(3.14);
			dos.writeFloat(3.14f);
			dos.writeInt(123456789);
			dos.writeLong(1234567890123456789L);
			dos.writeShort(32767);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (DataInputStream dis = new DataInputStream(new FileInputStream("data.bin"))){
			System.out.println(dis.readBoolean());
			System.out.println(dis.readByte());
			System.out.println(dis.readChar());
			System.out.println(dis.readDouble());
			System.out.println(dis.readFloat());
			System.out.println(dis.readInt());
			System.out.println(dis.readLong());
			System.out.println(dis.readShort());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
