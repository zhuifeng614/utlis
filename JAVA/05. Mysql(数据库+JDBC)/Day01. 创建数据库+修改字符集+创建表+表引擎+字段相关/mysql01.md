###数据库
- 数据库简介:
	之前通过IO技术可以实现数据的增删改查操作,但是执行效率低,只能保存文本数据,所有功能都由程序员自己实现开发效率很低, 使用现成的数据软件,把数据的具体操作交由数据库软件处理,只需要学习如何使用数据库软件即可
- DBMS: DataBaseManagementSystem(数据库管理系统 俗称数据库软件),常见的DBMS有:MySQL Oracle SQLserver DB2 SQLite  
- 数据库的分类
1. 关系型数据库: 经过数学理论验证,可以将现实生活中的任何关系进行保存,以表为单位保存数据
2. 非关系型数据库: 一般以键值对的形式保存数据,一般用于处理一些特殊场景如:数据缓存  
####主流DBMS介绍
1. MySQL: Oracle公司产品,  08年被Sun公司收购  09Sun被Oracle收购,开源数据库  原MySQL程序员从Oracle离开创办MariaDB(Maria创始人女儿的名字),市场占有率排名第一
2. Oracle: Oracle公司产品, 公司老板拉里.艾莉森,闭源产品,市场占有率排名第二 
3. SQLServer: 微软公司产品, 主要应用在微软的整套解决方案中,市场占有率排名第三
4. DB2: IBM公司产品, 主要应用在IBM整套解决方案中  
5. SQLite: 轻量级数据库软件, 只具备基础的增删改查操作,一般应用在移动设备或嵌入式设备中

网站: 操作系统+web服务软件+开发语言+数据库软件


####开源和闭源
1. 开源:开放源代码  通过卖服务盈利  , 有大拿程序员对开源项目进行无偿的维护和升级
2. 闭源:不开放源代码  通过卖产品+服务, 有大拿程序员为了刷存在感或获利的需求对闭源项目进行攻击  

###SQL
- Structured Query Language:结构化查询语言,用于程序员和数据库软件进行交互
###如何连接数据库软件
- 打开终端/命令行
- window系统: 开始菜单->所有程序->MariaDB/MySQL->MySQL Client 输入密码回车
- Linux系统:任何位置右键打开终端 输入以下指令
		mysql -uroot -p   回车  如果没有密码再次回车
- 退出指令:
		exit
###数据库相关SQL
1. 查看所有数据库
- 格式: show databases;
2. 创建数据库
- 格式: create database 数据库名;
	create database db1;
3. 查看数据库详情
- 格式: show create database 数据库名;
	show create database db1;
4. 创建数据库指定字符集
- 格式: create database 数据库名 character set utf8/gbk;
	create database db3 character set gbk;
	show create database db3; //验证一下
5. 删除数据库
- 格式: drop database 数据库名;
	drop database db3;
6. 使用数据库
- 格式: use 数据库名;
	use db1;
###表相关SQL
1. 创建表
- 格式: create table 表名(字段1名 字段1类型,字段2名 字段2类型);
	create table person(name varchar(10),age int);	
- 练习: 创建学生表student 字段:学号id  姓名name 语文chinese 数学math 英语 english
	create table student(id int, name varchar(10), chinese int, math int, english int);
2. 查看所有表
- 格式: show tables;
3. 查看表详情
- 格式: show create table 表名;
	show create table student;
- 表引擎:
	1. innoDB(默认): 支持事务和外键等高级操作
	2. myisam: 只支持基础的增删改查操作
4. 创建表指定引擎和字符集
- 格式:create table 表名(字段1名 字段1类型,字段2名 字段2类型) engine=myisam/innodb charset=utf8/gbk;
	create table t1(name varchar(10),age int)engine=myisam charset=gbk; 
#####练习:
1. 创建2个数据库分别是mydb1和mydb2(字符集为gbk)
	create database mydb1;
	create database mydb2 character set gbk;
2. 在mydb1里面创建员工表emp 字段: 姓名 年龄 工资(sal)
	use mydb1;
	create table emp(name varchar(10),age int,sal int);
3. 在mydb2里面创建英雄表hero 字段: 姓名 年龄 英雄类型(type) 引擎为myisam字符集为gbk
	use mydb2;
	create table hero(name varchar(10),age int, type varchar(10))engine=myisam charset=gbk;
