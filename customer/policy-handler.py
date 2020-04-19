from flask import Flask
from redis import Redis, RedisError
from kafka import KafkaConsumer
import os
import socket


# To consume latest messages and auto-commit offsets
consumer = KafkaConsumer('fooddelivery',
                         group_id='',
                         bootstrap_servers=['localhost:9092'])
for message in consumer:
    print ("%s:%d:%d: key=%s value=%s" % (message.topic, message.partition,
                                          message.offset, message.key,
                                          message.value))


