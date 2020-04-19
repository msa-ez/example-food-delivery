from flask import Flask
from redis import Redis, RedisError
from kafka import KafkaConsumer
import os
import socket

app = Flask(__name__)

@app.route("/customer")
def hello():

    html = "<h3>Hello {name}!</h3>" \
           "<b>Hostname:</b> {hostname}<br/>"

    return html.format(name=os.getenv("NAME", "world"), hostname=socket.gethostname())

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=8084)
