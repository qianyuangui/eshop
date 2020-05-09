package com.eshop.util.myaop.dao;

import org.springframework.stereotype.Repository;

/**
 * 
 */
@Repository
public class IndexDao {

	public void query() {
		System.out.println("query111");
	}

	public void query2(){
        System.out.println("aaaaaaaaaaaaaa");
    }
}
