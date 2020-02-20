# holo

[![GitHub version](https://badge.fury.io/gh/trevnels%2Fholo.svg)](https://badge.fury.io/gh/trevnels%2Fholo)

Image and media display for WPILib Shuffleboard

![Example](https://i.imgur.com/pX6iWqo.png)

### Installation:
See [Releases](https://github.com/trevnels/holo/releases) for installation instructions

### Usage:
- Publish an absolute path to a file located on the driver station to NetworkTables (as a string) from your robot code
- Set its Shuffleboard widget type to "Image View" (for images) or "Media View" (for audio/video) manually or programatically
- Profit!

### Known issues:
 - Media playback will continue in the background if a media view widget is deleted. Until Shuffleboard gets some sort of widget deletion hook for plugins, this behavior will continue.
