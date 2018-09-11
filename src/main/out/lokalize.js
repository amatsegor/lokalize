(function (_, Kotlin, $module$google_spreadsheet) {
  'use strict';
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var lazy = Kotlin.kotlin.lazy_klfg04$;
  var listOf = Kotlin.kotlin.collections.listOf_mh5how$;
  var Unit = Kotlin.kotlin.Unit;
  var indexOf = Kotlin.kotlin.text.indexOf_l5u8uk$;
  var Kind_OBJECT = Kotlin.Kind.OBJECT;
  var toList = Kotlin.kotlin.collections.toList_us0mfu$;
  var toIntOrNull = Kotlin.kotlin.text.toIntOrNull_pdl1vz$;
  var equals = Kotlin.equals;
  var addAll = Kotlin.kotlin.collections.addAll_ye1y7v$;
  var IllegalArgumentException_init = Kotlin.kotlin.IllegalArgumentException_init_pdl1vj$;
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  LSArray.prototype = Object.create(LSEntity.prototype);
  LSArray.prototype.constructor = LSArray;
  LSLine.prototype = Object.create(LSEntity.prototype);
  LSLine.prototype.constructor = LSLine;
  FakeReader.prototype = Object.create(AbstractReader.prototype);
  FakeReader.prototype.constructor = FakeReader;
  GSReader.prototype = Object.create(AbstractReader.prototype);
  GSReader.prototype.constructor = GSReader;
  AndroidTransformer.prototype = Object.create(AbstractTransformer.prototype);
  AndroidTransformer.prototype.constructor = AndroidTransformer;
  DartTemplateTransformer.prototype = Object.create(AbstractTransformer.prototype);
  DartTemplateTransformer.prototype.constructor = DartTemplateTransformer;
  DartTransformer.prototype = Object.create(AbstractTransformer.prototype);
  DartTransformer.prototype.constructor = DartTransformer;
  DotNetTransformer.prototype = Object.create(AbstractTransformer.prototype);
  DotNetTransformer.prototype.constructor = DotNetTransformer;
  IOSTransformer.prototype = Object.create(AbstractTransformer.prototype);
  IOSTransformer.prototype.constructor = IOSTransformer;
  JsonTransformer.prototype = Object.create(AbstractTransformer.prototype);
  JsonTransformer.prototype.constructor = JsonTransformer;
  FakeWriter.prototype = Object.create(AbstractWriter.prototype);
  FakeWriter.prototype.constructor = FakeWriter;
  FileWriter.prototype = Object.create(AbstractWriter.prototype);
  FileWriter.prototype.constructor = FileWriter;
  function SpreadsheetWorksheet(url, id, title, rowCount, colCount) {
    this.url = url;
    this.id = id;
    this.title = title;
    this.rowCount = rowCount;
    this.colCount = colCount;
  }
  SpreadsheetWorksheet.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'SpreadsheetWorksheet',
    interfaces: []
  };
  SpreadsheetWorksheet.prototype.component1 = function () {
    return this.url;
  };
  SpreadsheetWorksheet.prototype.component2 = function () {
    return this.id;
  };
  SpreadsheetWorksheet.prototype.component3 = function () {
    return this.title;
  };
  SpreadsheetWorksheet.prototype.component4 = function () {
    return this.rowCount;
  };
  SpreadsheetWorksheet.prototype.component5 = function () {
    return this.colCount;
  };
  SpreadsheetWorksheet.prototype.copy_cfnaqq$ = function (url, id, title, rowCount, colCount) {
    return new SpreadsheetWorksheet(url === void 0 ? this.url : url, id === void 0 ? this.id : id, title === void 0 ? this.title : title, rowCount === void 0 ? this.rowCount : rowCount, colCount === void 0 ? this.colCount : colCount);
  };
  SpreadsheetWorksheet.prototype.toString = function () {
    return 'SpreadsheetWorksheet(url=' + Kotlin.toString(this.url) + (', id=' + Kotlin.toString(this.id)) + (', title=' + Kotlin.toString(this.title)) + (', rowCount=' + Kotlin.toString(this.rowCount)) + (', colCount=' + Kotlin.toString(this.colCount)) + ')';
  };
  SpreadsheetWorksheet.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.url) | 0;
    result = result * 31 + Kotlin.hashCode(this.id) | 0;
    result = result * 31 + Kotlin.hashCode(this.title) | 0;
    result = result * 31 + Kotlin.hashCode(this.rowCount) | 0;
    result = result * 31 + Kotlin.hashCode(this.colCount) | 0;
    return result;
  };
  SpreadsheetWorksheet.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.url, other.url) && Kotlin.equals(this.id, other.id) && Kotlin.equals(this.title, other.title) && Kotlin.equals(this.rowCount, other.rowCount) && Kotlin.equals(this.colCount, other.colCount)))));
  };
  function WorksheetsResponse(id, title, updated, author, worksheets) {
    this.id = id;
    this.title = title;
    this.updated = updated;
    this.author = author;
    this.worksheets = worksheets;
  }
  WorksheetsResponse.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'WorksheetsResponse',
    interfaces: []
  };
  WorksheetsResponse.prototype.component1 = function () {
    return this.id;
  };
  WorksheetsResponse.prototype.component2 = function () {
    return this.title;
  };
  WorksheetsResponse.prototype.component3 = function () {
    return this.updated;
  };
  WorksheetsResponse.prototype.component4 = function () {
    return this.author;
  };
  WorksheetsResponse.prototype.component5 = function () {
    return this.worksheets;
  };
  WorksheetsResponse.prototype.copy_a97jvy$ = function (id, title, updated, author, worksheets) {
    return new WorksheetsResponse(id === void 0 ? this.id : id, title === void 0 ? this.title : title, updated === void 0 ? this.updated : updated, author === void 0 ? this.author : author, worksheets === void 0 ? this.worksheets : worksheets);
  };
  WorksheetsResponse.prototype.toString = function () {
    return 'WorksheetsResponse(id=' + Kotlin.toString(this.id) + (', title=' + Kotlin.toString(this.title)) + (', updated=' + Kotlin.toString(this.updated)) + (', author=' + Kotlin.toString(this.author)) + (', worksheets=' + Kotlin.toString(this.worksheets)) + ')';
  };
  WorksheetsResponse.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.id) | 0;
    result = result * 31 + Kotlin.hashCode(this.title) | 0;
    result = result * 31 + Kotlin.hashCode(this.updated) | 0;
    result = result * 31 + Kotlin.hashCode(this.author) | 0;
    result = result * 31 + Kotlin.hashCode(this.worksheets) | 0;
    return result;
  };
  WorksheetsResponse.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.id, other.id) && Kotlin.equals(this.title, other.title) && Kotlin.equals(this.updated, other.updated) && Kotlin.equals(this.author, other.author) && Kotlin.equals(this.worksheets, other.worksheets)))));
  };
  function Process$lambda() {
    return require('process');
  }
  var Process;
  function get_Process() {
    return Process.value;
  }
  function Fs$lambda() {
    return require('fs');
  }
  var Fs;
  function get_Fs() {
    return Fs.value;
  }
  function Q$lambda() {
    return require('q');
  }
  var Q;
  function get_Q() {
    return Q.value;
  }
  function main$lambda(it) {
    console.log(it);
    return Unit;
  }
  var emptyList = Kotlin.kotlin.collections.emptyList_287e2$;
  function main(args) {
    var options = new Options();
    (new FileWriter()).write_z2wymv$('./file.txt', emptyList(), new AndroidTransformer(), options);
    (new GSReader('1Ej7CiQpGUzbl2Ehb2P2cOpqBzhiWakFKJKW18uakZrw', listOf('*'))).select_ffqom1$(emptyList(), '', '', main$lambda);
  }
  function LSArray(key, lines) {
    LSEntity.call(this, key);
    this.lines = lines;
  }
  Object.defineProperty(LSArray.prototype, 'isEmpty', {
    get: function () {
      return this.lines.isEmpty();
    }
  });
  Object.defineProperty(LSArray.prototype, 'isComment', {
    get: function () {
      return false;
    }
  });
  LSArray.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'LSArray',
    interfaces: [LSEntity]
  };
  function LSEntity(key) {
    this.key = key;
  }
  LSEntity.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'LSEntity',
    interfaces: []
  };
  function LSLine(key, value) {
    LSLine$Companion_getInstance();
    LSEntity.call(this, key);
    this.value = value;
    if (this.isComment) {
      this.key = LSLine$Companion_getInstance().normalizeComment_0(key);
    }
  }
  Object.defineProperty(LSLine.prototype, 'isEmpty', {
    get: function () {
      return this.value.length === 0;
    }
  });
  Object.defineProperty(LSLine.prototype, 'isComment', {
    get: function () {
      return LSLine$Companion_getInstance().checkIsComment_0(this.key);
    }
  });
  function LSLine$Companion() {
    LSLine$Companion_instance = this;
    this.COMMENT_STARTERS_0 = ['//', '#'];
  }
  LSLine$Companion.prototype.checkIsComment_0 = function (value) {
    var $receiver = this.COMMENT_STARTERS_0;
    var any$result;
    any$break: do {
      var tmp$;
      for (tmp$ = 0; tmp$ !== $receiver.length; ++tmp$) {
        var element = $receiver[tmp$];
        if (indexOf(value, element) === 0) {
          any$result = true;
          break any$break;
        }
      }
      any$result = false;
    }
     while (false);
    return any$result;
  };
  var throwCCE = Kotlin.throwCCE;
  var trim = Kotlin.kotlin.text.trim_gw00vp$;
  LSLine$Companion.prototype.normalizeComment_0 = function (value) {
    var normalized = {v: value};
    var $receiver = this.COMMENT_STARTERS_0;
    var tmp$;
    for (tmp$ = 0; tmp$ !== $receiver.length; ++tmp$) {
      var element = $receiver[tmp$];
      var index = indexOf(normalized.v, element);
      if (index === 0) {
        var $receiver_0 = normalized.v;
        var startIndex = element.length;
        var endIndex = normalized.v.length - element.length | 0;
        normalized.v = $receiver_0.substring(startIndex, endIndex);
      }
    }
    var $receiver_1 = normalized.v;
    var tmp$_0;
    return trim(Kotlin.isCharSequence(tmp$_0 = $receiver_1) ? tmp$_0 : throwCCE()).toString();
  };
  LSLine$Companion.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Companion',
    interfaces: []
  };
  var LSLine$Companion_instance = null;
  function LSLine$Companion_getInstance() {
    if (LSLine$Companion_instance === null) {
      new LSLine$Companion();
    }
    return LSLine$Companion_instance;
  }
  LSLine.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'LSLine',
    interfaces: [LSEntity]
  };
  function Options(keyCol, valueCol, format, encoding, className, baseClass, header, footer) {
    if (keyCol === void 0)
      keyCol = '';
    if (valueCol === void 0)
      valueCol = '';
    if (format === void 0)
      format = 'android';
    if (encoding === void 0)
      encoding = 'utf-8';
    if (className === void 0)
      className = '';
    if (baseClass === void 0)
      baseClass = '';
    if (header === void 0)
      header = '';
    if (footer === void 0)
      footer = '';
    this.keyCol = keyCol;
    this.valueCol = valueCol;
    this.format = format;
    this.encoding = encoding;
    this.className = className;
    this.baseClass = baseClass;
    this.header = header;
    this.footer = footer;
  }
  Options.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Options',
    interfaces: []
  };
  Options.prototype.component1 = function () {
    return this.keyCol;
  };
  Options.prototype.component2 = function () {
    return this.valueCol;
  };
  Options.prototype.component3 = function () {
    return this.format;
  };
  Options.prototype.component4 = function () {
    return this.encoding;
  };
  Options.prototype.component5 = function () {
    return this.className;
  };
  Options.prototype.component6 = function () {
    return this.baseClass;
  };
  Options.prototype.component7 = function () {
    return this.header;
  };
  Options.prototype.component8 = function () {
    return this.footer;
  };
  Options.prototype.copy_osr9do$ = function (keyCol, valueCol, format, encoding, className, baseClass, header, footer) {
    return new Options(keyCol === void 0 ? this.keyCol : keyCol, valueCol === void 0 ? this.valueCol : valueCol, format === void 0 ? this.format : format, encoding === void 0 ? this.encoding : encoding, className === void 0 ? this.className : className, baseClass === void 0 ? this.baseClass : baseClass, header === void 0 ? this.header : header, footer === void 0 ? this.footer : footer);
  };
  Options.prototype.toString = function () {
    return 'Options(keyCol=' + Kotlin.toString(this.keyCol) + (', valueCol=' + Kotlin.toString(this.valueCol)) + (', format=' + Kotlin.toString(this.format)) + (', encoding=' + Kotlin.toString(this.encoding)) + (', className=' + Kotlin.toString(this.className)) + (', baseClass=' + Kotlin.toString(this.baseClass)) + (', header=' + Kotlin.toString(this.header)) + (', footer=' + Kotlin.toString(this.footer)) + ')';
  };
  Options.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.keyCol) | 0;
    result = result * 31 + Kotlin.hashCode(this.valueCol) | 0;
    result = result * 31 + Kotlin.hashCode(this.format) | 0;
    result = result * 31 + Kotlin.hashCode(this.encoding) | 0;
    result = result * 31 + Kotlin.hashCode(this.className) | 0;
    result = result * 31 + Kotlin.hashCode(this.baseClass) | 0;
    result = result * 31 + Kotlin.hashCode(this.header) | 0;
    result = result * 31 + Kotlin.hashCode(this.footer) | 0;
    return result;
  };
  Options.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.keyCol, other.keyCol) && Kotlin.equals(this.valueCol, other.valueCol) && Kotlin.equals(this.format, other.format) && Kotlin.equals(this.encoding, other.encoding) && Kotlin.equals(this.className, other.className) && Kotlin.equals(this.baseClass, other.baseClass) && Kotlin.equals(this.header, other.header) && Kotlin.equals(this.footer, other.footer)))));
  };
  function AbstractReader() {
  }
  AbstractReader.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'AbstractReader',
    interfaces: []
  };
  function FakeReader() {
    AbstractReader.call(this);
  }
  FakeReader.prototype.select_ffqom1$ = function (sheets, keyCol, valCol, callback) {
    return Promise.resolve(emptyList());
  };
  FakeReader.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'FakeReader',
    interfaces: [AbstractReader]
  };
  function GSReader(spreadsheetKey, sheetsFilter) {
    GSReader$Companion_getInstance();
    AbstractReader.call(this);
    this.sheetsFilter = sheetsFilter;
    this.isFetching_0 = false;
    this.sheet_0 = new $module$google_spreadsheet(spreadsheetKey);
    this.fetchedWorksheets_0 = null;
    this.fetchDeferred_0 = get_Q().defer();
  }
  function GSReader$fetchAllCells$lambda$lambda(this$GSReader) {
    return function (it) {
      this$GSReader.fetchedWorksheets_0 = it;
      this$GSReader.fetchDeferred_0.resolve(it);
      return Unit;
    };
  }
  function GSReader$fetchAllCells$lambda(this$GSReader) {
    return function (err, data) {
      if (err != null) {
        console.error('Error while fetching the Spreadsheet (' + err + ')');
        console.warn('WARNING! Check that your spreadsheet is "Published" in "File > Publish to the web..."');
        this$GSReader.fetchDeferred_0.reject(err);
      }
       else if (data != null) {
        this$GSReader.isFetching_0 = false;
        var worksheetsData = JSON.parse(JSON.stringify(data));
        var worksheetReader = new WorksheetReader(this$GSReader.sheet_0, toList(worksheetsData.worksheets), this$GSReader.sheetsFilter);
        worksheetReader.read_rn9x60$(GSReader$fetchAllCells$lambda$lambda(this$GSReader));
      }
       else
        this$GSReader.fetchDeferred_0.reject('Got neither data or error');
      return;
    };
  }
  GSReader.prototype.fetchAllCells_0 = function () {
    var worksheets = this.fetchedWorksheets_0;
    if (worksheets == null) {
      if (!this.isFetching_0) {
        this.isFetching_0 = true;
        console.log('Fetching...');
        this.sheet_0.getInfo(GSReader$fetchAllCells$lambda(this));
      }
      return this.fetchDeferred_0.promise;
    }
     else {
      return worksheets;
    }
  };
  function GSReader$select$lambda(closure$keyCol, closure$valCol, this$GSReader, closure$deferred) {
    return function (cells) {
      console.log('selected ' + cells.size + ' cells');
      var entities = this$GSReader.extractFromRawData_0(cells, closure$keyCol, closure$valCol);
      return closure$deferred.resolve(entities);
    };
  }
  function GSReader$select$lambda_0(err) {
    console.error(err);
    return Unit;
  }
  GSReader.prototype.select_ffqom1$ = function (sheets, keyCol, valCol, callback) {
    var deferred = get_Q().defer();
    get_Q().when(this.fetchAllCells_0(), GSReader$select$lambda(keyCol, valCol, this, deferred)).fail(GSReader$select$lambda_0);
    return deferred.promise;
  };
  GSReader.prototype.extractFromRawData_0 = function (cells, keyCol, valCol) {
    this.extractFromWorksheet_0(cells, keyCol, valCol);
    return emptyList();
  };
  GSReader.prototype.extractFromWorksheet_0 = function (cells, keyCol, valCol) {
    var results = emptyList();
    this.flattenWorksheet_0(cells);
    return results;
  };
  GSReader.prototype.flattenWorksheet_0 = function (cells) {
    console.log('Cell[0] = ' + cells.get_za3lpa$(0));
  };
  function GSReader$Companion() {
    GSReader$Companion_instance = this;
  }
  GSReader$Companion.prototype.shouldUseWorksheet_ruezxl$ = function (worksheetTitles, title, index) {
    if (this.shouldIncludeAllWorksheets_0(worksheetTitles)) {
      return true;
    }
     else {
      var tmp$;
      tmp$ = worksheetTitles.iterator();
      while (tmp$.hasNext()) {
        var element = tmp$.next();
        var intValue = toIntOrNull(element);
        if (intValue != null && intValue === index)
          return true;
        if (equals(element, title))
          return true;
      }
      return false;
    }
  };
  GSReader$Companion.prototype.shouldIncludeAllWorksheets_0 = function (sheetsFilter) {
    return sheetsFilter == null || sheetsFilter.contains_11rb$('*');
  };
  GSReader$Companion.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Companion',
    interfaces: []
  };
  var GSReader$Companion_instance = null;
  function GSReader$Companion_getInstance() {
    if (GSReader$Companion_instance === null) {
      new GSReader$Companion();
    }
    return GSReader$Companion_instance;
  }
  GSReader.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'GSReader',
    interfaces: [AbstractReader]
  };
  var ArrayList_init = Kotlin.kotlin.collections.ArrayList_init_287e2$;
  function WorksheetReader(gs, worksheets, sheetsFilter) {
    this.gs_0 = gs;
    this.worksheets_0 = worksheets;
    this.sheetsFilter_0 = sheetsFilter;
    this.cells_0 = ArrayList_init();
    this.index_0 = 0;
  }
  function WorksheetReader$read$lambda$lambda(this$WorksheetReader, closure$callback) {
    return function (err, cells) {
      var tmp$;
      tmp$ = this$WorksheetReader.index_0;
      this$WorksheetReader.index_0 = tmp$ + 1 | 0;
      if (err != null) {
        console.log(err);
      }
      if (cells != null) {
        addAll(this$WorksheetReader.cells_0, cells);
      }
      if (this$WorksheetReader.index_0 === this$WorksheetReader.worksheets_0.size)
        closure$callback(this$WorksheetReader.cells_0);
      return Unit;
    };
  }
  WorksheetReader.prototype.read_rn9x60$ = function (callback) {
    var tmp$;
    tmp$ = this.worksheets_0.iterator();
    while (tmp$.hasNext()) {
      var element = tmp$.next();
      if (GSReader$Companion_getInstance().shouldUseWorksheet_ruezxl$(this.sheetsFilter_0, element.title, this.index_0 + 1 | 0)) {
        this.gs_0.getCells(element.id, WorksheetReader$read$lambda$lambda(this, callback));
      }
       else {
        this.index_0 = this.index_0 + 1 | 0;
        if (this.index_0 === this.worksheets_0.size)
          callback(this.cells_0);
      }
    }
  };
  WorksheetReader.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'WorksheetReader',
    interfaces: []
  };
  function AbstractTransformer() {
  }
  AbstractTransformer.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'AbstractTransformer',
    interfaces: []
  };
  function AndroidTransformer() {
    AbstractTransformer.call(this);
  }
  var NotImplementedError_init = Kotlin.kotlin.NotImplementedError;
  AndroidTransformer.prototype.transformArray_umhckl$ = function (array) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  AndroidTransformer.prototype.transformComment_61zpoe$ = function (comment) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  AndroidTransformer.prototype.transformKeyValue_puj7f4$ = function (key, value) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  AndroidTransformer.prototype.insert_edr9kb$ = function (input, newValues, options) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  AndroidTransformer.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'AndroidTransformer',
    interfaces: [AbstractTransformer]
  };
  function DartTemplateTransformer() {
    AbstractTransformer.call(this);
  }
  DartTemplateTransformer.prototype.transformArray_umhckl$ = function (array) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  DartTemplateTransformer.prototype.transformComment_61zpoe$ = function (comment) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  DartTemplateTransformer.prototype.transformKeyValue_puj7f4$ = function (key, value) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  DartTemplateTransformer.prototype.insert_edr9kb$ = function (input, newValues, options) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  DartTemplateTransformer.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'DartTemplateTransformer',
    interfaces: [AbstractTransformer]
  };
  function DartTransformer() {
    AbstractTransformer.call(this);
  }
  DartTransformer.prototype.transformArray_umhckl$ = function (array) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  DartTransformer.prototype.transformComment_61zpoe$ = function (comment) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  DartTransformer.prototype.transformKeyValue_puj7f4$ = function (key, value) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  DartTransformer.prototype.insert_edr9kb$ = function (input, newValues, options) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  DartTransformer.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'DartTransformer',
    interfaces: [AbstractTransformer]
  };
  function DotNetTransformer() {
    AbstractTransformer.call(this);
  }
  DotNetTransformer.prototype.transformArray_umhckl$ = function (array) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  DotNetTransformer.prototype.transformComment_61zpoe$ = function (comment) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  DotNetTransformer.prototype.transformKeyValue_puj7f4$ = function (key, value) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  DotNetTransformer.prototype.insert_edr9kb$ = function (input, newValues, options) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  DotNetTransformer.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'DotNetTransformer',
    interfaces: [AbstractTransformer]
  };
  function IOSTransformer() {
    AbstractTransformer.call(this);
  }
  IOSTransformer.prototype.transformArray_umhckl$ = function (array) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  IOSTransformer.prototype.transformComment_61zpoe$ = function (comment) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  IOSTransformer.prototype.transformKeyValue_puj7f4$ = function (key, value) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  IOSTransformer.prototype.insert_edr9kb$ = function (input, newValues, options) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  IOSTransformer.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'IOSTransformer',
    interfaces: [AbstractTransformer]
  };
  function JsonTransformer() {
    AbstractTransformer.call(this);
  }
  JsonTransformer.prototype.transformArray_umhckl$ = function (array) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  JsonTransformer.prototype.transformComment_61zpoe$ = function (comment) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  JsonTransformer.prototype.transformKeyValue_puj7f4$ = function (key, value) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  JsonTransformer.prototype.insert_edr9kb$ = function (input, newValues, options) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  JsonTransformer.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'JsonTransformer',
    interfaces: [AbstractTransformer]
  };
  function TransformerFactory() {
    TransformerFactory_instance = this;
  }
  TransformerFactory.prototype.create_61zpoe$ = function (format) {
    switch (format) {
      case 'android':
        return new AndroidTransformer();
      case 'ios':
        return new IOSTransformer();
      case 'json':
        return new JsonTransformer();
      case 'dart':
        return new DartTransformer();
      case 'dartTemplate':
        return new DartTemplateTransformer();
      case 'dotnet':
        return new DotNetTransformer();
      default:throw IllegalArgumentException_init('Illegal format: ' + format);
    }
  };
  TransformerFactory.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'TransformerFactory',
    interfaces: []
  };
  var TransformerFactory_instance = null;
  function TransformerFactory_getInstance() {
    if (TransformerFactory_instance === null) {
      new TransformerFactory();
    }
    return TransformerFactory_instance;
  }
  function AbstractWriter() {
  }
  AbstractWriter.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'AbstractWriter',
    interfaces: []
  };
  function FakeWriter() {
    AbstractWriter.call(this);
  }
  FakeWriter.prototype.write_z2wymv$ = function (path, lines, transformer, options) {
    println('Fake writer: ' + lines);
  };
  FakeWriter.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'FakeWriter',
    interfaces: [AbstractWriter]
  };
  function FileWriter() {
    AbstractWriter.call(this);
  }
  FileWriter.prototype.write_z2wymv$ = function (path, lines, transformer, options) {
    var fileContent = '';
    println('Current directory: ' + get_Process().cwd());
    if (get_Fs().existsSync(path)) {
      fileContent = get_Fs().readFileSync(path, options.encoding);
    }
     else {
      println("File doesn't exist: " + path);
    }
    println(fileContent);
  };
  FileWriter.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'FileWriter',
    interfaces: [AbstractWriter]
  };
  var package$lokalize = _.lokalize || (_.lokalize = {});
  var package$external = package$lokalize.external || (package$lokalize.external = {});
  package$external.SpreadsheetWorksheet = SpreadsheetWorksheet;
  package$external.WorksheetsResponse = WorksheetsResponse;
  Object.defineProperty(_, 'Process', {
    get: get_Process
  });
  Object.defineProperty(_, 'Fs', {
    get: get_Fs
  });
  Object.defineProperty(_, 'Q', {
    get: get_Q
  });
  package$lokalize.main_kand9s$ = main;
  var package$models = package$lokalize.models || (package$lokalize.models = {});
  package$models.LSArray = LSArray;
  package$models.LSEntity = LSEntity;
  Object.defineProperty(LSLine, 'Companion', {
    get: LSLine$Companion_getInstance
  });
  package$models.LSLine = LSLine;
  package$models.Options = Options;
  var package$reader = package$lokalize.reader || (package$lokalize.reader = {});
  package$reader.AbstractReader = AbstractReader;
  package$reader.FakeReader = FakeReader;
  Object.defineProperty(GSReader, 'Companion', {
    get: GSReader$Companion_getInstance
  });
  package$reader.GSReader = GSReader;
  package$reader.WorksheetReader = WorksheetReader;
  var package$transformers = package$lokalize.transformers || (package$lokalize.transformers = {});
  package$transformers.AbstractTransformer = AbstractTransformer;
  package$transformers.AndroidTransformer = AndroidTransformer;
  package$transformers.DartTemplateTransformer = DartTemplateTransformer;
  package$transformers.DartTransformer = DartTransformer;
  package$transformers.DotNetTransformer = DotNetTransformer;
  package$transformers.IOSTransformer = IOSTransformer;
  package$transformers.JsonTransformer = JsonTransformer;
  Object.defineProperty(package$transformers, 'TransformerFactory', {
    get: TransformerFactory_getInstance
  });
  var package$writer = package$lokalize.writer || (package$lokalize.writer = {});
  package$writer.AbstractWriter = AbstractWriter;
  package$writer.FakeWriter = FakeWriter;
  package$writer.FileWriter = FileWriter;
  Process = lazy(Process$lambda);
  Fs = lazy(Fs$lambda);
  Q = lazy(Q$lambda);
  main([]);
  Kotlin.defineModule('lokalize', _);
  return _;
}(module.exports, require('kotlin'), require('google-spreadsheet')));
