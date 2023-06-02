import os

from pymongo import MongoClient


class Db:
    def __init__(self):
        self.client = MongoClient(os.environ['MONGODB_CONNECTION_STRING'])["m165-jukebox"]

    def access(self):
        return self.client
