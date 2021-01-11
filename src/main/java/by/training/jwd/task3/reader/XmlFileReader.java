package by.training.jwd.task3.reader;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlFileReader {

	public List<String> readFileInList(String fileName) {

		List<String> list = new ArrayList<String>();

		String line;

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			while ((line = br.readLine()) != null) {

				list.add(line);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}
}
