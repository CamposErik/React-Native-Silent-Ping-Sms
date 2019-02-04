
# react-native-silent-ping-sms

## Getting started

`$ npm install react-native-silent-ping-sms --save`

### Mostly automatic installation

`$ react-native link react-native-silent-ping-sms`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-silent-ping-sms` and add `RNSilentPingSms.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNSilentPingSms.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

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
      compile project(':react-native-silent-ping-sms')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNSilentPingSms.sln` in `node_modules/react-native-silent-ping-sms/windows/RNSilentPingSms.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Silent.Ping.Sms.RNSilentPingSms;` to the usings at the top of the file
  - Add `new RNSilentPingSmsPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNSilentPingSms from 'react-native-silent-ping-sms';

// TODO: What to do with the module?
RNSilentPingSms;
```
  