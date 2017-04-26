package net.jgp.labs.io.dir;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JpegLister {

	private String startPath = null;

	public void setPath(String newPath) {
		startPath = newPath;
	}

	public List<File> list() {
		if (startPath == null) {
			return new ArrayList<>();
		}

		File folder = new File(startPath);
		File[] listOfFiles = folder
				.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".jpeg"));

		return Arrays.asList(listOfFiles);
	}

}
