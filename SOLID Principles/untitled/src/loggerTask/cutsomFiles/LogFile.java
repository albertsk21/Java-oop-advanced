package loggerTask.cutsomFiles;

import loggerTask.cutsomFiles.interfaces.File;

import java.io.FileWriter;
import java.io.IOException;

public class LogFile implements File {

    private StringBuffer buffer;
    private FileWriter fileWriter;


    public LogFile() throws IOException {
        this.buffer = new StringBuffer();
        this.setFileWriter("src/output.txt");
    }


    public StringBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(StringBuffer buffer) {
        this.buffer = buffer;
    }

    public FileWriter getFileWriter() {
        return fileWriter;
    }

    public void setFileWriter(String path) throws IOException {
        java.io.File file = new java.io.File(path);
        this.fileWriter = new FileWriter(file);
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Character c : this.buffer.toString().toCharArray()) {
            if(Character.isAlphabetic(c)){
                size += c;
            }
        }
        return size;
    }

    @Override
    public void write() {
        try {
            this.setFileWriter("src/output.txt");
            String text = this.buffer.toString();
            this.fileWriter.append(text);
            this.fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void appendBuffer(String text) {
        this.buffer.append(text).append("\r\n");
    }

}
