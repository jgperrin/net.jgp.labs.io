package net.jgp.labs.io.dir;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileLister {

	private String startPath = null;
	private List<String> extensions = null;
	private long extensionCount;
	private boolean recursive;

	public FileLister() {
		this.extensions = new ArrayList<>();
		this.extensionCount = 0L;
		this.recursive = false;
	}

	public void setPath(String newPath) {
		startPath = newPath;
	}

	public List<File> list() {
		return list0(startPath, new ArrayList<>());
	}

	private List<File> list0(String startPath, ArrayList<File> arrayList) {
		if (startPath == null) {
			return arrayList;
		}
		return list0(new File(startPath), arrayList);
	}

	private List<File> list0(File folder, List<File> arrayList) {
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (supportedExtension(listOfFiles[i]) && listOfFiles[i].isFile()) {
				arrayList.add(listOfFiles[i]);
			} else {
				if (listOfFiles[i].isDirectory() && this.recursive) {
					arrayList.addAll(list0(listOfFiles[i], arrayList));
				}
			}
		}
		return arrayList;
	}

	private boolean supportedExtension(File file) {
		if (this.extensionCount == 0) {
			return true;
		}

		for (String extension : this.extensions) {
			if (file.getName().toLowerCase().endsWith(extension)) {
				return true;
			}
		}
		return false;
	}

	public void addExtensionFilter(String extension) {
		this.extensions.add(extension.toLowerCase());
		this.extensionCount++;
	}

	public void setRecursive() {
		this.recursive = true;
	}

	public void unsetRecursive() {
		this.recursive = false;
	}

}
