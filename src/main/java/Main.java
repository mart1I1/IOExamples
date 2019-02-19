import java.io.*;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {

    private static void demoIOFileReaderWriter() throws IOException {
        File file = File.createTempFile("first", ".txt");
        System.out.println("file exist: " + file.exists());

        FileWriter fileWriter = new FileWriter(file);
        FileReader fileReader = new FileReader(file);

        fileWriter.write("Hello file " + file.getName());
        fileWriter.flush();
        fileWriter.close();

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        System.out.println("read from file : " + bufferedReader.readLine());
        bufferedReader.close();

        System.out.println("file delete: " + file.delete());
    }

    private static void demoIOStream() throws IOException {
        String filename = "second.txt";
        OutputStream outputStream = new FileOutputStream(filename);
        String line = "Hello file " + filename;
        for (char ch : line.toCharArray()) {
            outputStream.write(ch);
        }
        outputStream.flush();
        outputStream.close();

        FileInputStream fileInputStream = new FileInputStream(filename);
        int i = -1;
        while ((i = fileInputStream.read()) != -1) {
            System.out.print((char) i);
        }
        fileInputStream.close();
        System.out.println();

        File file = new File(filename);
        System.out.println("file delete: " + file.delete());
    }



    public static void main(String[] args) throws IOException {
        demoIOFileReaderWriter();
        System.out.println("=============================");
        demoIOStream();
    }
}
