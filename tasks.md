# Tasks

- ✅ Binary data (FLAC) in DB
    - https://github.com/DukeXCode/m165-binary-poc
- ✅ Software/DB Architecture:
    - Software: m165-jukebox.drawio
    - DB (songs): {"_id":{"$oid":"6479a483eeb5a2390bade3e1"},"name":"foo","interpreter":"bar","album":"FooBar","genre":"
      FooBarStyle","release":{"$date":{"$numberLong":"1675638000000"}}}
    - DB (playlists): {"_id":{"$oid":"6479ae69a07f8ea31a11e769"},"songs":[{"$oid":"6479a483eeb5a2390bade3e1"}],"name":"
      FooBarList"}
- CLI
- Player
- Manager
