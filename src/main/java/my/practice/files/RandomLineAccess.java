package my.practice.files;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Random;

/**
 * Access a random line in a file.
 */
public class RandomLineAccess {

    private HashMap<Integer, Long> lineSeekMap = new HashMap<>();
    private Random random;
    private RandomAccessFile randomAccessFile;

    public RandomLineAccess(String file) throws IOException {
        random = new Random();
        lineSeekMap = new HashMap<>();
        randomAccessFile = new RandomAccessFile(file, "r");
        int lineCount = 0;
        while (randomAccessFile.readLine() != null) {
            lineSeekMap.put(lineCount++, randomAccessFile.getFilePointer());
        }
    }

    public String randomLine() throws IOException {
        int idx = random.nextInt(lineSeekMap.size());
        randomAccessFile.seek(lineSeekMap.get(idx));
        return randomAccessFile.readLine();
    }

    public static String lastLine(String file) throws IOException {
        File f = new File(file);
        long length = f.length();
        long seek = length - 1;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        StringBuilder sb = new StringBuilder();
        byte b;
        int newLineByte = "\n".getBytes(StandardCharsets.UTF_8)[0];
        while ((b = randomAccessFile.readByte()) != newLineByte) {
            sb.append((char)b);
            randomAccessFile.seek(seek);
            seek--;
        }
        sb.reverse();
        randomAccessFile.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        RandomLineAccess randomLineAccess = new RandomLineAccess(Creator.FILENAME);
        System.err.println(randomLineAccess.randomLine());
        System.err.println(randomLineAccess.randomLine());
        System.err.println(randomLineAccess.randomLine());
        System.err.println(lastLine(Creator.FILENAME));
    }
}
