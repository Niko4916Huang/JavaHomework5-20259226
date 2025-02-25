package util;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

import controller.ReportUI;

public class Tool2 {
	/*
	 * 註冊+存成檔案方法
	 * 1.static
	 * 2.void
	 * 3.引數-->輸入-->name,chi,eng-->new Student
	 * 4.檔案-->名+地點
	 * 
	 */
	
	public static void save(Object s,String filename)
	{
		
		try {
			
			FileOutputStream fos=new FileOutputStream(filename);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			
			oos.writeObject(s);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*
	 * 1.static
	 * 2.Object
	 * 3.引數-->檔名
	 * 
	 * 
	 */
	
	public static Object read(String filename)
	{
		Object o=null;
		
		try {
			FileInputStream fis=new FileInputStream(filename);
			ObjectInputStream ois=new ObjectInputStream(fis);
			o=ois.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return o;
	}
	
	public static boolean csvWrite(String filename, String[] titles, String[] headers, String[][] data)
	{
		FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter writer = null;
        
        /*
         * 亂碼原因
			亂碼的大多數原因是文件編碼和工具打開文件使用的編碼不統一導致。 Excel開啟的CSV檔案預設是ANSI編碼，如果CSV檔案的編碼方式為UTF-8、
			Unicode等編碼可能就會出現檔案亂碼的情況。另外記事本支援UTF-8編碼，所以用記事本開啟顯示正常。
			
			解決辦法
			既然Excel不能辨識檔案是UTF-8編碼，那就加入標識告訴Excel用UTF-8開啟。需要添加的標識就是BOM標識，添加的原因之後會介紹。
         */
		
		try  {
			fos = new FileOutputStream(filename);
			 
            //BOM
            fos.write(0xef);
            fos.write(0xbb);
            fos.write(0xbf);
 
            osw = new OutputStreamWriter(fos, "UTF-8");
            writer = new BufferedWriter(osw);
            
         // Write titles 
            if (titles.length > 0)
            {
            	 writer.write(String.join(",", titles)); 
                 writer.newLine();
                 writer.newLine();
            }
  
            // Write headers 
            writer.write(String.join(",", headers)); 
            writer.newLine(); 
 
            // Write data 
            for (String[] row : data) { 
                writer.write(String.join(",", row)); 
                writer.newLine(); 
            } 
            
            writer.flush();
            osw.flush();
            fos.flush();
            writer.close();
            osw.close();
            fos.close();
 
            Tool.alert(" CSV file: " + filename +" \n  輸出成功！");
            return true;
            
        } catch (IOException exc) { 
        
        	//exc.printStackTrace(); 
        	Tool.alert(exc.getMessage());
             // System.err.println(e.toString());
        	
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		
		return false;
		
		
	}

}