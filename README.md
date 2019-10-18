## :beginner::memo: a simple project for Spring Boot ~


### 项目概述
:+1:*一个简单的，基于 Spring Boot 的好友备忘录小项目，通过本项目你可以学习到 Spring Boot 与 MyBatis 的整合及 CURD 操作的基本思路，同时也可以帮助你学习 Thylemeaf 模板引擎的基本使用. 这可能是流程最清晰、代码最干净、注释最详细、最具扩展性的 Spring Boot 入门级项目咯，可以说非常适合作为初学 Sping Boot 的同学的第一个上手项目哟 (っ•̀ω•́)っ✎⁾⁾~*


### 分支介绍
- :arrows_clockwise: *`master` : 基本的 Spring Boot 整合 MyBatis ( 该代码的优化请参考`refactor-190823`分支 )*
- :arrows_clockwise: *`v2.0-redis` : 在 master 分支上简单集成 Redis*
- :arrows_clockwise: *`refactor-190823` : 重构并优化 master 分支代码，提高项目的可扩展性*

> 为了让更多同学快速地体验该项目，已通过`mvn package`将`master`分支打包，并将其作为`v1.0`已上传到了`release`中


### 开发环境
| 工具    | 版本或描述                |    
| ------- | ------------------------ |    
| `OS`    | Windows 10               | 
| `JDK`   | 11.0.2                   |    
| `IDE`   | IntelliJ IDEA 2019.1     |    
| `Maven` | 3.6.0                    |    
| `MySQL` | 8.0.11                   |

> 本项目的数据库版本为`8.0.11`，请广大版本为`5.0.0+`的同学注意咯：可通过逐个复制表结构来创建该数据库哟 ~


### 图片预览
- *系统主页*

![](https://raw.githubusercontent.com/YUbuntu0109/SpringBoot-CURD-Memo/master/demonstration_picture/SpringBoot-CURD-Memo_MainView.PNG)

- *好友信息管理页*

![](https://raw.githubusercontent.com/YUbuntu0109/SpringBoot-CURD-Memo/master/demonstration_picture/SpringBoot-CURD-Memo_FriendListView.PNG)

![](https://raw.githubusercontent.com/YUbuntu0109/SpringBoot-CURD-Memo/master/demonstration_picture/SpringBoot-CURD-Memo_FriendListView2.PNG)


### 项目结构(`master branch`)
```
│  .gitattributes
│  LICENSE
│  README.md
│
├─database file
│      memo.sql
│
├─demonstration_picture
│      SpringBoot-CURD-Memo_FriendListView.PNG
│      SpringBoot-CURD-Memo_FriendListView2.PNG
│      SpringBoot-CURD-Memo_MainView.PNG
│
└─memo
    │  .gitignore
    │  pom.xml
    │
    └─src
        └─main
            ├─java
            │  └─pers
            │      └─haungyuhui
            │          └─memo
            │              │  MemoApplication.java
            │              │
            │              ├─bean
            │              │      Friend.java
            │              │
            │              ├─controller
            │              │      StudentController.java
            │              │
            │              ├─dao
            │              │      FriendMapper.java
            │              │      FriendMapper.xml
            │              │
            │              ├─service
            │              │  │  FriendService.java
            │              │  │
            │              │  └─impl
            │              │          FriendServiceImpl.java
            │              │
            │              └─util
            │                      UploadFile.java
            │
            └─resources
                │  application.properties
                │
                ├─static
                │  ├─easyui
                │  │  │  jquery.easyui.min.js
                │  │  │  jquery.min.js
                │  │  │
                │  │  ├─css
                │  │  │      default.css
                │  │  │      demo.css
                │  │  │
                │  │  ├─js
                │  │  │      outlook2.js
                │  │  │      validateExtends.js
                │  │  │
                │  │  └─themes
                │  │      │
                │  │      │(略..)
                │  │      
                │  │      
                │  └─image
                │          default_portrait.png
                │
                └─templates
                        friendList.html
                        intro.html
                        main.html
```


### 文件说明 
1. *数据库文件*
```
memo.sql
```

2. *`EasyUI` 前端框架*
```
easyui/
```

3. *用户默认头像*
```
default_portrait.png
```



*:books:更多有趣项目及详细学习笔记请前往我的个人博客哟（づ￣3￣）づ╭❤～ : https://yubuntu0109.github.io/*

*👩‍💻学习笔记已全部开源 : https://github.com/YUbuntu0109/YUbuntu0109.github.io*
 
*:coffee: Look forward to your contribution, if you need any help, please contact me~ QQ : 3083968068*
