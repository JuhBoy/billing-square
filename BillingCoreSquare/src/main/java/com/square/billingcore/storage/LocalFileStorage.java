package com.square.billingcore.storage;

import com.square.billingcore.logging.ILogger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;

public final class LocalFileStorage extends FileStore {

    private ILogger logger;

    public LocalFileStorage(String rootPath, ILogger logger) {
        super(rootPath);
        this.logger = logger;
    }

    @Override
    public byte[] get(String name) throws Exception {
        String filePath = this.rootPath + '/' + name;
        if (Exists(filePath)) return new byte[0];

        BufferedReader bufferedReader = null;

        long fileSize = Files.getFileAttributeView(Paths.get(filePath),
                BasicFileAttributeView.class).readAttributes().size();

        try {
            byte[] buffer = new byte[(int)fileSize];
            FileReader fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);

            int single = 0;
            int index = 0;
            while ((single = bufferedReader.read()) != -1) {
                buffer[index] = (byte)single;
                index++;
            }

            return buffer;

        } catch (FileNotFoundException ex) {
            this.logger.error(ex);
        } catch (IOException ex) {
            this.logger.error(ex);
            throw ex;
        } finally {
            if (bufferedReader != null)
                bufferedReader.close();
        }

        return null;
    }

    @Override
    public void save(String name, byte[] data) {

    }

    @Override
    public void remove(String name) {

    }
}