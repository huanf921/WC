package com.rgproject.wc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 	wc主类，联系命令行与各大功能类
 * @author Visional
 *
 */
public class WordCount {
	static List<File> fileList = new ArrayList<>(); //用于存放目录下的所有文件,运行递归功能时可用
	static boolean checkBox0 = false; //五个布尔变量，用于确定图形界面的选择框状态
	static boolean checkBox1 = false;
	static boolean checkBox2 = false;
	static boolean checkBox3 = false;
	static boolean checkBox4 = false;
	static int cnum = 0; //用于向图形界面传达各种特征信息的统计情况
	static int wnum = 0;
	static int lnum = 0;
	static int cdnum = 0;
	static int bknum = 0;
	static int annum = 0;
	public static void main(String[] args) {
		System.out.println("##一个简单的源程序特征统计程序##");
		System.out.println("1.输入help可查看使用说明");
		System.out.println("2.输入exit可退出本程序");
		System.out.println("-------------------------------");
		while(true) {
			//循环获取键盘输入并执行相应功能，直到退出为止
			Scanner sc = new Scanner(System.in); //获取键盘输入
			String str1 = sc.nextLine();
			
			if(str1.equals("exit"))
				System.exit(0);
			
			if(str1.equals("help")) {
				new Help();
				continue;
			}
			
			String[] str2 = str1.split(" "); //以命令中的空格为分隔符将用户输入的命令分割处理
			for(String str : str2) {
				//检查用户输入的命令是否包含“-x”参数，若有，则直接调取图形界面
				if(str.equals("-x")) {
					//调取图形界面
					
				}
			}
			
			
			if(str2[1].equals("-s")) {
				//若第一个参数就是-s，则直接调用扩展功能进行递归处理
				String fileName = str2[3].substring(str2[3].lastIndexOf("/")+1); //取出末尾的文件或目录名
				String fileParent = str2[3].substring(0, str2[3].lastIndexOf("/")); //取出当前父目录
				switch(str2[2]) {
				case "-c":
					if((fileName.indexOf("*") != -1) || (fileName.indexOf("?") != -1)) {
						//文件路径包含通配符，将当前目录递归处理后所得文件进行条件筛选
						new ExtendFnc("-s",new File(fileParent));
					    for(File file : fileList) {
					    	String fname = file.getName();
					    	String suffix = fileName.substring(fileName.indexOf("."));//获取文件后缀名
					    	if(fname.matches(".+"+suffix)){
					    		//对符合条件的文件进行字符数统计 -c
					    		System.out.println(file.getPath());
					    		new BasicFnc("-c",file);
					    	}
					    }
					    System.out.println("-------------------------------");
					}else {
						File file = new File(str2[3]);
						if(file.isFile())
							//所给路径为文件，直接统计
							new BasicFnc("-c",file);
						else {
							new ExtendFnc("-s",file);//不包含通配符，路径为目录，递归保存目录下所有文件
							for(File file1 : fileList) {
								System.out.println(file1.getPath());
								new BasicFnc("-c",file1);
							}
						}
						System.out.println("-------------------------------");
					}
				break;
				
				case "-w":
					if((fileName.indexOf("*") != -1) || (fileName.indexOf("?") != -1)) {
						//文件路径包含通配符，将当前目录递归处理后所得文件进行条件筛选
						new ExtendFnc("-s",new File(fileParent));
					    for(File file : fileList) {
					    	String fname = file.getName();
					    	String suffix = fileName.substring(fileName.indexOf("."));//获取文件后缀名
					    	if(fname.matches(".+"+suffix)){
					    		//对符合条件的文件进行字符数统计 -w
					    		System.out.println(file.getPath());
					    		new BasicFnc("-w",file);
					    	}
					    }
					    System.out.println("-------------------------------");
					}else {
						File file = new File(str2[3]);
						if(file.isFile())
							//所给路径为文件，直接统计
							new BasicFnc("-w",file);
						else {
							new ExtendFnc("-s",file);//不包含通配符，路径为目录，递归保存目录下所有文件
							for(File file1 : fileList) {
								System.out.println(file1.getPath());
								new BasicFnc("-w",file1);
							}
						}
						System.out.println("-------------------------------");
					}
					break;
					
				case "-l":
					if((fileName.indexOf("*") != -1) || (fileName.indexOf("?") != -1)) {
						//文件路径包含通配符，将当前目录递归处理后所得文件进行条件筛选
						new ExtendFnc("-s",new File(fileParent));
					    for(File file : fileList) {
					    	String fname = file.getName();
					    	String suffix = fileName.substring(fileName.indexOf("."));//获取文件后缀名
					    	if(fname.matches(".+"+suffix)){
					    		//对符合条件的文件进行字符数统计 -l
					    		System.out.println(file.getPath());
					    		new BasicFnc("-l",file);
					    	}
					    }
					    System.out.println("-------------------------------");
					}else {
						File file = new File(str2[3]);
						if(file.isFile())
							//所给路径为文件，直接统计
							new BasicFnc("-l",file);
						else {
							new ExtendFnc("-s",file);//不包含通配符，路径为目录，递归保存目录下所有文件
							for(File file1 : fileList) {
								System.out.println(file1.getPath());
								new BasicFnc("-l",file1);
							}
						}
						System.out.println("-------------------------------");
					}
					break;
					
				case "-a":
					if((fileName.indexOf("*") != -1) || (fileName.indexOf("?") != -1)) {
						//文件路径包含通配符，将当前目录递归处理后所得文件进行条件筛选
						new ExtendFnc("-s",new File(fileParent));
					    for(File file : fileList) {
					    	String fname = file.getName();
					    	String suffix = fileName.substring(fileName.indexOf("."));//获取文件后缀名
					    	if(fname.matches(".+"+suffix)){
					    		//对符合条件的文件进行字符数统计 -a
					    		System.out.println(file.getPath());
					    		new ExtendFnc("-a",file);
					    	}
					    }
					    System.out.println("-------------------------------");
					}else {
						File file = new File(str2[3]);
						if(file.isFile())
							//所给路径为文件，直接统计
							new BasicFnc("-a",file);
						else {
							new ExtendFnc("-s",file);//不包含通配符，路径为目录，递归保存目录下所有文件
							for(File file1 : fileList) {
								System.out.println(file1.getPath());
								new ExtendFnc("-a",file1);
							}
						}
						System.out.println("-------------------------------");
					}
					break;
				default:
					System.out.println("请按正确格式输入，不清楚可输入help查看帮助哦~");
					System.out.println("-------------------------------");
				}
				
				
			}else if(str2[1].equals("-c")) {
				
				System.out.println(str2[2]);
				new BasicFnc("-c",new File(str2[2]));
				System.out.println("-------------------------------");
				//调用基本功能类实现“-c”参数功能
				
			}else if(str2[1].equals("-w")) {
				
				System.out.println(str2[2]);
				new BasicFnc("-w",new File(str2[2]));
				System.out.println("-------------------------------");
				//调用基本功能类实现“-w”参数功能
				
			}else if(str2[1].equals("-l")) {
				
				System.out.println(str2[2]);
				new BasicFnc("-l",new File(str2[2]));
				System.out.println("-------------------------------");
				//调用基本功能类实现“-l”参数功能
				
			}else if(str2[1].equals("-a")) {
				
				System.out.println(str2[2]);
				new ExtendFnc("-a",new File(str2[2]));
				System.out.println("-------------------------------");
				//调用扩展功能类实现“-a”参数功能
				
			}else {
				
				System.out.println("请按正确格式输入，不清楚可输入help查看帮助哦~");
				System.out.println("-------------------------------");
				
			}
			fileList.clear();
		}
	}
}
