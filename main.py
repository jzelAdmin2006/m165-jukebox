import os

from db import Db

db = Db().access()
print(db.name)
