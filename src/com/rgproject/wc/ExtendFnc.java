package com.rgproject.wc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;



/**
 * 	ʵ����չ����-s -a ����
 * @author Visional
 *
 */
public class ExtendFnc {
	
	@Ignore
	public void test_s(){
		//�ݹ鹦�ܵĵ�Ԫ����,ֻ������Ƿ񱣴��������ļ�����
		new ExtendFnc("-s",new File("D:/WC_Test"));
		System.out.println(WordCount.fileList);
		WordCount.fileList.clear();
	}
	
	@Test
	public void test_a() {
		//��������ͳ�ƹ��ܵĵ�Ԫ����
		new ExtendFnc("-a",new File("D:/d.c"));
	}
	
	public ExtendFnc() {}
	
	ExtendFnc(String para,File file) {
		//����ʵ��-s�������ܵĹ��췽�����ݹ�ͳ������Ŀ¼�·������������г����ļ���Ϣ
		//para:�жϴ���Ĳ���Ϊ-s����-a��ִ�в�ͬ���ܣ�file�������Դ�����ļ�
		if(para.equals("-s")) {
			if(file.exists() == false)
				System.out.println("�ļ������ڣ�");
			
			else if(file.isFile())
				WordCount.fileList.add(file); //�����������ļ�����ֱ�ӱ���
		
			else if(file.isDirectory()) {
				File[] file1 = file.listFiles(); 
				for(File file2 : file1) {
					//��Ŀ¼�嵥�µĸ���Ŀ¼/�ļ����еݹ鱣��
					if(file2.isFile())
						WordCount.fileList.add(file2);
					if(file2.isDirectory())
						new ExtendFnc("-s",file2);
				}
				
			}
		}else {
			//ʵ��-a�������ܣ�ͳ�Ƴ����ļ��������������У������У�ע���У�
			if(file.exists() == false)
				System.out.println("�ļ������ڣ�");
			else if(file.isDirectory()) 
				System.out.println("���ļ�·��ΪĿ¼");
			else {
				try {
					BufferedReader br = new BufferedReader(new FileReader(file));
					String line; //���ڽ���Դ�����ÿһ�н��з���ͳ��
					int allLine = 0; //ͳ��������
					int codeLine = 0; //��������
					int blankLine = 0; //������
					int annoLine = 0; //ע������
					boolean flag = false; //ָʾ�����Ƿ���ע�Ϳ���
					while((line = br.readLine()) != null) {
						allLine ++;
						if(!flag) {
							if(line.matches("^\\n?\\s*[{}]?\\s*\\r*$") ) {
								//������������ʽ����ƥ�����Ҫ��Ŀ���
								blankLine++;
							}else if(line.trim().matches("[{}]?//.*")) {
								annoLine++;
							}else if(line.trim().startsWith("/*")) {
								annoLine++;
								flag = true; //��ָʾ����Ϊ�棬��ʾע�Ϳ鿪ʼ
								
							}
								
						}else if(line.trim().indexOf("*/") != -1){
							//˵���ڱ���ע�Ϳ������ָʾ����Ϊ��
							flag = false;
							int annoEnd = line.trim().indexOf("*/");//��ȡע�Ϳ����λ��
							//�ж�ע�Ϳ���������Ƿ��ж���һ���ַ�
							if(line.trim().length() == annoEnd+2) {
								annoLine ++;
								//ע�Ϳ�����������ַ�������Ϊע���У�ע����+1
							}else if(line.trim().length() > annoEnd+2){
								//�ж϶����ַ��Ƿ񳬹�1��������Ϊ�����У���������Ϊע����
								if(line.trim().length() - (annoEnd+2) == 1)
									//ֻ����һ���ַ���Ϊע����
									annoLine ++;
								else {}
									//�����ַ�����1��Ϊ�����У�������
									
							}
						}else {
							//��ע�Ϳ��ڣ�ע����+1
							annoLine++;
						}
					
					}
					codeLine = allLine - annoLine - blankLine;//���˿��С�ע���У�����Ϊ������
					System.out.println("��������"+blankLine);
					System.out.println("����������"+codeLine);
					System.out.println("ע��������"+annoLine);
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
