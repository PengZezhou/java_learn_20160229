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
		//extracted1();

		// second test method code
		//extracted2();
		
		// third test method code
		//extracted3();
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
	public byte[] file2buf(File fobj) throws IOException {
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
	public StringBuilder intToHex(int n) {
		StringBuilder str = new StringBuilder(); // 待返回值
		char[] c = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' }; 
		// 16进制字符集判断负数的场合
		if (n < 0) {
			str.append('-');
		}
		int num = Math.abs(n); // 保存10进制数的绝对值
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
	public int TreeLevel(TNode tree, int n){
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
