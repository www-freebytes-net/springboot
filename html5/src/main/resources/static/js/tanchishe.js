let amount = 0;
// 容器的dom节点
let containerEl = null;
// 容器对象
let container = null;
// 容器的宽
let containerWidth = 0;
// 容器的高
let containerHeight = 0;
// 食物块集合
let foodMap = new Map();
//蛇块总数
let snakeBlockSum = 0;
// 控制蛇移动的定时器id
let moveTimerId = 0;
// 控制蛇移动的速度
let moveSpeed = 100;
//方向键
let up = 'up';
let down = 'down';
let left = 'left';
let right = 'right';
//蛇的当前移动方向
let currentDirection = 'down';
//游戏是否已经暂停
let isPause = false;


// 容器对象
function Container(width, height, left, top, bgColor, el) {
    this.width = width;
    this.height = height;
    this.left = left;
    this.top = top;
    this.bgColor = bgColor;
    this.el = el;
    this.toString = function () {
        console.log('{ width: ' + this.width + '; height: ' + height + ' ;left: ' + left + '; top: ' + top + '; bgColor: ' + bgColor + ' }')
    }
}

// 方块对象
function Blocker(id, width, height, bgColor, left, top, borderRadius, invalid) {
    // 公有属性
    this.id = id;
    this.width = width;
    this.height = height;
    this.bgColor = bgColor;
    //当前横坐标
    this.left = left;
    // 当前纵坐标
    this.top = top;
    this.invalid = invalid;
    this.position = 'absolute';
    this.borderRadius = borderRadius;
    this.el = null;
    // 移动前的横坐标
    this.previousLeft = null;
    // 移动前的纵坐标
    this.previousTop = null;
    // 前一个节点对象
    this.previousBloker = null;
}

// 静态属性，必须在外部声明
Blocker.size = 20;

Blocker.prototype = {
    constructor: Blocker,
    //对象转化为DOM节点
    toEl: function () {
        var el = document.createElement('div');
        // this.el = el;
        el.id = this.id;
        el.style.backgroundColor = this.bgColor;
        el.style.width = this.width + 'px';
        el.style.height = this.height + 'px';
        el.style.left = this.left + 'px';
        el.style.top = this.top + 'px';
        el.style.position = this.position;
        el.style.borderRadius = this.borderRadius;
        return el;
    },

    del: function () {
        console.log(this)
        containerEl.removeChild(this.el);
    },
    //块对象的移动
    move: function (direction) {
        var el = document.getElementById(this.id);
        // var el = this.el;
        // 记录原来的坐标值
        this.previousTop = this.top;
        this.previousLeft = this.left;
        // 设置当前的坐标值
        switch (direction) {
            case "up":
                this.top -= Blocker.size;
                el.style.top = this.top + 'px';
                break;
            case "down":
                this.top += Blocker.size;
                el.style.top = this.top + 'px';
                break;
            case "left":
                this.left -= Blocker.size;
                el.style.left = this.left + 'px';
                break;
            case "right":
                this.left += Blocker.size;
                el.style.left = this.left + 'px';
                break;
        }
        // 超出边界则游戏结束
        if (this.left > (containerWidth - Blocker.size) ||
            this.top > (containerHeight - Blocker.size) || this.left < 0 || this.top < 0) {
            this.invalid = false;
            // 重置坐标
            el.style.top = this.previousTop + 'px';
            el.style.left = this.previousLeft + 'px';
        }
        //如果蛇头跟蛇身节点碰撞，则游戏结束
        var node = this;
        while (node.previousBloker) {
            if (this.top === node.previousBloker.top && this.left === node.previousBloker.left) {
                this.invalid = false;
                // 重置坐标
                el.style.top = this.previousTop + 'px';
                el.style.left = this.previousLeft + 'px';
                break;
            }
            node = node.previousBloker;
        }
    },
    // 重置块对象的坐标
    resetPosition: function (left, top) {
        var el = document.getElementById(this.id);
        // var el = this.el;
        this.previousTop = this.top;
        this.previousLeft = this.left;
        this.top = top;
        this.left = left;
        el.style.top = top + 'px';
        el.style.left = left + 'px';
    }
}

// 蛇对象
function Snake(head) {
    // 头结点 蛇头
    this.head = head;

    // 蛇头先动
    this.move = function (moveSpeed, direction) {
        moveTimerId = setInterval(function () {
            head.move(direction);

            //判断异常情况
            if (!head.invalid) {
                clearInterval(moveTimerId);
                alert("Game Over !!! ");
                window.location.reload();
                return;
            }

            // 遇上食物块就吃掉
            eat();

            // 蛇身跟上蛇头
            follow();

        }, moveSpeed);
        return moveTimerId;
    };

    // 蛇身跟上蛇头
    var follow = function () {
        var node = head;
        // 重置链表的每个节点的坐标值
        while (node.previousBloker) {
            // console.log(node.previousBloker)
            node.previousBloker.resetPosition(node.previousLeft, node.previousTop);
            node = node.previousBloker;
        }
    };

    var eat = function () {
        if (!foodMap.has(head.left + '-' + head.top)) {
            return;
        }
        var food = foodMap.get(head.left + '-' + head.top);
        var block = foodToBlock(food);
        snakeBlockSum++;
        // console.log(block)
        block.previousTop = head.previousBloker.top;
        block.previousLeft = head.previousBloker.left;
        block.previousBloker = head.previousBloker;
        head.previousBloker = block;
        //再生产一个食物
        produceFood();
    }
}

