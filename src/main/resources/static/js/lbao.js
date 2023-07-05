// 1. 初始数据
const data = [
    {url: 'image/slider01.jpg', title: '来感受类魂开放世界的无限魅力', color: 'rgb(100, 67, 68)'},
    {url: 'image/slider02.jpg', title: '去无主之地体验不一样的人生', color: 'rgb(43, 35, 26)'},
    {url: 'image/slider03.jpg', title: '去地铁感受末日的温情', color: 'rgb(36, 31, 33)'},
    {url: 'image/slider04.jpg', title: '3男一狗', color: 'rgb(139, 98, 66)'},
    {url: 'image/slider05.jpg', title: '体验旷世神作', color: 'rgb(67, 90, 92)'},
    {url: 'image/slider06.jpg', title: '聆听爱笑的草丛', color: 'rgb(166, 131, 143)'},
    {url: 'image/slider07.jpg', title: '体验肉鸽神作的魅力', color: 'rgb(53, 29, 25)'},
    {url: 'image/slider08.jpg', title: '去拯救塞尔达公主吧', color: 'rgb(99, 72, 114)'},
]
// 获取元素
const img = document.querySelector('.slider-wrapper img')
const p = document.querySelector('.slider-footer p')
const footer = document.querySelector('.slider-footer')
// 1. 右按钮业务
// 1.1 获取右侧按钮
const next = document.querySelector('.next')
let i = 0  // 信号量 控制播放图片张数
// 1.2 注册点击事件
next.addEventListener('click', function () {
    //点击右侧按钮之后，图片转换
    i++
    i = i > data.length - 1 ? 0 : i
    toggle()
})

// 2. 左侧按钮业务
// 2.1 获取左侧按钮
const prev = document.querySelector('.prev')
// 1.2 注册点击事件
prev.addEventListener('click', function () {
    //点击右侧按钮之后，图片转换
    i--
    i = i < 0 ? data.length - 1 : i
    toggle()
})

// 声明一个渲染的函数作为复用
function toggle() {
    img.src = data[i].url
    p.innerHTML = data[i].title
    footer.style.backgroundColor = data[i].color
    //先移除以前active
    document.querySelector('.slider-indicator .active').classList.remove('active')
    document.querySelector(`.slider-indicator li:nth-child(${i + 1})`).classList.add('active')
}

// 3. 自动播放模块
let timId = setInterval(function () {
    // 利用js按钮自动调用点击事件
    next.click()
}, 1500)


// 4. 鼠标经过大盒子，停止定时器
const slider = document.querySelector('.slider')
// 注册事件
slider.addEventListener('mouseenter', function () {
    clearInterval(timId)
})

// 5. 鼠标离开大盒子，开启定时器
// 注册事件
slider.addEventListener('mouseleave', function () {
    // 先关在开
    clearInterval(timId)
    // 开启定时器
    timId = setInterval(function () {
        // 利用js按钮自动调用点击事件
        next.click()
    }, 1000)
})