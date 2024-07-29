package Application;

import java.util.Scanner;

import FileOrganize.OrganizeFile;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter you path :");
		String path = scan.nextLine();

		OrganizeFile orgFile = new OrganizeFile();
		orgFile.organizeFiles(path);
		

	}

}
