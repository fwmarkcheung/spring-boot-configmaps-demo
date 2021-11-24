FROM default-route-openshift-image-registry.apps.rhcasalab.sandbox1385.opentlc.com/openshift/openjdk-11-rhel8:1.0

COPY target/spring-rest-hello-world-1.0.jar /deployments

CMD /usr/local/s2i/run
