FROM ubuntu:latest

ENV LANG C.UTF-8
ENV JAVA_HOME /jdk-9

ADD ./jdk-mini /jdk-9

RUN ln -s $JAVA_HOME/bin/java /usr/bin/java && \
    ln -s $JAVA_HOME/bin/javac /usr/bin/javac && \
    ln -s $JAVA_HOME/bin/jshell /usr/bin/jshell && \
    rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*
    
CMD ["jshell"]
