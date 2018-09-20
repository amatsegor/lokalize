# Reqiurements for a Google Sheets document

* Your spreadsheet should be "Published" for the app to work (File -> Publish to the web)
* First row of a sheet should be a header row - so usually, a sheet is formatted in such a way:
<pre>
_________________________________________
|     KEY      |     EN     |     DE     |
----------------------------------------
|    my_key    |  StringEN  |  StringDE  |
-----------------------------------------
</pre>
So, in this case, the first column of a sheet will be containing keys (unique id-s) of a localization entity (line/array/plural).
And into the other ones corresponding localization string will be placed.
* Android platform supports a `string-array` type of localization entity. This means that you can create a named array
of strings, put some into it and then do something like this:<pre>val stringArray: Array<String> = context.getStringArray(R.array.strings1)</pre>
If you want to add such array to your spreadsheet, it should be declared using this syntax:
<pre>
________________________________________
|     KEY      |     EN     |     DE    |
_______________________________________
[first_array]  |            |           | // array id
----------------------------------------
               |  StringEN  |  StringDE |
----------------------------------------
               |  AnoStrEN  |  AnoStrDE |
----------------------------------------
[<b>/</b>first_array] |            |           | // same array id with closing slash before
----------------------------------------
</pre>

* Also, on Android (iOS - soon) you can use a [plural strings](https://developer.android.com/guide/topics/resources/string-resource#Plurals) format.
In this case, you should declare localizations in such format:
<pre>
______________________________________________
|        KEY         |     EN     |     DE    |
______________________________________________
first_plural.plural  |            |           | // plural id with "plural" suffix
----------------------------------------------
        zero         |  ZeroStEN  |  ZeroStDE |
----------------------------------------------
         one         |  OneStrEN  |  OneStrDE |
----------------------------------------------
         two         |  TwoStrEN  |  TwoStrDE |
----------------------------------------------
<b>!</b>first_plural.plural |            |           | // same id, but with leading exclamation
----------------------------------------------
</pre>
Supported quantifiers (value keys) are: `zero`,`one`,`two`,`few`,`many`,`other`

###To see a real example of a spreadsheet - [click here](https://docs.google.com/spreadsheets/d/1rVIuMUuuJcZNLmAnCRosxOqiZJ-jtRqBz2rkDXvFG8w/edit?usp=sharing)