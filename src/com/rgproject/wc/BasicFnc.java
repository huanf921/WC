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
 * ʵ�ֻ�������-c -w -l����
 * ���������д���Ĳ�����������Ӧ������ͳ��
 * @author Visional
 *
 */
public class BasicFnc {
	
	@Test
	public void testchar() {
		//���ַ���ͳ�ƽ��е�Ԫ����
		new BasicFnc("-c",new File("D:/b.txt"));
		
	}
	
	@Test
	public void testword() {
		//�Ե�����ͳ�ƽ��е�Ԫ����
		new BasicFnc("-w",new File("D:/a.java"));
		
	}
	
	@Test
	public void testline() {
		//������ͳ�ƽ��е�Ԫ����
		new BasicFnc("-l",new File("D:/a.java"));
		
	}
	
	public BasicFnc() {}
	
	BasicFnc(String para,File file){
		//para�������д���Ĳ������˴�ָ-c -w -l��file��������ļ�����·����
		switch(para) {
		
		case "-c":
			//���롰-c�������������ļ��ַ���ͳ��
			int c = 0;	//�����ʼ�ַ���
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				while(br.read() != -1) {
					c++;
				}
				System.out.println("�ַ�����"+c);
				WordCount.cnum = c;
				br.close();
			} catch (FileNotFoundException e) {
				System.out.println("�ļ������ڻ���ļ�·��ΪĿ¼");
			} catch (IOException e) {
				System.out.println("IO����");
			}
			break;
			
		case "-w":
			int w = 0;	//�����ʼ����
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String str;
				while((str = br.readLine())!=null){
	                //��������ʽƥ���ı��еĵ���
	                Pattern p = Pattern.compile("\\b[a-zA-Z]+\\b");
	                Matcher m = p.matcher(str);
	                while(m.find()){
	                    w++;
	                }
	            }
				
				System.out.println("������"+w);
				WordCount.wnum = w;
				br.close();
			} catch (FileNotFoundException e) {
				System.out.println("�ļ������ڻ���ļ�·��ΪĿ¼");
			} catch (IOException e) {
				System.out.println("IO����");
			}
			break;
			
		case "-l":
			int l = 0;	//�����ʼ����
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				while(br.readLine() != null) {
					l++;
				}
				System.out.println("������"+l);
				WordCount.lnum = l;
				br.close();
			} catch (FileNotFoundException e) {
				System.out.println("�ļ������ڻ���ļ�·��ΪĿ¼");
			} catch (IOException e) {
				System.out.println("IO����");
			}
			break;
			
		default:
			System.out.println("�밴��ʽ��ȷ���룬�����������help�鿴����Ŷ~");
			break;
			
		}
	}
}
