/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author xbest
 */
public class Encriptador {
    public SecretKeySpec CrearClave(String llave){
        try{
            byte[] cadena = llave.getBytes("UTF-16");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            cadena = md.digest(cadena);
            cadena = Arrays.copyOf(cadena,16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(cadena, "AES");
            return secretKeySpec;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public String Encriptar(String value){
        try{
            SecretKeySpec secretKeySpec = CrearClave("SistemaColegio");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            
            byte[] cadena = value.getBytes("UTF-8");
            byte[] encriptado = cipher.doFinal(cadena);
            String cadenaEncriptada = Base64.getEncoder().encodeToString(encriptado);
            return cadenaEncriptada;
        }catch(Exception e){
            System.out.println(e);
            return "";
        }
    }
    
    public String Desencriptar(String value){
        try{
            SecretKeySpec secretKeySpec = CrearClave("SistemaColegio");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); // Añade el modo y el esquema de relleno
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

            byte[] cadena = Base64.getDecoder().decode(value);
            byte[] desencriptado = cipher.doFinal(cadena);
            String cadenaDesencriptada = new String(desencriptado);
            return cadenaDesencriptada;
        }catch(Exception e){
            System.out.println(e);
            return "";
        }
    }


}
