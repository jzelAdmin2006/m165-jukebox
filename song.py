from db import Db


class Song:
    def __init__(self, object_id, name=None, interpreter=None, album=None, genre=None, release=None):
        if object_id is None:
            self.name = name
            self.interpreter = interpreter
            self.album = album
            self.genre = genre
            self.release = release
            db = Db().access()
            db['songs'].insert_one(
                {"name": name,
                 "interpreter": interpreter,
                 "album": album,
                 "genre": genre,
                 "release": release
                 }
            )
        else:
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
