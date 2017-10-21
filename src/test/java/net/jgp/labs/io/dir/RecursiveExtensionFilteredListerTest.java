package net.jgp.labs.io.dir;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecursiveExtensionFilteredListerTest {
    private static transient Logger log = LoggerFactory
            .getLogger(RecursiveExtensionFilteredListerTest.class);

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
    public void testNonRec() {
        log.info("** TEST NON REC **");
        RecursiveExtensionFilteredLister fl = new RecursiveExtensionFilteredLister();
        fl.setPath("/Users/jgp/Pictures/Photo Booth Library/Pictures/");
        fl.addExtension("jpg");
        fl.addExtension("jpeg");
        fl.dir();
        List<File> list = fl.getFiles();
        for (File f : list) {
            log.info("File: {}", f);
        }
        log.info("Number of photos: {}", list.size());
    }

    @Test
    public void testRec() {
        log.info("** TEST REC **");
        RecursiveExtensionFilteredLister app = new RecursiveExtensionFilteredLister();
        app.setPath("/Users/jgp/Pictures/All Photos/1940-1949");
        app.setRecursive(true);
        app.addExtension("jpg");
        app.addExtension("jpeg");
        app.dir();
        List<File> photos = app.getFiles();
        for (File photo : photos) {
            log.info("File: {}", photo.getAbsolutePath());
        }
        log.info("Number of photos: {}", photos.size());
    }

    @Test
    public void testRecLimit() {
        log.info("** TEST REC + LIMIT **");
        RecursiveExtensionFilteredLister app = new RecursiveExtensionFilteredLister();
        app.setPath("/Users/jgp/Pictures/All Photos");
        app.setRecursive(true);
        app.setLimit(20);
        app.addExtension("jpg");
        app.addExtension("jpeg");
        app.dir();
        List<File> photos = app.getFiles();
        for (File photo : photos) {
            log.info("File: {}", photo.getAbsolutePath());
        }
        log.info("Number of photos: {}", photos.size());
    }

    @Test
    public void testGif() {
        log.info("** TEST GIF **");
        RecursiveExtensionFilteredLister app = new RecursiveExtensionFilteredLister();
        app.setPath("/Users/jgp/Pictures/All Photos");
        app.setRecursive(true);
        app.setLimit(-1);
        app.addExtension("gif");
        app.dir();
        List<File> photos = app.getFiles();
        for (File photo : photos) {
            log.info("File: {}", photo.getAbsolutePath());
        }
        log.info("Number of photos: {}", photos.size());
    }
}
