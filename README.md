![status: active](https://img.shields.io/badge/status-active-green.svg)

## Command to Run

mvn compile exec:java

## Rquired Use Case
- [x] Building HystrixCommand to protect remote api calls 
- [x] Using OKHttpClient as a convenient REST API call client 
- [ ] Further simplify REST API call by replacing OKHttpClient with Feign Client 
- [ ] To use a load balancer to demonstrate the cluster nature of large sacle api services and how Hystix interact with it
- [ ] Hystrix Dashboard for monitoring CBS

## Optional Feature
- [ ] Integration with my side project, add SocketIO support to register, track, monitor synchronous call on WebSocket for visualization 
- [ ] Integration with my side project, add SocketIO support to register, track, monitor asynchronous call on WebSocket for visualization 
 

## References

[Hystrix](https://github.com/Netflix/Hystrix) is a an advanced circuit breaker implementation to imporve system resiliency contributed by Netflix 