ls
cd LogglyEvents
mvn clean install -DskipTests -Dmaven.test.skip=true 
cd ..
cd ServiceRegistery
mvn clean install -DskipTests -Dmaven.test.skip=true 
cd ..
cd ConfigServer
mvn clean install -DskipTests -Dmaven.test.skip=true 
cd ..
cd AuthorizationServiceRpcClient
mvn clean install -DskipTests -Dmaven.test.skip=true 
cd ..
cd MqClientAbstracts
mvn clean install -DskipTests -Dmaven.test.skip=true 
cd ..
cd MqServerAbstracts
mvn clean install -DskipTests -Dmaven.test.skip=true 
cd ..
cd AuthorizationService
mvn clean package spring-boot:repackage -DskipTests -Dmaven.test.skip=true 
cd ..
cd ProjectService
mvn clean package spring-boot:repackage -DskipTests -Dmaven.test.skip=true
cd ..
ls