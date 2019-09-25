package com.rgproject.wc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 	wc���࣬��ϵ���������������
 * @author Visional
 *
 */
public class WordCount {
	static List<File> fileList = new ArrayList<>(); //���ڴ��Ŀ¼�µ������ļ�,���еݹ鹦��ʱ����
	static boolean checkBox0 = false; //�����������������ȷ��ͼ�ν����ѡ���״̬
	static boolean checkBox1 = false;
	static boolean checkBox2 = false;
	static boolean checkBox3 = false;
	static boolean checkBox4 = false;
	static int cnum = 0; //������ͼ�ν��洫�����������Ϣ��ͳ�����
	static int wnum = 0;
	static int lnum = 0;
	static int cdnum = 0;
	static int bknum = 0;
	static int annum = 0;
	public static void main(String[] args) {
		System.out.println("##һ���򵥵�Դ��������ͳ�Ƴ���##");
		System.out.println("1.����help�ɲ鿴ʹ��˵��");
		System.out.println("2.����exit���˳�������");
		System.out.println("-------------------------------");
		while(true) {
			//ѭ����ȡ�������벢ִ����Ӧ���ܣ�ֱ���˳�Ϊֹ
			Scanner sc = new Scanner(System.in); //��ȡ��������
			String str1 = sc.nextLine();
			
			if(str1.equals("exit"))
				System.exit(0);
			
			if(str1.equals("help")) {
				new Help();
				continue;
			}
			
			String[] str2 = str1.split(" "); //�������еĿո�Ϊ�ָ������û����������ָ��
			for(String str : str2) {
				//����û�����������Ƿ������-x�����������У���ֱ�ӵ�ȡͼ�ν���
				if(str.equals("-x")) {
					//��ȡͼ�ν���
					
				}
			}
			
			
			if(str2[1].equals("-s")) {
				//����һ����������-s����ֱ�ӵ�����չ���ܽ��еݹ鴦��
				String fileName = str2[3].substring(str2[3].lastIndexOf("/")+1); //ȡ��ĩβ���ļ���Ŀ¼��
				String fileParent = str2[3].substring(0, str2[3].lastIndexOf("/")); //ȡ����ǰ��Ŀ¼
				switch(str2[2]) {
				case "-c":
					if((fileName.indexOf("*") != -1) || (fileName.indexOf("?") != -1)) {
						//�ļ�·������ͨ���������ǰĿ¼�ݹ鴦��������ļ���������ɸѡ
						new ExtendFnc("-s",new File(fileParent));
					    for(File file : fileList) {
					    	String fname = file.getName();
					    	String suffix = fileName.substring(fileName.indexOf("."));//��ȡ�ļ���׺��
					    	if(fname.matches(".+"+suffix)){
					    		//�Է����������ļ������ַ���ͳ�� -c
					    		System.out.println(file.getPath());
					    		new BasicFnc("-c",file);
					    	}
					    }
					    System.out.println("-------------------------------");
					}else {
						File file = new File(str2[3]);
						if(file.isFile())
							//����·��Ϊ�ļ���ֱ��ͳ��
							new BasicFnc("-c",file);
						else {
							new ExtendFnc("-s",file);//������ͨ�����·��ΪĿ¼���ݹ鱣��Ŀ¼�������ļ�
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
						//�ļ�·������ͨ���������ǰĿ¼�ݹ鴦��������ļ���������ɸѡ
						new ExtendFnc("-s",new File(fileParent));
					    for(File file : fileList) {
					    	String fname = file.getName();
					    	String suffix = fileName.substring(fileName.indexOf("."));//��ȡ�ļ���׺��
					    	if(fname.matches(".+"+suffix)){
					    		//�Է����������ļ������ַ���ͳ�� -w
					    		System.out.println(file.getPath());
					    		new BasicFnc("-w",file);
					    	}
					    }
					    System.out.println("-------------------------------");
					}else {
						File file = new File(str2[3]);
						if(file.isFile())
							//����·��Ϊ�ļ���ֱ��ͳ��
							new BasicFnc("-w",file);
						else {
							new ExtendFnc("-s",file);//������ͨ�����·��ΪĿ¼���ݹ鱣��Ŀ¼�������ļ�
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
						//�ļ�·������ͨ���������ǰĿ¼�ݹ鴦��������ļ���������ɸѡ
						new ExtendFnc("-s",new File(fileParent));
					    for(File file : fileList) {
					    	String fname = file.getName();
					    	String suffix = fileName.substring(fileName.indexOf("."));//��ȡ�ļ���׺��
					    	if(fname.matches(".+"+suffix)){
					    		//�Է����������ļ������ַ���ͳ�� -l
					    		System.out.println(file.getPath());
					    		new BasicFnc("-l",file);
					    	}
					    }
					    System.out.println("-------------------------------");
					}else {
						File file = new File(str2[3]);
						if(file.isFile())
							//����·��Ϊ�ļ���ֱ��ͳ��
							new BasicFnc("-l",file);
						else {
							new ExtendFnc("-s",file);//������ͨ�����·��ΪĿ¼���ݹ鱣��Ŀ¼�������ļ�
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
						//�ļ�·������ͨ���������ǰĿ¼�ݹ鴦��������ļ���������ɸѡ
						new ExtendFnc("-s",new File(fileParent));
					    for(File file : fileList) {
					    	String fname = file.getName();
					    	String suffix = fileName.substring(fileName.indexOf("."));//��ȡ�ļ���׺��
					    	if(fname.matches(".+"+suffix)){
					    		//�Է����������ļ������ַ���ͳ�� -a
					    		System.out.println(file.getPath());
					    		new ExtendFnc("-a",file);
					    	}
					    }
					    System.out.println("-------------------------------");
					}else {
						File file = new File(str2[3]);
						if(file.isFile())
							//����·��Ϊ�ļ���ֱ��ͳ��
							new BasicFnc("-a",file);
						else {
							new ExtendFnc("-s",file);//������ͨ�����·��ΪĿ¼���ݹ鱣��Ŀ¼�������ļ�
							for(File file1 : fileList) {
								System.out.println(file1.getPath());
								new ExtendFnc("-a",file1);
							}
						}
						System.out.println("-------------------------------");
					}
					break;
				default:
					System.out.println("�밴��ȷ��ʽ���룬�����������help�鿴����Ŷ~");
					System.out.println("-------------------------------");
				}
				
				
			}else if(str2[1].equals("-c")) {
				
				System.out.println(str2[2]);
				new BasicFnc("-c",new File(str2[2]));
				System.out.println("-------------------------------");
				//���û���������ʵ�֡�-c����������
				
			}else if(str2[1].equals("-w")) {
				
				System.out.println(str2[2]);
				new BasicFnc("-w",new File(str2[2]));
				System.out.println("-------------------------------");
				//���û���������ʵ�֡�-w����������
				
			}else if(str2[1].equals("-l")) {
				
				System.out.println(str2[2]);
				new BasicFnc("-l",new File(str2[2]));
				System.out.println("-------------------------------");
				//���û���������ʵ�֡�-l����������
				
			}else if(str2[1].equals("-a")) {
				
				System.out.println(str2[2]);
				new ExtendFnc("-a",new File(str2[2]));
				System.out.println("-------------------------------");
				//������չ������ʵ�֡�-a����������
				
			}else {
				
				System.out.println("�밴��ȷ��ʽ���룬�����������help�鿴����Ŷ~");
				System.out.println("-------------------------------");
				
			}
			fileList.clear();
		}
	}
}
