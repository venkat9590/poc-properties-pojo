package com.perfaware.sourcing.persistence.config;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PlainTextAuthProvider;
import com.datastax.driver.core.QueryLogger;
import com.datastax.driver.core.SocketOptions;
import com.perfaware.sourcing.config.CassandraConfig;

import com.perfaware.sourcing.config.DistanceConfig;
import com.perfaware.sourcing.config.Criteria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import javax.annotation.PostConstruct;

@Configuration
@EnableCassandraRepositories(basePackages = { "com.perfaware.sourcing.persistence.repository" })
@PropertySource("classpath:cassandra-${spring.profiles.active}.properties")
public class CassandraConfiguration extends AbstractCassandraConfiguration {

	private CassandraConfig cassandraConfig;

	@Autowired
	public CassandraConfiguration(CassandraConfig cassandraConfig, Criteria criteria, DistanceConfig distanceConfig) {
		this.cassandraConfig = cassandraConfig;

		contactPoints = cassandraConfig.getContactpoints();
		port = Integer.parseInt(cassandraConfig.getPort());
		username = cassandraConfig.getUsername();
		password = cassandraConfig.getPassword();
		keyspace = cassandraConfig.getKeyspace();
	}

	private static final Logger logger = LoggerFactory.getLogger(CassandraConfiguration.class);

	// @Value("${cassandra.contactpoints}")

	private String contactPoints;

	// @Value("${cassandra.port}")
	private int port;

	// @Value("${cassandra.username}")
	private String username;

	// @Value("${cassandra.password}")
	private String password;

	// @Value("${cassandra.keyspace}")
	private String keyspace;

	/*
	 * @Value("${cassandra.basePackages}") private String basePackages;
	 */
	// @Value("${cassandra.nodecount}")
	private int nodecount = 1;

	@PostConstruct
	public void init() {
		logger.info("CASSANDRA CONFIGURATION FOR CAPACITY MICROSERVICE INITIALIZING");
	}

	@Bean
	@Override
	public CassandraClusterFactoryBean cluster() {

		if (logger.isInfoEnabled()) {
			logger.info("CassandraClusterFactoryBean - Connecting to cluster contact points {} | port : {} with "
					+ "username {}", contactPoints, port, username);
		}

		CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
		PlainTextAuthProvider auth = new PlainTextAuthProvider(username, password);
		cluster.setContactPoints(contactPoints);
		cluster.setPort(port);
		cluster.setAuthProvider(auth);
		cluster.setSocketOptions(new SocketOptions().setConnectTimeoutMillis(60000).setReadTimeoutMillis(0));
		cluster.setJmxReportingEnabled(false);
		cluster.setMetricsEnabled(false);

		return cluster;
	}

	@Bean
	public QueryLogger queryLogger(Cluster cluster) {
		QueryLogger queryLogger = QueryLogger.builder().withMaxParameterValueLength(100).build();
		cluster.register(queryLogger);

		return queryLogger;
	}

	@Override
	protected String getKeyspaceName() {
		return keyspace;
	}
}
