# generic sensor data

## generic sensor data collector

This is an api backend written in clojure and run with leiningen/ring.

## generic sensor data fe

This is a simple frontend

## raspberry pi

### login

Raspberry Pi OS user:pi, pass:raspberry

~sudo apt update 
~sudo apt install -y i2c-tools python3-smbus
~sudo raspi-config 
~sudo reboot
~sudo raspi-config 
~history
~sudo i2cdetect -y 1
~python --version

~sudo apt install python3-pip
~sudo pip3 install --upgrade setuptools
~sudo pip3 install --upgrade adafruit-python-shell

~wget https://raw.githubusercontent.com/adafruit/Raspberry-Pi-Installer-Scripts/master/raspi-blinka.py
~sudo python3 raspi-blinka.py 
~pip3 install Adafruit-Blinka

### camera module

~sudo raspi-config
~pip3 install picamera

Then Interfaceing Options -> P1 Camera -> enable

~pip3 install picamera

### PM2.5

pip3 install adafruit-circuitpython-pm25

## License

Eclipse Public License 1.0 (epl-1.0)
Eclipse Public License 2.0 (epl-2.0)