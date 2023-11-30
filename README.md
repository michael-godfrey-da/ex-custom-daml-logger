# ex-custom-daml-logger
Example showing custom logging in Canton using a Logback filter

## Modify the following files to define custom logging behavior:
- CustomLevelConverter.java
- RegexLevelFilter.java
- logback.xml

## Build a custom logger jar file
Run As: Maven Build
Goals: package 

## Include custom logger on classpath
``` sh
# pattern is:
# java -cp <path to custom logger jar>:<path to canton jar> <canton main class> <args>

# Include path to logback xml in _JAVA_OPTIONS:
_JAVA_OPTIONS=-Dlogback.configurationFile=/app/log/logback.xml
CANTON_MAIN=com.digitalasset.canton.CantonEnterpriseApp

java -cp ex-custom-daml-logger-0.0.1-SNAPSHOT.jar:./lib/canton-enterprise-2.7.3.jar $CANTON_MAIN daemon --log-file-name=log/domain.log -c domain.conf
```