# Lokalize - convert your Google Sheet to a localization file you need

## Credits

First of all - credits to [xavierha](https://github.com/xavierha/localize-with-spreadsheet) - this project may be considered as a fork of that one.

The concept and ~50% of an implementation I've took from that project, only converting it to Kotlin.

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

## [Sonarqube](https://sonarcloud.io/dashboard?id=amatsegor_lokalize) badges

![](https://sonarcloud.io/api/project_badges/quality_gate?project=amatsegor_lokalize)

![](https://sonarcloud.io/api/project_badges/measure?project=amatsegor_lokalize&metric=sqale_index)
