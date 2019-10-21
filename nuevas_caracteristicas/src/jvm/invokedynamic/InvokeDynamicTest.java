package jvm.invokedynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvokeDynamicTest {

    public static void main(String[] args) {
//        try {
            Saludador saludador = new Saludador();

            MethodHandles.Lookup lookup = MethodHandles.lookup();
            // De instancia
            
            // De clase

            // Con parámetro

            // Con retorno


//        } catch (NoSuchMethodException | IllegalAccessException ex) {
//            Logger.getLogger(InvokeDynamicTest.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (Throwable ex) {
//            Logger.getLogger(InvokeDynamicTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}