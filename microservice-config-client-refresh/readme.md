### Spring config client refresh
  值得注意的是，以上属性应配置在bootstrap.yml,而不是application.yml 中。如果  
  配置在application.yml中，该部分配置就不能正常工作。例如，Config Client会连  
接spring.cloud.config.uri的默认值htp://localst:888,而并非配置的http://localhost:8080/。  
  
    
  Spring Cloud有-个“引导上下文”的概念，这是主应用程序的父上下文。引导上下  
  文负责从配置服务器加载配置属性，以及解密外部配置文件中的属性。和主应用程  
  序加载application. * (yml或properties)中的属性不同，引导上下文加载bootstrap.  
  中的属性。配置在bootstrap. *中的属性有更高的优先级，因此默认情况下它们不能  
  被本地配置覆盖。  
修改配置 手动刷新cmd 执行如下  
curl -X POST http://localhost:8081/actuator/refresh
