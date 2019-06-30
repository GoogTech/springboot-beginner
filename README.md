## :memo: a simple project for Spring Boot ~

### 项目概述  (:speech_balloon: pause update)
:+1:*一个简单的,基于Spring Boot的好友备忘录小项目,通过本项目可以学习`Spring Boot`与`MyBatis`的整合及CURD操作的基本思路,同时也可以帮助你学习`Thylemeaf`模板引擎使用哟 ! 该项目的代码注释详细,逻辑结构清晰,非常具有参考,学习价值哟 ! 可以说非常适合初学Sping Boot的同学啦(っ•̀ω•́)っ✎⁾⁾~*

:heart:*为了让更多同学快速地体验该项目,已通过`mvn package`将其打包,并将其作为`v1.0`上传到了`release`中~*


### 项目截图
- *项目主页面*

![](https://raw.githubusercontent.com/YUbuntu0109/SpringBoot-CURD-Memo/master/demonstration_picture/SpringBoot-CURD-Memo_MainView.PNG)

- *好友信息管理页面*

![](https://raw.githubusercontent.com/YUbuntu0109/SpringBoot-CURD-Memo/master/demonstration_picture/SpringBoot-CURD-Memo_FriendListView.PNG)

![](https://raw.githubusercontent.com/YUbuntu0109/SpringBoot-CURD-Memo/master/demonstration_picture/SpringBoot-CURD-Memo_FriendListView2.PNG)


### 项目结构
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
    │  mvnw
    │  mvnw.cmd
    │  pom.xml
    │
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
                │  │      │(略..)
                │  │        
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

#### 项目文件说明-`Spring boot启动类`
```
MemoApplication.java
```

#### 项目文件说明-`数据库文件`
```
memo.sql
```

#### 项目文件说明-`EasyUI 前端框架`
```
easyui/
```

#### 项目文件说明-`默认头像`
```
default_portrait.png
```



*:books:更多有趣项目及详细学习笔记请前往我的个人博客哟（づ￣3￣）づ╭❤～ : https://yubuntu0109.github.io/* 
 
:coffee: Look forward to your contribution !

:man_student: If you need any help, please contact me ~ QQ : 3083968068
