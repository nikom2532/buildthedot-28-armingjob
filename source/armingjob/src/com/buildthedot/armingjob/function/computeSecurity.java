package com.buildthedot.armingjob.function;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.util.Base64;

public class computeSecurity {
	/*
	private String result;
	private String SHAHash;
	
	public computeSecurity(){
		
	}

	private static String convertToHex(byte[] data) throws java.io.IOException 
    {
            
            
           StringBuffer sb = new StringBuffer();
           String hex=null;
            
           hex=Base64.encodeToString(data, 0, data.length, NO_OPTIONS);
            
           sb.append(hex);
                        
           return sb.toString();
       }
    
    
   public void computeSHAHash(String password)
     {
         MessageDigest mdSha1 = null;
           try
           {
             mdSha1 = MessageDigest.getInstance("SHA-1");
           } catch (NoSuchAlgorithmException e1) {
             Log.e("myapp", "Error initializing SHA1 message digest");
           }
           try {
               mdSha1.update(password.getBytes("ASCII"));
           } catch (UnsupportedEncodingException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
           byte[] data = mdSha1.digest();
           try {
               SHAHash=convertToHex(data);
           } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
            
           result.setText("SHA-1 hash generated is: " + " " + SHAHash);
       }
    
    
   public void computeMD5Hash(String password)
   {

       try {
           // Create MD5 Hash
           MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
           digest.update(password.getBytes());
           byte messageDigest[] = digest.digest();
     
           StringBuffer MD5Hash = new StringBuffer();
           for (int i = 0; i < messageDigest.length; i++)
           {
               String h = Integer.toHexString(0xFF & messageDigest[i]);
               while (h.length() < 2)
                   h = "0" + h;
               MD5Hash.append(h);
           }
                 
           result = MD5Hash;
            
           } 
           catch (NoSuchAlgorithmException e) 
           {
           e.printStackTrace();
           }
       
        
   }
	*/
}
