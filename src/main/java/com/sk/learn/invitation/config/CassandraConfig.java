package com.sk.learn.invitation.config;

import org.springframework.cassandra.config.PoolingOptionsFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.convert.CassandraConverter;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.mapping.SimpleUserTypeResolver;


/**
 * Created by skumar47 on 1/12/2017.
 */

@Configuration
@ComponentScan(basePackages = "com.sk.learn")
public class CassandraConfig {

    /**
     * Create cluster bean.
     * @return cluster.
     * @throws Exception throw exception if any.
     */
    @Bean
    public CassandraClusterFactoryBean cluster() throws Exception {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints("localhost");
        cluster.setPort(9042);
        cluster.setPoolingOptions(poolingOptions().getObject());
        return cluster;
    }

    /**
     * Create pooling options.
     * @return PoolingOptionsFactoryBean pooling options bean.
     * @throws Exception throw exception if any.
     */
    @Bean
    public PoolingOptionsFactoryBean poolingOptions() throws Exception {
        PoolingOptionsFactoryBean poolingOptionsFactoryBean = new PoolingOptionsFactoryBean();
        poolingOptionsFactoryBean.setLocalCoreConnections(1);
        poolingOptionsFactoryBean.setLocalMaxConnections(8);
        poolingOptionsFactoryBean.setLocalMaxSimultaneousRequests(64);
        poolingOptionsFactoryBean.setLocalMinSimultaneousRequests(1);
        return poolingOptionsFactoryBean;
    }

    /**
     * create mapping context.
     * @return mapping context
     * @throws Exception throw exception if any.
     */
    @Bean
    public CassandraMappingContext mappingContext() throws Exception {
        BasicCassandraMappingContext mappingContext = new BasicCassandraMappingContext();
        mappingContext.setUserTypeResolver(new SimpleUserTypeResolver(
                cluster().getObject(), "springcassandra"));
        return mappingContext;
    }

    /**
     * create cassandra converter.
     * @return CassandraConverter mapping cassandra converter.
     * @throws Exception throw exception if any.
     */
    @Bean
    public CassandraConverter converter() throws Exception {
        return new MappingCassandraConverter(mappingContext());
    }

    /**
     * create session.
     * @return CassandraSessionFactoryBean session.
     * @throws Exception throw exception if any.
     */
    @Bean
    public CassandraSessionFactoryBean session() throws Exception {
        CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
        session.setCluster(cluster().getObject());
        session.setKeyspaceName("springcassandra");
        session.setConverter(converter());
        session.setSchemaAction(SchemaAction.RECREATE);
        return session;
    }

    /**
     * create Cassandra template.
     * @return CassandraOperations cassandra operations.
     * @throws Exception throw exception if any.
     */
    @Bean
    public CassandraOperations cassandraTemplate() throws Exception {
        return new CassandraTemplate(session().getObject());
    }

}

