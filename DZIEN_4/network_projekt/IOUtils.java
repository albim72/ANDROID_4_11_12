package com.marcin.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class IOUtils {
    public static void closeQuietly(InputStream in){
        try{
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeQuietly(Reader reader){
        try{
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
