package com.lcl.erefill.core.vo;

import java.util.HashMap;

/**
 * @author vsha51
 */
public class ERefillSession implements ISession {

	private static final long serialVersionUID = -7784082556256755710L;

	private HashMap<String, Object> objects = null;

	/**
	 * addAttribute
	 * 
	 * @param identifier
	 * @param object
	 * @throws Exception
	 */
	public void addAttribute(String identifier, Object object) throws Exception {

		try {
			if (null == identifier) {
				throw new Exception("NULL OBJECT");
			}
			if (null == objects) {
				objects = new HashMap<String, Object>();
			}
			objects.put(identifier, object);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * removeAttribute
	 * 
	 * @param identifier
	 * @throws Exception
	 */
	public void removeAttribute(String identifier) throws Exception {
		if (null == identifier) {
			throw new Exception("NULL OBJECT");
		}
		if (null == objects) {
			return;
		}
		objects.remove(identifier);
	}

	/**
	 * getAttribute
	 * 
	 * @param identifier
	 * @return 
	 * @throws Exception
	 */
	public Object getAttribute(String identifier) throws Exception {
		if (null == objects) {
			return null;
		} else {
			if (null == identifier) {
				throw new Exception("NULL_OBJECT");
			} else {
				Object o = objects.get(identifier);
				return o;
			}
		}
	}

	/**
	 * reset
	 */
	public void reset() {
		objects = null;
	}
}
