package ioapp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

public class IOApp {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.xyz.com/sample.zip");
            URLConnection cn = url.openConnection();
            try (BufferedInputStream in
                    = new BufferedInputStream(cn.getInputStream())) {
                try (BufferedOutputStream out
                        = new BufferedOutputStream(
                                new FileOutputStream("d:/javaprg/sample1.zip"))) {
                            byte[] buffer = new byte[8192]; //8 KB
                            int reads = 0;

                            while ((reads = in.read(buffer)) > 0) {
                                out.write(buffer, 0, reads);
                            }
                        }//end-try
            }//end-try
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
