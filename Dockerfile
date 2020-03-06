FROM adoptopenjdk/openjdk13-openj9:ubi
RUN mkdir /opt/app
COPY target/coronavirus-tracker.jar /opt/app/japp.jar
CMD ["java", "-jar", "/opt/app/japp.jar"]