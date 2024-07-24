package Application;

import java.util.List;
import java.util.Scanner;

import FileOrganize.OrganizeFile;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter you path :");
		String path = scan.nextLine();

		OrganizeFile orgFile = new OrganizeFile();

		List<String> names = orgFile.getName(path);
		for (String name : names) {
			System.out.println(name);
		}

	}

}
