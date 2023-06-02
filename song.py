import os

from pymongo import MongoClient

from db import Db


class Song:
    def __init__(self, object_id):
        self.object_id = object_id
        db = Db().access()
        data = db['songs'].find_one({'_id': object_id})
        self.name = data['name']
        self.interpreter = data['interpreter']
        self.album = data['album']
        self.genre = data['genre']
        self.release = data['release']

    def get_name(self):
        return self.name

    def get_interpreter(self):
        return self.interpreter

    def get_album(self):
        return self.album

    def get_genre(self):
        return self.genre

    def get_release(self):
        return self.release
