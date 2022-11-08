```
$ java -version
openjdk version "19.0.1" 2022-10-18
OpenJDK Runtime Environment (build 19.0.1+11)
OpenJDK 64-Bit Server VM (build 19.0.1+11, mixed mode, sharing)
```


```
./mvnw spring-boot:run
```


```
$ curl localhost:8080
Hello from VirtualThread[#53]/runnable@ForkJoinPool-1-worker-1
```

```
$ curl -s http://localhost:8080/actuator/threaddump | jq . | grep threadName
      "threadName": "Reference Handler",
      "threadName": "Finalizer",
      "threadName": "Signal Dispatcher",
      "threadName": "Notification Thread",
      "threadName": "Common-Cleaner",
      "threadName": "Catalina-utility-1",
      "threadName": "Catalina-utility-2",
      "threadName": "container-0",
      "threadName": "http-nio-8080-Poller",
      "threadName": "http-nio-8080-Acceptor",
      "threadName": "DestroyJavaVM",
      "threadName": "ForkJoinPool-1-worker-1",
      "threadName": "ForkJoinPool-1-worker-2",
      "threadName": "ForkJoinPool-1-worker-3",
      "threadName": "ForkJoinPool-1-worker-4",
      "threadName": "ForkJoinPool-1-worker-5",
```