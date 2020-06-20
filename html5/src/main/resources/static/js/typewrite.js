/**
 * Created by lin on 2018/9/5.
 */
// window.ready = function () {

var left = document.getElementById('left');
var leftWidth = 980;
var leftHeight = 750;
var charDropSpeed = 100;
var charGenerateSpeed = 500;

var initCountTime = 0;
var initCountClearChar = 0;

var byte = new Array('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
// var charArraySum = new Array();


//定时产生字符
var generateCharInTime = function () {
    setInterval(function () {
        appearInDiv();
    }, charGenerateSpeed);
}


//产生随机字符
var generateChar = function () {
    var number = Math.random() * 26;
    var char = byte[Math.floor(number)];
    return char;
}

//字符在div中出现
var appearInDiv = function () {
    var char = generateChar();

    var p = document.createElement('p');
    p.innerHTML = char;
    var randNum = Math.random() * leftWidth;

    p.setAttribute('style', 'color: yellow; font-size: 20px;position: absolute');
    p.style.left = randNum + 'px';
    p.style.top = '0px';
    left.appendChild(p);
    // charArraySum.push(p);
}

//字符掉落行为
var drop = function () {
    var dropTime = setInterval(function () {
        var ptag = document.getElementsByTagName('p');
        for (var i = 0; i < ptag.length; i++) {
            var p = ptag[i];
            var currentTop = p.style.top.substr(0, p.style.top.length - 2);
            var sumTop = parseInt(currentTop) + 2;
            if (sumTop > leftHeight) {
                clearChar(p);
            }
            p.style.top = sumTop + 'px';
        }
    }, charDropSpeed);
}


//展示最高速度
var displyaSpeed = function (maxSpeed) {
    var right = document.getElementById('right');
    var originPs = right.getElementsByTagName('p');
    var originP = originPs[0];
    originP.setAttribute('style', 'color: yellow; font-size: 15px');
    originP.innerHTML = '您的最高打字速度：     ' + parseInt(maxSpeed * 60) + " 字/分钟";

}

//计算玩家打字速度
var calculate = function () {
    var speed = 0;
    var maxSpeed = 0;
    var speedTime = setInterval(function () {
        initCountTime = initCountTime + 1;
        console.log('总时长:       ' + initCountTime)
        console.log('总消除字符：         ' + initCountClearChar);
        speed = parseInt(initCountClearChar / initCountTime * 1000) / 1000;
        if (initCountTime > 10) {
            if (speed > maxSpeed) {
                maxSpeed = speed;
                displyaSpeed(maxSpeed);
            }
        }
    }, 1000, 2000);
    return speed;
}


// 键盘键入事件
document.onkeydown = function (event) {
    var char = String.fromCharCode(event.keyCode);
    var ptag = document.getElementsByTagName('p');
    for (var i = 0; i < ptag.length; i++) {
        if (ptag[i].innerHTML == char) {
            clearChar(ptag[i]);
            initCountClearChar++;
            break;
        }
    }


}

// 字符消除行为
var clearChar = function (char) {
    left.removeChild(char);
    // charArraySum.remove(p);
}

// }

//开启入口
function myClick() {
    generateCharInTime();
    drop();
    calculate();
}

//调节速度
function changeSpeed(speed) {
    var srcNode = window.event.srcElement;
    srcNode.style.backgroundColor='yellow';
    setTimeout(generateCharInTime.time);
    if (speed == 1) {
        charDropSpeed = 50;
        charGenerateSpeed = 250;
        myClick();
    } else if (speed == 2) {
        charDropSpeed = 25;
        charGenerateSpeed = 125;
        myClick();
    } else if (speed == 3) {
        charDropSpeed = 12;
        charGenerateSpeed = 67;
        myClick();
    }
}