function produceFood() {
    var left = Math.floor(Math.random() * container.width / Blocker.size) * Blocker.size;
    var top = Math.floor(Math.random() * container.height / Blocker.size) * Blocker.size;
    var food = new Blocker(uuid(), Blocker.size, Blocker.size, 'yellow', left, top, '50%', true);
    container.el.appendChild(food.toEl());
    foodMap.set(food.left + '-' + food.top, food);
    return food;
}

//食物块转为普通块
function foodToBlock(food) {
    food.bgColor = 'lightBlue';
    food.borderRadius = '0';
    var el = document.getElementById(food.id);
    el.style.backgroundColor = food.bgColor;
    el.style.borderRadius = food.borderRadius;
    foodMap.delete(food.left + '-' + food.top);
    return food;
}

// 将块对象放置到容器中,转化为DOM节点
function putBlockerToContainer(container, blocker) {
    container.el.appendChild(blocker.toEl());
}

// 初始化拥有3个block对象的蛇,需构建单向链表
function initSnake() {
    var blocker1 = new Blocker(uuid(), Blocker.size, Blocker.size, 'lightBlue', 40, 40, '0', true);
    var blocker2 = new Blocker(uuid(), Blocker.size, Blocker.size, 'lightBlue', 40, 60, '0', true);
    var blocker3 = new Blocker(uuid(), Blocker.size, Blocker.size, '#c86bd8', 40, 80, '50%', true);
    blocker3.previousBloker = blocker2;
    blocker2.previousBloker = blocker1;
    putBlockerToContainer(container, blocker1);
    putBlockerToContainer(container, blocker2);
    putBlockerToContainer(container, blocker3);
    var snake = new Snake(blocker3);
    snakeBlockSum+=3;
    return snake;
}
// 获取uuid
function uuid() {
    var s = [];
    var hexDigits = "0123456789abcdef";
    for (var i = 0; i < 36; i++) {
        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
    }
    s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
    s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
    s[8] = s[13] = s[18] = s[23] = "-";
    var uuid = s.join("");
    return uuid;
}
// 键盘移动蛇对象
function moveSnake(snake) {

    //动态增加移动速度
    setInterval(function () {

    },10*1000);

    //获取键盘事件
    document.onkeydown = function (event) {
        var e = event || window.event || arguments.callee.caller.arguments[0];

        if (e && e.keyCode == 32) {//按空格键
            clearInterval(moveTimerId);
            isPause = true;
        }

        if (e && e.keyCode == 38) { // 按 up
            //如果方向相反，则不作理会
            var nextLeft = snake.head.left;
            var nextTop = snake.head.top - Blocker.size;
            if (nextLeft === snake.head.previousBloker.left && nextTop === snake.head.previousBloker.top) {
                return;
            }
            // 清除原有的移动定时器
            clearInterval(moveTimerId);
            //开启新的移动定时器
            snake.move(moveSpeed, up);
            currentDirection = up;
            isPause = false;
        }
        if (e && e.keyCode == 40) { // 按 down
            //如果方向相反，则不作理会
            var nextLeft = snake.head.left;
            var nextTop = snake.head.top + Blocker.size;
            if (nextLeft === snake.head.previousBloker.left && nextTop === snake.head.previousBloker.top) {
                return;
            }
            clearInterval(moveTimerId);
            snake.move(moveSpeed, down);
            currentDirection = down;
            isPause = false;
        }
        if (e && e.keyCode == 37) { // 按left
            //如果方向相反，则不作理会
            var nextLeft = snake.head.left - Blocker.size;
            var nextTop = snake.head.top;
            if (nextLeft === snake.head.previousBloker.left && nextTop === snake.head.previousBloker.top) {
                return;
            }
            clearInterval(moveTimerId);
            snake.move(moveSpeed, left);
            currentDirection = left;
            isPause = false;
        }
        if (e && e.keyCode == 39) { // 按right
            //如果方向相反，则不作理会
            var nextLeft = snake.head.left + Blocker.size;
            var nextTop = snake.head.top;
            if (nextLeft === snake.head.previousBloker.left && nextTop === snake.head.previousBloker.top) {
                return;
            }
            clearInterval(moveTimerId);
            snake.move(moveSpeed, right);
            currentDirection = right;
            isPause = false;
        }
    };

}

/**
 * 游戏运行步骤：
 * 1. 初始化容器
 * 2. 初始化蛇
 * 3. 初始化食物
 * 4. 控制蛇移动
 * 4.1 如果蛇头和蛇身碰撞或者蛇头超出容器边界，则游戏结束
 * 4.2 如果蛇头碰到食物，则将食物对象加入蛇对象的链表中，将蛇头的previousBlocker指向该食物对象，
 *       该食物对象指向蛇头原来的previousBlocker。即将食物对象插入到蛇头的前一个节点。
 */
window.onload = function () {
    // 初始化容器
    containerEl = document.getElementById("container");
    // console.log(window.screen.availHeight)
    //设置屏幕可见高度
    // containerEl.style.height = (window.screen.availHeight-200)+'px';
    containerWidth = containerEl.offsetWidth - 2;// 减去border边界宽度值2px
    containerHeight = containerEl.offsetHeight - 2;
    container = new Container(containerWidth, containerHeight, containerEl.offsetLeft, containerEl.offsetTop, null, containerEl);
    // 初始化食物块
    produceFood(container);
    // 初始化蛇块
    var snake = initSnake();
    // 键盘移动蛇对象
    moveSnake(snake);
}

