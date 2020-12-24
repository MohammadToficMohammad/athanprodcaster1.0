cd ..
cd LogglyEvents
call mvn clean install -DskipTests
cd ..
cd ServiceRegistery
call mvn clean install -DskipTests
cd ..
cd ConfigServer
call mvn clean install -DskipTests
cd ..
cd AuthorizationServiceRpcClient
call mvn clean install -DskipTests
cd ..
cd MqClientAbstracts
call mvn clean install -DskipTests
cd ..
cd MqServerAbstracts
call mvn clean install -DskipTests
cd ..
cd AuthorizationService
call mvn clean package spring-boot:repackage -DskipTests
cd ..
cd ProjectService
call mvn clean package spring-boot:repackage -DskipTests
cd ..
cd build