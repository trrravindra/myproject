package com.lcl.erefill.core.common.entity;


public interface IDataCarrier {
	
	public void addObject (String identifier_, Object object_) throws Exception; 
	public void removeObject (String identifier_) throws Exception; 
	public Object getObject (String identifier_) throws Exception;
	public void reset ();
		
	}


