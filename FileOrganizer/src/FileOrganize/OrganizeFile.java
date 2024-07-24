package FileOrganize;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class OrganizeFile {

	public List<String> getName(String path) {

		File directory = new File(path);
		List<String> fileNames = new ArrayList<String>();

		if (directory.toString().isEmpty()) {
			fileNames.add("Names are not found cause path is empty");
			return fileNames;
		}else if(!directory.isAbsolute()) {
			fileNames.add("The provided path is not valid");
			return fileNames;
		}

		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				fileNames.add(file.getName());
			}
		}
		return fileNames;
	}
}
