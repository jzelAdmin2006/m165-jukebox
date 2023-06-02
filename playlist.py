from db import Db


class Playlist:
    def __init__(self, object_id):
        self.object_id = object_id
        db = Db().access()
        data = db['playlists'].find_one({'_id': object_id})
        self.name = data['name']
        self.songs = data['songs']

    def get_name(self):
        return self.name

    def get_songs(self):
        return self.songs
