package cn.zsk.shardingconfigjavaconfig.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author:zsk
 * @CreateTime:2019-10-24 10:36
 */
@Configuration
public class MybatisPlusConfig {
    @Resource
    private DataSource dataSource;

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        //可以通过环境变量获取你的mapper路径,这样mapper扫描可以通过配置文件配置了
        scannerConfigurer.setBasePackage("classpath*:mapper/**/*.xml");
        return scannerConfigurer;
    }

////    @Bean(name = "sqlSessionFactory")
////    private SqlSessionFactory sqlSessionFactoryBean() {
////        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
////        bean.setDataSource(dataSource);
////        try {
////            return bean.getObject();
////        } catch (Exception e) {
////            e.printStackTrace();
////            throw new RuntimeException(e);
////        }
////    }
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate() {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }

    /**
     * 分页
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * SQL执行效率插件 生产环境建议删除
     * 设置 dev test 环境开启
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }




}
