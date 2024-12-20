package IOSQLFormat;

import java.io.File;

import java.io.FileOutputStream;

import java.io.FileWriter;

import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Paths;

import java.util.List;

import java.util.Scanner;

public class FormatForSQLSearch {

	static String inputPath = System.getProperty("user.home") + "\\Desktop\\Before.txt";

	static String outputPath = System.getProperty("user.home") + "\\Desktop\\After.txt";

	public static void main(String[] args) {

		int counter = 0;

		try {

			List<String> lines = Files.readAllLines(Paths.get(inputPath));

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < lines.size(); i++) {

				sb.append("'");

				sb.append(lines.get(i).trim());

				sb.append("'");

				sb.append(",");

				counter++;

				if (i % 40 == 0 && i != 0) {

					sb.append("\n");

				}

			}

			String result = sb.toString();

			Files.write(Paths.get(outputPath), result.getBytes());

		} catch (Exception e) {

			// TODO: handle exception

		} finally {

			System.out.println(counter);

		}

	}

}