FROM gradle:jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN chmod +x ./gradlew
RUN ./gradlew bootJar --no-daemon

FROM openjdk:17
EXPOSE 8004
RUN mkdir /videostreamservice
COPY --from=build /home/gradle/src/build/libs/*.jar /videostreamservice/videostreamservice.jar
ENTRYPOINT ["java", "-jar", "/videostreamservice/videostreamservice.jar"]
