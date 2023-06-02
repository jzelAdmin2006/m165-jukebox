from bson import ObjectId

from db import Db
from playlist import Playlist
from song import Song

db = Db().access()
song = Song(ObjectId('6479a483eeb5a2390bade3e1'))
print(song.get_name())

playlist = Playlist(ObjectId('6479ae69a07f8ea31a11e769'))
print(playlist.get_name())
print(playlist.get_songs())
