package com.imooc.mybatis;

import com.imooc.entity.Goods;
import com.imooc.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.Reader;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testSqlSessionFactory() throws Exception {
        // 利用Reader加载classpath下的mybatis-config.xml核心配置文件
        // AsReader: 按照字符流的方式进行读取
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        // 初始化sqlSessionFactory对象解析xml文件
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = null;
        try {
            // 创建SqlSession对象,这是JDBC的扩展类,用于与数据库交互
            sqlSession = sqlSessionFactory.openSession();
            Connection connection = sqlSession.getConnection();
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                // 如果type="POOLED",代表使用连接池,close则是将连接回收到连接池中
                // 如果type="UNPOOLED",代表直连,close则会调用Connection.close()方法关闭连接
                sqlSession.close();
            }
        }
    }

    @Test
    public void testMyBatisUtils() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            Connection connection = sqlSession.getConnection();
            System.out.println(connection);
        } catch (Exception e) {
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testSelectAll() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            List<Goods> list = sqlSession.selectList("goods.selectAll");
            for (Goods g : list) {
                System.out.println(g.getTitle());
            }
        } catch (Exception e) {
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testSelectById() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            Goods goods = sqlSession.selectOne("goods.selectById", 1602);
            System.out.println(goods.getTitle());
        } catch (Exception e) {
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testSelectByPriceRange() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            Map params = new HashMap<>();
            params.put("min", 100);
            params.put("max", 500);
            params.put("pageSize", 10);
            List<Goods> list = sqlSession.selectList("goods.selectByPriceRange", params);
            for (Goods g : list) {
                System.out.println("价格: " + g.getCurrentPrice() + " " + g.getTitle());
            }
        } catch (Exception e) {
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }
}
