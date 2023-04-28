package Lesson11;

import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class fileHandle {
	public static void main(String[] args) throws IOException {
		try(RandomAccessFile raf = new RandomAccessFile("sorok.txt", "rw")) {
			String row1 = null, row2 = null;
			row1 = raf.readLine();
			row2 = raf.readLine();
			System.out.println(row1);
			System.out.println(row2);

			List<String> rows = new ArrayList<>();
			for (String row = raf.readLine(); row != null; row = raf.readLine()) {
				rows.add(row);
			}
			for (String row : rows) {
				System.out.println(row);
			}
		}
		RandomAccessFile raf2 = new RandomAccessFile("names.txt", "rw");
		String[] names = {"Vasya", "Petya", "Kolya", "Sasha", "Masha"};
		for (String name : names) {
			raf2.writeBytes(name + "\n");
		}
		String[] names2 = {"Trevor", "Phillip"};
		raf2.seek(10); // Byte offset
		for (String name : names2) {
			raf2.writeBytes(name + "\n");
		}
		raf2.close();
	}
}
