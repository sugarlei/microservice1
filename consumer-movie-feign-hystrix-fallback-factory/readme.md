##使用eureka client实现服务发现，使用feign 声明式rest，默认集成了ribbon实现负载均衡
###需要在yml中配置
####需要在yml中启用 熔断器，fallback才生效
####很多场景下，需要了解回退的原因,此时可使用注解@FeignClient的fallbackFactory属性。
####FeignClientFallbackFactory需要和 FeignClient在同一包下
####增加hystrix 依赖，yml配置endpoint，实现hystrix.stream监控