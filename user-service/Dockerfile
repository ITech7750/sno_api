FROM gradle:jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN chmod +x ./gradlew
RUN ./gradlew bootJar --no-daemon

FROM openjdk:17
EXPOSE 8003
RUN mkdir /userservice
COPY --from=build /home/gradle/src/build/libs/*.jar /userservice/userservice.jar
ENTRYPOINT ["java", "-jar", "/userservice/userservice.jar"]
