from bson import ObjectId

from db import Db
from song import Song

db = Db().access()
song = Song(ObjectId('6479a483eeb5a2390bade3e1'))
print(song.get_name())
