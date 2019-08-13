## 使用eureka client实现服务发现，使用feign 声明式rest，feign默认集成了ribbon实现负载均衡
### 需要在yml中配置
#### 使用@FeignClient注解的fallback属性,就可为指定名称的Feign客户端添加回退。
#### 需要在yml中启用 熔断器，fallback才生效