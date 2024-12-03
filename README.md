<h1 align="center">Country Code Picker</h1>

[![Kotlin Version](https://img.shields.io/badge/Kotlin-v1.5.31-blue.svg)](https://kotlinlang.org)  [![Platform](https://img.shields.io/badge/Platform-Android-green.svg?style=flat)](https://www.android.com/) [![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)
[![](https://jitpack.io/v/gordonyfg/CountryCodePicker.svg)](https://jitpack.io/#gordonyfg/CountryCodePicker)
<br/>

#### A simple Country Code Picker library for Android completely written in Kotlin.

<img src="https://github.com/Ajinkrishnak/CountryCodePicker/blob/main/art/artgithub.jpeg">
 
## 🛠 Installation

Add the JitPack repository to your ```build.gradle``` (Project) file
```bash
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Add this line to your ```build.gradle``` (module)
```bash
	dependencies {
	        implementation 'com.github.gordonyfg:CountryCodePicker:v1.0.1'
	}
```

## ⌨️ Usage

- Add this in your layout xml file.

```xml
                <com.ak.ui.CountryCodePicker
                    android:id="@+id/ccp_phone"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    app:contentColor="@color/black"
                    app:fontFamily="@font/montserrat_medium"
                    app:showFlag="true"
                    android:gravity="center"
                    app:defaultNameCode="in"
                    app:showArrowDown="true"
                    app:showNameCode="false"
                    app:arrowSize="@dimen/_20sdp"
                    app:textSize="@dimen/_12ssp"
                    app:excludedCountries="ad,ae" />

```

### Parameters

| Explanation               | Parameter Name          | Type       | Default Value            |
| ------------------------- | ----------------------- | ---------- | --------------           |
| Set Content Color           | **contentColor**          | color      | Content Color  |
| Set Show Flag status     | **showFlag**            | boolean    | true                     |
| Set Default code          | **defaultNameCode**        | enum       | in                     |
| Set FontFamily            | **android:fontFamily**  | font       | Android Default          | 
| Set Show Arrow status     | **showArrowDown**            | boolean    | true                     |
| Set Show Name Code status     | **showNameCode**            | boolean    | true                     |


## ✍️ Original Author
* <b>Ajinkrishna</b>


## 📝 License

```
Apache License 2.0

Copyright (c) 2021 Ajinkrishna

Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
