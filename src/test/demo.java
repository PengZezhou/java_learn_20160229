package test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 练习题，代码实现
 * @author Peng.Zezhou
 *
 */
public class demo {

	/**
	 * 测试函数入口
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// first test method code
		extracted1();

		// second test method code
		extracted2();
		
		// third test method code
		extracted3();
	}

	/**
	 * 测试方法：返回树tree的第n层的所有节点值，并且输出顺序为从左到右
	 */
	private static void extracted3() {
		TNode[] t = new TNode[16];
		for(int i=0;i<16;i++){
			t[i] = new TNode();
			t[i].value = Integer.toString(i);
		}
		
		t[0].left = t[1];//				0
		t[0].right = t[2];//		              /   \	
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
		
		TreeLevel(t[0],3);
	}

	/**
	 * 测试方法：文件内容转换成byte数组
	 * 
	 * @throws IOException
	 */
	private static void extracted1() throws IOException {
		System.out.println("// first test method code:file2buf");

		File file = new File(System.getProperty("user.dir") + "Dog.java");
		System.out.println("file:" + file.toString());
		byte[] bytes = file2buf(file);

		System.out.println("buf:" + bytes);
	}

	/**
	 * 测试方法：整数转换为16进制的字符
	 */
	private static void extracted2() {
		System.out.println("// second test method code:intToHex");

		int numInt = 16;
		System.out.println("int:" + numInt);
		StringBuilder s = intToHex(numInt);
		System.out.println("hex:" + s);
	}

	/**
	 * 将文件内容转换成byte数组返回,如果文件不存在或者读入错误返回null
	 * 
	 * @param 文件对象
	 * @return byte数组
	 * @throws IOException
	 *             文件输入输出流异常
	 * 
	 */
	public static byte[] file2buf(File fobj) throws IOException {
		BufferedOutputStream bos = null; // 新建一个输出流
		FileOutputStream fos = null; // 文件包装输出流
		byte[] bytes = null; // 字节数组

		try {
			bytes = new byte[(int) fobj.length()];
			fos = new FileOutputStream(fobj);
			bos = new BufferedOutputStream(fos);
			// 流内容写入字节数组
			bos.write(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return bytes;
	}

	/**
	 * 将一个整数转换为16进制的字符串
	 * 
	 * @param 一个整数
	 * @return 16进制的字符串
	 */
	public static StringBuilder intToHex(int n) {
		StringBuilder str = new StringBuilder(); // 待返回值
		char[] c = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' }; // 16进制字符集
		int num = n; // 保存10进制数
		// int to hex转换逻辑
		while (true) {
			str.append(c[num / 16]);
			num %= 16;
			if (num < 16) {
				str.append(c[num]);
				break;
			}
		}
		return str;
	}
	
	/**
	 * 返回树tree的第n层的所有节点值，并且输出顺序为从左到右
	 * @param tree 树顶层节点
	 * @param n 层数
	 * @return 最左侧节点
	 */
	public static int TreeLevel(TNode tree, int n){
	    if (tree==null || n < 0)  
	        return 0;  
	    if (0 == n) {  
	    	System.out.print(tree.value+"  ");  
	        return 1;  
	    }  
	    return TreeLevel(tree.left, n - 1) + TreeLevel(tree.right, n - 1); 
	}
}

/**
 * 节点定义
 * @author Peng.Zezhou
 *
 */
class TNode  {
    String    value;
    TNode   left,right;
}
