# Read Me First
The following was discovered as part of building this project:

* The JVM level was changed from '1.8' to '17', review the [JDK Version Range](https://github.com/spring-projects/spring-framework/wiki/Spring-Framework-Versions#jdk-version-range) on the wiki for more details.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.5/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web)
* [Spring Data Redis (Access+Driver)](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#data.nosql.redis)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Messaging with Redis](https://spring.io/guides/gs/messaging-redis/)

## About Redis
Set 和 ZSet
值都是String类型的集合


Redis的数据结构类型指的是redis的值value的类型


redis常用的数据结构类型：String、list、hash、set、sortedSet、HyperLogLog、geospatial
## List类型
1. 基于LinkedList实现
2. 元素是**字符串**类型
3. 列表头尾增删快、中间增删慢、增删元素是常态
4. 元素可以重复出现
5. 最多包含2^32-1个元素

## Hash类型
1. 由field和与之关联的value组成map键值对
2. field和value是**字符串**类型
3. 一个hash中最多包含2^32-1个键值对
## Set类型
1. 无序的、去重的
2. 元素是**字符串**类型
3. 最多包含2^32-1个元素

## SortedSet
1. 类似Set集合
2. 有序的、去重的
3. 元素是字符串类型
4. 每一个元素都关联着一个浮点数分值（Score），并按照分值从小到大的顺序排列集合中的元素。分值可以相同
5. 最多包含2^32-1个元素


spop命令移除并返回集合中的一个随机元素
Redis的key是单线程模式的，这就意味着一瞬间只有一个线程能够持有这个key，所以可以使用redis解决部分涉及线程安全的业务。