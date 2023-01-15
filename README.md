# holo
Image and media display for WPILib Shuffleboard

![Example](https://i.imgur.com/pX6iWqo.png)

### Usage:
Send an absolute file path over NT as a string, add it to your dashboard, set its widget type to "Image View" (for images) or "Media View" (for audio/video), profit

A few notes:
- Some formats (i.e. mp4) will not work on Linux without an older version of ffmpeg.
- GIFs will play and loop in the Image View widget
- You can pass audio files to a Media View, and they will play on repeat, though the widget will appear blank. WAV tends to work best.
