# holo
Image and media display for WPILib Shuffleboard

![Example](https://i.imgur.com/pX6iWqo.png)

### Usage:
Send an absolute file path over nt as a string, set widget type to "Image View" (for images) or "Media View" (for audio/video), profit


### Known issue:
Media playback will continue if a media view widget is deleted. Until shuffleboard gets some sort of widget deletion hook for plugins, this behavior will continue.
