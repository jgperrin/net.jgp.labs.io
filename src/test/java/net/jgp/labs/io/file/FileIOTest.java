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
	public void test() {
		StringBuffer sb;
		sb = FileIO.fileToStringBuffer(Paths.get("/etc/hosts"));
		System.out.println(sb.toString());
		if (sb.length() == 0) {
			fail("Return a 0 length /etc/hosts - weird or runing Windows");
		}
	}

}
