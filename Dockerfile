FROM openjdk:11.0.16-oraclelinux7
ADD target/6jarsmanagement-0.0.1-SNAPSHOT.jar 6jars
ENTRYPOINT ["java","-jar","6jars"]
EXPOSE 8080