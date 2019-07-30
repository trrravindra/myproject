package com.lcl.erefill.core.common.entity;

import java.util.HashMap;

public class DataCarrier implements IDataCarrier {

	/**
	 * Object holder
	 */
	private HashMap<Object, Object> objects = null;

	public DataCarrier() {
		super();
	}

	public void addObject(String identifier_, Object object_) throws Exception {

		try {
			if (null == identifier_) {
				throw new Exception("NULL OBJECT");
			}
			if (null == objects) {
				objects = new HashMap<Object, Object>();
			}
			objects.put(identifier_, object_);
		}// try
		catch (Exception e) {
			throw e;
		} finally {

		}

	}

	public void removeObject(String identifier_) throws Exception {
		try {
			if (null == identifier_) {
				throw new Exception("NULL OBJECT");
			}
			if (null == objects) {
				return;
			}
			objects.remove(identifier_);
		} catch (Exception e) {
			throw e;
		} finally {

		}
	}

	public Object getObject(String identifier_) throws Exception {
		try {
			if (null == objects) {
				return null;
			} else {
				if (null == identifier_) {
					throw new Exception("NULL_OBJECT");
				} else {
					Object o = objects.get(identifier_);
					return o;
				}
			}
		}// try
		catch (Exception e) {
			throw e;
		} finally {

		}

	}

	public void reset() {

		objects = null;

	}
}
