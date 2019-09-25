package com.rgproject.wc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;



/**
 * 	实现扩展功能-s -a 的类
 * @author Visional
 *
 */
public class ExtendFnc {
	
	@Ignore
	public void test_s(){
		//递归功能的单元测试,只需测试是否保存了所有文件即可
		new ExtendFnc("-s",new File("D:/WC_Test"));
		System.out.println(WordCount.fileList);
		WordCount.fileList.clear();
	}
	
	@Test
	public void test_a() {
		//特殊行数统计功能的单元测试
		new ExtendFnc("-a",new File("D:/d.c"));
	}
	
	public ExtendFnc() {}
	
	ExtendFnc(String para,File file) {
		//用于实现-s参数功能的构造方法：递归统计所给目录下符合条件的所有程序文件信息
		//para:判断传入的参数为-s还是-a，执行不同功能，file：传入的源程序文件
		if(para.equals("-s")) {
			if(file.exists() == false)
				System.out.println("文件不存在！");
			
			else if(file.isFile())
				WordCount.fileList.add(file); //若传进的是文件，则直接保存
		
			else if(file.isDirectory()) {
				File[] file1 = file.listFiles(); 
				for(File file2 : file1) {
					//对目录清单下的各项目录/文件进行递归保存
					if(file2.isFile())
						WordCount.fileList.add(file2);
					if(file2.isDirectory())
						new ExtendFnc("-s",file2);
				}
				
			}
		}else {
			//实现-a参数功能：统计程序文件特殊行数（空行，代码行，注释行）
			if(file.exists() == false)
				System.out.println("文件不存在！");
			else if(file.isDirectory()) 
				System.out.println("该文件路径为目录");
			else {
				try {
					BufferedReader br = new BufferedReader(new FileReader(file));
					String line; //用于接收源程序的每一行进行分类统计
					int allLine = 0; //统计总行数
					int codeLine = 0; //代码行数
					int blankLine = 0; //空行数
					int annoLine = 0; //注释行数
					boolean flag = false; //指示本行是否在注释块内
					while((line = br.readLine()) != null) {
						allLine ++;
						if(!flag) {
							if(line.matches("^\\n?\\s*[{}]?\\s*\\r*$") ) {
								//按如上正则表达式即可匹配符合要求的空行
								blankLine++;
							}else if(line.trim().matches("[{}]?//.*")) {
								annoLine++;
							}else if(line.trim().startsWith("/*")) {
								annoLine++;
								flag = true; //将指示符置为真，表示注释块开始
								
							}
								
						}else if(line.trim().indexOf("*/") != -1){
							//说明在本行注释块结束，指示符置为假
							flag = false;
							int annoEnd = line.trim().indexOf("*/");//获取注释块结束位置
							//判断注释块结束后本行是否有多于一个字符
							if(line.trim().length() == annoEnd+2) {
								annoLine ++;
								//注释块结束后本行无字符，本行为注释行，注释行+1
							}else if(line.trim().length() > annoEnd+2){
								//判断多余字符是否超过1，超过则为代码行，不超过则为注释行
								if(line.trim().length() - (annoEnd+2) == 1)
									//只多余一个字符，为注释行
									annoLine ++;
								else {}
									//多余字符超过1，为代码行，不操作
									
							}
						}else {
							//在注释块内，注释行+1
							annoLine++;
						}
					
					}
					codeLine = allLine - annoLine - blankLine;//除了空行、注释行，其余为代码行
					System.out.println("空行数："+blankLine);
					System.out.println("代码行数："+codeLine);
					System.out.println("注释行数："+annoLine);
					WordCount.bknum = blankLine;
					WordCount.cdnum = codeLine;
					WordCount.annum = annoLine;
					br.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
			}
		}
	}
	
	
}
