package test;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class demoTest extends testDemo{
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

	/**
	 * 测试方法：文件内容转换成byte数组
	 */
	public void testFile2buf() {
		System.out.println("// first test method code:file2buf");
		demo d = new demo();
		
		File file = new File(System.getProperty("user.dir") + "Dog.java");
		System.out.println("file:" + file.toString());
		byte[] bytes = null;
		try {
			bytes = d.file2buf(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertNotNull(bytes);
		System.out.println("buf:" + bytes);
	}

	/**
	 * 测试方法：整数转换为16进制的字符
	 */
	public void testIntToHex() {
		System.out.println("// second test method code:intToHex");
		demo d = new demo();
		
		int numInt = 29;
		System.out.println("int:" + numInt);
		StringBuilder s = d.intToHex(numInt);
		
		Assert.assertEquals("1D", s.toString());
		System.out.println("hex:" + s);
	}
}
