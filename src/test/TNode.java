package test;

/**
 * 节点定义
 * @author Peng.Zezhou
 *
 */
public class TNode {
	private String value;
	private TNode left, right;

	public final String getValue() {
		return value;
	}

	public final void setValue(String value) {
		this.value = value;
	}

	public final TNode getLeft() {
		return left;
	}

	public final void setLeft(TNode left) {
		this.left = left;
	}

	public final TNode getRight() {
		return right;
	}

	public final void setRight(TNode right) {
		this.right = right;
	}
}
