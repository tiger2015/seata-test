package com.tiger.seata.stock.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author Zenghu
 * @Date 2023年12月24日 22:15
 * @Description
 * @Version: 1.0
 **/
@Configuration
//@ConditionalOnClass(DruidDataSource.class)
//@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DataSourceProxyConfig {


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean
    @Primary
    public DataSource dataSourceProxy(DruidDataSource dataSource) {
        return new DataSourceProxy(dataSource);
    }

//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean(DataSourceProxy dataSourceProxy) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSourceProxy);
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/*.xml"));
//        return sqlSessionFactoryBean.getObject();
//    }
}
