package com.s5.cache.service;

import com.s5.cache.bean.Employee;
import com.s5.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @Author: Aresong
 * @Date: 2019/6/10 22:17
 * @Version 1.0
 */

@CacheConfig(cacheNames = "emp",cacheManager = "employeeCacheManager")//抽取缓存的公共配置
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 将方法的运行结果进行缓存：以后再要相同的数据，直接从缓存中获取，不用调用方法
     * CacheManager管理多个Cache组件，对缓存的真正的CRUD操作在Cache组件中，每一个缓存组件有自己唯一一个名字。
     * 几个属性：
     *      cacheNames/values:指定缓存的名字；讲方法的返回结果放在哪个缓存中，是数组的方式，可以指定多个缓存
     *      key：缓存数据使用的key：可以用它来指定。默认使用方法参数的值  1-方法的返回值
     *          编写SpEl:#id：参数id的值  #a0 #p0 #root.args[0]
     *          condition = "#a0>1",第一个参数的值>1的时候才进行缓存
     *      keyGenerator：key的生成器：可以自己制定key的生成器的组件id
     *          key/keyGenerator：二选一使用
     *      cacheManager：指定缓存管理器；或者cacheResolver：缓存解析器
     *      condition：指定符合条件的情况下才缓存
     *      unless：否定缓存；当unless指定的条件为true，方法的返回值就不会被缓存，可以获取到结果在判断
     *      sync：是否使用异步模式，不支持unless!!!
     * 原理：
     *  1.自动配置类：CacheAutoConfiguration
     *  2.缓存的配置类
     *  3.哪个配置类生效：SimpleCacheConfiguration
     *  4.给容器中注册一个CacheManager,ConcurrentMapCacheManager【默认的】
     *  5.可以获取和创建ConcurrentMapCache类型的缓存组件，它的作用将数据保存在ConcurrentMap中
     * 运行流程：
     * @Cacheable
     *  1.方法运行之前，先去查询Cache（缓存组件），按照cacheNames指定的名字获取；
     *  （CacheManager先获取相应的缓存），第一次获取缓存如果没有Cache组件会自动创建。
     *  2.去cache中查找缓存的内容，使用一个key，默认即使方法的参数；
     *  key是按照某种策略生成的；默认使用keyGenerator生成的，默认使用SimpleKeyGenerator生成key
     *      SimpleKeyGenerator生成key的默认策略；
     *      如果没有参数；key=new Simplekey();
     *      如果有一个参数，key=参数的值
     *      如果有多个参数，key=new SimpleKey(params);
     *  3.没有查到缓存就调用目标方法；
     *  4.将目标方法返回结果，放进缓存中
     *
     *  @Cacheable方法执行之前先来检查缓存中有没有这个数据，默认按照参数的值作为key去查询缓存，
     *  如果没有就运行方法并将结果放入缓存；以后再来调用就可以直接使用缓存中的数据；
     *
     *  核心：
     *  1)、使用CacheManager[ConcurrentMapCacheManager]按照名字得到Cache[ConcurrentMapCache]组件
     *  2)、key使用keyGenerator生成的，默认是SimplekeyGenerator
     */
//    @Cacheable(cacheNames = "emp",key = "#id")
//    @Cacheable(cacheNames = "emp",key = "#root.args[0]")
//    @Cacheable(cacheNames = "emp",key = "#root.methodName+'['+#id+']'")
//    @Cacheable(cacheNames = {"emp"},condition = "#id>0",unless = "#result==null")
    @Cacheable(value = {"emp"},keyGenerator = "myKeyGenerator")//用的自定义的keyGenerator
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeMapper.getById(id);
        return emp;
    }

    /**
     * @CachePut：即调用方法，又更新缓存数据：同步更新缓存
     * 修改了数据库的某个数据，同时更新缓存；
     * 运行时机：
     *  1.先调用目标方法
     *  2.将目标方法的结果缓存起来
     * 测试步骤：
     *  1.查询1号员工：查到的结果会放到缓存中
     *      key:1 value:lastName:tom
     *  2.以后查询还是之前的结果
     *  3.更新1号员工[lastName:lisi]
     *      将方法的返回值也放进缓存了；
     *      key：传入的Employee对象值：返回的Employee对象；
     *  4.查询1号员工？
     *      查询结果应该是更新后的员工啊；
     *      为什么是没更新之前的tom
     *      因为key没对上，之前存入的时候使用的是默认的key，或者定义的key值；[1号员工没有在缓存中更新]
     *      处理：[key = "#employee.id"]
     *           [key = "#result.id"]
     *      注意：@Cacheable的key是不能用result的！！！【因为在方法没有执行之前，@Cacheable就要用到key】
     *      【反正key一样就能更缓存中的数据】
     * **/
    @CachePut(value = "emp",key = "#result.id")
    public Employee updateEmp(Employee employee){
        System.out.println("updateEmp"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * @CacheEvict:缓存清除
     * key:指定清除的数据
     * allEntries = true指定清除这个缓存中全部数据
     * beforeInvocation = false;缓存清除是否在方法之前执行（true是之前）
     * （默认是在方法执行之后执行，如果出现异常，缓存不会被清除）
     * **/
    @CacheEvict(value = "emp",key="#id",allEntries = true)
    public void deleteEmp(Integer id){
        System.out.println("deleteEmp"+id);
//        employeeMapper.deleteEmpById(id);
        int a = 1/0;

    }

    /**@Caching组合注解来定义复杂的缓存规则**/
    @Caching(
        cacheable = {
            @Cacheable(key = "#lastName")//@CacheConfig(cacheNames = "emp")有了这个这里面的value就不用写了
        },
        put = {
            @CachePut(key = "#result.id"),
            @CachePut(key = "#result.email")
        }
    )
    public Employee getEmpByLastName(String lastName){
        return employeeMapper.getEmpByLastName(lastName);
    }
}
