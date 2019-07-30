package com.lcl.erefill.core.utils;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.cache.CacheBuilder;

public class TTLAwareConcurrentMapFactoryBean implements FactoryBean<ConcurrentMap<Object, Object>> {
	
	@Autowired
	private PropertyUtil propertyUtil;


    public ConcurrentMap<Object, Object> getObject() throws Exception {
        return CacheBuilder.newBuilder().expireAfterWrite(propertyUtil.getTtlDuration(), TimeUnit.MINUTES).build().asMap();
    }

    public Class<?> getObjectType() {
        return ConcurrentMap.class;
    }

    public boolean isSingleton() {
        return false;
    }

}
