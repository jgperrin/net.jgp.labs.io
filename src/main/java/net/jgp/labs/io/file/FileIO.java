package net.jgp.labs.io.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIO {

	public static StringBuffer fileToStringBuffer(String filename) throws IOException {
		StringBuffer sb = new StringBuffer();
		File f = new File(filename);
		FileInputStream fis = new FileInputStream(f);
		BufferedInputStream bif = new BufferedInputStream(fis);
		byte b[] = new byte[4096];
		while (bif.read(b) != -1) {
			sb.append(new String(b));
		}
		bif.close();
		return sb;
	}

}
