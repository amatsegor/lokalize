# LokalizeGS - convert your Google Sheet to a localization file you need

## Credits

First of all - credits to [xavierha](https://github.com/xavierha/localize-with-spreadsheet) - this project may be considered as a fork of that one.

The concept and `Transformer`-s implementation I've took from that project, only converting it to Kotlin.

As an Android developer I've used an original `localize-with-spreadsheet` for 2+ years and that was fine (excepting that it doesn't support string-array's), so my warm greetings to **xavierha** - man, you helped me really much.

## Description

This app/module helps you to convert a specifically-formatted Google Sheet containing localization strings for different languages into a format used by the most popular platforms/langs, such as:

* Android
* iOS
* .NET
* Dart (hey, [Flutter](https://github.com/flutter/flutter)!)
* Dart template

It's written using a multi-platform projects (MPP) feature of Kotlin language, so nearly 65% of LOC are shared and platform-independent.

So why didn't I just remove a NodeJS flavor (desktop one is really easier to use)? Well, it's a good chance to try MPP on a real project - and this is the only reason, I guess

### Features:
* 6 supported platforms
* Support for `string-array`-s in Android
* Portability

### Implementation:
Language: Kotlin 1.2.70

**Common**: kotlinx-coroutines

**Desktop**: kotlinx-coroutines, slf4j

**JS**: kotlinx-coroutines


## Usage:

### Notes:
* The app will preserve everything that is above the tags: <pre>< !-- AUTO-GENERATED --> (Android)</pre>or<pre>// AUTO-GENERATED (e-thing else)</pre>
So, any changes that you manually make below this tags, will be overwritten after the next application launch

* Your spreadsheet should be "Published" for the app to work (File -> Publish to the web)

### Configuration
`key` - Google Sheet key (https:// docs.google.com/ spreadsheets/d/**1rVIuMUuuJcZNLmAnCRosxOqiZJ-jtRqBz2rkDXvFG8w**/edit)

`sheets` - Array of sheet names. May include either specific sheets (Sheet1, Sheet2) or just ``["*"]`` (so app will fetch all sheets in a document)

`options` object - Additional options.
* `format` - which platform file format you want to get in output **(required)**
* `keyCol` - title of a column you want to use as translation key **(required)**
* `encoding` - encoding of an output file. Default: utf8

`targets` object - defines which columns you want to be parsed and in what file
* `valueCol` - title of a column used as a language key
* `filepath` - path to a target file

### Desktop app
**Requires:** JDK/JRE 1.8+ installed

First, you should create a config JSON file ([click to see example file](https://github.com/amatsegor/lokalize-gs/blob/master/sample/config.json)).

Then [download](https://github.com/amatsegor/lokalize-gs/releases) a JAR executable file, open a terminal and launch a JAR using such command: <pre>`java -jar lokalize-desktop-x.x.jar $PATH_TO_CONFIG_JSON_FILE`</pre>

That's it! App should load a Google Sheets document. parse it and create a file structure you specified in a config.

## Plans
* Fix issue when .NET converter overwrites whole existing file, even if a `AUTO-GENERATED` tag is present **(DONE)**
* Add support for plurals
* Develop an Android Studio plugin
* Add support for converting translations from PO/POT files

## Contributing

Issues/PRs are extremely welcome - please, find as much bugs as you can!

## [Sonarqube](https://sonarcloud.io/dashboard?id=amatsegor_lokalize) badges

![](https://sonarcloud.io/api/project_badges/quality_gate?project=amatsegor_lokalize)

![](https://sonarcloud.io/api/project_badges/measure?project=amatsegor_lokalize&metric=sqale_index)
