const int trigpin=12;
const int echopin=13;

long duration1,duration2;
float distance1,distance2;
int v1 = A0;
int g1 = A1;

void setup() {
 
pinMode(trigpin,OUTPUT);
pinMode(echopin,INPUT);
Serial.begin(9600);  
  digitalWrite(g1, 0);
  digitalWrite(v1, 1);
  
  // put your setup code here, to run once:

}

void loop() {
  // put your main code here, to run repeatedly:
int cm;
digitalWrite(trigpin,LOW);

delayMicroseconds(2);

digitalWrite(trigpin,HIGH);
delayMicroseconds(10);
digitalWrite(trigpin,LOW);

duration1=pulseIn(echopin,HIGH);

// calculating distance1
distance1=duration1*0.034/2;

delay(3000);


digitalWrite(trigpin,LOW);

delayMicroseconds(2);

digitalWrite(trigpin,HIGH);
delayMicroseconds(10);
digitalWrite(trigpin,LOW);

duration2=pulseIn(echopin,HIGH);

// calculating distance2
distance2=duration2*0.034/2;




//calculating angle
Serial.println("\n");



Serial.print("Angle: ");

Serial.print(acos(distance1/distance2)*180/3.14);
Serial.println(" degrees");






}
