package cn.tyty;

import org.junit.Test;

import java.io.*;


public class MainTest {

    /* ---字节流--- */

    @Test
    public void InputStream() {
        try(InputStream fileInputStream = new FileInputStream("src/main/resources/input.txt")){
            System.out.println("字节流大小："+ fileInputStream.available());
            int content;
            long skip = fileInputStream.skip(2);
            System.out.println("skip："+ skip);
            while ((content = fileInputStream.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void OutputStream() {
        try(OutputStream fileOutputStream = new FileOutputStream("src/main/resources/output.txt")){
            byte[] bytes = "hello world".getBytes();
            fileOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ---字符流--- */

    @Test
    public void Reader() {
        try(Reader fileReader = new FileReader("src/main/resources/input.txt")){
            int content;
            while ((content = fileReader.read()) != -1) {
                System.out.print((char) content);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void Writer(){
        try(Writer fileWriter = new FileWriter("src/main/resources/output.txt")){
            fileWriter.write("world hello");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /* ---字节缓冲流--- */

    @Test
    public void BufferedInputStream(){
        try(BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream("src/main/resources/input.txt"))) {
            int content;
            long skip = fileInputStream.skip(2);
            while ((content = fileInputStream.read()) != -1) {
                System.out.print((char) content);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void BufferedOutputStream(){
        try(BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream("src/main/resources/output.txt"))) {
            fileOutputStream.write("hello hello".getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}