4. 删除刚创建的两个数据库
	drop database mydb1;
	drop database mydb2;

####表相关SQL(续)
1. 查看表字段
- 格式: desc 表名;
	desc student;
2. 删除表
- 格式: drop table 表名;
	drop table student;
3. 修改表名
- 格式: rename table 原名 to 新名;
	rename table t1 to t2;
4. 修改引擎和字符集
- 格式: alter table 表名 engine=myisam/innodb charset=utf8/gbk;
	alter table t2 engine=innodb charset=utf8;
5. 添加表字段
- 格式: alter table 表名 add 字段名 字段类型;  //最后
- 格式: alter table 表名 add 字段名 字段类型 first;  //最前面
- 格式: alter table 表名 add 字段名 字段类型 after xxx;//在xxx的后面
	create table emp (name varchar(10)); //创建
	alter table emp add age int; //最后
	alter table emp add id int first; //最前面
	alter table emp add gender varchar(5) after name; //name后面
6. 删除表字段
- 格式: alter table 表名 drop 字段名;
	alter table emp drop gender;
7. 修改表字段名和类型
- 格式: alter table 表名 change 原字段名 新名 新类型;
	alter table emp change age gender varchar(10);
8. 修改字段类型和位置
- 格式: alter table 表名 modify 字段名 新类型 first/after xxx;
	alter table emp modify gender varchar(5) first;
	alter table emp modify gender varchar(5) after id;

######表相关练习
1. 创建数据库mydb3 指定字符utf8 并使用 
	create database mydb3 character set utf8;
	use mydb3;
2. 创建temp表 只有id字段 指定引擎为myisam 字符集为gbk 
	create table temp(id int)engine=myisam charset=gbk;
3. 修改表名为t_emp ;
	rename table temp to t_emp;
4. 修改引擎为innodb 修改字符集为utf8 
	alter table t_emp engine=innodb charset=utf8;
5. 在最后面添加name字段  
	alter table t_emp add name varchar(10);
6. 在name前面添加age字段  
	alter table t_emp add age int after id;
7. 在age后面添加工资sal字段
	alter table t_emp add sal int after age;
8. 修改sal字段名称为salary  
	alter table t_emp change sal salary int;
9. 修改age字段到最后面 
	alter table t_emp modify age int after name;
10. 删除salary字段  
	alter table t_emp drop salary;
11. 删除表
	drop table t_emp;
12. 删除数据库 
	drop database mydb3;
###数据相关SQL
	create database mydb1 character set utf8;
	use mydb1;
	create table emp(id int,name varchar(10),age int)engine=innodb charset=utf8;
1. 插入数据(增)   
- 全表插入格式: insert into 表名 values(值1,值2,值3); 
	insert into emp values(1,'Tom',8);
- 指定字段插入格式: insert into 表名(字段1名,字段2名) values(值1,值2);
	insert into emp (id,name) values(2,'Jerry');
- 中文问题:
	insert into emp values(3,'刘备',30);
	如果以上代码报错执行以下命令
	set names gbk;
- 批量插入:
	insert into emp values(4,'关羽',25),(5,'张飞',18);
	insert into emp (name) values('悟空'),('八戒'),('沙僧');	
2. 查询数据
- 格式: select 字段信息 from 表名 where 条件;
	select name,age from emp;  //查询所有数据的name和age
	select name,age from emp where age<20;//20岁以下的name和age
	select * from emp;  //查询所有数据的所有字段信息
3. 修改数据
- 格式: update 表名 set 字段名=xxx where 条件;
	update emp set age=500 where name='悟空';
	update emp set age=10 where id=2;
4. 删除数据
- 格式: delete from 表名 where 条件;
	delete from emp where age<20;
	delete from emp where age is null;
	delete from emp;//删除全部数据
####数据相关练习
1. 创建hero表 id 名字name 类型type  价格money
2. 保存以下数据
	1,'诸葛亮','法师',18888 2,'周瑜','法师',13888
	3,'孙悟空','打野',18888 4,'小乔','法师',13888
	5,'黄忠','射手',8888 6,'刘备','战士',6888
3. 修改所有18888为28888
4. 修改所有法师为战士
5. 删除价格为6888的英雄
6. 修改小乔为猪八戒
7. 删除价格低于15000的英雄
8. 添加性别gender字段在name的后面
9. 修改所有英雄的性别为男
10. 删除所有数据
11. 删除表



