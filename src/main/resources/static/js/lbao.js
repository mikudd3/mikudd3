new Vue({
    el: '#slider',
    data() {
        return {
            slides: [
                {url: 'image/slider01.jpg', title: '来感受类魂开放世界的无限魅力', color: '#644344'},
                {url: 'image/slider02.jpg', title: '去无主之地体验不一样的人生', color: '#2B231A'},
                {url: 'image/slider03.jpg', title: '去地铁感受末日的温情', color: '#241F21'},
                {url: 'image/slider04.jpg', title: '3男一狗', color: '#8B6242'},
                {url: 'image/slider05.jpg', title: '体验旷世神作', color: '#435A5C'},
                {url: 'image/slider06.jpg', title: '聆听爱笑的草丛', color: '#A6838F'},
                {url: 'image/slider07.jpg', title: '体验肉鸽神作的魅力', color: '#351D19'},
                {url: 'image/slider08.jpg', title: '去拯救塞尔达公主吧', color: '#634872'}
            ],
            currentIndex: 0,
            timerId: null
        };
    },
    computed: {
        currentSlide() {
            return this.slides[this.currentIndex];
        }
    },
    mounted() {
        this.startAutoPlay();
    },
    methods: {
        fetchSlides() {
            axios({
                url: "/Lunbao",
                method: "get"
            }).then(response => {
                this.slides = response.data;
            }).catch(error => {
                console.error('Error fetching slides:', error);
            });
        },
        nextSlide() {
            this.currentIndex = (this.currentIndex + 1) % this.slides.length;
        },
        prevSlide() {
            this.currentIndex = (this.currentIndex - 1 + this.slides.length) % this.slides.length;
        },
        startAutoPlay() {
            this.timerId = setInterval(() => {
                this.nextSlide();
            }, 1500);
        },
        stopAutoPlay() {
            clearInterval(this.timerId);
        }
    },
    beforeDestroy() {
        this.stopAutoPlay();
    }
})