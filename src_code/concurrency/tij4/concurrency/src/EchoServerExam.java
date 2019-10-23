/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.*;
import java.io.*;
import java.util.concurrent.*;

/**
 *
 * @author emaya
 */
public class EchoServerExam {

  public final static int PORT = 10367;

  public static void main(String[] args) {

   ExecutorService pool = Executors.newFixedThreadPool(500);

   try (ServerSocket server = new ServerSocket(PORT)) {
     while (true) {
       try {
         Socket connection = server.accept();
         Callable<Void> task = new EchoTask(connection);
         pool.submit(task);
       } catch (IOException ex) {}
     }
    } catch (IOException ex) {
      System.err.println("Couldn't start server");
      ex.printStackTrace();
    }
  }

  private static class EchoTask implements Callable<Void> {

    private Socket connection;

    EchoTask(Socket connection) {
      this.connection = connection;
    }

    @Override
    public Void call() throws IOException {
      try {
        InputStream in = new BufferedInputStream(connection.getInputStream());
        OutputStream out = connection.getOutputStream();
        int c;
        System.out.println(">");
        while ((c = in.read()) != -1) {
          out.write(c);
          out.flush();
        }
      } catch (IOException ex) {
        System.err.println(ex);
      } finally {
        connection.close();
      }
      return null;
    }
  }
}

