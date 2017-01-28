# vmstat
Simple application to observe the results of the "vmstat" command in a Linux environment. The application is composed of 3 components: back-end, front-end, and a bash script. The bash script is responsible for sending the machine status to the back-end written in Java. The front-end, written using react js shows the status saved. 

I also wrote some unit test for the back-end (using JUnit and mockito) and for the front-end (using enzime and chai).

### Setup
- Install node version 4.4.5
- Install npm version 4.1.2
- Install Oracle Java jdk 1.8
- Install Maven 3.x
- Add Java and Maven to the env variable PATH 

Everything tested on ubuntu 15.10

### Install
- In the folder back-end run "mvn install"
- In the folder back-end/target run "java -jar vmstat-audit-1.0-SNAPSHOT.jar" and keep it running
- In the folder front-end run "sh run.sh" and keep it running
- In the folder crontab "run sh bash.sh" or put bash.sh in crontab

### Usage
URL access:  http://localhost:8080


App to see the vmstat the linux command in a web interface.
