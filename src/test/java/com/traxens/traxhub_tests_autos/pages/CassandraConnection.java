package com.traxens.traxhub_tests_autos.pages;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Cluster.Builder;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class CassandraConnection {
	private Cluster cluster;
	 
    private Session session;
 
    public void connect(String node, Integer port,String username,String password) {
        Builder b = Cluster.builder().addContactPoint(node).withCredentials(username.trim(), password.trim());
        if (port != null) {
            b.withPort(port);
        }
        cluster = b.build();
 
        session = cluster.connect("traxhub_ks");
        
    }
 
    public Session getSession() {
        return this.session;
    }
 
    public void close() {
        session.close();
        cluster.close();
    }
    
    
    public void resetKey() {
    	
    	                     
        
    }
}
