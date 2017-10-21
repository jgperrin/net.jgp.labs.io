package net.jgp.labs.io.dir;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecursiveExtensionFilteredLister {
    private static transient Logger log = LoggerFactory
            .getLogger(RecursiveExtensionFilteredLister.class);
    private String startPath = null;
    private List<File> files;
    private boolean recursive;
    private int limit;
    private List<String> extensions;

    public RecursiveExtensionFilteredLister() {
        this.files = new ArrayList<>();
        this.extensions = new ArrayList<>();
        this.recursive = false;
        this.limit = -1;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setRecursive(boolean b) {
        this.recursive = b;
    }

    public void setPath(String newPath) {
        startPath = newPath;
    }

    public boolean dir() {
        if (this.startPath == null) {
            return false;
        }
        return list0(new File(this.startPath));
    }

    private boolean list0(File folder) {
        if (folder == null) {
            return false;
        }
        if (!folder.isDirectory()) {
            return false;
        }

        File[] listOfFiles = folder.listFiles((dir, name) -> check(dir, name));
        if (listOfFiles == null) {
            return true;
        }
        if (limit == -1) {
            this.files.addAll(Arrays.asList(listOfFiles));
        } else {
            int fileCount = this.files.size();
            if (fileCount >= limit) {
                recursive = false;
                return false;
            }

            for (int i = fileCount, j = 0; i < limit
                    && j < listOfFiles.length; i++, j++) {
                this.files.add(listOfFiles[j]);
            }
        }
        return true;
    }

    private boolean check(File dir, String name) {
        //log.debug("{}/{}", dir, name);
        File f = new File(dir, name);
        if (f.isDirectory()) {
            if (recursive) {
                list0(f);
            }
            return false;
        } else {
            for (String ext : extensions) {
                if (name.toLowerCase().endsWith(ext)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void setLimit(int i) {
        this.limit = i;
    }

    public void addExtension(String extension) {
        if (extension.startsWith(".")) {
            this.extensions.add(extension.toLowerCase());
        } else {
            this.extensions.add("." + extension.toLowerCase());
        }
    }
}
