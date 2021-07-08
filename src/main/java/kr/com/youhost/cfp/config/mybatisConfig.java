package kr.com.youhost.cfp.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/application.yaml")
public class mybatisConfig {

        private final Logger logger = LoggerFactory.getLogger(this.getClass());

        private final ApplicationContext applicationContext;

        @Autowired
        public mybatisConfig(ApplicationContext applicationContext) {
            this.applicationContext = applicationContext;
        }


        @Bean
        @ConfigurationProperties(prefix = "spring.datasource.hikari")
        public HikariConfig hikariConfig() {
            return new HikariConfig();
        }

        @Bean
        public DataSource dataSource() {
            DataSource dataSource = new HikariDataSource(hikariConfig());
            return dataSource;
        }

        @Bean
        public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/sqlmap/user/*.xml"));
            return sqlSessionFactoryBean.getObject();
        }

        @Bean
        public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
            return new SqlSessionTemplate(sqlSessionFactory);
        }

}
