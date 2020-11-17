package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 字符流
 * 由于读写文本数据在实际开发中非常常见，因此java推出了一系列
 * 用于读写文本数据的流，并给他们单独分类为字符流。
 * 字符流是以字符为单位读写数据的，所以字符流只适合读写文本数据。
 * 
 * java.io.Reader 所有字符输入流的超类，规定了读取字符的相关方法
 * java.io.Writer 所有字符输出流的超类。
 * 
 * 字符流底层实际还是读写字节，只是字符与字节的转换工作有字符流
 * 自行完成了。
 * 
 * 
 * 转换流，转换流是常见的字符流实现类，是一对高级流，实际开发中
 * 我们通常不会把它们作为终端流使用，但是他们在流连接中起到重要
 * 的一环。
 * 
 * 终端流就是流连接完成后，我们实际操作的流。
 * 
 * 
 * 转换流是唯一一个可以直接连接在字节流上的字符流。
 * 而其他字符流都要求只能连接在字符流上，这会导致
 * 这些字符流在作为终端流使用时不能直接串联底下的某些
 * 字节流，因此转换流在这里就有非常重要的作用了，我们
 * 通常使用它们来衔接字符流与字节流使用，起到"转换器"
 * 的作用。
 * 
 * 
 * 
 * @author ta
 *
 */
public class OSWDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 利用字符流向文件中写入文本数据
		 */
		FileOutputStream fos
			= new FileOutputStream("osw.txt");
		
		OutputStreamWriter osw
			= new OutputStreamWriter(fos,"UTF-8");
		
		osw.write("摩擦，摩擦~是魔鬼的步伐~");
		osw.write("在光滑的马路牙子上打出溜滑~");
		
		System.out.println("写出完毕!");
		osw.close();
		
	}
}











