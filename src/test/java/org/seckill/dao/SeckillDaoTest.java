package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author tianyi
 * @date 2017-11-26 22:10
 * 配置spring和junit整合，这样junit在启动时就会加载spring容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    //注入Dao实现类依赖
    @Resource
    private SeckillDao seckillDao;


    @Test
    public void queryById() throws Exception {
        long seckillId=1000;
        Seckill seckill=seckillDao.queryById(seckillId);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void queryAll() throws Exception {
        /**
         * org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.binding.BindingException:
         * Parameter 'offset' not found. Available parameters are [0, 1, param1, param2]
         */
        //List<Seckill> queryAll(int offet, int limit);
        //java没有保存形参的记录：queryAll(int offet, int limit)  --》   queryAll(arg0, arg1)
        List<Seckill> seckills=seckillDao.queryAll(0,100);
        for (Seckill seckill : seckills)
        {
            System.out.println(seckill);
        }
    }

    @Test
    public void reduceNumber() throws Exception {

        long seckillId=1000;
        Date date=new Date();
        int updateCount=seckillDao.reduceNumber(seckillId,date);
        System.out.println(updateCount);

    }


}