FROM gradle:jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN chmod +x ./gradlew
RUN ./gradlew bootJar --no-daemon

FROM openjdk:17
EXPOSE 8002
RUN mkdir /lectureservice
COPY --from=build /home/gradle/src/build/libs/*.jar /lectureservice/lectureservice.jar
ENTRYPOINT ["java", "-jar", "/lectureservice/lectureservice.jar"]
