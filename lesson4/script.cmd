set MEMORY=-Xms2g -Xmx2g

java %MEMORY% -XX:+UseSerialGC -jar target/lesson4-1.0-SNAPSHOT.jar

java %MEMORY% -XX:+UseParallelGC -jar target/lesson4-1.0-SNAPSHOT.jar

java %MEMORY% -XX:+UseConcMarkSweepGC -jar target/lesson4-1.0-SNAPSHOT.jar

java %MEMORY% -XX:+UseG1GC -jar target/lesson4-1.0-SNAPSHOT.jar