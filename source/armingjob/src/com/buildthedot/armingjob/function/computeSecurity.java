package com.buildthedot.armingjob.function;

import java.security.MessageDigest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException; 
import java.util.Formatter;

public class computeSecurity {
	
	public computeSecurity(){
		
	}
//	password = md5(sha1(password)).sha1(md5(password));
	
	public String convertToMd5(final String md5) throws UnsupportedEncodingException {
        StringBuffer sb = null;
		try {
            final java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            final byte[] array = md.digest(md5.getBytes("UTF-8"));
            sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } 
		catch (final java.security.NoSuchAlgorithmException e) {
        }
        return sb.toString();
    }
	
	public String convertToSha1(String password)
	{
	    String sha1 = "";
	    try
	    {
	        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
	        crypt.reset();
	        crypt.update(password.getBytes("UTF-8"));
	        sha1 = byteToHex(crypt.digest());
	    }
	    catch(NoSuchAlgorithmException e)
	    {
	        e.printStackTrace();
	    }
	    catch(UnsupportedEncodingException e)
	    {
	        e.printStackTrace();
	    }
	    return sha1;
	}

	private static String byteToHex(final byte[] hash)
	{
	    Formatter formatter = new Formatter();
	    for (byte b : hash)
	    {
	        formatter.format("%02x", b);
	    }
	    String result = formatter.toString();
	    formatter.close();
	    return result;
	}
	
	
	
//	public String convertMD5(String word) throws IOException, NoSuchAlgorithmException{
//		
////		password = md5(sha1(password)).sha1(md5(password));
//		byte[] bytesOfMessage;
//		bytesOfMessage = word.getBytes("UTF-8");
//		MessageDigest md = null;
//		md = MessageDigest.getInstance("MD5");
//		byte[] convertWord = md.digest(bytesOfMessage);
//		
//		Log.v("convertWord", convertWord.toString());
//		
//		return convertWord.toString();
//	}
	
	/*
	private String result;
	private String SHAHash;
	
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
