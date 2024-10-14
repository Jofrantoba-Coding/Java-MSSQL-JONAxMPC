/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jofrantoba.model.jpa.psf.connection;

import java.util.Properties;
import org.hibernate.cfg.Environment;

/**
 *
 * @author apoyo1953
 */
public class ConnectionPropertiesSqlServer extends AbstractConnectionProperties{
    
    public ConnectionPropertiesSqlServer(
            String host,
            int port,
            String nameDatabase,
            String userDatabase,
            String passwordDatabase){
        super.setHost(host);
        super.setPort(port);
        super.setNameDatabase(nameDatabase);
        super.setUserDatabase(userDatabase);
        super.setPasswordDatabase(passwordDatabase);    
        super.setDriver(ProviderDatabase.SQLSERVER.getDriver());
        super.setProviderDatabase(ProviderDatabase.SQLSERVER.getNameProvider());
        super.setUrlConnection("jdbc:sqlserver://"+host+":"+port+";databasename="+nameDatabase+";encrypt=true;trustServerCertificate=true;");        
        
    }
    
    @Override
    public Properties getProperties() {
        Properties props=new Properties();                
        props.setProperty("jakarta.persistence.jdbc.driver", super.getDriver());
        props.setProperty("jakarta.persistence.jdbc.url", super.getUrlConnection());
        props.setProperty("jakarta.persistence.jdbc.user", super.getUserDatabase());        
        props.setProperty("jakarta.persistence.jdbc.password", super.getPasswordDatabase());                                    
        //props.setProperty(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");                 
        props.setProperty(Environment.SHOW_SQL,"true");                 
        props.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");           
        //props.setProperty("hibernate.type_contributors", "com.fasterxml.jackson.datatype.hibernate6.Hibernate6ModuleTypeContributor");
        //props.setProperty("hibernate.connection.release_mode", "after_transaction");
        props.setProperty("hibernate.connection.handling_mode", "delayed_acquisition_and_release_after_transaction");        
        props.setProperty("hibernate.connection.useUnicode", "true");
        props.setProperty("hibernate.connection.charSet", "utf8mb4");
        props.setProperty("hibernate.connection.characterEncoding", "utf8");
        props.setProperty("hibernate.connection.isolation","2");
        props.setProperty("hibernate.connection.provider_class","org.hibernate.connection.C3P0ConnectionProvider");
        props.setProperty("hibernate.c3p0.acquire_increment","5");
        props.setProperty("hibernate.c3p0.idle_test_period","3000");
        props.setProperty("hibernate.c3p0.min_size","5");
        props.setProperty("hibernate.c3p0.max_size","20");
        props.setProperty("hibernate.c3p0.max_statements","50");
        props.setProperty("hibernate.c3p0.timeout","1800");
        props.setProperty("hibernate.c3p0.acquireRetryAttempts","1");
        props.setProperty("hibernate.c3p0.acquireRetryDelay","250");       
        return props;
    }
    
}
