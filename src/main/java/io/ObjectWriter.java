package io;

import java.io.*;

/**
 * Created by User on 03.03.2016.
 */
public class ObjectWriter {
    public static void main(String[] args) {
        stringExample();
        descriptorExample();
    }

    private static void stringExample(){
        write("Ph'nglui mglw'nafh Cthulhu R'lyeh wgah'nagl fhtagn", "./string.bin");
        String fromFile = (String) read("./string.bin");
        System.out.println(fromFile);
    }

    private static void descriptorExample(){
        Descriptor descriptor = new Descriptor("Anna", 33);
        write(descriptor, "./descriptor.bin");
        Descriptor fromFile = (Descriptor) read("./descriptor.bin");
        System.out.println(fromFile);


    }

    public static void write(Object object, String fileName){
        try(FileOutputStream out = new FileOutputStream(fileName)){
            BufferedOutputStream bout = new BufferedOutputStream(out);
            ObjectOutputStream dout = new ObjectOutputStream(bout);
            dout.writeObject(object);
            dout.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Object read(String fileName){
        try(FileInputStream input = new FileInputStream(fileName)){
            BufferedInputStream binput = new BufferedInputStream(input);
            ObjectInputStream dinput = new ObjectInputStream(binput);
            return dinput.readObject();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }

    }
}
