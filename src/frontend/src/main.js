import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import router from './router'
import {store} from './store'
import Vuex from 'vuex'
import axios from 'axios'

Vue.config.productionTip = false
Vue.prototype.$http = axios;
Vue.use(Vuex)
new Vue({
  vuetify,
  router,
  store,
  Vuex,
  axios,
  render: h => h(App)
}).$mount('#app')















