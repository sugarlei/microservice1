#微服务练习
##此目录下均按照Spring Cloud与Docker微服务架构实战 .pdf编写
###消费者部分
consumer-movie                  使用eureka client实现服务发现的消费者服务

consumer-movie-feign            使用eureka client实现服务发现，使用feign 声明式rest，
                                默认集成了ribbon实现负载均衡需要在yml中配置
                                
consumer-movie-feign-hystrix-fallback   基于上一个。使用@FeignClient注解的fallback属性,就可为指定名称的Feign客户端添加回退。

consumer-movie-feign-hystrix-fallback-factory   基于上一个。很多场景下，需要了解回退的原因,此时可使用注解@FeignClient的fallbackFactory属性。

consumer-movie-feign-manual     使用eureka client实现服务发现，手写feign,实现服务提供者的认证

consumer-movie-ribbon           使用eureka配合ribbon 实现服务提供者负载均衡

consumer-movie-ribbon-hystrix   使用eureka配合ribbon 实现服务提供者负载均衡，增加hystrix 熔断器

consumer-movie-without-eureka   不用eureka只用ribbon实现负载均衡，针对未注册到eureka的服务
###服务发现
discovery-eureka                EurekaServer作为注册中心

discovery-eureka-authenticating EurekaServer作为注册中心，增加用户认证

discovery-eureka-ha             多个eureka server节点，相互注册

###服务监控
microservice-hystrix-dashboard   使用hystrix-dashboard实现可视化监控

microservice-hystrix-turbine      Turbine是一个聚合Hystrix监控数据的工具，它可将所有相关/hystrix.stream端点的数据
                                  聚合到一个组合的/turbine.stream中，从而让集群的监控更加方便。
                                  
###服务提供者
provider-user                      服务提供者，注册到eureka server

provider-user-with-auth            服务提供者，注册到eureka server, 增加security
###zuul网关
microservice-gateway-zuul          Zuul微服务网关，整合了Hystrix，使用ribbon实现负载均衡
