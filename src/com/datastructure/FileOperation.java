package com.datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperation {
	public static void main(String[] args) {
		File file = new File("D:\\input.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String st;
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\output.txt"));
			while ((st = br.readLine()) != null)
				if (st.contains("Ubuntu, ") && !st.endsWith(st.valueOf("12.04")))
					writer.write("\n" + "Ubuntu");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
