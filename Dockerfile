FROM registry.access.redhat.com/openshift/openjdk-11-rhel8:1.0

COPY target/spring-rest-hello-world-1.0.jar /deployments

CMD /usr/local/s2i/run
