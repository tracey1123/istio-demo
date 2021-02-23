FROM openjdk:8-jdk
VOLUME /tmp
#ARG JAR_FILE
#COPY target/${JAR_FILE} service-a.jar
COPY target/service-nacos-a-0.0.1-SNAPSHOT.jar service-nacos-a.jar
#COPY --from=hub.komect.com:10443/iot/arthas:latest /opt/arthas /opt/arthas
RUN apt-get install -y tzdata \
    && cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && dpkg-reconfigure -f noninteractive tzdata

ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /service-nacos-a.jar
