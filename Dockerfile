FROM openjdk:11.0.16-oraclelinux7
ADD target/wedding-0.0.1-SNAPSHOT.jar wedding
ENTRYPOINT ["java","-jar","wedding"]
EXPOSE 8080