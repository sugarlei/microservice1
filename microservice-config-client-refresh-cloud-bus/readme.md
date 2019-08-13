### Spring config client refresh
  值得注意的是，以上属性应配置在bootstrap.yml,而不是application.yml 中。如果
  配置在application.yml中，该部分配置就不能正常工作。例如，Config Client会连
接spring.cloud.config.uri的默认值htp://localst:888,而并非配置的http://localhost:
  8080/。
  Spring Cloud有-个“引导上下文”的概念，这是主应用程序的父上下文。引导上下
  文负责从配置服务器加载配置属性，以及解密外部配置文件中的属性。和主应用程
  序加载application. * (yml或properties)中的属性不同，引导上下文加载bootstrap.
  中的属性。配置在bootstrap. *中的属性有更高的优先级，因此默认情况下它们不能
  被本地配置覆盖。
修改配置 手动刷新 cmd 执行如下
curl -X POST http://localhost:8081/actuator/refresh

使用spring cloud bus 配合rabbitmq自动刷新
curl -X POST http://localhost:8081/actuator/bus-refresh


局部刷新
某些场景下(例如灰度发布等),若只想刷新部分微服务的配置，可通过/bus/refresh端
点的destination参数来定位要刷新的应用程序。
例如: /bus/refresh?destination=customers:9000， 这样消息总线上的微服务实例就会根
据destination参数的值来判断是否需要刷新。其中，customers:9000指的是各个微服务的
ApplicationContext ID。
destination参数也可以用来定位特定的微服务。例如:/bus/refresh?destination=customers:**，
这样就可以触发customers微服务所有实例的配置刷新。


缺陷
1.破坏了微服务的职责单一原则。业务微服务只应关注自身业务,不应承担配置刷新
的职责。
2.破坏了微服务各节点的对等性。
3.有一定的局限性。例如，微服务在迁移时，网络地址常常会发生变化。此时如果想
自动刷新配置，就不得不修改WebHook的配置。

### 跟踪总线事件
actuator/trace是springbootactuator1.x版本才有的一个接口，
不知什么原因在springboot2.x版本后官方取消了这个接口
想要跟踪总线事件非常简单,只须设置spring.cloud.bus.trace.enabled=true ,这样在/bus/
refresh端点被请求后，访问/trace 端点就可获得 spring boot2.x 不再支持这种方式，如下是自己实现的