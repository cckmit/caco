# caco
Spring Cloud + Vue全家桶，前后端分离，完整的后端运营平台，可以实现快速搭建企业级微服务项目。采用‘大后台小前台’、‘领域模型’等设计模式。https://uoko.io

```
south-star
└── south-star-auth -- 授权服务 
     ├── south-star-auth-api -- 授权服务 api
     ├── south-star-auth-biz -- 授权服务  biz
     └── south-star-auth-starter -- 授权服务 stater[4000]
└── south-star-common -- 系统公共模块 
     ├── south-star-common-core -- 公共工具类核心包
     └── south-star-common-security -- 安全工具类
├── south-star-eureka -- 服务注册与发现[3000]
├── south-star-gateway -- Spring Cloud Gateway网关[8080]
└── south-star-modules -- 通用用户权限管理模块
     └──south-star-user-center -- 用户中台
          ├── south-star-user-center-api -- 中户中台api
          ├── south-star-user-center-biz -- 用户biz
          └── south-star-user-center-starter -- 用户stater[7002]
└── south-star-visual  -- 图形化模块  - 未启用
     ├── south-star-monitor -- Spring Boot Admin监控 [5001]
     └── south-star-zikpin -- 图形化代码生成[5003]
```