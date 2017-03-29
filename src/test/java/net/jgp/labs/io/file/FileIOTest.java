package net.jgp.labs.io.file;

import static org.junit.Assert.*;

import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileIOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFileToStringBuffer() {
		StringBuffer sb;
		long t0 = System.nanoTime();
		long t1;
		try {
			sb = FileIO.fileToStringBuffer("/etc/hosts");
			t1 = System.nanoTime();
		} catch (Exception e) {
			e.printStackTrace();
			fail("An exception was raised: " + e.getMessage());
			return;
		}
		System.out.println(sb.toString());
		long t2 = System.nanoTime();
		if (sb.length() == 0) {
			fail("Return a 0 length /etc/hosts - weird or running Windows");
		}

		System.out.println("Full process took ... " + (t2 - t0) / 1000 + " µs.");
		System.out.println("Reading took ........ " + (t1 - t0) / 1000 + " µs.");
	}

	@Test
	public void testFileToStringBufferWithBuffer() {
		StringBuffer sb;
		long t0 = System.nanoTime();
		long t1;
		try {
			sb = FileIO.fileToStringBufferWithBuffer("/etc/hosts");
			t1 = System.nanoTime();
		} catch (Exception e) {
			e.printStackTrace();
			fail("An exception was raised: " + e.getMessage());
			return;
		}
		System.out.println(sb.toString());
		long t2 = System.nanoTime();
		if (sb.length() == 0) {
			fail("Return a 0 length /etc/hosts - weird or running Windows");
		}

		System.out.println("Full process took ... " + (t2 - t0) / 1000 + " µs.");
		System.out.println("Reading took ........ " + (t1 - t0) / 1000 + " µs.");
	}
}
