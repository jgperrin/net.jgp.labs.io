package net.jgp.labs.io.dir;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileLister {

	private String startPath = null;
	private List<String> extensions = null;
	private long extensionCount;

	public FileLister() {
		this.extensions = new ArrayList<>();
		this.extensionCount = 0L;
	}

	public void setPath(String newPath) {
		startPath = newPath;
	}

	public List<File> list() {
		if (startPath == null) {
			return new ArrayList<>();
		}

		File folder = new File(startPath);
		File[] listOfFiles = folder.listFiles((dir, name) -> supportedExtension(name));

		return Arrays.asList(listOfFiles);
	}

	private boolean supportedExtension(String name) {
		if (this.extensionCount == 0) {
			return true;
		}

		for (String extension : this.extensions) {
			if (name.toLowerCase().endsWith(extension)) {
				return true;
			}
		}
		return false;
	}

	public void addExtensionFilter(String extension) {
		this.extensions.add(extension.toLowerCase());
		this.extensionCount++;
	}

}
