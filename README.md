# holo

[![GitHub version](https://badge.fury.io/gh/trevnels%2Fholo.svg)](https://badge.fury.io/gh/trevnels%2Fholo)

Image and media display for WPILib Shuffleboard

![Example](https://i.imgur.com/pX6iWqo.png)

### Installation:
See [Releases](https://github.com/trevnels/holo/releases) for installation instructions

### Usage:
- Publish an absolute path to a file located on the driver station to NetworkTables (as a string) from your robot code
- Add it to a dashboard tab
- Set its Shuffleboard widget type to "Image View" (for images) or "Media View" (for audio/video) manually or programatically
- Profit!

A few notes:
- Some formats (i.e. mp4) will not work on Linux without an older version of ffmpeg.
- GIFs will play and loop in the Image View widget
- You can pass audio files to a Media View, and they will play on repeat, though the widget will appear blank. WAV tends to work best.
