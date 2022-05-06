import { createApp } from 'vue'
import App from './App.vue'
import {AuthModule} from "@/module/AuthModule";
import store from "./module/index"
createApp(App).use(store).mount('#app')
