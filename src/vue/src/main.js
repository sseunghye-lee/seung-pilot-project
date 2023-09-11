import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

import ElementPlus from 'element-plus'
import '@/assets/style/element-variables.scss'
import ko from 'element-plus/es/locale/lang/ko'

const app = createApp(App)

app.use(router)

app.use(ElementPlus)
app.use(ElementPlus, {
    size: 'small',
    zIndex: 3000,
    locale: ko
})

app.mount('#app')
