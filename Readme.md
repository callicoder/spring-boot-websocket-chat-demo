## Spring Boot WebSocket Chat Appplication

You can checkout the live version of the application at https://spring-ws-chat.herokuapp.com/

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/callicoder/spring-boot-websocket-chat-demo.git
```

**2. Build and run the app using maven**

```bash
cd spring-boot-websocket-chat-demo
mvn package
java -jar target/websocket-demo-0.0.1-SNAPSHOT.jar
```

Alternatively, you can run the app directly without packaging it like so -

```bash
mvn spring-boot:run
```

## Learn More

You can find the tutorial for this application on my blog -

https://www.callicoder.com/spring-boot-websocket-chat-example/

## Note
If you are running rabbitmq from a docker instance Guest/Guest credentials will not work since the virtual host permissions block the request.

Set the system login and system passcode to your admin account

```bash
registry.enableStompBrokerRelay("/topic")
                .setRelayHost("localhost")
                .setRelayPort(61613)
                .setClientLogin("admin")
                .setSystemLogin("admin")
                .setSystemPasscode("password")
                .setClientPasscode("password");
```
