//-------------------------
// JSONで表記したPDFの内容
//-------------------------
var dd = { content: '<img src=../../images/mypage.home.png>' };

//-------------------------
// ボタンクリックイベント
//-------------------------
function pdfOpen() {

    // フォント
    pdfMake.fonts = {
        GenShin: {
            normal:      'GenShinGothic-Normal-Sub.ttf',
            bold:        'GenShinGothic-Normal-Sub.ttf',
            italics:     'GenShinGothic-Normal-Sub.ttf',
            bolditalics: 'GenShinGothic-Normal-Sub.ttf'
        }
    }

    // ディフォルトフォントを指定
    if (!dd['defaultStyle']) {
        dd['defaultStyle'] = new Object();
    }
    dd['defaultStyle']['font'] = 'GenShin';


    // ブラウザ名を取得
    var name = getBrowser();

    // ブラウザことに処理を分岐
    // IEの場合
    if (name == 'ie') {
        pdfMake.createPdf(dd).download('optionalName.pdf');

        // IE以外
    } else {
        pdfMake.createPdf(dd).open();
    }
}

//-------------------------
// ブラウザを判定する関数
//-------------------------
var getBrowser = function() {

    var name = 'unknown';

    // ユーザーエージェントを取得
    var ua = window.navigator.userAgent.toLowerCase();

    // ieをチェック
    if (ua.indexOf("msie") != -1 ||
        ua.indexOf('edge') != -1 ||
        ua.indexOf('trident/7') != -1) {
        name = 'ie';

        // ie以外
    } else if (ua.indexOf('chrome') != -1) {
        name = 'chrome';

    } else if (ua.indexOf('safari') != -1) {
        name = 'safari';

    } else if (ua.indexOf('opera') != -1) {
        name = 'opera';

    } else if (ua.indexOf('firefox') != -1) {
        name = 'firefox';
    }

    return name;
}