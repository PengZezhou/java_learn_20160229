package test;

import java.io.File;
import java.io.UnsupportedEncodingException;
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
	 * 
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testFile2buf() throws UnsupportedEncodingException {
		File file = null;

		file = new File(System.getProperty("user.dir")
				+ "\\test\\test\\file.txt");
		String str = "it is a test for file2buf .";
		Assert.assertEquals(str, new String(start2Buf(file), "UTF-8"));

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
			log.log(Level.WARNING, e.toString());
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
		TNode root = createTree1();

		testTreeCase1(root);

		root = null;
		testTreeCase1(root);

		root = createTree1();
		testTreeCase2(root, -1);

		root = createTree1();
		testTreeCase2(root, Integer.MAX_VALUE);

		root = createTree1();
		testTreeCase2(root, Integer.MIN_VALUE);

		root = createTree2();
		testTreeCase3(root, 1);

		testTreeCase3(root, -1);

		testTreeCase3(root, Integer.MAX_VALUE);

		testTreeCase3(root, Integer.MIN_VALUE);

		root = null;
		testTreeCase3(root, 1);
	}

	/**
	 * 创建4层完全二叉树
	 * <p>
	 * 0 / \ 1 2 / \ / \ 3 4 5 6 / \ / \ / \ / \ 7 8 9 10 11 12 13 14 / 15
	 * 
	 * @return 树根节点
	 */
	private TNode createTree1() {
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
	private void testTreeCase1(TNode root) {
		List<TNode> nodelist = null;
		for (int i = 1; i <= 5; i++) {
			nodelist = demo.treeLevel(root, i);
			if (0 == nodelist.size()) {
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
	private void testTreeCase2(TNode root, int n) {
		List<TNode> nodelist = null;
		nodelist = demo.treeLevel(root, n);
		Assert.assertEquals(0, nodelist.size());
	}

	/**
	 * 非完全二叉树的创建
	 * <p>
	 * <CODE>
	 * TNode root = createTree2();
	 * </CODE>
	 * 
	 * @return 根节点
	 */
	private TNode createTree2() {
		TNode[] t = new TNode[10];
		for (int i = 0; i < 10; i++) {
			t[i] = new TNode();
			t[i].setValue(Integer.toString(i));
		}

		t[0].setLeft(t[1]);
		t[0].setRight(t[2]);
		t[1].setLeft(t[3]);
		t[2].setLeft(t[4]);
		t[2].setRight(t[5]);
		t[3].setLeft(t[6]);
		t[4].setLeft(t[7]);
		t[4].setRight(t[8]);
		t[5].setRight(t[9]);

		return t[0];
	}

	/**
	 * 非完全二叉树测试用例
	 * 
	 * @param root
	 *            根节点
	 * @param n
	 *            层数
	 */
	private void testTreeCase3(TNode root, int n) {
		List<TNode> nodelist = null;
		nodelist = demo.treeLevel(root, n);
		if (n < 1 || n > 4 || root == null) {
			Assert.assertEquals(0, nodelist.size());
			return;
		}
		for (int i = 1; i <= 4; i++) {
			nodelist = demo.treeLevel(root, i);
			switch (i) {
			case 1:
				Assert.assertEquals("0", nodelist.get(0).getValue());
				break;
			case 2:
				Assert.assertEquals("1", nodelist.get(0).getValue());
				Assert.assertEquals("2", nodelist.get(1).getValue());
				break;
			case 3:
				Assert.assertEquals("3", nodelist.get(0).getValue());
				Assert.assertEquals("4", nodelist.get(1).getValue());
				Assert.assertEquals("5", nodelist.get(2).getValue());
				break;
			case 4:
				Assert.assertEquals("6", nodelist.get(0).getValue());
				Assert.assertEquals("7", nodelist.get(1).getValue());
				Assert.assertEquals("8", nodelist.get(2).getValue());
				Assert.assertEquals("9", nodelist.get(3).getValue());
				break;
			default:
				break;
			}
		}
	}
}
