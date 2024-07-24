package Compressor_Decompressor;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;


public class Compressor {
    public static void method(File file) throws IOException { // Method to compress a file using GZIP
        
        String fileDirectory = file.getParent(); // Get the parent directory of the input file

        FileInputStream fis = new FileInputStream(file); // Initialize FileInputStream to read the input file

        FileOutputStream fos = new FileOutputStream(fileDirectory + "/Compressed.gz");  // Initialize FileOutputStream to write the compressed output to a new GZIP file

        GZIPOutputStream gzip = new GZIPOutputStream(fos); // Initialize GZIPOutputStream to compress the output stream

        byte[] buffer = new byte[1024]; // Initialize a buffer for reading/writing data
        int len;
        while ((len = fis.read(buffer)) != -1) { // Read from the FileInputStream and compress/write to the GZIPOutputStream
            gzip.write(buffer, 0, len);
        }
        // Close the streams in the reverse order: first GZIPOutputStream, then FileOutputStream, and finally FileInputStream
        gzip.close();
        fos.close();
        fis.close();
    }
}
