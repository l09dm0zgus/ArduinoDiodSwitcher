void setup() {
  pinMode(2,OUTPUT);
  Serial.begin(9600);
  digitalWrite(2,LOW);
}

void loop() {
  if(Serial.available())
  {
    byte data = Serial.read();
    if(data == 49) digitalWrite(2,HIGH);
    if(data == 48) digitalWrite(2,LOW);
  }
}
