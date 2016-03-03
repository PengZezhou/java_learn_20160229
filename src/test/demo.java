package test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 练习题，代码实现
 * @author Peng.Zezhou
 *
 */
public class demo {

	// 日志记录对象
	private Logger log = Global.getInstance().LOG;

	// 16进制字符数组
	private static char[] HEX_CHARS = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	/**
	 * 将文件内容转换成byte数组返回,如果文件不存在、读入错误、文件大小超过2G则返回null
	 * 
	 * <pre>
	 * byte[] b = file2buf(new File(&quot;D:\tmp.txt&quot;));
	 * </pre>
	 * 
	 * @param 文件对象 File
	 * @return byte数组
	 * @throws IOException
	 *             文件输入输出流异常
	 * 
	 */
	public byte[] file2buf(File fobj) throws IOException {
		if (fobj == null || fobj.isDirectory() || !fobj.exists()
				|| fobj.length() > (1024 * 1024 * 1024 * 2 - 1)) {
			log.log(Level.INFO, "输入参数为null、不是文件、文件不存在或者文件大小超过2G");
			return null;
		}

		log.log(Level.INFO, "文件开始转换为字节数组...");
		FileInputStream fis = null;
		ByteArrayOutputStream bos = null;
		byte[] bytes = null;

		try {
			fis = new FileInputStream(fobj);
			bos = new ByteArrayOutputStream((int) fobj.length());
			byte[] b = new byte[4096];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			bytes = bos.toByteArray();
		} catch (Exception e) {
			log.log(Level.INFO, "文件转换为字节数组出现异常");
		} finally {
			try {
				fis.close();
				bos.close();
			} catch (IOException e) {
				log.log(Level.INFO, "流关闭出现异常");
			}
		}

		log.log(Level.INFO, "文件开始转换为字节数组结束");
		return bytes;
	}

	/**
	 * 将一个整数转换为16进制的字符串
	 * 
	 * <pre>
	 * String s = intToHex(17);
	 * </pre>
	 * @param 一个整数 int
	 * @return String 16进制的字符串
	 */
	public String intToHex(int n) {
		StringBuilder str = new StringBuilder(8); // 待返回值
		// 16进制字符集判断负数的场合
		if (n < 0) {
			str.append('-');
		}
		int num = Math.abs(n); // 保存10进制数的绝对值
		// int to hex转换逻辑
		for(int i=7;i>=0;i--) {
			str.setCharAt(i,HEX_CHARS[num & 15]);
			num >>>= 4;
			if (num == 0) {
				str.setCharAt(i,'0');
			}
		}
		
		return str.toString();
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
