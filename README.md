
# React Native Silent Ping SMS

## Table of contents

* [Synopsis](#synopsis)
* [Description](#description)
* [Links](#links)
* [Installation](#installation)
* [Usage](#usage)
* [Professional Services](#professional-services)
* [Contribute](#contribute)
* [Copying](#copying)

## Synopsis

The react native silent ping sms will send a silent sms to another device and this will retrun the delivery report, tell us if this device is connected. This library only works on Android devices.

## Description

  - Does not require rooted device
  - SMS will not be delivered as standard SMS, target user will receive no visual notification about SMS being received
  - Payload looks like this: `byte[]{0x0A, 0x06, 0x03, (byte) 0xB0, (byte) 0xAF, (byte) 0x82, 0x03, 0x06, 0x6A, 0x00, 0x05}`
	-It will show the delivery report at the java console log.

## Links

  - 3GPP 23.040 (originally GSM 03.40) https://en.wikipedia.org/wiki/GSM_03.40
  - 3GPP 23.038 (originally GSM 03.38) https://en.wikipedia.org/wiki/GSM_03.38

## Installation

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

## Professional Services

We provide special training, bug fixes with editor subscription, contributions for new features, and more.

Obtain a personalized service experience, associated with benefits and opportunities.
[Partner's Network](http://www.teclib-edition.com/en/partners/)

## Contribute

Want to file a bug, contribute some code, or improve documentation? Excellent! Please send your code in a issue and we will check it.[Issues Dashboard](https://github.com/CamposErik/React-Native-Silent-Ping-Sms/issues).

## Copying

* **Name**: [Flyve MDM](https://flyve-mdm.com/) is a registered trademark of [Teclib'](http://www.teclib-edition.com/en/).
* **Code**: you can redistribute it and/or modify it under the terms of the GNU General Public License ([GPLv3](https://www.gnu.org/licenses/gpl-3.0.en.html)).
* **Documentation**: released under Attribution 4.0 International ([CC BY 4.0](https://creativecommons.org/licenses/by/4.0/)).




  
