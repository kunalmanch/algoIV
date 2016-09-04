package my.practice.files;

import java.io.*;

/**
 * Created by kmishra on 9/1/2016.
 */
public class Creator {

    public static final String FILENAME = "C:\\git\\algorithmIV\\src\\main\\java\\my\\practice\\files\\temp.txt";

    public static void main(String[] ar) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(FILENAME, "rw");
        int i = 0;
        for (; i < 10000 - 1; i++) {
            String line = "This is line num " + i + ".\n";
            randomAccessFile.writeUTF(line);
        }
        String line = "This is line num " + i + ".";
        randomAccessFile.writeUTF(line);
        randomAccessFile.close();
    }
}
