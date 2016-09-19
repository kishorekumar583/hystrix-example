# spring-boot-hystrix-example


This application explains about how to implement spring boot with hystrix implementation. Basically there are two parts in Hystrix dashboard implementation. One is creating the dashboard and the second one is you're application can able to register to hystrix dashboard. In order to support your application, You need to have a actuator which will emits all the information about your application.(like, service calls, java memory etc.,)

 [Here](https://spring.io/guides/gs/spring-boot/) is the basic instructions, Which will explain how to create a basic spring boot application. Once the application is created please follow the below steps on how your application able to register with hystrix dashboard. In this application am using the same application to launch the dashboard as well service monitoring.
 
 - Make sure you have the dependencies required for your application 

```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-hystrix</artifactId>
</dependency>

```
For dashboard
```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
</dependency>
```
-After the implementation you need to have few annotation inorder to load hystrix features 

```
@SpringBootApplication
@Configuration
@ComponentScan
@RestController
@EnableHystrix
@EnableDiscoveryClient
public class HystrixDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDemoApplication.class, args);
	}

	@HystrixCommand
	@RequestMapping(value = "/test")
	public String testApp() {
		return "Hello Application";
	}

	@HystrixCommand
	@RequestMapping(value = "/abcd")
	public String testAppAB() {
		return "Hello Application";
	}


}
```
- @EnableHystrix will load your hystrix features
- @EnableDiscoverClient which will enables your service to discover with client
- @HystrixCommand this plays major role, This is the one hystrix is going to monitor.
- Once your application is running you can able to see some pings with the url http://localhost:8080/hystrix.stream
- Copy this ping URL and paste it into your hystrix dashboard. That's it, Your job is done.
- If your not able to see your application dashboard, Just ping your application once that will do your job.




