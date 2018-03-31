Code for Q4 B) i) part is in the file celastiline1.ino (Open with wordpad in case you dont have the arduino IDE).

There are two videos :
1. distance measurement using ultrasonic sensor.
2. displaying angle movement by ultrasonic sensor.

OUR Approach:
This particular sensor transmits an ultrasonic sound that has a frequency of about 40 kHz. The sensor has two main parts- transducer that creates an ultrasonic sound wave while the other part listens to its echo.
The transmitter transmits the ultrasonic beam that strikes the flat surface of the obstacle and reflects back to meet the receiver.So, the sensor measures the time in which the transceiver emits the ultrasonic beam and receives it.

The distance is measured by multiplying the time duration with the speed of sound (340 metres/second) to give the distance in centimeters.

The angle by which the sensor gets rotated is measured by calculating the distance1 (BASE) and distance2 (Hypotenuse) and then applying cos inverse formula.
