FROM registry.access.redhat.com/ubi8/openjdk-11:1.10-10

COPY target/spring-rest-hello-world-1.0.jar /deployments

CMD /usr/local/s2i/run
