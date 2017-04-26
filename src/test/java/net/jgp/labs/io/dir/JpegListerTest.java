package net.jgp.labs.io.dir;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JpegListerTest {

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
		JpegLister fl = new JpegLister();
		fl.setPath("/Users/jgp/Pictures/Photo Booth Library/Pictures/");
		List<File> list = fl.list();
		for (File f : list) {
			System.out.println(f);
		}
	}

}