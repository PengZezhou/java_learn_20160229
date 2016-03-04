package test;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class DemoTest{
	
	// 日志记录对象
	private Logger log = Logger.getLogger(DemoTest.class.getName());
	// 待测试对象
	private Demo d = new Demo();
	
	/**
	 * 测试方法：文件内容转换成byte数组
	 */
	@Test
	public void testFile2buf() {
		log.log(Level.INFO, "File2buf> 调试开始");
		File file = null;

		log.log(Level.INFO, "测试用例1" );
		file = new File(System.getProperty("user.dir")
				+ "\\test\\test\\file.txt");
		Assert.assertNotNull(start2Buf(file));

		log.log(Level.INFO, "测试用例2");
		file = new File(System.getProperty("user.dir") + "\\test\\test");
		Assert.assertNull(start2Buf(file));

		log.log(Level.INFO, "测试用例3");
		file = new File(System.getProperty("user.dir")
				+ "\\test\\test\\filetmp.txt");
		Assert.assertNull(start2Buf(file));

		log.log(Level.INFO, "测试用例4");
		file = null;
		Assert.assertNull(start2Buf(file));

		log.log(Level.INFO, "测试用例5");
		file = new File("D:\\MicrosoftVisualStudio2008Professional.ISO");
		Assert.assertNull(start2Buf(file));

		log.log(Level.INFO, "File2buf> 调试结束");
	}

	/**
	 * 测试逻辑，检测路径下文件转换为byte数组
	 * 
	 * <pre>
	 * byte[] b = start2Buf(new File("D:\tmp.txt"))
	 * </pre>
	 * 
	 * @param file 文件对象     
	 * @return byte[] byte数组
	 * 
	 */
	private byte[] start2Buf(File file) {
		if (file != null) {
			log.log(Level.INFO, "文件路径：" + file.toString());
		} else {
			log.log(Level.INFO, "文件为null");
		}

		byte[] bytes = null;
		try {
			bytes = d.file2buf(file);
		} catch (Exception e) {
			log.log(Level.WARNING, "转换过程捕获到异常");
		}
		return bytes;
	}

	/**
	 * 测试方法：整数转换为16进制的字符
	 */
	@Test
	public void testIntToHex() {
		log.log(Level.INFO, "IntToHex> 调试开始");

		log.log(Level.INFO, "测试用例1");
		Assert.assertEquals("0X00000936H", d.intToHex(2358));

		log.log(Level.INFO, "测试用例2");
		Assert.assertEquals("0X00000000H", d.intToHex(0));

		log.log(Level.INFO, "测试用例3");
		Assert.assertEquals("0X7FFFFFFFH", d.intToHex(Integer.MAX_VALUE));

		log.log(Level.INFO, "测试用例4");
		Assert.assertEquals(null, d.intToHex(Integer.MIN_VALUE));

		log.log(Level.INFO, "IntToHex> 调试结束");
	}

	/**
	 * 测试方法：返回树tree的第n层的所有节点值，并且输出顺序为从左到右
	 */
	@Test
	public void testTreeLevel() {
		System.out.println("// third test method code: TreeLevel");
//		demo d = new demo();
		
		TNode[] t = new TNode[16];
		for(int i=0;i<16;i++){
			t[i] = new TNode();
			t[i].setValue(Integer.toString(i));
		}
		
/*		t[0].setLeft(t[1]);//				                0
		t[0].right = t[2];//		                  /   \	
		t[1].left = t[3];//                         1       2
		t[1].right = t[4];//                      /  \      /  \
		t[2].left = t[5];//                     3    4     5    6
		t[2].right = t[6];//                   / \  / \   / \   / \  
		t[3].left = t[7];//                   7  8  9  10 11 12 13 14
		t[3].right = t[8];//                 /
		t[4].left = t[9];//                 15
		t[4].right = t[10];
		t[5].left = t[11];
		t[5].right = t[12];
		t[6].left = t[13];
		t[6].right = t[14];
		t[7].left = t[15];*/
		
//		int tmp = d.TreeLevel(t[0],3);
		System.out.println();
//		Assert.assertEquals(8, tmp);
	}

}
