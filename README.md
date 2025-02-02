## Kafka Setup on Windows #
 
-- provides steps to start Zookeeper, the Kafka server, and create Kafka topics on a Windows environment.

------- 
## Prerequisites ##

-- Ensure you have downloaded and extracted Kafka (kafka_2.12-3.7.0) on your system.
-- Java should be installed and configured in your environment variables.

------------------
## Starting Zookeeper
1. Open PowerShell and navigate to the Kafka directory:

```declarative
        PS C:\WINDOWS\system32> cd ../..
        PS C:\> cd .\kafka_2.12-3.7.0\

```
2. Start Zookeeper: 

```declarative
    PS C:\kafka_2.12-3.7.0> .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```
------------------

## Starting Kafka Server #
1. Open a new PowerShell window and navigate to the Kafka directory:

```declarative
    PS C:\WINDOWS\system32> cd ../..
    PS C:\> cd .\kafka_2.12-3.7.0\
```
2. Start the Kafka server:
```declarative
    PS C:\kafka_2.12-3.7.0> .\bin\windows\kafka-server-start.bat .\config\server.properties
```
------------------------
## Creating Kafka Topics #
After starting both Zookeeper and the Kafka server, you can create topics. 
1. To create a topic named test-topic:
```declarative
    .\bin\windows\kafka-topics.bat --create --topic test-topic --bootstrap-server localhost:9092 
      --partitions 1 --replication-factor 1
```
Output:
```declarative
    Created topic test-topic.
```
2. To create another topic named user-events:
```declarative
    .\bin\windows\kafka-topics.bat --create --topic user-events --bootstrap-server localhost:9092 
        --partitions 1 --replication-factor 1
```
Output:
```declarative
    Created topic user-events.
```
--------------------
## Verifying Created Topics #
To list all created topics, run:
```declarative
    .\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092
```


