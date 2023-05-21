#FROM bellsoft/liberica-openjdk-alpine
#ENV APP_HOME=/app
#ENV POSTGRES_URL=jdbc:postgresql://localhost:5432/test
#ENV POSTGRES_USER=postgres
#ENV POSTGRES_PASSWORD=bestuser
#RUN mkdir $APP_HOME
#COPY . $APP_HOME
#WORKDIR $APP_HOME
#RUN ./mvnw clean package
#EXPOSE 8080
#CMD ["java", "-jar", "target/*.jar"]

FROM bellsoft/liberica-openjdk-alpine
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]