package org.apache.hadoop.hdfs.server.namenode;

import org.apache.hadoop.conf.Configuration;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Hello world!
 */
public class FSLoader {
  public static void main(String[] args) throws Exception {
//        String fsImage = "/Users/duong/Downloads/mastercard";
    String fsImage = System.getProperty("fsImage");
    System.out.println("LOADING FSIMAGE: " + fsImage);
    FsImageValidation image = new FsImageValidation(new File(fsImage));
    AtomicInteger errorCount = new AtomicInteger();
    FSNamesystem fsNamesystem =
        image.checkINodeReference(new Configuration(), errorCount);
    System.out.println("Successfulling load file, fsState" + fsNamesystem.getFSState());
  }
}
