package test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 全局对象，单例
 * @author Peng.Zezhou
 *
 */
public class Global {
	
	public Logger LOG = null;	// 全局日志对象
	
	private static Global instance = null;
	
	private Global(){
	}
	
	public static Global getInstance(){
		if(instance==null){
			instance = new Global();
			instance.LOG = Logger.getLogger("debug");
			instance.LOG.setLevel(Level.ALL);
		}
		return instance;
	}
}
