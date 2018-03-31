const int trigpin1=12;
const int echopin1=13;

long duration1,duration2;
float distance1,distance2;

const int trigpin2=8;
const int echopin2=9;
int v1 = A0;
int g1 = A1;

void setup() {
 
pinMode(trigpin1,OUTPUT);
pinMode(echopin1,INPUT);

pinMode(trigpin2,OUTPUT);
pinMode(echopin2,INPUT);
Serial.begin(9600);  
  digitalWrite(g1, 0);
  digitalWrite(v1, 1);
  
  // put your setup code here, to run once:

}

void loop() {
  // put your main code here, to run repeatedly:
int cm;
digitalWrite(trigpin1,LOW);

delayMicroseconds(2);

digitalWrite(trigpin1,HIGH);
delayMicroseconds(10);
digitalWrite(trigpin1,LOW);

duration1=pulseIn(echopin1,HIGH);

// calculating distance1
distance1=duration1*0.034/2;


digitalWrite(trigpin2,LOW);

delayMicroseconds(2);

digitalWrite(trigpin2,HIGH);
delayMicroseconds(10);
digitalWrite(trigpin2,LOW);

duration2=pulseIn(echopin2,HIGH);

// calculating distance2
distance2=duration2*0.034/2;


Serial.print("(X,Y) COORDINATES ARE :");
Serial.print(distance1);
Serial.print(",");
Serial.println(distance2);

delay(3000);



}
