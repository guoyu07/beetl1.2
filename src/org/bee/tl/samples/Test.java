package org.bee.tl.samples;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bee.tl.core.Context;
import org.bee.tl.core.GroupTemplate;
import org.bee.tl.core.Template;
import org.bee.tl.ext.String2Json;

public class Test
{

	public static int i = 12;
	public static int j = 1 ;
	static public User[] users = new User[]{new User(),new User()};

	public static void main(String[] args) throws Exception
	{

		 		String home = System.getProperty("user.dir") + File.separator + "template" + File.separator;
		 		GroupTemplate group = new GroupTemplate(new File(home));
		 		group.setCharset("GBK");
		 		group.config("<%", "%>", "${", "}");
		 		//group.config("<!--[", "]-->", "<!--[=", "]-->");	 		
		 		group.enableChecker(0.01);
		 		group.registerFunction("str2json", new String2Json());
		 		
		 		group.setDebug(true);
		 		group.enableNativeCall();
		 		//group.enableDirectOutputByte();
		 		Map compileConfig = new HashMap();
	 		    compileConfig.put(GroupTemplate.OPTIMIZE_KEEP_SOURCE, true);
	 		    group.enableOptimize(compileConfig);
//		 		 	group.enableOptimize();
//		 		  group.enableDirectOutputByte();
		 		
		 	
	 		    group.registerFunctionPackage("test", new NowFunction());
	 		    Template template = group.getFileTemplate("/helloworld.html");
		 	 template.set("tt", new Test());	
		 	 Map map = new HashMap();
		 	map.put("a", "a");
		 	map.put("b", "b");
		 	template.set("map", map);	
		 	
		 	
		 	 
		 	 
		 	
		 	System.out.println(template.getTextAsString());
		 	
		 	
		 	template = group.getFileTemplate("/helloworld.html");
		 	 template.set("tt",new Person());	
		 	template.set("map", map);	
		 	
		 	System.out.println(template.getTextAsString());
//			template = group.getFileTemplate("/helloworld.html");
//			template.set("a", 1);
//		 	System.out.println(template.getTextAsString());
//		 	group.removeTemplateCache("hello2");
//		 	Template t = group.getStringTemplate("hello1dfdf2356${name}", "hello2");
//		 	t.set("name", "中文");
//		 	String str = t.getTextAsString();
//		 	System.out.println(str);
		 	
		
//		 		

		
	
	}
	
	public static User getUser(){
		return new User();
	}
	
	public Test getTest(){
		return this;
	}
	
	public boolean isOk(Context ctx){
		return true;
	}

	public static boolean isTrue(int a, int b, int c)
	{
		return true;
	}
	
	public Object getList(){
		List list = new ArrayList();
		list.add(new User());
		list.add(new User());
		return list;
	}

}
