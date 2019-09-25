package com.rgproject.wc;
/**
 *  WordCount程序使用说明
 * @author Visional
 *
 */
public class Help {
	Help(){
		System.out.println("本程序可通过“wc.exe [parameter] [file_name]”的命令模式实现不同功能");
		System.out.println("其中[file_name]代表文件的完整路径，[parameter]是代表功能选择的参数，");
		System.out.println("-c：统计源程序字符数（包括空格符换行符制表符等各种字符）");
		System.out.println("-w：统计源程序单词数");
		System.out.println("-l：统计源程序行数");
		System.out.println("-a：统计源程序的特殊行数（包括空行，注释行，代码行）");
		System.out.println("-x：提供交互的图形界面，无需后接文件名");
		System.out.println("-s：递归统计目录内所有符合条件的文件信息");
		
		System.out.println();
		System.out.println("特别说明：");
		System.out.println("-a：本程序统计特殊行数信息时，有如下默认规定");
		System.out.println("空行：本行全部是空格或格式控制字符，如果包括代码，则只有不超过一个可显示的字符，例如“{”。");
		System.out.println("代码行：本行包括多于一个字符的代码。");
		System.out.println("注释行：本行不是代码行，并且本行包括注释。");
		System.out.println("例如， “} //注释” 或是 “{//” 、 “}/* ... ”这一类的也属于注释行范围");
		System.out.println("使用本程序的源程序文件，注释块须至少包括两行，非代码行使用了“/*...*/”将被记为代码行");
		
		System.out.println();
		System.out.println("-s:使用时命令模式为wc.exe -s [parameter] [file_name]");
		System.out.println("-------------------------------");
	}
}
