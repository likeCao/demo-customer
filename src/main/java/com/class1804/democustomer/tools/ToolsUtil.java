package com.class1804.democustomer.tools;

public class ToolsUtil {

	/**
	 * 验证文件格式是否正确
	 * @param ext 原文件格式
	 * @param validateExt 要验证的格式
	 * @return boolean 是否符合格式要求
	 */
	public static boolean checkExt(String ext, String validateExt) {
		if(validateExt.indexOf(ext) < 0) {
			return false ;
		}
		return true ;
	}
}
