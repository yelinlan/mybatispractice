#idea全局utf-8
#增删改要手动提交
#factory.openSession(true) 可以自动提交
#多对一association javaType
#一对多collection ofType
#动态sql

mybatis缓存模块
一级缓存：一次会话中，查询到的数据库数据放到一级缓存中；会话结束时，把一级缓存剩余的内容转移到二级缓存
二级缓存：namespace下
用户访问时顺序：二级->一级->数据库
1.增删改查 2.手动清除了缓存 3.查询不同mapper 它们的效果等同于删除之前的缓存；不影响之后的缓存数据
