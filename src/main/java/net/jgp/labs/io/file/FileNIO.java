package net.jgp.labs.io.file;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileNIO {

	public static StringBuffer fileToStringBuffer(String filename) throws Exception {
		return fileToStringBuffer(Paths.get(filename));
	}

	public static StringBuffer fileToStringBuffer(Path path) throws Exception {
		System.out.println("-> fileToStringBuffer(" + path.toString() + ")");
		StringBuffer sb = new StringBuffer();
		RandomAccessFile aFile = new RandomAccessFile(path.toFile(), "r");
		FileChannel inChannel = aFile.getChannel();

		ByteBuffer buf = ByteBuffer.allocate(480);

		int bytesRead = inChannel.read(buf);
		while (bytesRead != -1) {
			System.out.println("Read " + bytesRead);
			buf.flip();

			while (buf.hasRemaining()) {
				sb.append((char) buf.get());
			}

			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
		return sb;
	}

}
