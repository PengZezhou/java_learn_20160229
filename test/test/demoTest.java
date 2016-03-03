package test;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class demoTest extends testDemo{
	
	// 日志记录对象
	private Logger log = Global.getInstance().LOG;
	// 待测试对象
	private demo d = new demo();
	
	/**
	 * 测试方法：文件内容转换成byte数组
	 */
	public void testFile2buf() {
		log.log(Level.INFO, "File2buf> 调试开始");
		File file = null;

		log.log(Level.INFO, "测试用例1");
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
	 * @param file
	 *            文件对象
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
	public void testIntToHex() {
		System.out.println("// second test method code:intToHex");
		demo d = new demo();
		
		int numInt = 29;
		System.out.println("int:" + numInt);
		String s = d.intToHex(numInt);
		
		Assert.assertEquals("1D", s.toString());
		System.out.println("hex:" + s);
	}
	
	/**
	 * 测试方法：返回树tree的第n层的所有节点值，并且输出顺序为从左到右
	 */
	public void testTreeLevel() {
		System.out.println("// third test method code: TreeLevel");
		demo d = new demo();
		
		TNode[] t = new TNode[16];
		for(int i=0;i<16;i++){
			t[i] = new TNode();
			t[i].value = Integer.toString(i);
		}
		
		t[0].left = t[1];//				                0
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
		t[7].left = t[15];
		
		int tmp = d.TreeLevel(t[0],3);
		System.out.println();
		Assert.assertEquals(8, tmp);
	}

}
