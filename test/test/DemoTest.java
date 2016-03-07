package test;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class DemoTest {

	// 日志记录对象
	private static final Logger log = Logger.getLogger(Demo.class.getName());
	// 待测试对象
	private static final Demo demo = new Demo();

	/**
	 * 测试方法：文件内容转换成byte数组
	 */
	@Test
	public void testFile2buf() {
		File file = null;

		file = new File(System.getProperty("user.dir")
				+ "\\test\\test\\file.txt");
		Assert.assertNotNull(start2Buf(file));

		file = new File(System.getProperty("user.dir") + "\\test\\test");
		Assert.assertNull(start2Buf(file));

		file = new File(System.getProperty("user.dir")
				+ "\\test\\test\\filetmp.txt");
		Assert.assertNull(start2Buf(file));

		file = null;
		Assert.assertNull(start2Buf(file));

		file = new File("D:\\MicrosoftVisualStudio2008Professional.ISO");
		Assert.assertNull(start2Buf(file));
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
			bytes = demo.file2buf(file);
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
		Assert.assertEquals("0X0936H", demo.intToHex(2358));

		Assert.assertEquals("0X0H", demo.intToHex(0));

		Assert.assertEquals("0X7FFFFFFFH", demo.intToHex(Integer.MAX_VALUE));

		Assert.assertEquals(null, demo.intToHex(Integer.MIN_VALUE));
	}

	/**
	 * 测试方法：返回树tree的第n层的所有节点值，并且输出顺序为从左到右
	 */
	@Test
	public void testTreeLevel() {
		TNode root = createTree();

		testCaseTree1(root);

		root = null;
		testCaseTree1(root);

		root = createTree();
		testCaseTree2(root, -1);

		root = createTree();
		testCaseTree2(root, Integer.MAX_VALUE);

		root = createTree();
		testCaseTree2(root, Integer.MIN_VALUE);
	}

	/**
	 * 创建4层完全二叉树
	 * <p>
	 * 0 / \ 1 2 / \ / \ 3 4 5 6 / \ / \ / \ / \ 7 8 9 10 11 12 13 14 / 15
	 * 
	 * @return 树根节点
	 */
	private TNode createTree() {
		TNode[] t = new TNode[16];
		for (int i = 0; i < 16; i++) {
			t[i] = new TNode();
			t[i].setValue(Integer.toString(i));
		}

		t[0].setLeft(t[1]);
		t[0].setRight(t[2]);
		t[1].setLeft(t[3]);
		t[1].setRight(t[4]);
		t[2].setLeft(t[5]);
		t[2].setRight(t[6]);
		t[3].setLeft(t[7]);
		t[3].setRight(t[8]);
		t[4].setLeft(t[9]);
		t[4].setRight(t[10]);
		t[5].setLeft(t[11]);
		t[5].setRight(t[12]);
		t[6].setLeft(t[13]);
		t[6].setRight(t[14]);
		t[7].setLeft(t[15]);

		return t[0];
	}

	/**
	 * 二叉树层节点查找测试用例逻辑1
	 * 
	 * @param root
	 *            根节点
	 */
	private void testCaseTree1(TNode root) {
		List<TNode> nodelist = null;
		for (int i = 1; i <= 5; i++) {
			nodelist = demo.treeLevel(root, i);
			if (nodelist == null) {
				return;
			}
			int start = (int) Math.pow(2, i - 1) - 1;
			int end = (int) (Math.pow(2, i - 1) - 1) * 2;
			int max = Integer.valueOf(nodelist.get(nodelist.size() - 1)
					.getValue());
			for (int j = start; j <= end && j <= max; j++) {
				Assert.assertEquals(String.valueOf(j),
						nodelist.get(j - (int) Math.pow(2, i - 1) + 1)
								.getValue());
			}
		}
	}

	/**
	 * 二叉树层节点查找测试用例逻辑2
	 * 
	 * @param root
	 *            树根节点
	 */
	private void testCaseTree2(TNode root, int n) {
		List<TNode> nodelist = null;
		nodelist = demo.treeLevel(root, n);
		Assert.assertEquals(null, nodelist);
	}
}
