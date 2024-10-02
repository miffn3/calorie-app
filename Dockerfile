ARG JAVA_IMAGE=openjdk:17-oracle

FROM ${JAVA_IMAGE}
WORKDIR /opt/application
USER nobody
COPY target/*.jar /opt/application/application.jar
ENTRYPOINT java $JAVA_OPTS -jar /opt/application/application.jar $JAVA_ARGS