# Kafka Code

## Clone repo

        apt install git
        git clone https://github.com/suyash-srivastava-dev/testrepo.git

---

## Install Java & Kafka

        ./java_install.sh
        ./kafka_install.sh

---
## Start Zookeeper & Kafka Servers

        bin/zookeeper-server-start.sh config/zookeeper.properties
        bin/kafka-server-start.sh config/server.properties
---

## Create Topic

        bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092

        bin/kafka-topics.sh --describe --topic quickstart-events --bootstrap-server localhost:9092

## Write Events into Topic

        bin/kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:9092

## Read Event 

        bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092

---

# Project KafkaBoot


![image](./assets/Architecture.png)


