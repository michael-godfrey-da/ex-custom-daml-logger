# ex-custom-daml-logger
Example showing custom logging in Canton using a Logback filter

Modify 

- logback.xml

## Generate a (.jar) file for the logger in Eclipse
See Instructions Here:
[Generate (.jar) in Eclipse](doc/eclipse.md)

## Include custom logger on classpath
``` sh
# pattern is:
# java -cp <path to custom logger jar>:<path to canton jar> <canton main class> <args>

# Include path to logback xml in _JAVA_OPTIONS:
_JAVA_OPTIONS=-Dlogback.configurationFile=/app/log/logback.xml
CANTON_MAIN=com.digitalasset.canton.CantonEnterpriseApp

java -cp ex-custom-daml-logger-0.0.1-SNAPSHOT.jar:./lib/canton-enterprise-2.7.3.jar $CANTON_MAIN daemon --log-file-name=log/domain.log -c domain.conf
```

``` daml
debug "[CustomApp Debug] This is a debug message"
```