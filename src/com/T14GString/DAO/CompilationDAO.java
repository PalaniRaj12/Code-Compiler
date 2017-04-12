package com.T14GString.DAO;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.web.multipart.MultipartFile;

public class CompilationDAO {
	public static ArrayList al=new ArrayList<String>();
	public static ArrayList al1=new ArrayList<String>();
	public CompilationForm compileCode(CompilationForm compilationForm)
	{
		al.clear();
		StringBuffer code = null;
		if(compilationForm.isCheckbox())
		{
			MultipartFile doc_file = compilationForm.getFile();
			BufferedReader reader;
			File temp_file = new File("H:\\h.txt");			
			try {
				doc_file.transferTo(temp_file);
				reader = new BufferedReader(new FileReader("H:\\h.txt"));
				String line=null;
				StringBuffer sb=new StringBuffer();
				String ls=System.getProperty("line.separator");
				while((line=reader.readLine())!=null){
					sb.append(line);
					sb.append(ls);
				}
			code=sb;
			compilationForm.setCode(sb.toString());	
			}       catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();}
		}
		else{
			code=new StringBuffer(compilationForm.getCode());
		}
		File newTextFile=new File("H:\\Studies Full\\CIRCUITS\\imp\\JAVA--Software\\eclipse-jee-luna-SR1a-win32\\eclipse\\Main.java");
		FileWriter fw;
		try {
			fw = new FileWriter(newTextFile);
			fw.write(code.toString());
			fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		try{
			int error=runProcess("javac Main.java");
			if(error==0){
				runProcess("java Main");}
  			}catch(Exception e){
					e.printStackTrace();
			}	
		    StringBuffer stdout=new StringBuffer(),stderr=new StringBuffer();
			for(int i=0;i<al.size();i++)
				 stdout.append(System.getProperty("line.separator")+new StringBuffer((String) al.get(i)));
			for(int i=0;i<al1.size();i++)
				 stderr.append(System.getProperty("line.separator")+new StringBuffer((String) al1.get(i)));
			System.out.println(stdout);
			compilationForm.setStdout(stdout.toString());
			compilationForm.setStderr(stderr.toString());
			al1.clear();
			al.clear();
		return compilationForm;
	}
	
	private static void printLines(String name,InputStream ins,boolean stderr) throws Exception
	{
		String line= null;
		BufferedReader in=new BufferedReader(new InputStreamReader(ins));
		while((line=in.readLine())!=null){
			String line1=line;
			System.out.println(name+""+line1);
			if(stderr)
				al.add(line1);
			else
				al1.add(line1);
		}
	}
	private static int runProcess(String command) throws Exception
	{
		Process pro=Runtime.getRuntime().exec(command);
		printLines(command+" stdout: ",pro.getInputStream(),true);
		printLines(command+" stderr: ",pro.getErrorStream(),false);
		pro.waitFor();
		System.out.println(command+"existValue:"+pro.exitValue());
		return pro.exitValue();
	}
	
	public boolean DBsave(CompilationForm compilationForm,int id)
	{
		System.out.println("id is "+id);
		try{
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		compilationForm.setQuestionId(id);
		session.saveOrUpdate(compilationForm);
		transaction.commit(); 
		System.out.println("Successfully saved"); 
		session.flush(); 
		session.close();
		return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	public CompilationForm DBretrieve(int i)
	{
		CompilationForm compilationForm =new CompilationForm();
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		compilationForm =  (CompilationForm) session.get(CompilationForm.class, i);
		transaction.commit(); 
		session.flush(); 
		session.close();
		return compilationForm;
	}
}
