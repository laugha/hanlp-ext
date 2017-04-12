package com.hualongdata.hanlpext.io;

import com.hankcs.hanlp.corpus.io.IIOAdapter;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

/**
 * HanLP HDFSIOAdapter
 */
public class HDFSIOAdapter implements IIOAdapter {
    @Override
    public InputStream open(String path) throws IOException {

        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://dn111:9000");
        FileSystem fs = FileSystem.get(URI.create(path), conf);
        InputStream in = null;

        try {
            in = fs.open(new Path(path));

        } catch (Exception e) {
            System.out.println(e);
        }

        return in;
    }

    @Override
    public OutputStream create(String path) throws IOException {
        return null;
    }

}
