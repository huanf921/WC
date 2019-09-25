package com.rgproject.wc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;


/**
 * 实现基本功能-c -w -l的类
 * 接收命令行传入的参数并进行相应的特征统计
 * @author Visional
 *
 */
public class BasicFnc {
	
	@Test
	public void testchar() {
		//对字符数统计进行单元测试
		new BasicFnc("-c",new File("D:/b.txt"));
		
	}
	
	@Test
	public void testword() {
		//对单词数统计进行单元测试
		new BasicFnc("-w",new File("D:/a.java"));
		
	}
	
	@Test
	public void testline() {
		//对行数统计进行单元测试
		new BasicFnc("-l",new File("D:/a.java"));
		
	}
	
	public BasicFnc() {}
	
	BasicFnc(String para,File file){
		//para：命令行传入的参数，此处指-c -w -l，file：传入的文件名（路径）
		switch(para) {
		
		case "-c":
			//传入“-c”参数，进行文件字符数统计
			int c = 0;	//定义初始字符数
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				while(br.read() != -1) {
					c++;
				}
				System.out.println("字符数："+c);
				WordCount.cnum = c;
				br.close();
			} catch (FileNotFoundException e) {
				System.out.println("文件不存在或该文件路径为目录");
			} catch (IOException e) {
				System.out.println("IO错误");
			}
			break;
			
		case "-w":
			int w = 0;	//定义初始词数
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String str;
				while((str = br.readLine())!=null){
	                //用正则表达式匹配文本中的单词
	                Pattern p = Pattern.compile("\\b[a-zA-Z]+\\b");
	                Matcher m = p.matcher(str);
	                while(m.find()){
	                    w++;
	                }
	            }
				
				System.out.println("词数："+w);
				WordCount.wnum = w;
				br.close();
			} catch (FileNotFoundException e) {
				System.out.println("文件不存在或该文件路径为目录");
			} catch (IOException e) {
				System.out.println("IO错误");
			}
			break;
			
		case "-l":
			int l = 0;	//定义初始行数
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				while(br.readLine() != null) {
					l++;
				}
				System.out.println("行数："+l);
				WordCount.lnum = l;
				br.close();
			} catch (FileNotFoundException e) {
				System.out.println("文件不存在或该文件路径为目录");
			} catch (IOException e) {
				System.out.println("IO错误");
			}
			break;
			
		default:
			System.out.println("请按格式正确输入，不清楚可输入help查看帮助哦~");
			break;
			
		}
	}
}
