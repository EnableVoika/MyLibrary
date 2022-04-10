import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import axios from "axios"
import ElementUI from "element-ui"
import 'element-ui/lib/theme-chalk/index.css';
import './permission'



Vue.config.productionTip = process.env.NODE_ENV==='production';

Vue.prototype.$axios = axios
Vue.use(ElementUI)

new Vue({
  router,
  render: h => h(App)
}).$mount("#app");
