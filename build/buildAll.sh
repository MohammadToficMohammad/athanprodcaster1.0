cd ..
cd LogglyEvents
mvn clean install -DskipTests
cd ..
cd ServiceRegistery
mvn clean install -DskipTests
cd ..
cd ConfigServer
mvn clean install -DskipTests
cd ..
cd AuthorizationServiceRpcClient
mvn clean install -DskipTests
cd ..
cd MqClientAbstracts
mvn clean install -DskipTests
cd ..
cd MqServerAbstracts
mvn clean install -DskipTests
cd ..
cd AuthorizationService
mvn clean install -DskipTests
cd ..
cd ProjectService
mvn clean install -DskipTests
cd ..
cd build