# ssh_crm
这个CRM管理系统是我练习Struts2，Hibernate，Spring整合做的项目，在做这个项目的过程中学习了很多，不仅仅是SSH整合的方法，同时还收获了很多其他的东西，比如：了解一下CRM系统的流程和一些简单的业务等等

## 还是采用三层的分层架构
采用Dao，service，Controller来分层，使用Spring来整合项目之后，果然很方便开发了，我之前写过一个小项目只采用Struts2+Hibernate开发的，现在想想没有使用Spring真是难受了

## 模块划分
模块可以分为客户管理，联系人管理，客户拜访管理，综合查询，统计功能

## 客户管理
主要完成了添加客户和显示客户列表的这两个功能

## 联系人管理
主要完成了添加联系人和显示联系人列表的这两个功能

## 客户拜访管理
主要完成了新增客户拜访功能和客户拜访列表的这两个功能

前面这几个功能逻辑上都差不多，只不过是操作的表不同而已，其中较为难的是处理一对多或者是多对多关系，可能还会有双向查询的业务需求。

## 综合查询
这个模块练习的是多条件查询

## 统计功能
这个模块练习的是使用Hibernate来操作复杂的SQL语句，Hibernate封装的太完全，所以对于一些复杂的查询，Hibernate就不好操作了，还是需要我们自己写SQL

