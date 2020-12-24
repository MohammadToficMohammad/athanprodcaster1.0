cd ..
cd LogglyEvents
call mvn clean install -DskipTests -Dmaven.test.skip=true
cd ..
cd ServiceRegistery
call mvn clean install -DskipTests -Dmaven.test.skip=true
cd ..
cd ConfigServer
call mvn clean install -DskipTests -Dmaven.test.skip=true
cd ..
cd AuthorizationServiceRpcClient
call mvn clean install -DskipTests -Dmaven.test.skip=true
cd ..
cd MqClientAbstracts
call mvn clean install -DskipTests -Dmaven.test.skip=true
cd ..
cd MqServerAbstracts
call mvn clean install -DskipTests -Dmaven.test.skip=true
cd ..
cd AuthorizationService
call mvn clean package spring-boot:repackage -DskipTests -Dmaven.test.skip=true
cd ..
cd ProjectService
call mvn clean package spring-boot:repackage -DskipTests -Dmaven.test.skip=true
cd ..
cd build