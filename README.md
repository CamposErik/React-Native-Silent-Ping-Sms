
# react-native-silent-ping-sms

  - Does not require rooted device
  - SMS will not be delivered as standard SMS, target user will receive no visual notification about SMS being received

## Description

  - Payload looks like this: `byte[]{0x0A, 0x06, 0x03, (byte) 0xB0, (byte) 0xAF, (byte) 0x82, 0x03, 0x06, 0x6A, 0x00, 0x05}`
  - Full SMS PDU looks like this: `03050020 01f61fe0c91246066833682000412 06050423f00000 0a0603b0af8203066a0005`
    - Where first segment is SMSC (SMS Center), second is user-defined data SMS, last segment is payload specified in userspace
    - Using this payload, remote mobile station (baseband) will not deliver or correctly process the SMS, will only provide ACK (delivery report)
	-It will show the delivery report at the java console log.

## Links

  - 3GPP 23.040 (originally GSM 03.40) https://en.wikipedia.org/wiki/GSM_03.40
  - 3GPP 23.038 (originally GSM 03.38) https://en.wikipedia.org/wiki/GSM_03.38

## Getting started

`$ npm install react-native-silent-ping-sms --save`

### Mostly automatic installation

`$ react-native link react-native-silent-ping-sms`

### Manual installation

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNSilentPingSmsPackage;` to the imports at the top of the file
  - Add `new RNSilentPingSmsPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-silent-ping-sms'
  	project(':react-native-silent-ping-sms').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-silent-ping-sms/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      implementation project(':react-native-silent-ping-sms')
  	```
4.  Insert the following lines inside the AndroidManifest.xml in `android/app/src/main/AndroidManifest.xml`:
    ```
    <uses-permission android:name="android.permission.RECEIVE_SMS" />
    <uses-permission android:name="android.permission.SEND_SMS" />
    <uses-permission android:name="android.permission.READ_SMS" />
    ```





## Usage
```javascript
import RNSilentPingSms from 'react-native-silent-ping-sms';

// you can put any number as Id to identify which message being process
    SendSilentSms.send(123, "Numberphone", (msg)=>{alert(msg)});

```
  