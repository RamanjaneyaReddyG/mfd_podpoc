package com.ram.mft;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CopyFilesPoc {

	
	@Value( "${jasperapi.xml.source}" )
	private String sourcepath;
	

	@Value( "${jasperapi.xml.destination}" )
	private String targetpath;
	
	public void moveXmlFiles() throws NullPointerException 
	{
		try {
		File root=new File(sourcepath);
		File[] files=root.listFiles((d, name) -> name.endsWith(".xml"));
		
		for(File f:files)
		{
			System.out.println(f.getAbsolutePath());
			System.out.println(f.getName());
			
			Path xmlSpath = Paths.get(sourcepath.concat(f.getName()));
			Path xmlTpath = Paths.get(targetpath.concat(f.getName()));
			
			try {
				Files.copy(xmlSpath, xmlTpath, StandardCopyOption.REPLACE_EXISTING);
				System.out.println("Files successfully moved....");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	
//	public static void main(String[] args)
//	{
//		CopyFilesPoc p=new CopyFilesPoc();
//		p.moveXmlFiles();
//	}
	
	
}
