FROM centos:7
RUN yum update -y && yum install -y groovy which zip unzip && curl --location --show-error -O --url "https://services.gradle.org/distributions/gradle-6.0.1-all.zip" \
    && mkdir /opt/gradle && unzip -d /opt/gradle gradle-6.0.1-all.zip && ln -s /opt/gradle/gradle-6.0.1 /opt/gradle/current-version 
ENV PATH=$PATH:/opt/gradle/current-version/bin
WORKDIR /build
