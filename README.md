# vmstat

### Setup
- Install node version 4.4.7
- Install npm version 2.15.8
- Install Oracle Java jdk 1.8
- Install Maven 3.x
- Add Java and Maven to the env variable PATH 

Everything tested on ubuntu 16

### Install
- In the folder back-end run "mvn install"
- In the folder back-end/target run "java -jar vmstat-audit-1.0-SNAPSHOT.jar" and keep it running
- In the folder front-end run "sh run.sh" and keep it running
- In the folder crontab "run sh bash.sh" or put bash.sh in crontab

### Usage
URL access:  http://localhost:8080


App to see the vmstat the linux command in a web interface.
